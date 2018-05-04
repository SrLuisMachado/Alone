package graficos;

import entes.criatura.Jugador;
import mapa.tile.Tile;

public final class Pantalla {

	private final int ancho;
	private final int alto;
	
	private int diferenciaX;
	private int diferenciaY;
	
	public final int[] pixeles;
	
	
	
	public Pantalla(final int ancho, final int alto){
		this.ancho =ancho;
		this.alto = alto;
		
		pixeles = new int[ancho * alto];
	}
	
	public void limpiar() {
		for(int i = 0; i < pixeles.length; i++) {
			pixeles[i] = 0;
		}
	}
	
	
	//COMPENSACION x Y y ayuda a saber en que medida se a desplazado la pantalla del mapa
	public void mostrarTile(int compensacionX, int compensacionY, Tile Tile) {
		compensacionX -= diferenciaX;
		compensacionY -= diferenciaY;
		
		//doble bucle asegura que se acualiza de izquierda a derecha  arriba a bajo
		for(int y = 0; y < Tile.sprite.getTamanyo(); y++) {
			int posicionY = y + compensacionY;
			for(int x = 0; x < Tile.sprite.getTamanyo(); x++) {
				int posicionX = x + compensacionX;
				//este if no dibuja lo que esta fuera de pantalla
				if(posicionX < -Tile.sprite.getTamanyo() || posicionX >= ancho || posicionY < 0 || posicionY >= alto) {
					break;
				}
				//sin este if daria un error ya que modifique el if de arriba para que los tiles aparecieran aunque no hubiera un espacio de 32 bits(tamaño de los sprite)
				if(posicionX < 0) {
					posicionX = 0;
				}
				pixeles[posicionX + posicionY * ancho] = Tile.sprite.pixeles[x + y * Tile.sprite.getTamanyo()];
			}
		}
	}
	
	public void mostrarJugador(int compensacionX, int compensacionY, Jugador jugador) {
		compensacionX -= diferenciaX;
		compensacionY -= diferenciaY;
		
		//doble bucle asegura que se acualiza de izquierda a derecha  arriba a bajo
		for(int y = 0; y < jugador.getSprite().getTamanyo(); y++) {
			int posicionY = y + compensacionY;
			for(int x = 0; x < jugador.getSprite().getTamanyo(); x++) {
				int posicionX = x + compensacionX;
				//este if no dibuja lo que esta fuera de pantalla
				if(posicionX < -jugador.getSprite().getTamanyo() || posicionX >= ancho || posicionY < 0 || posicionY >= alto) {
					break;
				}
				//sin este if daria un error ya que modifique el if de arriba para que los tiles aparecieran aunque no hubiera un espacio de 32 bits(tamaño de los sprite)
				if(posicionX < 0) {
					posicionX = 0;
				}
				//pixeles[posicionX + posicionY * ancho] = jugador.getSprite().pixeles[x + y * jugador.getSprite().getTamanyo()];
				int colorPixelJugador = jugador.getSprite().pixeles[x+y*jugador.getSprite().getTamanyo()];
				if(colorPixelJugador != 0xffff00ff) {
					pixeles[posicionX + posicionY * ancho] = colorPixelJugador;
				}
				
			}
		}
	}
	
	public void setDiferencia(final int diferenciaX, final int diferenciaY){
		this.diferenciaX = diferenciaX;
		this.diferenciaY = diferenciaY;
	}
	
	public int getAncho(){
		return ancho;
	}
	public int getAlto(){
		return alto;
	}
}
