package graficos;

public final class Sprite {
	private final int tamanyo;
	
	private int x;
	private int y;
	
	public int[] pixeles;
	private HojaSprites hoja;
	
	//colección de Sprites
	public static final Sprite VACIO = new Sprite(32, 0);
	public static final Sprite BLOQUES = new Sprite(32, 0, 0, HojaSprites.Sprite_prueba);
	//fin de la colección
	
	public Sprite(final int lado, final int columna, final int fila, final HojaSprites hoja) {
		this.tamanyo=lado;
		
		pixeles = new int [lado * lado];
		
		this.x = columna * lado;
		this.y = fila * lado;
		this.hoja = hoja;
		
		for(int y = 0; y < lado; y++) {
			for(int x = 0; x < lado; x++) {
				pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.getAncho()];
			}
		}
	}
	
	public Sprite(final int lado, final int color) {
		this.tamanyo = lado;
		pixeles = new int[lado * lado];
		
		for(int i = 0; i < pixeles.length;i++) {
			pixeles[i] = color;
		}
	}
	public int getTamanyo() {
		return tamanyo;
	}
}
