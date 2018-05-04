package mapa.tile;

import graficos.Pantalla;
import graficos.Sprite;

public class Tile {
	public int x;
	public int y;
	
	public Sprite sprite;
	
	private boolean solido;
	
	public static final int LADO = 32;
	
	//Colección de tiles
	public static final Tile VACIO = new Tile(Sprite.VACIO, true);
	public static final Tile CESPED = new Tile(Sprite.CESPED);
	public static final Tile AGUJERO1 = new Tile(Sprite.AGUJERO1,true);
	public static final Tile AGUJERO2 = new Tile(Sprite.AGUJERO2,true);
	public static final Tile AGUJERO3 = new Tile(Sprite.AGUJERO3,true);
	public static final Tile AGUJERO4 = new Tile(Sprite.AGUJERO4,true);
	public static final Tile AGUJERO5 = new Tile(Sprite.AGUJERO5,true);
	public static final Tile AGUJERO6 = new Tile(Sprite.AGUJERO6,true);
	public static final Tile AGUJERO7 = new Tile(Sprite.AGUJERO7,true);
	public static final Tile AGUJERO8 = new Tile(Sprite.AGUJERO8,true);
	public static final Tile AGUJERO9 = new Tile(Sprite.AGUJERO9,true);
	public static final Tile ARBOL1 = new Tile(Sprite.ARBOL1,true);
	public static final Tile ARBOL2 = new Tile(Sprite.ARBOL2,true);
	public static final Tile ARBOL3 = new Tile(Sprite.ARBOL3,true);
	public static final Tile ARBOL4 = new Tile(Sprite.ARBOL4,true);
	public static final Tile CASA1 = new Tile(Sprite.CASA1,true);
	public static final Tile CASA2 = new Tile(Sprite.CASA2,true);
	public static final Tile CASA3 = new Tile(Sprite.CASA3,true);
	public static final Tile CASA4 = new Tile(Sprite.CASA4,true);
	//Fin de colección de tiles
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
		solido = false;
	}
	
	public Tile(Sprite sprite, boolean solido) {
		this.sprite = sprite;
		this.solido = solido;
	}
	
	//ensamblara los tiles(cuadros) y se los enviara a la clase juego en una sola "imagen" 
	//para no tener que dibujar 100 o mas sprites.
	public void mostrar(int x, int y, Pantalla pantalla) {
		pantalla.mostrarTile(x << 5, y << 5, this);
	}
	
	//para saber si el tile es solido(colisiones), por defecto sera falso.
	public boolean isSolido() {
		return solido;
	}
}
