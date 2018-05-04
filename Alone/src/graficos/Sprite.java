package graficos;

public final class Sprite {
	private final int tamanyo;
	
	private int x;
	private int y;
	
	public int[] pixeles;
	private HojaSprites hoja;
	
	// Colección de sprites del personaje
	public static final Sprite Abajo0 = new Sprite(32, 0, 0, HojaSprites.jugador);
	public static final Sprite Abajo1 = new Sprite(32, 0, 1, HojaSprites.jugador);
	public static final Sprite Abajo2 = new Sprite(32, 0, 2, HojaSprites.jugador);
	
	public static final Sprite Arriba0 = new Sprite(32, 1, 0, HojaSprites.jugador);
	public static final Sprite Arriba1 = new Sprite(32, 1, 1, HojaSprites.jugador);
	public static final Sprite Arriba2 = new Sprite(32, 1, 2, HojaSprites.jugador);
	
	public static final Sprite derecha0 = new Sprite(32, 2, 0, HojaSprites.jugador);
	public static final Sprite derecha1 = new Sprite(32, 2, 1, HojaSprites.jugador);
	public static final Sprite derecha2 = new Sprite(32, 2, 2, HojaSprites.jugador);

	public static final Sprite izquierda0 = new Sprite(32, 3, 0, HojaSprites.jugador);
	public static final Sprite izquierda1 = new Sprite(32, 3, 1, HojaSprites.jugador);
	public static final Sprite izquierda2 = new Sprite(32, 3, 2, HojaSprites.jugador);
	// Fin de la colección
	
	//colección de Sprites
	public static final Sprite VACIO = new Sprite(32, 0);
	
	//CESPED
	public static final Sprite CESPED = new Sprite(32, 0, 0, HojaSprites.Sprite_prueba);
	
	//AGUJERO
	public static final Sprite  AGUJERO1= new Sprite(32, 1, 0, HojaSprites.Sprite_prueba);
	public static final Sprite  AGUJERO2= new Sprite(32, 2, 0, HojaSprites.Sprite_prueba);
	public static final Sprite  AGUJERO3= new Sprite(32, 3, 0, HojaSprites.Sprite_prueba);
	public static final Sprite  AGUJERO4= new Sprite(32, 1, 1, HojaSprites.Sprite_prueba);
	public static final Sprite  AGUJERO5= new Sprite(32, 2, 1, HojaSprites.Sprite_prueba);
	public static final Sprite  AGUJERO6= new Sprite(32, 3, 1, HojaSprites.Sprite_prueba);
	public static final Sprite  AGUJERO7= new Sprite(32, 1, 2, HojaSprites.Sprite_prueba);
	public static final Sprite  AGUJERO8= new Sprite(32, 2, 2, HojaSprites.Sprite_prueba);
	public static final Sprite  AGUJERO9= new Sprite(32, 3, 2, HojaSprites.Sprite_prueba);
	
	//ARBOL
	public static final Sprite  ARBOL1= new Sprite(32, 4, 0, HojaSprites.Sprite_prueba);
	public static final Sprite  ARBOL2= new Sprite(32, 5, 0, HojaSprites.Sprite_prueba);
	public static final Sprite  ARBOL3= new Sprite(32, 4, 1, HojaSprites.Sprite_prueba);
	public static final Sprite  ARBOL4= new Sprite(32, 5, 1, HojaSprites.Sprite_prueba);
	
	//CASA
	public static final Sprite  CASA1= new Sprite(32, 6, 0, HojaSprites.Sprite_prueba);
	public static final Sprite  CASA2= new Sprite(32, 7, 0, HojaSprites.Sprite_prueba);
	public static final Sprite  CASA3= new Sprite(32, 6, 1, HojaSprites.Sprite_prueba);
	public static final Sprite  CASA4= new Sprite(32, 7, 1, HojaSprites.Sprite_prueba);

	
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
	
//	private void cargarSprite(int version) {
//		if(version == 0) {
//			cargaNormal();
//		} else {
//			
//		}
//		
//	}
	
//	private void cargaNormal(){
//		for(int y = 0; y < tamanyo; y++) {
//			for(int x = 0; x < tamanyo; x++) {
//				pixeles[x + y * tamanyo] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.getAncho()];
//			}
//		}
//	}
}
