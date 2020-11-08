package ar.unlam.edu.rrhh;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.unlam.edu.calendario.Calendario;
import ar.unlam.edu.persona.Empleado;
import ar.unlam.edu.persona.Gerente;
import ar.unlam.edu.persona.Jefe;
import ar.unlam.edu.persona.Persona;

public class testTomas {

	@Test
	public void queSeCumplanfaltasDelMes() {
		
		Persona g1=new Gerente(1, 123, "jorge", "lopez", new Calendario(1999, 4, 3), 3007.0, 5);
		Persona j1=new Jefe(2, 456, "federico", "perez", new Calendario(1995, 5, 12), 3000.0, 0);
		Persona e1=new Empleado(3, 789, "tomas", "diaz", new Calendario(1993, 7, 1), 3001.0, 1);
		
		for (int i = 0; i < 12; i++) {
			g1.setDiasAusentesEnUnMes(i, i);
			j1.setDiasAusentesEnUnMes(i+1, i);
			e1.setDiasAusentesEnUnMes(i+2, i);
		}
		
		assertNotNull(g1);
		assertNotNull(j1);
		assertNotNull(e1);
		
		Integer faltasG= g1.obtenerFaltasDelMes(1);
		Integer expectedG=0;
		assertEquals(expectedG,faltasG);
		
		Integer faltasF= j1.obtenerFaltasDelMes(1);;
		Integer expectedF=1;
		assertEquals(expectedF,faltasF);
		
		Integer faltasE= e1.obtenerFaltasDelMes(1);
		Integer expectedE=2;
		assertEquals(expectedE,faltasE);
		
		
		
	}
	

	@Test
	public void queSeCumplanSalarioNetoBruto() {
		
		Persona g1=new Gerente(1, 123, "jorge", "lopez", new Calendario(1999, 4, 3), 3007.0, 5);
		Persona j1=new Jefe(2, 456, "federico", "perez", new Calendario(1995, 5, 12), 3000.0, 0);
		Persona e1=new Empleado(3, 789, "tomas", "diaz", new Calendario(1993, 7, 1), 3001.0, 1);
		
		for (int i = 0; i < 12; i++) {
			g1.setDiasAusentesEnUnMes(i, i);
			j1.setDiasAusentesEnUnMes(i+1, i);
			e1.setDiasAusentesEnUnMes(i+2, i);
		}
		
		Double expectedG=3758.75; //saldo 3007 antiguedad 5
		assertEquals(expectedG, g1.salarioBruto());
		
		Double expectedJ=3000.0; //saldo 3007 antiguedad 5
		assertEquals(expectedJ, j1.salarioBruto());
		
		Double expectedE=3151.05; //saldo 3007 antiguedad 5
		assertEquals(expectedE, e1.salarioBruto());
		
		
		Double expectedG1=3357.816; //aisentismo 4
		assertEquals(expectedG1, g1.salarioNeto(5),0.01);
		
		Double expectedJ1=2500.0; //ausentismo 5
		assertEquals(expectedJ1, j1.salarioNeto(5),0.01);
		
		Double expectedE1=2550.85; //ausentismo 6
		assertEquals(expectedE1, e1.salarioNeto(5),0.01);
		
	}

}
