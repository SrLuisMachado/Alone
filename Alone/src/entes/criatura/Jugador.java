package entes.criatura;

import control.Teclado;
import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;

public class Jugador extends Criatura {
	
	private Teclado teclado;
	
	private int animacion;
	
	public Jugador(Mapa mapa,Teclado teclado, Sprite sprite) {
		this.mapa = mapa;
		this.teclado = teclado;
		this.sprite = sprite;
	}
	
	public Jugador(Mapa mapa,Teclado teclado, Sprite sprite, int posicionX, int posicionY) {
		this.mapa = mapa;
		this.teclado = teclado;
		this.sprite = sprite;
		this.x = posicionX;
		this.y = posicionY;
	}
	
	public void actualizar() {
		int desplazamientoX = 0;
		int desplazamientoY = 0;
		
		int velocidadMovimiento = 1;
		
		if(animacion < 32767) {
			animacion++;
		}else {
			animacion = 0;
		}
		
		if(teclado.correr) {
			velocidadMovimiento = 2;
		}
		
		if(teclado.arriba) {
			desplazamientoY -= velocidadMovimiento;
		}
		if(teclado.abajo) {
			desplazamientoY += velocidadMovimiento;
		}
		if(teclado.izquierda) {
			desplazamientoX -= velocidadMovimiento;
		}
		if(teclado.derecha) {
			desplazamientoX += velocidadMovimiento;
		}	
		
		if(desplazamientoX != 0 || desplazamientoY != 0) {
			mover(desplazamientoX, desplazamientoY);
			movimiento = true;
		}else {
			movimiento = false;
		}
		
		int resto = animacion % 40;
		
		if(direccion == 'n') {
			sprite = sprite.Arriba0;
			if(movimiento) {
				if(resto > 10 && resto <= 20) {
					sprite = Sprite.Arriba1;
				}else if(resto > 20 && resto <=30) {
					sprite = Sprite.Arriba0;
				}else if(resto > 30) {
					sprite = Sprite.Arriba2;
				}else {
					sprite = Sprite.Arriba0;
				}
			}
		}
		if(direccion == 's') {
			sprite = sprite.Abajo0;
			if(movimiento) {
				if(resto > 10 && resto <= 20) {
					sprite = Sprite.Abajo1;
				}else if(resto > 20 && resto <=30) {
					sprite = Sprite.Abajo0;
				}else if(resto > 30) {
					sprite = Sprite.Abajo2;
				}else {
					sprite = Sprite.Abajo0;
				}
			}
		}
		if(direccion == 'w') {
			sprite = sprite.izquierda0;
			if(movimiento) {
				if(resto > 10 && resto <= 20) {
					sprite = Sprite.izquierda1;
				}else if(resto > 20 && resto <=30) {
					sprite = Sprite.izquierda0;
				}else if(resto > 30) {
					sprite = Sprite.izquierda2;
				}else {
					sprite = Sprite.izquierda0;
				}
			}
		}
		if(direccion == 'e') {
			sprite = sprite.derecha0;
			if(movimiento) {
				if(resto > 10 && resto <= 20) {
					sprite = Sprite.derecha1;
				}else if(resto > 20 && resto <=30) {
					sprite = Sprite.derecha0;
				}else if(resto > 30) {
					sprite = Sprite.derecha2;
				}else {
					sprite = Sprite.derecha0;
				}
			}
		}
	}
	
	public void mostrar(Pantalla pantalla) {
		pantalla.mostrarJugador(x, y, this);
	}
	
}
