package principal.graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import principal.Constantes;
import principal.GestorPrincipal;
import principal.control.GestorControles;
import principal.control.Raton;
import principal.control.Teclado;
import principal.maquinaestado.GestorEstados;

public class SuperficieDibujo extends Canvas {

	private static final long serialVersionUID = -6227038142688953660L;
	
	private int ancho;
	private int alto;
	
	private Raton raton;
	
	public SuperficieDibujo(final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;
		
		this.raton = new Raton();
		
		setIgnoreRepaint(true);
		setCursor(raton.getCursor());
		setPreferredSize(new Dimension(ancho, alto));
		addKeyListener(GestorControles.teclado);
		setFocusable(true);
		requestFocus();
	}
	
	public void dibujar(final GestorEstados ge) {
		BufferStrategy buffer = getBufferStrategy();
		
		if(buffer == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, Constantes.ANCHO_JUEGO, Constantes.ALTO_JUEGO);
//		g.fillRect(0, 0, Constantes.ANCHO_PANTALLA_COMPLETA, Constantes.ALTO_PANTALLA_COMPLETA);
		
//		if(Constantes.FACTOR_ESCALADO_X != 1.0 || Constantes.FACTOR_ESCALADO_Y !=1.0) {
//			g.scale(Constantes.FACTOR_ESCALADO_X, Constantes.FACTOR_ESCALADO_Y);
//		}
		
		ge.dibujar(g);
		
		g.drawString("FPS: " + GestorPrincipal.getFPS(), 20, 50);
		g.drawString("APS: " + GestorPrincipal.getAPS(), 20, 60);
		
		Toolkit.getDefaultToolkit().sync();
		
		g.dispose();
		
		buffer.show();
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return alto;
	}
}
