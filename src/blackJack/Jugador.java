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
	
	public void darCarta(Carta carta) {
		jugada.add(carta);
	}
	
	public void plantarse() {
		plantado= true;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean isPlantado() {
		return plantado;
	}
	
	public List<Carta> getJugada() {
		return jugada; 
	}
	
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




















