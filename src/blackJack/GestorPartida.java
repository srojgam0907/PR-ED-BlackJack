package blackJack;

public class GestorPartida {

	private Jugador j1;
	private Jugador j2;
	private Baraja baraja;
	private Consola cs;
	
	public GestorPartida() {
        this.cs = new Consola();
        this.baraja = new Baraja();
    }
	
	/**
	 * Metodo principal que gestinona todo el juego
	 */
	public void iniciar() { 
		int numCartas;
		int numRonda= 1;
		boolean j1Sigue;
		boolean j2Sigue; 
		String opcion;
		String mensaje1;
		String mensaje2;
		
		j1= new Jugador(cs.leerTexto("Nombre del jugador 1: "));
		j2= new Jugador(cs.leerTexto("Nombre del jugador 2: "));
		
		mensaje1= j1.getNombre() + ", ¿Quieres carta (C) o quieres plantarte (P)";
		mensaje2= j2.getNombre() + ", ¿Quieres carta (C) o quieres plantarte (P)";
		
		numCartas= cs.leerEntero("¿Cuantás cartas queréis para empezar? (1 o 2)", 1, 2);
		baraja.barajar(); 
		
		for(int i= 0; i< numCartas; i++) {
			j1.darCarta(baraja.repartir());
			j2.darCarta(baraja.repartir());
		}
		
		//Bucle para cada ronda
		while(continuar()) {
			j1Sigue= false;
			j2Sigue= false;
			
			cs.escribirMensaje("\n--- RONDA " + numRonda + " ---");
			cs.escribirMensaje(j1);
			cs.escribirMensaje(j2); 
			cs.escribirMensaje("");
            cs.escribirMensaje("------------------------------------------------------");
            
            if(!j1.isPlantado() && !j1.pasado()) {
            	opcion= cs.leerOpcion(mensaje1, "C", "P");
            	if(opcion.equals("C")) {
            		j1Sigue= true;
            		
            	} else {
            		j1.plantarse();
            	}
            }

            if(!j2.isPlantado() && !j2.pasado()) {
            	opcion= cs.leerOpcion(mensaje2, "C", "P"); 
            	if(opcion.equals("C")) {
            		j2Sigue= true;
            		
            	} else {
            		j2.plantarse();
            	}
            }
            
            if(j1Sigue) {
            	j1.darCarta(baraja.repartir());
            }
            
            if(j2Sigue) {
            	j2.darCarta(baraja.repartir());
            }
            
            numRonda++; 
		}
		
		mostrarGanador();
	}
	
	/**
	 * Determina si la partida puede continuar
	 * @return sigue True si continua o false si no
	 */
	private boolean continuar() { 
		boolean sigue;
		
		if(j1.pasado() || j2.pasado()) {
			sigue= false;
			
		} else if(j1.isPlantado() && j2.isPlantado()){
			sigue= false; 
			
		} else {
			sigue= true; 
			
		}
		
		return sigue; 
	}
	
	/**
	 * Muestra el ganador de la partida segun la puntuación de cada uno
	 */
	private void mostrarGanador() {
		int p1 = j1.calcularPuntuacion();
        int p2 = j2.calcularPuntuacion();
        
		cs.escribirMensaje("\n--- RESULTADO FINAL ---"); 
		cs.escribirMensaje(j1);
		cs.escribirMensaje(j2);

		cs.escribirMensaje("");
		
        if (j1.pasado() && j2.pasado()) {
        	cs.escribirMensaje("EMPATE: Ambos se han pasado.");
        } else if (j1.pasado()) {
        	cs.escribirMensaje("GANADOR: " + j2.getNombre());
        } else if (j2.pasado()) {
        	cs.escribirMensaje("GANADOR: " + j1.getNombre());
        } else if (p1 > p2) {
        	cs.escribirMensaje("GANADOR: " + j1.getNombre());
        } else if (p2 > p1) {
        	cs.escribirMensaje("GANADOR: " + j2.getNombre()); 
        } else {
        	cs.escribirMensaje("EMPATE por puntos."); 
        }
	}
}
