package ar.unlam.edu.rrhh;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import ar.unlam.edu.calendario.Calendario;
import ar.unlam.edu.persona.Empleado;
import ar.unlam.edu.persona.Gerente;
import ar.unlam.edu.persona.Jefe;
import ar.unlam.edu.persona.Persona;

public class testEduar {
	/*la fecha de nacimiento arroja null pero se puede setear con una instanciacion de la Clase Calendar;*/

	@Test
	public void pruebaLiquidacionConEmpleado() {
		
		Empleado crew = new Empleado(1000, 12, "Juan", "Perez", null, 20000.0, 2);
		
			Double veb = crew.salarioBruto();
			Double vob = 26400.0;
			assertEquals(veb, vob, 0.01);
			
			crew.setDiasAusentesEnUnMes(1, 10);
			Integer v = crew.obtenerFaltasDelMes(10);
			Integer e= 1;
			assertEquals(v,e);
			
			Double ven=crew.salarioNeto(10);
			Double von=21266.67;
			assertEquals(ven, von, 0.01);
	}
	
	@Test
	public void pruebaLiquidacionConGerente() {
		
		Gerente local = new Gerente(1001, 13, "Jose", "Paez", null, 100000.0, 4);
		
			Double veb = local.salarioBruto();
			Double vob = 120000.0;
			assertEquals(veb, vob, 0.01);
			
			local.setDiasAusentesEnUnMes(10, 10);
			Integer v = local.obtenerFaltasDelMes(10);
			Integer e= 10;
			assertEquals(v,e);
			
			Double ven=local.salarioNeto(10);
			Double von=80000.0;
			assertEquals(ven, von, 0.01);
			
			
			Double bono = local.obtenerBonoFinAnio();
			Double bonoE = 48611.11; /*falto 10 dias*/
			assertEquals(bono, bonoE, 0.01);
					
	}
	
	@Test
	public void pruebaLiquidacionConConJefe() {
		
		Jefe  oficina = new Jefe(1006, 15, "Alberto", "Portillo", null, 50000.0, 8);
		
		oficina.cumplioObjetivos(); /*suma fija de 5000.0*/
		
		Double veb = oficina.salarioBruto();
		Double vob = 75000.0;
		assertEquals(veb, vob, 0.01);
		
		oficina.setDiasAusentesEnUnMes(2, 10);
		Integer v = oficina.obtenerFaltasDelMes(10);
		Integer e= 2;
		assertEquals(v,e);
		
		Double ven=oficina.salarioNeto(10);
		Double von=70333.33;
		assertEquals(ven, von, 0.01);
	
	}
	
	
	@Test
	public void pruebaConsultasDeSector() {
		
		Gerente g1=new Gerente(1, 4215, "jorge", "lopez", null, 3007.0, 5);
//		Sector s1= new Sector();
		SectorDos s1= new SectorDos();
		
		s1.agregar(g1,"administracion");
		
		Integer dni = g1.getDni();
		Integer vo=s1.buscar(4215, "administracion").getDni(); /*123 es l dni buscado*/
		Integer ve=4215;	
		assertEquals(ve, vo);
			
		assertNull(s1.buscar(42150, "administracion")); /*no encuentra porque no esta instanciado el empleado*///
		
		s1.eliminar(g1, "administracion");
		assertNull(s1.buscar(4215, "administracion")); 
	}
	
	@Test
	public void pruebaConDuplicadosEnElSector() {
		
		Persona p1=new Gerente(1, 123, "jorge", "lopez", null, 3007.0, 5);
		Persona p2=new Gerente(11, 1234, "jorge2", "lopez2", null, 3015.0, 6);

		Persona p3=new Jefe(2, 456, "federico", "perez", null, 3000.0, 0);
		Persona p4=new Empleado(33, 78910, "tomas2", "diaz2",null, 3101.0, 1);
		SectorDos s1= new SectorDos();
		
		s1.agregar(p1, "produccion");
		assertFalse(s1.agregar(p1, "produccion"));
		
		
		s1.agregar(p3, "produccion");
		assertFalse(s1.agregar(p3, "produccion"));
		
		
		s1.agregar(p4, "produccion");
		assertFalse(s1.agregar(p4, "produccion"));
		
		assertEquals(3, s1.getProduccion().size());
	}
	
	@Test
	public void probarSector() {
		
		Persona g1=new Gerente(1, 123, "jorge", "lopez", null, 3007.0, 5);
		Persona g2=new Gerente(11, 1234, "jorge2", "lopez2", null, 3015.0, 6);

		Persona j1=new Jefe(2, 456, "federico", "perez", null, 3000.0, 0);
		Persona e1=new Empleado(33, 78910, "tomas2", "diaz2",null, 3101.0, 1);
		Sector s1= new Sector();
		
		
		assertEquals(s1.insertar(g1, "ventas"), true);
		Boolean estado = s1.actualizar(g1, "ventas");
		assertEquals(estado, true);
		Integer ve = s1.buscar(123).getDni();
		Integer vo = 123;
		assertEquals(ve, vo);
		
	}

}
