package ar.unlam.edu.persona;

import java.util.Calendar;

import ar.unlam.edu.calendario.Calendario;
import ar.unlam.edu.rrhh.CargaNovedades;

public class Gerente extends Persona implements CargaNovedades {//bono de fin de a�o
	
	private Double bonoFinAnio;

	public Gerente(Integer numLegajo, Integer dni, String nombre, String apellido, Calendar fechaDeNacimiento,
			Double salario, Integer antiguedad) {
		super(numLegajo, dni, nombre, apellido, fechaDeNacimiento, salario, antiguedad);
		this.bonoFinAnio=50000.0; 
	} 

	public Gerente() {
		super();
	}
	
		
	
	public Double calcularAntiguedad() {
		double antiguedad = super.getSalario() * (this.antiguedad*0.05);
		return antiguedad;
	}
	
	public Double salarioBruto() {
	Double bruto = this.getSalario() + this.calcularAntiguedad();
		return bruto;
	}

	public Double salarioNeto(Integer nroMes) {
		Double neto = 0.0;
		if(super.obtenerFaltasDelMes(nroMes).equals(null)) {
			neto = this.salarioBruto();
		}else {
			neto =  this.salarioBruto()-((this.salarioBruto()/30)*super.obtenerFaltasDelMes(nroMes));
		}/*ej: 20000.0 + 2000.0 - (22000.0 /30 * 1)*/
		return neto;
	}
	
	public Double obtenerBonoFinAnio() {
		Double bono = 0.0;
		if(this.obtenerFaltasAnuales()>=1) {
			bono = this.bonoFinAnio- ((this.bonoFinAnio/360.0)*this.obtenerFaltasAnuales());
		}else {
			bono =this.bonoFinAnio;
		}
		return bono;
	}

	
	
	
	
	
}
