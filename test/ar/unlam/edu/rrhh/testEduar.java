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
	/*la fecha de nacimiento arroja null pero se puede setar con una instanciacion de la interface Calendar;*/

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
		
		oficina.cumplioObjetivos();
		
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
	

}
