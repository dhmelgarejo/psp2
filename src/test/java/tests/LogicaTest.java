package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.uniandes.ecos.psp2.modelo.Logica;

public class LogicaTest {

	public List<Double> listaPositivosGrandes(){
		List<Double> listaNegativos = new ArrayList<Double>();
		listaNegativos.add((double) 100050000);
		listaNegativos.add((double) 200300000);
		listaNegativos.add((double) 300050000);
		listaNegativos.add((double) 400300000);
		listaNegativos.add((double) 500050000);
		listaNegativos.add((double) 600300000);
		listaNegativos.add((double) 700050000);
		listaNegativos.add((double) 800300000);
		listaNegativos.add((double) 900050000);
		listaNegativos.add((double) 1003000000);
		return listaNegativos;
	}

	
	public List<Double> listaNegativosGrandes(){
		List<Double> listaNegativos = new ArrayList<Double>();
		listaNegativos.add((double) -100000000);
		listaNegativos.add((double) -200000000);
		listaNegativos.add((double) -300000000);
		listaNegativos.add((double) -400000000);
		listaNegativos.add((double) -500000000);
		listaNegativos.add((double) -600000000);
		listaNegativos.add((double) -700000000);
		listaNegativos.add((double) -800000000);
		listaNegativos.add((double) -900000000);
		listaNegativos.add((double) -1000000000);
		return listaNegativos;
	}

	public List<Double> listaCombinadosGrandes(){
		List<Double> listaNegativos = new ArrayList<Double>();
		listaNegativos.add((double) -100000000);
		listaNegativos.add((double) 200000000);
		listaNegativos.add((double) -300000000);
		listaNegativos.add((double) -400000000);
		listaNegativos.add((double) 500000000);
		listaNegativos.add((double) -600000000);
		listaNegativos.add((double) -700000000);
		listaNegativos.add((double) 800000000);
		listaNegativos.add((double) 900000000);
		listaNegativos.add((double) -1000000000);
		return listaNegativos;
	}
	
	@Test
	public void testCalcularPromedio() {
		List<Double> listaNegativosGrandes = listaNegativosGrandes();
		List<Double> listaCombinadosGrandes = listaCombinadosGrandes();
		List<Double> listaPositivosGrandes = listaPositivosGrandes();
		
		assertEquals(-550000000.0, Logica.calcularPromedio(listaNegativosGrandes),0.001);
		assertEquals(-70000000.0, Logica.calcularPromedio(listaCombinadosGrandes),0.001);
		assertEquals(5.50445E8, Logica.calcularPromedio(listaPositivosGrandes),0.001);
	}

	@Test
	public void testCalcularSumatoria() {
		List<Double> listaNegativosGrandes = listaNegativosGrandes();
		List<Double> listaCombinadosGrandes = listaCombinadosGrandes();
		List<Double> listaPositivosGrandes = listaPositivosGrandes();
		
		assertEquals(-700000000.0, Logica.calcularSumatoria(listaCombinadosGrandes),0.001);
		assertEquals(-5500000000.0, Logica.calcularSumatoria(listaNegativosGrandes),0.001);
		assertEquals(5504450000.0, Logica.calcularSumatoria(listaPositivosGrandes),0.001);
	}

	@Test
	public void testCalcularSumatoriaAlCuadrado() {
		List<Double> listaNegativosGrandes = listaNegativosGrandes();
		List<Double> listaCombinadosGrandes = listaCombinadosGrandes();
		List<Double> listaPositivosGrandes = listaPositivosGrandes();
		
		assertEquals(3.85E18 , Logica.calcularSumatoriaAlCuadrado(listaCombinadosGrandes),0.001);
		assertEquals(3.85E18, Logica.calcularSumatoriaAlCuadrado(listaNegativosGrandes),0.001);
		assertEquals(3857459372500000000.0, Logica.calcularSumatoriaAlCuadrado(listaPositivosGrandes),0.001);
	}

	@Test
	public void testCalcularSumatoriaMultiplicacionXY() {
		List<Double> listaNegativosGrandes = listaNegativosGrandes();
		List<Double> listaCombinadosGrandes = listaCombinadosGrandes();
		List<Double> listaPositivosGrandes = listaPositivosGrandes();
		
		assertEquals(3.7E17, Logica.calcularSumatoriaMultiplicacionXY(listaNegativosGrandes, listaCombinadosGrandes),0.001);
		assertEquals(-3.72985E17, Logica.calcularSumatoriaMultiplicacionXY(listaCombinadosGrandes, listaPositivosGrandes),0.001);
		assertEquals(-3.853725E18, Logica.calcularSumatoriaMultiplicacionXY(listaPositivosGrandes, listaNegativosGrandes),0.001);
	}

	@Test
	public void testCalcularB1() {
		List<Double> listaNegativosGrandes = listaNegativosGrandes();
		List<Double> listaCombinadosGrandes = listaCombinadosGrandes();
		List<Double> listaPositivosGrandes = listaPositivosGrandes();
		
		double promedioListaCombinadosGrandes = Logica.calcularPromedio(listaCombinadosGrandes);
		double promedioListaNegativosGrandes = Logica.calcularPromedio(listaNegativosGrandes);
		double promedioListaPositivosGrandes = Logica.calcularPromedio(listaPositivosGrandes);
		
		double sumMulti1 = Logica.calcularSumatoriaMultiplicacionXY(listaCombinadosGrandes, listaNegativosGrandes);
		double sumMulti2 = Logica.calcularSumatoriaMultiplicacionXY(listaPositivosGrandes, listaNegativosGrandes);
		double sumMulti3 = Logica.calcularSumatoriaMultiplicacionXY(listaCombinadosGrandes, listaPositivosGrandes);
		
		double sumCuadradoListaCombinadosGrandes = Logica.calcularSumatoriaAlCuadrado(listaCombinadosGrandes);
		double sumCuadradoListaNegativosGrandes = Logica.calcularSumatoriaAlCuadrado(listaNegativosGrandes);
		double sumCuadradoListaPositivosGrandes = Logica.calcularSumatoriaAlCuadrado(listaPositivosGrandes);
		
		
		assertEquals(-0.00395, Logica.calcularB1(promedioListaCombinadosGrandes, promedioListaNegativosGrandes, sumMulti1, sumCuadradoListaCombinadosGrandes,10),0.001);
		assertEquals(-0.99845, Logica.calcularB1(promedioListaPositivosGrandes, promedioListaNegativosGrandes, sumMulti2, sumCuadradoListaPositivosGrandes,10),0.001);
		assertEquals(0.00324, Logica.calcularB1(promedioListaCombinadosGrandes, promedioListaPositivosGrandes, sumMulti3, sumCuadradoListaCombinadosGrandes,10),0.001);
		assertEquals(-0.01818, Logica.calcularB1(promedioListaNegativosGrandes, promedioListaCombinadosGrandes, sumMulti1, sumCuadradoListaNegativosGrandes,10),0.001);
	}

	@Test
	public void testCalcularB0() {

		List<Double> listaNegativosGrandes = listaNegativosGrandes();
		List<Double> listaCombinadosGrandes = listaCombinadosGrandes();
		List<Double> listaPositivosGrandes = listaPositivosGrandes();
		
		double promedioListaCombinadosGrandes = Logica.calcularPromedio(listaCombinadosGrandes);
		double promedioListaNegativosGrandes = Logica.calcularPromedio(listaNegativosGrandes);
		double promedioListaPositivosGrandes = Logica.calcularPromedio(listaPositivosGrandes);
		
		double sumMulti1 = Logica.calcularSumatoriaMultiplicacionXY(listaCombinadosGrandes, listaNegativosGrandes);
		double sumMulti2 = Logica.calcularSumatoriaMultiplicacionXY(listaPositivosGrandes, listaNegativosGrandes);
		double sumMulti3 = Logica.calcularSumatoriaMultiplicacionXY(listaCombinadosGrandes, listaPositivosGrandes);
		
		double sumCuadradoListaCombinadosGrandes = Logica.calcularSumatoriaAlCuadrado(listaCombinadosGrandes);
		double sumCuadradoListaNegativosGrandes = Logica.calcularSumatoriaAlCuadrado(listaNegativosGrandes);
		double sumCuadradoListaPositivosGrandes = Logica.calcularSumatoriaAlCuadrado(listaPositivosGrandes);
		
		double B1 = Logica.calcularB1(promedioListaCombinadosGrandes, promedioListaNegativosGrandes, sumMulti1, sumCuadradoListaCombinadosGrandes,10);
		double B2 = Logica.calcularB1(promedioListaPositivosGrandes, promedioListaNegativosGrandes, sumMulti2, sumCuadradoListaPositivosGrandes,10);
		double B3 = Logica.calcularB1(promedioListaCombinadosGrandes, promedioListaPositivosGrandes, sumMulti3, sumCuadradoListaCombinadosGrandes,10);
		double B4 = Logica.calcularB1(promedioListaNegativosGrandes, promedioListaCombinadosGrandes, sumMulti1, sumCuadradoListaNegativosGrandes,10);
		
		assertEquals(-5.502762430939226E8, Logica.calcularB0(B1, promedioListaCombinadosGrandes, promedioListaNegativosGrandes),0.001);
		assertEquals(-5.478277624309392E8, Logica.calcularB0(B1, promedioListaPositivosGrandes, promedioListaNegativosGrandes),0.001);
		assertEquals(5.501687569060774E8, Logica.calcularB0(B1, promedioListaCombinadosGrandes, promedioListaPositivosGrandes),0.001);
		assertEquals(-7.217048145224941E7, Logica.calcularB0(B1, promedioListaNegativosGrandes, promedioListaCombinadosGrandes),0.001);
	
	}

	@Test
	public void testCalcularR() {

		List<Double> listaNegativosGrandes = listaNegativosGrandes();
		List<Double> listaCombinadosGrandes = listaCombinadosGrandes();
		List<Double> listaPositivosGrandes = listaPositivosGrandes();
		
		double sumatoria1 = Logica.calcularSumatoria(listaNegativosGrandes);
		double sumatoria2 = Logica.calcularSumatoria(listaCombinadosGrandes);
		double sumatoria3 = Logica.calcularSumatoria(listaPositivosGrandes);
		
		double sumMulti1 = Logica.calcularSumatoriaMultiplicacionXY(listaCombinadosGrandes, listaNegativosGrandes);
		double sumMulti2 = Logica.calcularSumatoriaMultiplicacionXY(listaPositivosGrandes, listaNegativosGrandes);
		double sumMulti3 = Logica.calcularSumatoriaMultiplicacionXY(listaCombinadosGrandes, listaPositivosGrandes);
		
		double sumCuadradoListaCombinadosGrandes = Logica.calcularSumatoriaAlCuadrado(listaCombinadosGrandes);
		double sumCuadradoListaNegativosGrandes = Logica.calcularSumatoriaAlCuadrado(listaNegativosGrandes);
		double sumCuadradoListaPositivosGrandes = Logica.calcularSumatoriaAlCuadrado(listaPositivosGrandes);
		
		assertEquals(-0.00847062293854015, Logica.calcularR(10, sumMulti1, sumatoria2, sumatoria1, sumCuadradoListaCombinadosGrandes, sumCuadradoListaNegativosGrandes),0.001);
		assertEquals(-0.9999967289055716, Logica.calcularR(10, sumMulti2, sumatoria3, sumatoria1, sumCuadradoListaPositivosGrandes, sumCuadradoListaNegativosGrandes),0.001);
		assertEquals(0.006950090696973171, Logica.calcularR(10, sumMulti3, sumatoria2, sumatoria3, sumCuadradoListaCombinadosGrandes, sumCuadradoListaPositivosGrandes),0.001);
	}

	@Test
	public void testCalcularR2() {
		List<Double> listaNegativosGrandes = listaNegativosGrandes();
		List<Double> listaCombinadosGrandes = listaCombinadosGrandes();
		List<Double> listaPositivosGrandes = listaPositivosGrandes();
		
		double sumatoria1 = Logica.calcularSumatoria(listaNegativosGrandes);
		double sumatoria2 = Logica.calcularSumatoria(listaCombinadosGrandes);
		double sumatoria3 = Logica.calcularSumatoria(listaPositivosGrandes);
		
		double sumMulti1 = Logica.calcularSumatoriaMultiplicacionXY(listaCombinadosGrandes, listaNegativosGrandes);
		double sumMulti2 = Logica.calcularSumatoriaMultiplicacionXY(listaPositivosGrandes, listaNegativosGrandes);
		double sumMulti3 = Logica.calcularSumatoriaMultiplicacionXY(listaCombinadosGrandes, listaPositivosGrandes);
		
		double sumCuadradoListaCombinadosGrandes = Logica.calcularSumatoriaAlCuadrado(listaCombinadosGrandes);
		double sumCuadradoListaNegativosGrandes = Logica.calcularSumatoriaAlCuadrado(listaNegativosGrandes);
		double sumCuadradoListaPositivosGrandes = Logica.calcularSumatoriaAlCuadrado(listaPositivosGrandes);
		
		double R1 = Logica.calcularR(10, sumMulti1, sumatoria2, sumatoria1, sumCuadradoListaCombinadosGrandes, sumCuadradoListaNegativosGrandes);
		double R2 = Logica.calcularR(10, sumMulti2, sumatoria3, sumatoria1, sumCuadradoListaPositivosGrandes, sumCuadradoListaNegativosGrandes);
		double R3 = Logica.calcularR(10, sumMulti3, sumatoria2, sumatoria3, sumCuadradoListaCombinadosGrandes, sumCuadradoListaPositivosGrandes);
		
		assertEquals(0.00007175145297, Logica.calcularR2(R1) ,0.001);
		assertEquals(0.9999934578, Logica.calcularR2(R2),0.001);
		assertEquals(0.0000483037607, Logica.calcularR2(R3),0.001);
	
	}

	@Test
	public void testCalcularY() {

		List<Double> listaNegativosGrandes = listaNegativosGrandes();
		List<Double> listaCombinadosGrandes = listaCombinadosGrandes();
		List<Double> listaPositivosGrandes = listaPositivosGrandes();
		double X = 386;
		
		double promedioListaCombinadosGrandes = Logica.calcularPromedio(listaCombinadosGrandes);
		double promedioListaNegativosGrandes = Logica.calcularPromedio(listaNegativosGrandes);
		double promedioListaPositivosGrandes = Logica.calcularPromedio(listaPositivosGrandes);
		
		double sumMulti1 = Logica.calcularSumatoriaMultiplicacionXY(listaCombinadosGrandes, listaNegativosGrandes);
		double sumMulti2 = Logica.calcularSumatoriaMultiplicacionXY(listaPositivosGrandes, listaNegativosGrandes);
		double sumMulti3 = Logica.calcularSumatoriaMultiplicacionXY(listaCombinadosGrandes, listaPositivosGrandes);
		
		double sumCuadradoListaCombinadosGrandes = Logica.calcularSumatoriaAlCuadrado(listaCombinadosGrandes);
		double sumCuadradoListaNegativosGrandes = Logica.calcularSumatoriaAlCuadrado(listaNegativosGrandes);
		double sumCuadradoListaPositivosGrandes = Logica.calcularSumatoriaAlCuadrado(listaPositivosGrandes);
		
		double B01 = Logica.calcularB1(promedioListaCombinadosGrandes, promedioListaNegativosGrandes, sumMulti1, sumCuadradoListaCombinadosGrandes,10);
		double B02 = Logica.calcularB1(promedioListaPositivosGrandes, promedioListaNegativosGrandes, sumMulti2, sumCuadradoListaPositivosGrandes,10);
		double B03 = Logica.calcularB1(promedioListaCombinadosGrandes, promedioListaPositivosGrandes, sumMulti3, sumCuadradoListaCombinadosGrandes,10);
		double B04 = Logica.calcularB1(promedioListaNegativosGrandes, promedioListaCombinadosGrandes, sumMulti1, sumCuadradoListaNegativosGrandes,10);
		
		double B11 = Logica.calcularB0(B01, promedioListaCombinadosGrandes, promedioListaNegativosGrandes);
		double B12 = Logica.calcularB0(B02, promedioListaPositivosGrandes, promedioListaNegativosGrandes);
		double B13 = Logica.calcularB0(B03, promedioListaCombinadosGrandes, promedioListaPositivosGrandes);
		double B14 = Logica.calcularB0(B04, promedioListaNegativosGrandes, promedioListaCombinadosGrandes);

		assertEquals(-2.1240662983425806E11, Logica.calcularY(B01, B11, X) ,0.001);
		assertEquals(-1.5811851837600014E8, Logica.calcularY(B02, B12, X) ,0.001);
		assertEquals(2.1255939484346548E11, Logica.calcularY(B03, B13, X) ,0.001);
		assertEquals(-3.088000000001818E10, Logica.calcularY(B04, B14, X) ,0.001);
		
	}

}
