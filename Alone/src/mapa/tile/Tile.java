package mapa.tile;

import graficos.Pantalla;
import graficos.Sprite;

public abstract class Tile {
	public int x;
	public int y;
	
	public Sprite sprite;
	
	public static final int LADO = 32;
	
	//Colección de tiles
	public static final Tile Vacio = new TileVacio(Sprite.VACIO);
	public static final Tile Prueba = new TilePrueba(Sprite.BLOQUES);
	//Fin de colección de tiles
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	//ensamblara los tiles(cuadros) y se los enviara a la clase juego en una sola "imagen" 
	//para no tener que dibujar 100 o mas sprites.
	public void mostrar(int x, int y, Pantalla pantalla) {
		pantalla.mostrarTile(x << 5, y << 5, this);
	}
	
	//para saber si el tile es solido(colisiones), por defecto sera falso.
	public boolean solido() {
		return false;
	}
}
