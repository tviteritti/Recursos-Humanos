package ar.unlam.edu.rrhh;

import java.util.ArrayList;

public class Sector {

	static ArrayList<Persona> produccion ;  //solo puede tener 1 gerente , 1 jefe por cada seccion y n empleados                                                     
	static ArrayList<Persona> ventas;
	static ArrayList<Persona> rrhh;
	static ArrayList<Persona> administracion;
	
	public Sector() {
		this.produccion= new ArrayList<Persona>();
		this.ventas= new ArrayList<Persona>();
		this.rrhh= new ArrayList<Persona>();
		this.administracion= new ArrayList<Persona>();
		
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