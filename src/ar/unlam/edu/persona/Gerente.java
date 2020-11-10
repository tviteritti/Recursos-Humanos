package ar.unlam.edu.persona;

import java.util.Calendar;

import ar.unlam.edu.calendario.Calendario;
import ar.unlam.edu.rrhh.CargaNovedades;

public class Gerente extends Jefe implements CargaNovedades {//bono de fin de a�o

	public Gerente(Integer numLegajo, Integer dni, String nombre, String apellido, Calendar fechaDeNacimiento,
			Double salario, Integer antiguedad) {
		super(numLegajo, dni, nombre, apellido, fechaDeNacimiento, salario, antiguedad);
		
	} 

	



	@Override
	public Double salarioNeto(Integer nroMes) {
		Double  resta=(this.salario/30)*ausentismo[nroMes-1];
		
		return salarioBruto()-resta;
	}

	@Override
	public Double salarioBruto() {
		Double bruto=this.salario+(this.salario*5/100)*this.antiguedad; 
		return bruto;
	}

	
	
	
	

	
	
	
	
}
