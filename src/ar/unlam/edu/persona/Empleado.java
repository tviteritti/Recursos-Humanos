package ar.unlam.edu.persona;

import java.util.Calendar;

import ar.unlam.edu.rrhh.CargaNovedades;

public class Empleado extends Persona implements CargaNovedades{//un trabajador comun, analista, obreo, etc
	
	private Double presentismo;

	public Empleado(Integer numLegajo, Integer dni, String nombre, String apellido, Calendar fechaDeNacimiento,
			Double salario, Integer antiguedad) {
		super(numLegajo, dni, nombre, apellido, fechaDeNacimiento, salario, antiguedad);
		this.presentismo=0.20; /*20% por nunca faltar*/
	}	
	
	public Empleado() {
		super();
	}
	
	public Double calcularAntiguedad() {
		double antiguedad = super.getSalario() * (this.antiguedad*0.05);
		return antiguedad;
	}
	
	public Double calcularPresentismo() { /*Obtengo presentismo*/
		Double presentismo = ((this.getSalario() + this.calcularAntiguedad())*this.presentismo);
		return presentismo;
	}
	
	public Double salarioBruto() {
	Double bruto = this.getSalario() + this.calcularAntiguedad()+this.calcularPresentismo();
		return bruto;
	}

	public Double salarioNeto(Integer nroMes) {
		Double neto = 0.0;
		if(super.obtenerFaltasDelMes(nroMes).equals(null)) {
			neto = this.salarioBruto();
		}else {
			neto =  (this.getSalario()+this.calcularAntiguedad())-((this.getSalario() + this.calcularAntiguedad())/30*super.obtenerFaltasDelMes(nroMes));
		}/*ej: 20000.0 + 2000.0 - (22000.0 /30 * 1)*/
		return neto;
	}
	
	
	
	
	
}
