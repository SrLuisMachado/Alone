package principal.maquinaestado.estados.juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import principal.control.GestorControles;
import principal.entes.Jugador;
import principal.herramientas.CargadorRecursos;
import principal.interfaz_usuario.Interfaz_usuario;
import principal.mapas.Mapa;
import principal.maquinaestado.EstadoJuego;
import principal.sprites.HojaSprites;

public class GestorJuego implements EstadoJuego{
	
	Mapa mapa = new Mapa("/texto/prueba.lm");
	Jugador jugador = new Jugador(0, 0, mapa);
	
	public void actualizar() {
		jugador.actualizar();
		mapa.actualizar((int) jugador.getPosicionX(), (int) jugador.getPosicionY());
	}

	public void dibujar(Graphics g) {
		mapa.dibujar(g, (int) jugador.getPosicionX(), (int) jugador.getPosicionY());
		jugador.dibujar(g);
		
		g.setColor(Color.red);
		g.drawString("X = " + jugador.getPosicionX(), 20, 20);
		g.drawString("Y = " + jugador.getPosicionY(), 20, 35);
		
		Interfaz_usuario.dibujarBarraResistencia(g, jugador.resistencia);
	}
	
}
