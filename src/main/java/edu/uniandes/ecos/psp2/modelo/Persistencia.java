package edu.uniandes.ecos.psp2.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para almacenar en una estructora de datos las variables mas relevantes para 
 * el calculo de una regresion lineal 
 * @author Melga
 *
 */
public class Persistencia {

	// VARIABLES 
	private List<Double> datosX;
	private List<Double> datosY;
	private double promedioX;
	private double promedioY;
	private double sumatoriaX;
	private double sumatoriaY;
	private double sumatoriaMultiplicacionXY;
	private double sumatoriaCuadradoY;
	private double sumatoriaCuadradoX;
	private double B0;
	private double B1;
	private double R;
	private double R2;
	private double Y;
	private double X;
	
	/**
	 * Constructor
	 * @param datosX
	 * @param datosY
	 */
	public Persistencia(){
		this.datosX = new ArrayList<Double>();
		this.datosY = new ArrayList<Double>();
	}
	
	/**
	 * Calcula los valores de las variables en el orden necesario usando las clases de los metodos
	 * definidos en Logica.java
	 */
	public void calcularRegresionLineal(){
		this.promedioX = Logica.calcularPromedio(datosX);
		this.promedioY = Logica.calcularPromedio(datosY);
		
		this.sumatoriaX = Logica.calcularSumatoria(datosX);
		this.sumatoriaY = Logica.calcularSumatoria(datosY);
		
		this.sumatoriaCuadradoX = Logica.calcularSumatoriaAlCuadrado(datosX);
		this.sumatoriaCuadradoY = Logica.calcularSumatoriaAlCuadrado(datosY);
		
		this.sumatoriaMultiplicacionXY = Logica.calcularSumatoriaMultiplicacionXY(datosX, datosY);		
		
		this.B1 = Logica.calcularB1(promedioX, promedioY, sumatoriaMultiplicacionXY, sumatoriaCuadradoX, (double)datosX.size());
		this.B0 = Logica.calcularB0(B1, promedioX, promedioY);
		
		this.R = Logica.calcularR((double) datosX.size(), sumatoriaMultiplicacionXY, sumatoriaX, sumatoriaY, sumatoriaCuadradoX, sumatoriaCuadradoY);
		this.R2 = Logica.calcularR2( this.R);
		
		this.Y = Logica.calcularY(this.B0, this.B1, this.X );
	}

	// SETTERS Y GETTERS
	
	public List<Double> getDatosX() {
		return datosX;
	}
	public List<Double> getDatosY() {
		return datosY;
	}

	public double getB0() {
		return B0;
	}

	public double getB1() {
		return B1;
	}

	public double getR() {
		return R;
	}

	public double getR2() {
		return R2;
	}

	public double getY() {
		return Y;
	}

	public double getX() {
		return X;
	}
	
	public void setX(double x) {
		X = x;
	}

}
