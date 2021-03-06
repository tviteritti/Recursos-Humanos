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




	static HashSet<Persona> bajas;

	static Set<Persona> produccion; 
	static Set<Persona> ventas;
	static Set<Persona> rrhh;
	static Set<Persona> administracion;
	
	

	final static Integer cantJefes = 3;

	public Sector() {
		this.produccion = new HashSet<Persona>();
		this.ventas = new HashSet<Persona>();
		this.rrhh = new HashSet<Persona>();
		this.administracion = new HashSet<Persona>();
	}

	private Boolean agregarGerente(Gerente gerente, String sector) {

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
			return administracion.add(gerente);
		}

		if (sector.equals(Area.RRHH.name())) {
			Iterator<Persona> it = rrhh.iterator();

			while (it.hasNext()) {
				if (it.next() instanceof Gerente) {
					return false;
				}
			}
			return rrhh.add(gerente);
		}

		if (sector.equals(Area.VENTAS.name())) {
			Iterator<Persona> it = ventas.iterator();

			while (it.hasNext()) {
				if (it.next() instanceof Gerente) {
					return false;
				}
			}
			return ventas.add(gerente);
		}

		return false;

	}

	private Boolean agregarJefe(Jefe jefe, String sector) {

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
			return administracion.add(jefe);
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
			return rrhh.add(jefe);
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
			return ventas.add(jefe);
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

	private Boolean agregarEmpleado(Empleado empleado, String sector) {

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

	private Boolean modificarPersona(Persona obj, String sector) {

		/*
		 * if (produccion.contains(obj) && sector.equals(Area.PRODUCCION.name())) {
		 * produccion.remove(obj); return produccion.add(obj); } return false;
		 */Boolean estado = false;

		if (sector.equals(Area.PRODUCCION.name())) {
			Iterator<Persona> it = produccion.iterator();

			while (it.hasNext()) {
				if (obj.equals(it.next())) {
					it.remove();
					estado = true;
				}
			}
			return produccion.add(obj) ;

		}

		if (sector.equals(Area.ADMINISTRACION.name())) {
			Iterator<Persona> it = administracion.iterator();

			while (it.hasNext()) {
				if (obj.equals(it.next())) {
					it.remove();
					estado = true;
				}
			}

			return administracion.add(obj);

		}

		if (sector.equals(Area.RRHH.name())) {
			Iterator<Persona> it = rrhh.iterator();

			while (it.hasNext()) {
				if (obj.equals(it.next())) {
					it.remove();
					estado = true;
				}
			}
			return rrhh.add(obj);

		}

		if (sector.equals(Area.VENTAS.name())) {
			Iterator<Persona> it = ventas.iterator();

			while (it.hasNext()) {
				if (obj.equals(it.next())) {
					it.remove();
					estado = true;
				}
			}
			return ventas.add(obj);
		}

		return false;

	}

	private Persona EncontradoPersona(Integer id) {


		 for (Persona obj : ventas) { 
		     if (obj.getDni().equals(id)) 
		      return obj; 
		     } 
		
		 for (Persona obj : administracion) { 
		     if (obj.getDni().equals(id)) 
		      return obj; 
		     } 
		
		 for (Persona obj : produccion) { 
		     if (obj.getDni().equals(id)) 
		      return obj; 
		     } 
		 
		 for (Persona obj : rrhh) { 
		     if (obj.getDni().equals(id)) 
		      return obj; 
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

			return (Persona) EncontradoPersona(id);
		}
		
		return null;
	}

	@Override
	public Boolean existe(Integer id) {

		Iterator<Persona> itad = administracion.iterator();
		while (itad.hasNext()) {
			if (id.equals(itad.next().getDni())) {
				
				return true;
			}
		}

		Iterator<Persona> itpro = produccion.iterator();
		while (itpro.hasNext()) {
			if (id.equals(itpro.next().getDni())) {
				return true;
			}
		}

		Iterator<Persona> itrrhh = rrhh.iterator();
		while (itrrhh.hasNext()) {
			if (id.equals(itrrhh.next().getDni())) {
				return true;
			}
		}

		Iterator<Persona> itventas = ventas.iterator();
		while (itventas.hasNext()) {
			if (id.equals(itventas.next().getDni())) {
				return true;
			}
		}

		return false;

	}

	@Override
	public Boolean darBaja(Persona obj) {
		if (this.existe(obj.getDni())) {

			Iterator<Persona> itad = administracion.iterator();
			while (itad.hasNext()) {
				if (obj.equals(itad.next())) {
					itad.remove();
					obj.renunciarJubilarce();
					administracion.add(obj);
					return true;
				}
			}

			Iterator<Persona> itpro = produccion.iterator();
			while (itpro.hasNext()) {
				if (obj.equals(itpro.next())) {
					itpro.remove();
					obj.renunciarJubilarce();
					produccion.add(obj);
					return true;
				}
			}

			Iterator<Persona> itrrhh = rrhh.iterator();
			while (itrrhh.hasNext()) {
				if (obj.equals(itrrhh.next())) {
					itrrhh.remove();
					obj.darBaja();
					rrhh.add(obj);
					return true;
				}
			}

			Iterator<Persona> itventas = ventas.iterator();
			while (itventas.hasNext()) {
				if (obj.equals(itventas.next())) {
					itventas.remove();
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
		Iterator<Persona> itad = administracion.iterator();
		while (itad.hasNext()) {
			if (obj.equals(itad.next())) {
				itad.remove();
				obj.darAlta();
				administracion.add(obj);
				return true;
			}
		}

		Iterator<Persona> itpro = produccion.iterator();
		while (itpro.hasNext()) {
			if (obj.equals(itpro.next())) {
				itad.remove();
				obj.darAlta();
				produccion.add(obj);
				return true;
			}
		}

		Iterator<Persona> itrrhh = rrhh.iterator();
		while (itrrhh.hasNext()) {
			if (obj.equals(itrrhh.next())) {
				itad.remove();
				obj.darAlta();
				rrhh.add(obj);
				return true;
			}
		}

		Iterator<Persona> itventas = ventas.iterator();
		while (itventas.hasNext()) {
			if (obj.equals(itventas.next())) {
				itad.remove();
				obj.darAlta();
				return true;
			}
		}

		return false;
	}

	@Override
	public Set<Persona> getTodos() {
		Set<Persona> todos = new HashSet<>();
		if (!administracion.isEmpty())
			todos.addAll(administracion);
		if (!produccion.isEmpty())
			todos.addAll(produccion);
		if (!rrhh.isEmpty())
			todos.addAll(rrhh);
		if (!ventas.isEmpty())
			todos.addAll(ventas);
		return todos;
	}

	@Override
	public Set<Persona> getBajas() {
		Set<Persona> todos = new HashSet<>();
		if (!administracion.isEmpty()) {
			Iterator<Persona> itad = administracion.iterator();
			while (itad.hasNext()) {
				if (itad.next().getEstado() == false) {

					todos.add(itad.next());
				}
			}
		}

		if (!rrhh.isEmpty()) {
			Iterator<Persona> itrh = rrhh.iterator();
			while (itrh.hasNext()) {

				if (itrh.next().getEstado() == false) {

					todos.add(itrh.next());
				}
			}
		}

		if (!ventas.isEmpty()) {
			Iterator<Persona> itven = ventas.iterator();
			while (itven.hasNext()) {

			
				if (itven.next().getEstado()==false) {

					todos.add(itven.next());
				}
			}
		}

		if (!produccion.isEmpty()) {
			Iterator<Persona> itpro = produccion.iterator();
			while (itpro.hasNext()) {

				

				if (itpro.next().getEstado()==false) {

					todos.add(itpro.next());
				}
			}
		}

		return todos;

	}

	@Override
	public Set<Persona> getAltas() {
		Set<Persona> todos = new HashSet<>();
		if (!administracion.isEmpty()) {
			Iterator<Persona> itad = administracion.iterator();
			while (itad.hasNext()) {
				if (itad.next().getEstado()) {
					todos.add(itad.next());
				}
			}
		}

		if (!rrhh.isEmpty()) {
			Iterator<Persona> itad = rrhh.iterator();
			while (itad.hasNext()) {
				if (itad.next().getEstado()) {
					todos.add(itad.next());
				}
			}
		}

		if (!ventas.isEmpty()) {
			Iterator<Persona> itad = ventas.iterator();
			while (itad.hasNext()) {
				if (itad.next().getEstado()) {
					todos.add(itad.next());
				}
			}
		}

		if (!produccion.isEmpty()) {
			Iterator<Persona> itad = produccion.iterator();
			while (itad.hasNext()) {
				if (itad.next().getEstado()) {
					todos.add(itad.next());
				}
			}
		}

		return todos;

	}

	@Override
	public Boolean existe(Integer id, String sector) {

		sector = sector.toUpperCase();

		if (sector.equals(Area.ADMINISTRACION.name())) {
			Iterator<Persona> itad = administracion.iterator();
			while (itad.hasNext()) {
				if (id.equals(itad.next().getDni())) {
					return true;
				}
			}

		}

		if (sector.equals(Area.RRHH.name())) {
			Iterator<Persona> itrrhh = rrhh.iterator();
			while (itrrhh.hasNext()) {
				if (id.equals(itrrhh.next().getDni())) {
					return true;
				}
			}

		}

		if (sector.equals(Area.VENTAS.name())) {
			Iterator<Persona> itven = ventas.iterator();
			while (itven.hasNext()) {
				if (id.equals(itven.next().getDni())) {
					return true;
				}
			}

		}

		if (sector.equals(Area.PRODUCCION.name())) {
			Iterator<Persona> itpro = produccion.iterator();
			while (itpro.hasNext()) {
				if (id.equals(itpro.next().getDni())) {
					return true;
				}
			}

		}

		return false;

	}

	@Override
	public Boolean eliminar(Persona obj, String sector) {
		sector = sector.toUpperCase();
		if ( this.existe(obj.getDni(), sector)){
		
			if (sector.equals(Area.ADMINISTRACION.name())) {
				Iterator<Persona> itad = administracion.iterator();
				while (itad.hasNext()) {
					if (obj.equals(itad.next())&& itad.next().getEstado() == false) {
					 itad.remove();
					 return true;
					}
				}
			}
			
			if (sector.equals(Area.RRHH.name())) {
				Iterator<Persona> itrh = rrhh.iterator();
				while (itrh.hasNext()) {
					if (obj.equals(itrh.next())&& itrh.next().getEstado() == false) {
						itrh.remove();
						 return true;
					}
				}
			}
			
			
			if (sector.equals(Area.VENTAS.name())) {
				Iterator<Persona> itvent = ventas.iterator();
				while (itvent.hasNext()) {
					if (obj.equals(itvent.next())&& itvent.next().getEstado() == false) {
						itvent.remove();
						 return true;
					}
				}
			}
			
			if (sector.equals(Area.VENTAS.name())) {
				Iterator<Persona> itpro = produccion.iterator();
				while (itpro.hasNext()) {
					if (obj.equals(itpro.next())&& itpro.next().getEstado() == false) {
						itpro.remove();
						 return true;
					}
				}
			}
		}
		return false;
		
	}

	@Override
	public Area Sector(Persona obj) {
		Iterator<Persona> itad = administracion.iterator();
		while (itad.hasNext()) {
			if (obj.equals(itad.next())) {
				return Area.ADMINISTRACION;
			}
		}

		Iterator<Persona> itpro = produccion.iterator();
		while (itpro.hasNext()) {
			if (obj.equals(itpro.next())) {
				return Area.PRODUCCION;
			}
		}

		Iterator<Persona> itrrhh = rrhh.iterator();
		while (itrrhh.hasNext()) {
			if (obj.equals(itrrhh.next())) {
				return Area.RRHH;
			}
		}

		Iterator<Persona> itventas = ventas.iterator();
		while (itventas.hasNext()) {
			if (obj.equals(itventas.next())) {
				return Area.VENTAS;
			}
		}

		return Area.NULL;

	}

}