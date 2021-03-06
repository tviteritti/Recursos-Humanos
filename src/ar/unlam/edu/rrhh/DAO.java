package ar.unlam.edu.rrhh;

import java.util.List;
import java.util.Set;

public interface DAO<T, U, S> {    
	/* data access object */

	Boolean insertar(T obj, S sector);

	Boolean actualizar(T obj, S sector);

	T buscar(U id);

	Boolean existe(U id, S sector);

	Boolean existe(U id);
	
	Area Sector (T obj);

	Boolean eliminar(T obj, S sector);

	Boolean darBaja(T obj);

	Boolean darAlta(T obj);



	Set<T> getTodos();

	Set<T> getBajas();

	Set<T> getAltas();

}
