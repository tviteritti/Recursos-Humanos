
package ar.unlam.edu.rrhh;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import ar.unlam.edu.calendario.Calendario;
import ar.unlam.edu.persona.Empleado;
import ar.unlam.edu.persona.Gerente;
import ar.unlam.edu.persona.Jefe;
import ar.unlam.edu.persona.Persona;

public class testTomas {

	@Test
	public void queSeCumplanfaltasDelMes() {
		
		Persona g1=new Gerente(1, 123, "jorge", "lopez",null, 3007.0, 5);
		Persona j1=new Jefe(2, 456, "federico", "perez", null, 3000.0, 0);
		Persona e1=new Empleado(3, 789, "tomas", "diaz", null, 3001.0, 1);
		
		for (int i = 1; i < 13; i++) {
			g1.setDiasAusentesEnUnMes(i, i);
			j1.setDiasAusentesEnUnMes(i+1, i);
			e1.setDiasAusentesEnUnMes(i+2, i);
		}
		
		assertNotNull(g1);
		assertNotNull(j1);
		assertNotNull(e1);
		
		Integer faltasG= g1.obtenerFaltasDelMes(1);
		Integer expectedG=1;
		assertEquals(expectedG,faltasG);
		
		Integer faltasF= j1.obtenerFaltasDelMes(1);;
		Integer expectedF=2;
		assertEquals(expectedF,faltasF);
		
		Integer faltasE= e1.obtenerFaltasDelMes(1);
		Integer expectedE=3;
		assertEquals(expectedE,faltasE);
		
		
		
	}
	

	@Test
	public void queSeCumplanSalarioNetoBrutoYAntiguedad() {
		
		Persona g1=new Gerente(1, 123, "jorge", "lopez", null, 3007.0, 5);
		Persona j1=new Jefe(2, 456, "federico", "perez", null, 3000.0, 0);
		Persona e1=new Empleado(3, 789, "tomas", "diaz",null, 3001.0, 1);
		
		for (int i = 1; i < 13; i++) {
			g1.setDiasAusentesEnUnMes(i, i);
			j1.setDiasAusentesEnUnMes(i+1, i);
			e1.setDiasAusentesEnUnMes(i+2, i);
		}
		
		Double expectedG=3758.75; //saldo 3007 antiguedad 5
		assertEquals(expectedG, g1.salarioBruto());
		
		Double expectedJ=3000.0; //saldo 3000 antiguedad 0
		assertEquals(expectedJ, j1.salarioBruto());
		
		Double expectedE=3151.05; //saldo 3001 antiguedad 1
		assertEquals(expectedE, e1.salarioBruto());
		
		
		Double expectedG1=3257.58; //ausentismo 5
		assertEquals(expectedG1, g1.salarioNeto(5),0.01);
		
		Double expectedJ1=2400.0; //ausentismo 6
		assertEquals(expectedJ1, j1.salarioNeto(5),0.01);
		
		Double expectedE1=2450.82; //ausentismo 7
		assertEquals(expectedE1, e1.salarioNeto(5),0.01);
		
		g1.reporteAnual();
		g1.reporteMensual(5);
		
	}
	
	@Test
	public void queNoPermitaDuplicadosYmasDeLosQueSePueda() {
		
		Calendar fechaNac = Calendar.getInstance();
		fechaNac.set(1992, 5, 15);
		fechaNac.get(Calendar.YEAR);
		
		Persona g1=new Gerente(1, 123, "jorge", "lopez", fechaNac, 3007.0, 5);
		Persona g2=new Gerente(11, 1234, "jorge2", "lopez2", null, 3015.0, 6);

		Persona j1=new Jefe(2, 456, "federico", "perez", null, 3000.0, 0);
		Persona j2=new Jefe(22, 4567, "federico2", "perez2", null, 3100.0, 7);
		Persona j3=new Jefe(222, 45678, "federico3", "perez3", null, 3200.0, 5);
		Persona j4=new Jefe(2222, 456789, "federico4", "perez4", null, 3300.0, 5);
		
		Persona e1=new Empleado(3, 789, "tomas", "diaz",null, 3001.0, 1);
		Persona e2=new Empleado(33, 78910, "tomas2", "diaz2",null, 3101.0, 1);
		
		Sector s1= new Sector();
		
		s1.insertar(g1, "produccion");
		s1.insertar(g1, "produccion");
		s1.insertar(g2, "produccion");
		
		s1.insertar(j1, "produccion");
		s1.insertar(j1, "produccion");
		s1.insertar(j2, "produccion");
		s1.insertar(j3, "produccion");
		s1.insertar(j4, "produccion");
		
		
		s1.insertar(e1, "produccion");
		s1.insertar(e1, "produccion");
		s1.insertar(e2, "produccion");
		
		
		
		
	
	}
	
	@Test
	public void queFuncioneLaBusqueda() {
		
		Persona g1=new Persona(1, 123, "jorge", "lopez", null, 3007.0, 5);
//		Sector s1= new Sector();
		SectorDos s1= new SectorDos();
		
		s1.agregar(g1,"administracion");
		
		Integer dni = g1.getDni();
		Integer vo=s1.buscar(123, "administracion").getDni(); /*123 es l dni buscado*/
		Integer ve=123;	
		assertEquals(ve, vo);
			
		assertNull(s1.buscar(124, "administracion")); /*no encuentra porque no esta instanciado el empleado*/
		
		
		
	}

}
