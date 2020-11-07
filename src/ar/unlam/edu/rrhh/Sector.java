package ar.unlam.edu.rrhh;

import java.util.ArrayList;

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
		
		TiposSectores tiposSectores;
		sector = sector.toUpperCase();
		
		
		
		if(sector.equals()
			produccion.add(gerente);
		if(sector=="ventas")
			ventas.add(gerente);
		if(sector=="rrhh")
			rrhh.add(gerente);
		if(sector=="administracion")
		// 	sector si ya psee un gerente 
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
	
	



	public static ArrayList<Persona> getProduccion() {
		return produccion;
	}



	public static void setProduccion(ArrayList<Persona> produccion) {
		Sector.produccion = produccion;
	}



	public static ArrayList<Persona> getVentas() {
		return ventas;
	}



	public static void setVentas(ArrayList<Persona> ventas) {
		Sector.ventas = ventas;
	}



	public static ArrayList<Persona> getRrhh() {
		return rrhh;
	}



	public static void setRrhh(ArrayList<Persona> rrhh) {
		Sector.rrhh = rrhh;
	}



	public static ArrayList<Persona> getAdministracion() {
		return administracion;
	}



	public static void setAdministracion(ArrayList<Persona> administracion) {
		Sector.administracion = administracion;
	}
	
	
	
}