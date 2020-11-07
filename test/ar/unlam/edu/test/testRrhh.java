package ar.unlam.edu.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.unlam.edu.rrhh.Calendario;
import ar.unlam.edu.rrhh.Empleado;
import ar.unlam.edu.rrhh.Gerente;
import ar.unlam.edu.rrhh.Jefe;
import ar.unlam.edu.rrhh.Sector;

public class testRrhh {

	@Test
	public void queSePuedaAgregarGerenteJefeEmpleado() {
		
		Gerente g1= new Gerente(123, "jorge", "lopez", new Calendario(1999, 10, 13), 3000.0, 2, 3);
		Jefe j1= new Jefe(456, "pablo", "perez", new Calendario(1980, 5, 10), 4000.0, 0, 1);
		Empleado e1=new Empleado(789, "federico", "gomez", new Calendario(1989, 9, 4), 7000.0, 7, 9);


		Sector s1= new Sector();
		
		s1.agregarGerente(g1, "produccion");
		s1.agregarEmpleado(e1, "produccion");
		s1.agregarJefe(j1, "produccion");
		
		assertEquals(3, s1.getProduccion().size());
		
		
	}

}
