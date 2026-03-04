package blackJack;

public enum Palo {

	CORAZONES('♥'),
	DIAMANTES('♦'), 
	TREBOLES('♣'),
	PICAS('♠');
	
	private final char palo; 

    Palo(char simbolo) {
        this.palo= simbolo;
    }

    public char getSimbolo() {
        return palo;  
    }
}
