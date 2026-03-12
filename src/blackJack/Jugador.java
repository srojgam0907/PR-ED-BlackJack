package blackJack;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

	private String nombre;
	private List<Carta> jugada; 
	private boolean plantado;

	public Jugador(String nombre) {
		this.nombre= nombre;
		this.jugada= new ArrayList<>();
		this.plantado= false;
	}
	
	/**
	 * Reparte una carta al jugador
	 * @param carta una carta aleatoria de la baraja
	 */
	public void darCarta(Carta carta) {
		jugada.add(carta);
	}
	
	/**
	 * Cambia el estado del jugador
	 */
	public void plantarse() {
		plantado= true;
	}
	
	/**
	 * @return nombre El nombre del jugador
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @return plantado El estado del jugador
	 */
	public boolean isPlantado() {
		return plantado;
	}
	
	/**
	 * @return jugada La lista de cartas del jugador
	 */
	public List<Carta> getJugada() {
		return jugada; 
	}
	
	/**
	 * Calcula la puntuación de las cartas del jugador
	 * teniendo en cuenta los Ases. Si el jugador se pasa
	 * de 21 y tiene algún AS, este pasa de valer 11 a valer 1
	 * @return total La puntacion del jugador
	 */
	public int calcularPuntuacion() {
		int total= 0;
		int contadorAS= 0;
		
		for(Carta carta : jugada) {
			total += carta.getValor();
			if(carta.esAs()) {
				contadorAS++;
			}
		}
		
		while(total > 21 && contadorAS > 0) {
			total-= 10;
			contadorAS--;
		}
		
		return total;
	}
	
	/**
	 * Comprueba si el jugador se ha pasado de 21
	 * @return true si se ha pasado, false si no
	 */
	public boolean pasado() {
		if(calcularPuntuacion() > 21) {
			return true;
			
		} else {
			return false; 
			
		}
	}
	
	@Override
    public String toString() {
        return nombre + ": " + jugada + " -> Puntos: " + calcularPuntuacion();
    } 
}




















