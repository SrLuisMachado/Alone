package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Teclado implements KeyListener{
	
	private final static int numeroTeclas = 120;
	private final boolean[] teclas = new boolean[numeroTeclas];
	
	//teclas para mover el mapa
	public boolean arriba;
	public boolean abajo;
	public boolean izquierda;
	public boolean derecha;
	
	//correr
	public boolean correr;
	
	//cerrara la aplicación
	public boolean cerrar;
	
	public void actualizar() {
		arriba = teclas[KeyEvent.VK_W];
		abajo = teclas[KeyEvent.VK_S];
		izquierda = teclas[KeyEvent.VK_A];
		derecha = teclas[KeyEvent.VK_D];
		
		correr = teclas[KeyEvent.VK_SHIFT];
		
		cerrar = teclas[KeyEvent.VK_ESCAPE];
	}
	
	public void keyPressed(KeyEvent e) {
		teclas[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		teclas[e.getKeyCode()] = false;
	}
	//Metodo de la implementación no utilizado dado que sirve para mantener la accion sin pulsar
	public void keyTyped(KeyEvent e) {
		
	}

}
