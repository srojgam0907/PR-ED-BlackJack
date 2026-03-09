package blackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {

	private List<Carta> cartas;
	
	/**
	 * Inicializa la baraja con las 52 cartas correspondientes.
	 * También genera automáticamente las combinaciones de cartas.
	 */
	public Baraja() {
		this.cartas= new ArrayList<>();
		crearBaraja();
	}
	
	/**
	 * Llena la lista con las 52 cartas de la baraja estándar.
	 */
	private void crearBaraja() {
		for(Palo palo : Palo.values()) {
			for(TipoCarta valor : TipoCarta.values()) {
				this.cartas.add(new Carta(valor, palo));
			}
		}
	}
	
	/**
	 * Mezcla las cartas de la lista de forma aleatoria
	 */
	public void barajar() {
		Collections.shuffle(cartas);
	}
	
	/**
	 * Extrae de la baraja la carta de arriba para repartirla
	 * @return la carta que se extrae
	 */
	public Carta repartir() {
		if(cartas.isEmpty()) {
			throw new IllegalStateException("No quedan más cartas");
		}
		
		return cartas.remove(cartas.size()-1);
	}
}
