package entes.criatura;

import entes.Ente;
import graficos.Sprite;

public abstract class Criatura extends Ente {
	protected Sprite sprite;
	protected char direccion = 'n';
	protected boolean movimiento = false;
	
	public void actualizar() {
		
	}
	
	public void mostrar() {
		
	}
	
	public void mover(int desplazamientoX, int desplazamientoY) {
		if(desplazamientoX > 0) {
			direccion = 'e';
		}
		if(desplazamientoX < 0) {
			direccion = 'w';
		}
		if(desplazamientoY > 0) {
			direccion = 's';
		}
		if(desplazamientoY < 0) {
			direccion = 'n';
		}
		
		if(!getEliminado()) {
			if(!Colision(desplazamientoX, 0)) {
				setPosicionX(desplazamientoX);
			}
			if(!Colision(0, desplazamientoY)) {
				setPosicionY(desplazamientoY);
			}
		}
	}
	
	private boolean Colision(int desplazamientoX, int desplazamientoY) {
		
		boolean colision = false;
		
		int posicionX = x + desplazamientoX;
		int posicionY = y + desplazamientoY;
		
		int margenIzquierdo = -6;
		int margenDerecho = 18;
		int margenSuperior = -4;
		int margenInferior = 31;
		
		int bordeIzquierdo = (posicionX + margenDerecho) / sprite.getTamanyo();
		int bordeDerecho = (posicionX + margenDerecho + margenIzquierdo) / sprite.getTamanyo();
		int bordeSuperior = (posicionY + margenInferior) / sprite.getTamanyo();
		int bordeInferior = (posicionY + margenInferior + margenSuperior) / sprite.getTamanyo();
		
		if(mapa.getTileMapa(bordeIzquierdo+bordeSuperior * mapa.getAncho()).isSolido()) {
			colision = true;
		}
		if(mapa.getTileMapa(bordeIzquierdo+bordeInferior * mapa.getAncho()).isSolido()) {
			colision = true;
		}
		if(mapa.getTileMapa(bordeDerecho+bordeSuperior * mapa.getAncho()).isSolido()) {
			colision = true;
		}
		if(mapa.getTileMapa(bordeDerecho+bordeInferior * mapa.getAncho()).isSolido()) {
			colision = true;
		}
		return colision;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
}
