package mapa;

import graficos.Pantalla;
import mapa.tile.Tile;

public abstract class Mapa {
	protected int ancho;
	protected int alto;
	
	protected int[] tiles;
	protected Tile[] TileMapa;
	
	public Mapa(int ancho, int alto) {
		this.ancho=ancho;
		this.alto=alto;
		
		tiles = new int[ancho * alto];
		generarMapa();
	}
	
	public Mapa(String ruta) {
		cargarMapa(ruta);
		generarMapa();
	}
	
	//si es que llego a hacer mapas que se generen automaticamente ellos sin requisitos -temporal-
	protected void generarMapa() {
		
	}
	
	protected void cargarMapa(String ruta) {
		
	}
	
	public void actualizar() {
		
	}
	
	public void motrar(final int  compensacionX, final int compensacionY, Pantalla pantalla) {
		
		pantalla.setDiferencia(compensacionX, compensacionY);
		
		//puntos cardinales(oeste, este, norte y sur)---temporal
		int o = compensacionX >> 5; // dividiendo entre 32 
		int e = (compensacionX + pantalla.getAncho() + Tile.LADO) >> 5;
		int n = compensacionY >> 5;
		int s = (compensacionY + pantalla.getAlto() + Tile.LADO) >> 5;
		
		for(int y = n; y < s; y++) {
			for(int x = 0; x < e; x++) {
				//getTile(x,y).mostrar(x, y, pantalla);
				if(x < 0 || y < 0 || x >= ancho || y >= alto) {
					Tile.VACIO.mostrar(x, y, pantalla);
				} else {
					TileMapa[x + y * ancho].mostrar(x, y, pantalla);
				}
			}
		}
	}
	
	public Tile getTileMapa(int posicion) {
		return TileMapa[posicion];
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public Tile getTile(final int x, final int y) {
		if(x < 0 || y < 0 || x >= ancho || y >= alto) {
			return Tile.VACIO;
		}
		switch(tiles[x + y * ancho]) {
		case 0:
			return Tile.CESPED;
		case 1:
			return Tile.AGUJERO1;
		case 2:
			return Tile.AGUJERO2;
		case 3:
			return Tile.ARBOL1;
		default:
			return Tile.VACIO;	
		}
	}
}
