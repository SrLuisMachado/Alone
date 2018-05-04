package juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import control.Teclado;
import entes.criatura.Jugador;
import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;
import mapa.MapaCargado;
import mapa.MapaGenerado;

public class Juego extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	
	private static final int ANCHO = 600;
	private static final int ALTO = 400;
	
	private static volatile boolean funcionando = false;
	
	private static final String NOMBRE = "Alone";
	
	//MOSTRARA LOS VALORES
	private static String CONTADOR_APS = "";
	private static String CONTADOR_FPS = "";
	
	//contador de rendimiento
	private static int aps = 0;
	private static int fps = 0;
	
	private static JFrame ventana;
	private static Thread Hilo;
	private static Teclado teclado;
	private static Pantalla pantalla;
	
	private static Mapa mapa;
	private static Jugador jugador;
	
	//acceder a la imagen en forma de array de pixeles que devuelve un array de int
	private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
	private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
	
	//Icono
	private static final ImageIcon icono = new ImageIcon(Juego.class.getResource("/icono/icono.png"));
	
	//ventana del juego
	private Juego() {
		setPreferredSize(new Dimension(ANCHO, ALTO));
		
		pantalla = new Pantalla(ANCHO, ALTO);
		
		teclado = new Teclado();
		addKeyListener(teclado);
		
		//se refiere a que el mapa sera de 128x128 tiles(cuadros)
				//mapa = new MapaGenerado(128, 128);
		mapa = new MapaCargado("/mapas/Mapa1.png");
		jugador = new Jugador(mapa, teclado, Sprite.Abajo0, 215, 127);
		
		ventana = new JFrame(NOMBRE);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		
		//Temporal para ver como se ve, quita el borde de la ventana(pura decoración)
		//ventana.setUndecorated(true);
		
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setIconImage(icono.getImage());
		ventana.setVisible(true);
	}
	
	public static void main(String[] args) {
		Juego Juego = new Juego();
		Juego.iniciar();
	}
	
	private synchronized void iniciar() {
		funcionando = true;
		
		Hilo = new Thread(this,"Graficos");
		Hilo.start();
	}
	
	/*private synchronized void detener() {
		funcionando = false;
		
		try {
			Hilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}*/

	private void actualizar() {
		teclado.actualizar();
		
		jugador.actualizar();
//		if(teclado.arriba) {
//			y--;
//		}
//		if(teclado.abajo) {
//			y++;
//		}
//		if(teclado.izquierda) {
//			x--;
//		}
//		if(teclado.derecha) {
//			x++;
//		}
		if(teclado.cerrar) {
			System.exit(0);
		}
		
		aps++;
	}
	
	private void mostrar() {
		BufferStrategy estrategia = getBufferStrategy();
		
		if(estrategia == null) {
			createBufferStrategy(3);
			return;
		}
		
		pantalla.limpiar();
		mapa.motrar(jugador.getPosicionX()- pantalla.getAncho()/2 + jugador.getSprite().getTamanyo()/2, jugador.getPosicionY() - pantalla.getAlto()/2 + jugador.getSprite().getTamanyo()/2, pantalla);
		jugador.mostrar(pantalla);
		System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);
		//comentado por que para ordenadores antiguos va mal, la línea de arriba lo sustituye
//		for(int i = 0; i < pixeles.length;i++) {
//			pixeles[i] =pantalla.pixeles[i];
//		}
		
		//se encargara de dibujar lo que haya en el buffer
		Graphics g = estrategia.getDrawGraphics();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
		//pone un cuadro blanco de 32 x 32 pixeles en e centre(avatar)
		g.setColor(Color.red);
		//g.fillRect(ANCHO/2, ALTO/2, 32, 32);
		
		//MOSTRARA EL CONTADOR APS EN LA POSICION 10 px a la derecha, 20 px hacia abajo de la esquina superior izquierda
		g.drawString(CONTADOR_APS, 10, 20);
		//MOSTRARA EL CONTADOR APS EN LA POSICION 10 px a la derecha, 35 px hacia abajo de la esquina superior izquierda
		g.drawString(CONTADOR_FPS, 10, 35);
		//dibujar posicion
		g.drawString("x :" +jugador.getPosicionX(), 10, 50);
		g.drawString("x :" +jugador.getPosicionY(), 10, 65);
		//destruye la memoria de g
		g.dispose();
		
		estrategia.show();
		
		fps++;
	}
	
	public void run() {
		final int NANOSEGUNDOS_POR_SEGUNDO =1000000000;
		final byte ACTUALIZACION_POR_SEGUNDO = 80;
		final double NS_POR_ACTUALIZACION = NANOSEGUNDOS_POR_SEGUNDO/ACTUALIZACION_POR_SEGUNDO;
		
		long referenciaActualizacion = System.nanoTime();
		long referenciaContador = System.nanoTime();
		
		double tiempoTranscurrido;
		double delta = 0;
		
		requestFocus();
		
		while(funcionando){
			final long inicioBucle=System.nanoTime();
			
			tiempoTranscurrido = inicioBucle-referenciaActualizacion;
			referenciaActualizacion=inicioBucle;
			
			delta+=tiempoTranscurrido/NS_POR_ACTUALIZACION;
			
			while(delta >=1) {
			actualizar();
			delta--;
			}
			
			mostrar();
			
			if(System.nanoTime() - referenciaContador > NANOSEGUNDOS_POR_SEGUNDO) {
				//Muestra el nombre de la aplicacion y los contadores
				ventana.setTitle(NOMBRE +" || APS: " + aps + " || FPS : " + fps);
				
				CONTADOR_APS = "APS: " + aps;
				CONTADOR_FPS = "FPS: " + fps;
				
				aps = 0;
				fps = 0;
				referenciaContador = System.nanoTime();
			}
		}
	}
}