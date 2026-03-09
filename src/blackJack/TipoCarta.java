package blackJack;

public enum TipoCarta {

	AS(11), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), 
	OCHO(8), NUEVE(9), DIEZ(10), JOTA(10), REINA(10), REY(10);
	
	private final int valor;

    TipoCarta(int valor) {
        this.valor = valor;
    }

    public int getValorBase() {
        return valor; 
    }
    
    @Override
    public String toString() {
        return switch (this) {
            case AS -> "A";
            case JOTA -> "J";
            case REINA -> "Q";
            case REY -> "K";
            case DIEZ -> "10";
            default -> String.valueOf(this.valor); // Para 2 al 9, usa su valor
        };
    }
}
