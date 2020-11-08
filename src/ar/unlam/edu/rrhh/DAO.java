package ar.unlam.edu.rrhh;

import java.util.List;
import java.util.Set;

public interface DAO <T ,U , S>{
	
	 Boolean insertar(T obj , S sector) ;
	 Boolean actualizar(T obj , S sector);
	    T buscar(U id) ;
	    Boolean guardar(T obj) ;
	    Boolean existe(U id , S sector) ;
	    Boolean existe(U id) ;

	    Boolean eliminar(T obj , S sector) ;
	    Boolean darBaja(T obj) ;
	    Boolean darAlta(T obj) ;
	    Boolean cerrar() ;
	    Set<T> getTodos() ;
	    Set<T> getBajas() ;
	      Set<T> getAltas() ;

}
