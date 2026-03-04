package blackJack;

public class Carta {

	private final TipoCarta valor;
	private final Palo palo; 
	
	/**
     * Constructor para crear una carta.
     * @param palo El palo de la carta
     * @param tipo El tipo o figura
     */
	public Carta(TipoCarta valor, Palo palo) {
		this.valor= valor;
		this.palo= palo;
	}
	
	/**
     * Obtiene el valor numérico base de la carta.
     * @return El valor de la carta
     */
    public int getValor() {
        return valor.getValorBase();  
    }
	
    /**
     * Comprueba si la carta es un AS.
     * @return true si es un AS, false en caso contrario.
     */
    public boolean esAs() {
        return valor == TipoCarta.AS; 
    }
	
	/**
     * Devuelve la representación visual de la carta.
     * @return Formato legible, ejemplo: "AS♠" o "10♦".
     */
    @Override
    public String toString() {
        return valor + "" + palo.getSimbolo(); 
    }
}
