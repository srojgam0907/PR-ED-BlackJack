package blackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {

	private List<Carta> cartas;
	
	public Baraja() {
		this.cartas= new ArrayList<>();
		crearBaraja();
	}
	
	private void crearBaraja() {
		for(Palo palo : Palo.values()) {
			for(TipoCarta valor : TipoCarta.values()) {
				this.cartas.add(new Carta(valor, palo));
			}
		}
	}
	
	public void barajar() {
		Collections.shuffle(cartas);
	}
	
	public Carta repartir() {
		if(cartas.isEmpty()) {
			throw new IllegalStateException("No quedan más cartas");
		}
		
		return cartas.remove(cartas.size()-1);
	}
}
