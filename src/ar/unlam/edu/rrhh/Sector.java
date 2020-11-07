package ar.unlam.edu.rrhh;

import java.util.ArrayList;
import java.util.HashSet;

import ar.unlam.edu.persona.Empleado;
import ar.unlam.edu.persona.Gerente;
import ar.unlam.edu.persona.Jefe;
import ar.unlam.edu.persona.Persona;

public class Sector {

	static HashSet<Persona> produccion ;  //solo puede tener 1 gerente , 1 jefe por cada seccion y n empleados                                                     
	static HashSet<Persona> ventas;
	static HashSet<Persona> rrhh;
	static HashSet<Persona> administracion;
	
	public Sector() {
		this.produccion= new HashSet<Persona>();
		this.ventas= new HashSet<Persona>();
		this.rrhh= new HashSet<Persona>();
		this.administracion= new HashSet<Persona>();
		
	}
	
	
	
	public void agregarGerente(Gerente gerente, String sector) {
		
		if(sector=="produccion")
			produccion.add(gerente);
		if(sector=="ventas")
			ventas.add(gerente);
		if(sector=="rrhh")
			rrhh.add(gerente);
		if(sector=="administracion")
			administracion.add(gerente);
		
		
	}
	public void agregarJefe(Jefe jefe, String sector) {
		
		if(sector=="produccion")
			produccion.add(jefe);
		if(sector=="ventas")
			ventas.add(jefe);
		if(sector=="rrhh")
			rrhh.add(jefe);
		if(sector=="administracion")
			administracion.add(jefe);
		
		
	}
	public void agregarEmpleado(Empleado empleado, String sector) {
	
		if(sector=="produccion")
			produccion.add(empleado);
		if(sector=="ventas")
			ventas.add(empleado);
		if(sector=="rrhh")
			rrhh.add(empleado);
		if(sector=="administracion")
			administracion.add(empleado);
	
	
	}
	



	public static HashSet<Persona> getProduccion() {
		return produccion;
	}



	public static void setProduccion(HashSet<Persona> produccion) {
		Sector.produccion = produccion;
	}



	public static HashSet<Persona> getVentas() {
		return ventas;
	}



	public static void setVentas(HashSet<Persona> ventas) {
		Sector.ventas = ventas;
	}



	public static HashSet<Persona> getRrhh() {
		return rrhh;
	}



	public static void setRrhh(HashSet<Persona> rrhh) {
		Sector.rrhh = rrhh;
	}



	public static HashSet<Persona> getAdministracion() {
		return administracion;
	}



	public static void setAdministracion(HashSet<Persona> administracion) {
		Sector.administracion = administracion;
	}
	
	
	
}