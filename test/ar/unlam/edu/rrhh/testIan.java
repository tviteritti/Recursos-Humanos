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
	public void QueSecalculeCorrectamenteElSalarioBruto() {
		
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
		
		Persona jefe=new Jefe(null, null, null, null, null, 1000.0, 10);
		
		Integer ausentismo[]=new Integer [12];
		ausentismo[4-1]=5;
		jefe.setAusentismo(ausentismo);
		
		Double descuento=(double)(jefe.getSalario()/30)*jefe.obtenerFaltasDelMes(4);
		Double salarioNeto=jefe.salarioBruto()-descuento;
		
		
		assertEquals(jefe.salarioNeto(4), salarioNeto);
		
		
	}
	
	@Test
	public void QueSecalculeCorrectamenteLasFaltasDelMes() {
		
		Persona jefe=new Jefe(null, null, null, null, null, null, null);
		
		Integer mes=8;
		Integer faltas=9;
		Integer ausentismo[]=new Integer[12];
		ausentismo[mes-1]=faltas;
		
		jefe.setAusentismo(ausentismo);
		
		assertEquals(jefe.obtenerFaltasDelMes(mes), faltas);
		
		
	}
	
	@Test
	public void QueCalculeCorrectamenteLaAntiguedad() {
		
		Integer anosAntiguedad=10;
		Persona jefe=new Jefe(null, null, null, null, null, null, anosAntiguedad);
		
		Double antiguedad=(double)anosAntiguedad*(anosAntiguedad*5/100);
		
		
		assertEquals(jefe.calcularAntiguedad(), antiguedad);
		
		
	}
	
	

}
