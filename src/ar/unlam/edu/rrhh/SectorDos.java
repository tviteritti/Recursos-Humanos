package ar.unlam.edu.rrhh;

import java.util.HashSet;

import ar.unlam.edu.persona.Persona;

public class SectorDos {

	static HashSet<Persona> produccion; // solo puede tener 1 gerente , 3 jefe por cada seccion y n empleados
	static HashSet<Persona> ventas;
	static HashSet<Persona> rrhh;
	static HashSet<Persona> administracion;
	final static Integer cantJefes = 3;
	Persona persAux;

	public SectorDos() {
		this.produccion = new HashSet<Persona>();
		this.ventas = new HashSet<Persona>();
		this.rrhh = new HashSet<Persona>();
		this.administracion = new HashSet<Persona>();
		this.persAux = new Persona();
	}
	
	
	public Persona buscar(Integer dni) {
		for (Persona persona : administracion) {
			if(persona.getDni().equals(dni)) {
				return persona;
			}
		}
		return null;
	}
	
	public Boolean agregar(Persona persona) {
		Boolean agregado = false;
		agregado = this.administracion.add(persona);
		return agregado;
	}
	
	public Boolean eliminar(Persona persona) {
		Boolean eliminado = false;
		eliminado = this.administracion.remove(persona);
		return eliminado;
	}
}
