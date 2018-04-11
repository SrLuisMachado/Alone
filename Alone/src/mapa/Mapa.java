package mapa;

import graficos.Pantalla;
import mapa.tile.Tile;

public abstract class Mapa {
	protected int ancho;
	protected int alto;
	
	protected int[] tiles;
	
	public Mapa(int ancho, int alto) {
		this.ancho=ancho;
		this.alto=alto;
		
		tiles = new int[ancho * alto];
		generarMapa();
	}
	
	public Mapa(String ruta) {
		cargarMapa(ruta);
	}
	
	//si es que llego a hacer mapas que se generen automaticamente ellos sin requisitos -temporal-
	protected void generarMapa() {
		
	}
	
	private void cargarMapa(String ruta) {
		
	}
	
	public void actualizar() {
		
	}
	
	public void motrar(int  compensacionX, int compensacionY, Pantalla pantalla) {
		
		pantalla.setDiferencia(compensacionX, compensacionY);
		
		//puntos cardinales(oeste, este, norte y sur)---temporal
		int o = compensacionX >> 5; // dividiendo entre 32 
		int e = (compensacionX + pantalla.getAncho() + Tile.LADO) >> 5;
		int n = compensacionY >> 5;
		int s = (compensacionY + pantalla.getAlto() + Tile.LADO) >> 5;
		
		for(int y = n; y < s; y++) {
			for(int x = 0; x < e; x++) {
				getTile(x,y).mostrar(x, y, pantalla);
			}
		}
	}
	
	public Tile getTile(final int x, final int y) {
		if(x < 0 || y < 0 || x >= ancho || y >= alto) {
			return Tile.Vacio;
		}
		switch(tiles[x + y * ancho]) {
		case 0:
			return Tile.Prueba;
		case 1:
		case 2:
		case 3:
		default:
			return Tile.Vacio;	
		}
	}
}
