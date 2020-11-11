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
	
	@Test
	public void QueSeInserteCorrectamenteUnJefeEnUnSector() {
		
		Integer id=123;
		Jefe jefe=new Jefe(123, id, "Jose", "Alvarez", null, 1000.0, 0);
		
		Sector sector= new Sector();
		sector.insertar(jefe, "Produccion");
		sector.actualizar(jefe, "Produccion");
		
		assertEquals(sector.buscar(id), jefe);
	}
	    
	
	
	@Test
	public void QueNoSePuedanAgregar2GerentesAUnMismoSector() {
		
		Integer id=123;
		Integer id2=1234;
		Gerente gerente=new Gerente(1234, id, "Jose", "Alvarez", null, 1000.0, 0);
		Gerente gerente2=new Gerente(123, id2, "Pedro", "Estevez", null, 1000.0, 0);
		
		
		Sector sector= new Sector();
		sector.insertar(gerente, "Produccion");
		sector.actualizar(gerente, "Produccion");
		sector.insertar(gerente2, "Produccion");
		sector.actualizar(gerente2, "Produccion");
		
		assertNull(sector.buscar(id2));
		
	}
	
	
	@Test
	public void QueSePuedanInsertarUnEmpleadoJefeYGerenteAUnMismoSector() {
		
	Integer id=123;
	Integer id2=1234;
	Integer id3=12345;
	Empleado empleado=new Empleado(1233, id, "Jose", "Alvarez", null, 1000.0, 0);
	Gerente gerente=new Gerente(1234, id2, "Pedro", "Estevez", null, 1000.0, 0);
	Jefe jefe=new Jefe(1231, id3, "Alberto", "Nuñez", null, 1000.0, 0);
	
	Sector sector= new Sector();
	sector.insertar(gerente, "Produccion");
	sector.actualizar(gerente, "Produccion");
	sector.insertar(empleado, "Produccion");
	sector.actualizar(empleado, "Produccion");
	sector.insertar(jefe, "Produccion");
	sector.actualizar(jefe, "Produccion");
	
	assertEquals(sector.buscar(id), empleado);
	assertEquals(sector.buscar(id2), gerente);
	assertEquals(sector.buscar(id3), jefe);
	

}
	

	@Test
	public void QueNoSePuedanInsertarMasDe3JefesAUnMismoSector() {
		
		Integer id=12;
		Integer id1=123;
		Integer id2=1234;
		Integer id3=12345;
		Jefe jefe=new Jefe(1, id, "Alberto", "Nuñez", null, 1000.0, 0);
		Jefe jefe1=new Jefe(2, id1, "Pedro", "Nuñez", null, 1000.0, 0);
		Jefe jefe2=new Jefe(3, id2, "Jose", "Nuñez", null, 1000.0, 0);
		Jefe jefe3=new Jefe(4, id3, "Ian", "Nuñez", null, 1000.0, 0);
		
		
		Sector sector= new Sector();
		sector.insertar(jefe, "Produccion");
		sector.actualizar(jefe, "Produccion");
		sector.insertar(jefe1, "Produccion");
		sector.actualizar(jefe1, "Produccion");
		sector.insertar(jefe2, "Produccion");
		sector.actualizar(jefe2, "Produccion");
		sector.insertar(jefe3, "Produccion");
		sector.actualizar(jefe3, "Produccion");
		
		
		assertEquals(sector.buscar(id), jefe);
		assertEquals(sector.buscar(id1), jefe1);
		assertEquals(sector.buscar(id2), jefe2);
		assertEquals(sector.buscar(id3), jefe3);
		
		
	}
	

}
