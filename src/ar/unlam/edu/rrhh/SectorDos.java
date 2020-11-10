package ar.unlam.edu.rrhh;

import java.util.HashSet;

import ar.unlam.edu.persona.Persona;

public class SectorDos {

	static HashSet<Persona> produccion; // solo puede tener 1 gerente , 3 jefe por cada seccion y n empleados
	static HashSet<Persona> ventas;
	static HashSet<Persona> rrhh;
	static HashSet<Persona> administracion;
	final static Integer cantJefes = 3;

	public SectorDos() {
		this.produccion = new HashSet<Persona>();
		this.ventas = new HashSet<Persona>();
		this.rrhh = new HashSet<Persona>();
		this.administracion = new HashSet<Persona>();

	}
	
}
