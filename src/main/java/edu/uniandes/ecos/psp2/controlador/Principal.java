package edu.uniandes.ecos.psp2.controlador;

import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.uniandes.ecos.psp2.modelo.Persistencia;
import edu.uniandes.ecos.psp2.vista.Presentacion;

/**
	* Programa 3 desarrollado para calcular variables de regresion lineal
	* ECOS Primer Semestre de 2017
	*
	* @author  Daniel Melgarejo
**/
public class Principal {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Por favor ingrese la ruta del archivo a analizar");
		String ruta = in.nextLine();
		//String ruta = "C:\\Users\\Melga\\workspace\\Tarea3\\src\\test\\resources\\test1.txt";
		Persistencia datos = new Persistencia();
		Lector lector = new Lector(datos);
		try {
			lector.leerArchivo(ruta);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		datos.calcularRegresionLineal();
		//Impresion de resultados
		Presentacion.mostrarResultados(datos);
	}
}
