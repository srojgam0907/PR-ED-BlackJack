package blackJack;

import java.util.Scanner;

public class Consola {

	private Scanner kb;
	
	public Consola() {
		this.kb= new Scanner(System.in);
	}
	
	/**
	 * Imprime por pantalla un mensaje para el usuario
	 * @param mensaje El mensaje dirigido al usuario
	 */
	public void escribirMensaje(Object mensaje) { 
		System.out.println(mensaje);
	}
	
	/**
	 * Imprime por pantalla una mensaje de error
	 * @param mensaje El mensaje para informar al usuario
	 */
	public void escribirError(String mensaje) {
		System.out.println("ERROR: " + mensaje); 
	}
	
	/**
     * Lee una cadena de texto del usuario.
     * @param mensaje Invitación a escribir (prompt).
     * @return El texto introducido.
     */
    public String leerTexto(String mensaje) {
        escribirMensaje(mensaje);
        return kb.nextLine();
    }
	
    /**
     * Lee un número entero y valida que esté dentro de un rango.
     * @param mensaje Invitación a escribir.
     * @param min Valor mínimo aceptado.
     * @param max Valor máximo aceptado.
     * @return El número validado.
     */
    public int leerEntero(String mensaje, int min, int max) {
        int numero= 0;
        boolean error= false;
        
        do {
            try {
                escribirMensaje(mensaje);
                numero = Integer.parseInt(kb.nextLine());
                
                if (numero >= min && numero <= max) {
                	error= false;
                	
                } else {
                	escribirError("Introduce un número entre " + min + " y " + max + ".");
                	error= true;
                }
                
            } catch (NumberFormatException e) {
                escribirError("Entrada no válida. Debes introducir un número entero.");
            }
        } while (error);
        
        return numero;
    }

    /**
     * Lee una opción de tipo texto y valida que sea una de las permitidas.
     * @param mensaje Invitación a escribir.
     * @param opcionesValidas Array de strings con las opciones aceptadas (ej: "C", "P").
     * @return La opción elegida en mayúsculas.
     */
    public String leerOpcion(String mensaje, String... opcionesValidas) {
    	String entrada;
    	boolean error;
    	
        do {
        	error= true;
            escribirMensaje(mensaje);
            entrada = kb.nextLine().trim().toUpperCase();
            
            for (int i=0; i< opcionesValidas.length && error; i++) {
                if (entrada.equals(opcionesValidas[i].toUpperCase())) {
                    error= false;
                    
                }
            }
            
            if(error) {
            	escribirError("Opción no válida. Inténtalo de nuevo."); 
            }

        } while (error);
        
        return entrada; 
    }
}
