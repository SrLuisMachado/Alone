package principal.interfaz_usuario;

import java.awt.Color;
import java.awt.Graphics;

public class Interfaz_usuario {
	
	public static void dibujarBarraResistencia(Graphics g, int resistencia) {
		int ancho = 100 * resistencia / 600;
		Color VerdeOscuro = new Color(0 ,152 ,0);
		
		g.setColor(Color.white);
		g.drawRect(19, 99, 102, 17);
		
		g.setColor(Color.green);
		g.fillRect(20, 100, ancho, 5);
		
		g.setColor(VerdeOscuro);
		g.fillRect(20, 105, ancho, 10);
	}
}
