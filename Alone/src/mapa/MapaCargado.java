package mapa;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import mapa.tile.Tile;

public class MapaCargado extends Mapa{

	private int[] pixeles;
	
	public MapaCargado(String ruta) {
		super(ruta);
		
	}

	protected void cargarMapa(String ruta) {
		try {
			BufferedImage imagen = ImageIO.read(MapaCargado.class.getResource(ruta));
			
			ancho = imagen.getWidth();
			alto = imagen.getHeight();
			
			TileMapa = new Tile[ancho * alto];
			pixeles = new int[ancho * alto];
			
			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void generarMapa() {
		for(int i = 0; i < pixeles.length; i++) {
			switch(pixeles[i]) {
			case 0xff00cf00:
				TileMapa[i] = Tile.CESPED;
				continue;
			case 0xff4903d3:
				TileMapa[i] = Tile.AGUJERO1;
				continue;
			case 0xffff6512:
				TileMapa[i] = Tile.AGUJERO2;
				continue;
			case 0xff00ebd5:
				TileMapa[i] = Tile.AGUJERO3;
				continue;
			case 0xff5d5d4a:
				TileMapa[i] = Tile.AGUJERO4;
				continue;
			case 0xff100e00:
				TileMapa[i] = Tile.AGUJERO5;
				continue;
			case 0xff009500:
				TileMapa[i] = Tile.AGUJERO6;
				continue;
			case 0xfff07d96:
				TileMapa[i] = Tile.AGUJERO7;
				continue;
			case 0xffe8dd00:
				TileMapa[i] = Tile.AGUJERO8;
				continue;
			case 0xffea7dc8:
				TileMapa[i] = Tile.AGUJERO9;
				continue;
			case 0xfff2cf64:
				TileMapa[i] = Tile.CASA1;
				continue;
			case 0xffefc723:
				TileMapa[i] = Tile.CASA2;
				continue;
			case 0xffffbc68:
				TileMapa[i] = Tile.CASA3;
				continue;
			case 0xffffaf6b:
				TileMapa[i] = Tile.CASA4;
				continue;
			case 0xff00e800:
				TileMapa[i] = Tile.ARBOL1;
				continue;
			case 0xff598d00:
				TileMapa[i] = Tile.ARBOL2;
				continue;
			case 0xffffad00:
				TileMapa[i] = Tile.ARBOL3;
				continue;
			case 0xffb15500:
				TileMapa[i] = Tile.ARBOL4;
				continue;
			default:
				TileMapa[i] = Tile.VACIO;
			}
		}
	}
}
