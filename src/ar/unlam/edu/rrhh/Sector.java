package ar.unlam.edu.rrhh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import ar.unlam.edu.persona.Empleado;
import ar.unlam.edu.persona.Gerente;
import ar.unlam.edu.persona.Jefe;
import ar.unlam.edu.persona.Persona;

public class Sector  implements DAO <Persona , Integer , String>{

	static HashSet<Persona> produccion ;  //solo puede tener 1 gerente , 3 jefe por cada seccion y n empleados                                                     
	static HashSet<Persona> ventas;
	static HashSet<Persona> rrhh;
	static HashSet<Persona> administracion;
	
	public Sector() {
		this.produccion= new HashSet<Persona>();
		this.ventas= new HashSet<Persona>();
		this.rrhh= new HashSet<Persona>();
		this.administracion= new HashSet<Persona>();
		
	}
	
	
	
	private Boolean agregarGerente(Gerente gerente, String sector) {
		
		
		sector  = sector.toUpperCase();
		
		if (sector.equals(arg0))
		if(sector=="produccion")
			produccion.add(gerente);
		if(sector=="ventas")
			ventas.add(gerente);
		if(sector=="rrhh")
			rrhh.add(gerente);
		if(sector=="administracion")
			administracion.add(gerente);
		
		
	}
	private Boolean agregarJefe(Jefe jefe, String sector) {
		
		if(sector=="produccion")
			produccion.add(jefe);
		if(sector=="ventas")
			ventas.add(jefe);
		if(sector=="rrhh")
			rrhh.add(jefe);
		if(sector=="administracion")
			administracion.add(jefe);
		
		
	}
	private Boolean agregarEmpleado(Empleado empleado, String sector) {
	
		if(sector=="produccion")
			produccion.add(empleado);
		if(sector=="ventas")
			ventas.add(empleado);
		if(sector=="rrhh")
			rrhh.add(empleado);
		if(sector=="administracion")
			administracion.add(empleado);
	
	
	}
	private Boolean modificarPersona(Persona obj, String sector) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean insertar(Persona obj , String sector) {
	
		if ( obj instanceof Empleado) {
			 Empleado empleado = (Empleado) obj; 
			return agregarEmpleado(empleado,  sector); 
		}
		
		if ( obj instanceof Jefe) {
			Jefe gerente = (Jefe) obj; 
			return agregarJefe(gerente , sector);
		}
		
		if (obj instanceof Gerente) {
			Gerente gerente = (Gerente) obj; 
			return agregarGerente(gerente , sector);
		}
		
		return false; 
		
		
	}



	@Override
	public Boolean actualizar(Persona obj, String sector) {
		
		if ( this.existe(obj.getDni())) {
		 sector = sector.toUpperCase(); 
		 return modificarPersona (obj , sector); 
		}
		return false; 
		
	}







	@Override
	public Persona buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Boolean guardar(Persona obj) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Boolean existe(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Boolean eliminar(Persona obj) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Boolean darBaja(Persona obj) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Boolean darAlta(Persona obj) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Boolean cerrar() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Set<Persona> getTodos() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Set<Persona> getBajas() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Set<Persona> getAltas() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Boolean actualizar(Persona obj, String sector) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Boolean existe(Integer id, String sector) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Boolean eliminar(Persona obj, String sector) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}