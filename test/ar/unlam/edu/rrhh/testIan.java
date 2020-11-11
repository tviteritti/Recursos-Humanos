package ar.unlam.edu.rrhh;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import ar.unlam.edu.persona.*;
import ar.unlam.edu.calendario.*;
import ar.unlam.edu.rrhh.*;


public class testIan {

	@Test
	public void JefeGerenteyEmpleadoCreadosCorrectamente() {
		
		Persona jefe=new Jefe(null, null, null, null, null, null, null);
		Persona gerente=new Gerente(null, null, null, null, null, null, null);
		Persona empleado=new Empleado(null, null, null, null, null, null, null);
		
		assertNotNull(jefe);
		assertNotNull(gerente);
		assertNotNull(empleado);
		
	}
	
	@Test
	public void QueSeCalculeCorrectamenteElSalarioBruto() {
		
		Persona jefe=new Jefe(null, null, null, null, null, 1000.0, 10);
		
		Double Salario=1000.0;
		Integer antiguedad=10;
		Double salarioBruto=Salario+(Salario*5/100)*antiguedad;
		
		assertEquals(jefe.salarioBruto(), salarioBruto);
		
		
	}
	
	@Test
	public void QueSecalculeCorrectamenteLaLiquidacionFinal() {
		
		
	}
	
	@Test
	public void QueSecalculeCorrectamenteElSalarioNeto() {
		
		Persona jefe=new Jefe(null, null, null, null, null, 1000.0, 0);
		
		jefe.setDiasAusentesEnUnMes(5, 4);
		
		Double descuento=(double)(jefe.getSalario()/30)*jefe.obtenerFaltasDelMes(4);
		Double salarioNeto=jefe.salarioBruto()-descuento;
		
		
		assertEquals(jefe.salarioNeto(4), salarioNeto);
		
		
	}
	
	@Test
	public void QueSecalculeCorrectamenteLasFaltasDelMes() {
		
		Persona jefe=new Jefe(null, null, null, null, null, null, null);
		
		Integer mes=8;
		Integer faltas=9;
		
		jefe.setDiasAusentesEnUnMes(faltas, mes);
		
		assertEquals(jefe.obtenerFaltasDelMes(mes), faltas);
		
		
	}
	
	@Test
	public void QueCalculeCorrectamenteLaAntiguedad() {
		
		Integer anosAntiguedad=10;
		Persona jefe=new Jefe(null, null, null, null, null, 1000.0, anosAntiguedad);
		
		Double antiguedad=(anosAntiguedad*0.05)*jefe.getSalario();
		
		assertEquals(jefe.calcularAntiguedad(), antiguedad);
		
		
	}
	
	@Test
	public void QueSeObtenganLasFaltasAnualesCorrectamente() {
		
		Persona jefe=new Jefe(123, 123, "Jose", "Alvarez", null, 1000.0, 0);
		
		assertNotNull(jefe);
		
		Integer faltas=5;
		
		jefe.setDiasAusentesEnUnMes(faltas, 2);
		jefe.setDiasAusentesEnUnMes(faltas, 3);
		jefe.setDiasAusentesEnUnMes(faltas, 4);
		jefe.setDiasAusentesEnUnMes(faltas, 5);
		jefe.setDiasAusentesEnUnMes(faltas, 6);
		
		faltas=faltas*5;
		
		assertEquals(jefe.obtenerFaltasAnuales(), faltas);
		
		
	}
	
	
	
	
	@Test
	public void QueSeRealiceUnReporteMensualCorrectamente() {
		
		Jefe jefe=new Jefe(123, 123, "Jose", "Alvarez", null, 1000.0, 0);
		Integer mes= 4 ;
		
		jefe.setDiasAusentesEnUnMes(5, mes);
		
		String reporte="Saldo= " + jefe.salarioNeto(mes) + ", ausentismo= " + jefe.obtenerFaltasDelMes(mes);
		
		assertEquals(jefe.reporteMensual(mes), reporte);
	}
	

}
