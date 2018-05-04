package entes;

import mapa.Mapa;

public abstract class Ente {
	protected int x;
	protected int y;
	private boolean eliminado = false;
	
	protected Mapa mapa;
	
	public void actualizar() {
		
	}
	
	public void mostrar() {
		
	}
	
	public void eliminar() {
		eliminado = true;
	}
	
	public int getPosicionX() {
		return x;
	}
	
	public void setPosicionX(int desplazamientoX) {
		x += desplazamientoX;
	}
	
	public int getPosicionY() {
		return y;
	}
	
	public void setPosicionY(int desplazamientoY) {
		y += desplazamientoY;
	}
	
	public int posicionX() {
		return x;
	}
	
	public int posicionY() {
		return y;
	}
	
	public boolean getEliminado() {
		return eliminado;
		
	}
}
