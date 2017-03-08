package edu.uniandes.ecos.psp2.vista;

import edu.uniandes.ecos.psp2.modelo.Persistencia;

/**
 * Clase auxiliar para mostrar resultados de forma ordenada
 * @author Melga
 *
 */
public class Presentacion {
	
	/**
	 * Metodo estatico que recibe una instancia de la persistencia de datos y realiza la impresion de las
	 * operacion entre variables para calcular la regresion lineal
	 * @param datos
	 */
	public static void mostrarResultados(Persistencia datos){
		System.out.println("Resultado:");
		System.out.println("B0: "+datos.getB0());
		System.out.println("B1: "+datos.getB1());
		
		System.out.println("R: "+datos.getR());
		System.out.println("R2: "+datos.getR2());
		
		System.out.println("Y: "+datos.getY());
	}
}
