package principal.maquinaestado;

import java.awt.Graphics;

import principal.maquinaestado.estados.juego.GestorJuego;

public class GestorEstados {
	
	private EstadoJuego[] estados;
	private EstadoJuego estadoActual;
	public GestorEstados() {
		iniciarEstados();
		iniciarEstadoActual();
	}
	
	private void iniciarEstados() {
		estados = new EstadoJuego[1];
		estados[0] = new GestorJuego();
		//Añadir y iniciar los démas estados a medida que se creen
	}
	private void iniciarEstadoActual() {
		estadoActual = estados[0];
		
	}
	
	public void actualizar() {
		estadoActual.actualizar();
	}
	
	public void dibujar(final Graphics g) {
		estadoActual.dibujar(g);
	}
	
	public void cambiarEstadoActual(final int nuevoEstado) {
		estadoActual = estados[nuevoEstado];
	}
	
	public EstadoJuego getEstadoActual() {
		return estadoActual;
	}
}
