package ar.unlam.edu.rrhh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ar.unlam.edu.persona.Empleado;
import ar.unlam.edu.persona.Gerente;
import ar.unlam.edu.persona.Jefe;
import ar.unlam.edu.persona.Persona;

public class Sector implements DAO<Persona, Integer, String> {

	static HashSet<Persona> produccion; // solo puede tener 1 gerente , 3 jefe por cada seccion y n empleados
	static HashSet<Persona> ventas;
	static HashSet<Persona> rrhh;
	static HashSet<Persona> administracion;
	final static Integer cantJefes = 3;

	public Sector() {
		this.produccion = new HashSet<Persona>();
		this.ventas = new HashSet<Persona>();
		this.rrhh = new HashSet<Persona>();
		this.administracion = new HashSet<Persona>();

	}

	public Boolean agregarGerente(Gerente gerente, String sector) {

		sector = sector.toUpperCase();

		if (sector.equals(Area.PRODUCCION.name())) {
			Iterator<Persona> it = produccion.iterator();

			while (it.hasNext()) {
				if (it.next() instanceof Gerente) {
					return false;
				}
			}
			return produccion.add(gerente);
		}

		if (sector.equals(Area.ADMINISTRACION.name())) {
			Iterator<Persona> it = administracion.iterator();

			while (it.hasNext()) {
				if (it.next() instanceof Gerente) {
					return false;
				}
			}
			return produccion.add(gerente);
		}

		if (sector.equals(Area.RRHH.name())) {
			Iterator<Persona> it = rrhh.iterator();

			while (it.hasNext()) {
				if (it.next() instanceof Gerente) {
					return false;
				}
			}
			return produccion.add(gerente);
		}

		if (sector.equals(Area.VENTAS.name())) {
			Iterator<Persona> it = ventas.iterator();

			while (it.hasNext()) {
				if (it.next() instanceof Gerente) {
					return false;
				}
			}
			return produccion.add(gerente);
		}

		return false;

	}

	public Boolean agregarJefe(Jefe jefe, String sector) {

		if (sector.equals(Area.ADMINISTRACION.name())) {
			Iterator<Persona> it = administracion.iterator();
			Integer cantJefesProduccion = 0;
			while (it.hasNext()) {
				if (it.next() instanceof Jefe) {
					if (cantJefesProduccion == this.cantJefes)
						return false;
					cantJefesProduccion++;
				}
			}
			return produccion.add(jefe);
		}

		if (sector.equals(Area.RRHH.name())) {
			Iterator<Persona> it = rrhh.iterator();
			Integer cantJefesProduccion = 0;
			while (it.hasNext()) {
				if (it.next() instanceof Jefe) {
					if (cantJefesProduccion == this.cantJefes)
						return false;
					cantJefesProduccion++;
				}
			}
			return produccion.add(jefe);
		}

		if (sector.equals(Area.VENTAS.name())) {
			Iterator<Persona> it = ventas.iterator();
			Integer cantJefesProduccion = 0;
			while (it.hasNext()) {
				if (it.next() instanceof Jefe) {
					if (cantJefesProduccion == this.cantJefes)
						return false;
					cantJefesProduccion++;
				}
			}
			return produccion.add(jefe);
		}

		if (sector.equals(Area.PRODUCCION.name())) {
			Iterator<Persona> it = produccion.iterator();
			Integer cantJefesProduccion = 0;
			while (it.hasNext()) {
				if (it.next() instanceof Jefe) {
					if (cantJefesProduccion == this.cantJefes)
						return false;
					cantJefesProduccion++;
				}
			}
			return produccion.add(jefe);
		}

		return false;

	}

	public Boolean agregarEmpleado(Empleado empleado, String sector) {

		sector = sector.toUpperCase();
		if (sector.equals(Area.PRODUCCION.name())) {
			return produccion.add(empleado);
		}

		if (sector.equals(Area.ADMINISTRACION.name())) {
			return administracion.add(empleado);
		}

		if (sector.equals(Area.RRHH.name())) {
			return rrhh.add(empleado);
		}

		if (sector.equals(Area.VENTAS.name())) {
			return ventas.add(empleado);
		}

		return false;

	}

	public Boolean modificarPersona(Persona obj, String sector) {

		/*
		 * if (produccion.contains(obj) && sector.equals(Area.PRODUCCION.name())) {
		 * produccion.remove(obj); return produccion.add(obj); } return false;
		 */

		if (sector.equals(Area.PRODUCCION.name())) {
			Iterator<Persona> it = produccion.iterator();

			while (it.hasNext()) {
				if (obj.equals(it.next())) {
					it.remove();
				}
			}
			return produccion.add(obj);

		}

		if (sector.equals(Area.ADMINISTRACION.name())) {
			Iterator<Persona> it = administracion.iterator();

			while (it.hasNext()) {
				if (obj.equals(it.next())) {
					it.remove();
				}
			}
			return administracion.add(obj);

		}

		if (sector.equals(Area.RRHH.name())) {
			Iterator<Persona> it = rrhh.iterator();

			while (it.hasNext()) {
				if (obj.equals(it.next())) {
					it.remove();
				}
			}
			return rrhh.add(obj);

		}

		if (sector.equals(Area.ADMINISTRACION.name())) {
			Iterator<Persona> it = administracion.iterator();

			while (it.hasNext()) {
				if (obj.equals(it.next())) {
					it.remove();
				}
			}
			return administracion.add(obj);

		}

		return false;

	}

	public Persona EncontradoPersona(Integer id) {

		Iterator <Persona>itad = administracion.iterator();
		while(itad.hasNext()) {
			if(id.equals(itad.next().getDni())){
				return itad.next();
			}
		}
	
			
	Iterator <Persona>itpro = produccion.iterator();
		while(itpro.hasNext()) {
			if(id.equals(itpro.next().getDni())){
				return  itpro.next();
			}
		}
			
	Iterator <Persona>itrrhh = rrhh.iterator();
		while(itrrhh.hasNext()) {
			if(id.equals(itrrhh.next().getDni())){
				return itrrhh.next();
			}
		}
	
	Iterator <Persona>itventas = ventas.iterator();
		while(itventas.hasNext()) {
			if(id.equals(itventas.next().getDni())){
				return itventas.next();
			}
		}	
	
	return null;
	
	}


	@Override
	public Boolean insertar(Persona obj, String sector) {

		if (obj instanceof Empleado) {
			Empleado empleado = (Empleado) obj;
			return agregarEmpleado(empleado, sector);
		}

		if (obj instanceof Jefe) {
			Jefe gerente = (Jefe) obj;
			return agregarJefe(gerente, sector);
		}

		if (obj instanceof Gerente) {
			Gerente gerente = (Gerente) obj;
			return agregarGerente(gerente, sector);
		}

		return false;

	}

	@Override
	public Boolean actualizar(Persona obj, String sector) {

		if (this.existe(obj.getDni())) {
			sector = sector.toUpperCase();
			return modificarPersona(obj, sector);
		}
		return false;

	}

	@Override
	public Persona buscar(Integer id) {
		if (this.existe(id)) {

			return EncontradoPersona(id);
		}
		return null;
	}

	@Override
	public Boolean existe(Integer id) {
		
		Iterator <Persona>itad = administracion.iterator();
			while(itad.hasNext()) {
				if(id.equals(itad.next().getDni())){
					return true;
				}
			}
		
				
		Iterator <Persona>itpro = produccion.iterator();
			while(itpro.hasNext()) {
				if(id.equals(itpro.next().getDni())){
					return  true;
				}
			}
				
		Iterator <Persona>itrrhh = rrhh.iterator();
			while(itrrhh.hasNext()) {
				if(id.equals(itrrhh.next().getDni())){
					return true;
				}
			}
		
		Iterator <Persona>itventas = ventas.iterator();
			while(itventas.hasNext()) {
				if(id.equals(itventas.next().getDni())){
					return true;
				}
			}	
		
		return false;
		
	}

	@Override
	public Boolean darBaja(Persona obj) {
		if(this.existe(obj.getDni())){
			
			Iterator <Persona>itad = administracion.iterator();
			while(itad.hasNext()) {
				if(obj.equals(itad.next())){
					itad.remove();
					obj.renunciarJubilarce();
					administracion.add(obj);
					return true;
				}
			}
		
				
		Iterator <Persona>itpro = produccion.iterator();
			while(itpro.hasNext()) {
				if(obj.equals(itpro.next())){
					itad.remove();
					obj.renunciarJubilarce();
					produccion.add(obj);
					return  true;
				}
			}
				
		Iterator <Persona>itrrhh = rrhh.iterator();
			while(itrrhh.hasNext()) {
				if(obj.equals(itrrhh.next())){
					itad.remove();
					obj.renunciarJubilarce();
					rrhh.add(obj);
					return true;
				}
			}
		
		Iterator <Persona>itventas = ventas.iterator();
			while(itventas.hasNext()) {
				if(obj.equals(itventas.next())){
					itad.remove();
					obj.renunciarJubilarce();
					ventas.add(obj);
					return true;
				}
			}	
		
		
		
		}
		
		return false;
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
	public Boolean existe(Integer id, String sector) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Persona obj, String sector) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Area Sector(Persona obj) {
		Iterator <Persona>itad = administracion.iterator();
		while(itad.hasNext()) {
			if(obj.equals(itad.next())){
				return Area.ADMINISTRACION;
			}
		}
	
			
	Iterator <Persona>itpro = produccion.iterator();
		while(itpro.hasNext()) {
			if(obj.equals(itpro.next())){
				return  Area.PRODUCCION;
			}
		}
			
	Iterator <Persona>itrrhh = rrhh.iterator();
		while(itrrhh.hasNext()) {
			if(obj.equals(itrrhh.next())){
				return Area.RRHH;
			}
		}
	
	Iterator <Persona>itventas = ventas.iterator();
		while(itventas.hasNext()) {
			if(obj.equals(itventas.next())){
				return Area.VENTAS;
			}
		}	
	
		return Area.NULL;

	}

}