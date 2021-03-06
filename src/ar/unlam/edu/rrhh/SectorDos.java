package ar.unlam.edu.rrhh;

import java.util.HashSet;

import ar.unlam.edu.persona.Persona;

public class SectorDos {

	static HashSet<Persona> produccion; // solo puede tener 1 gerente , 3 jefe por cada seccion y n empleados
	static HashSet<Persona> ventas;
	static HashSet<Persona> rrhh;
	static HashSet<Persona> administracion;
	
	public SectorDos() {
		this.produccion = new HashSet<Persona>();
		this.ventas = new HashSet<Persona>();
		this.rrhh = new HashSet<Persona>();
		this.administracion = new HashSet<Persona>();

	}
	
	
	public Persona buscar(Integer dni, String sector) {
		switch (sector) {
		case "administracion":
			for (Persona persona : administracion) {
				if(persona.getDni().equals(dni)) {
					return persona;
				}
			}
			break;
			
		case "produccion":
			for (Persona persona : produccion) {
				if(persona.getDni().equals(dni)) {
					return persona;
				}
			}
			break;
		case "rrhh":
			for (Persona persona : rrhh) {
				if(persona.getDni().equals(dni)) {
					return persona;
				}
			}
			break;
		case "ventas":
			for (Persona persona : ventas) {
				if(persona.getDni().equals(dni)) {
					return persona;
				}
			}
			break;

		default:
			break;
		}
		
		
		return null;
	}
	
	public Boolean agregar(Persona persona, String sector) {
		Boolean agregado = false;
		
		switch (sector) {
		case "administracion":
			agregado = this.administracion.add(persona);
			break;

		case "produccion":
			agregado = this.produccion.add(persona);
			break;

		case "rrhh":
			agregado = this.rrhh.add(persona);
			break;

		case "ventas":
			agregado = this.ventas.add(persona);
			break;

		default:
			break;
		}
		
		return agregado;
	}
	
	public Boolean eliminar(Persona persona, String sector) {
		Boolean eliminado = false;
		
		switch (sector) {
		case "administracion":
			eliminado = this.administracion.remove(persona);
			break;

		case "produccion":
			eliminado = this.produccion.remove(persona);

		case "rrhh":
			eliminado = this.rrhh.remove(persona);
			break;

		case "ventas":
			eliminado = this.ventas.remove(persona);
			break;

		default:
			break;
		}
		
		
		return eliminado;
	}


	public static HashSet<Persona> getProduccion() {
		return produccion;
	}


	public static HashSet<Persona> getVentas() {
		return ventas;
	}


	public static HashSet<Persona> getRrhh() {
		return rrhh;
	}


	public static HashSet<Persona> getAdministracion() {
		return administracion;
	}
	
	
}
