package ar.unlam.edu.rrhh;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ar.unlam.edu.persona.Empleado;
import ar.unlam.edu.persona.Gerente;
import ar.unlam.edu.persona.Jefe;
import ar.unlam.edu.persona.Persona;

public class testVictor {

	
	
	
	
	@Test
	public void test() {	
		Persona g1=new Gerente(1, 123, "gecter", "werewr", null, 3007.0, 5);
		Persona g2=new Gerente(11, 1234, "vicer", "swerew", null, 3015.0, 6);

		Persona j1=new Jefe(2, 456, "federico", "perez", null, 3000.0, 0);
		Persona e1=new Empleado(33, 78910, "tomas2", "diaz2",null, 3101.0, 1);
		Sector s1= new Sector();
		s1.insertar(g1, "ventas");
	//assertEquals(s1.insertar(g1, "ventas"), true);
	
	
//		Boolean estado = s1.actualizar(g1, "ventas");
//		assertEquals(estado, true);
		Persona ve = s1.buscar(123);	
	//	System.out.print(ve.toString());
		Integer v = 123;
	// assertEquals(ve.getDni(), v);	fail("Not yet implemented");
	}

}
