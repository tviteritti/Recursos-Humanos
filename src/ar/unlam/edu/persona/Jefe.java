package ar.unlam.edu.persona;

import java.util.Calendar;

import ar.unlam.edu.calendario.Calendario;
import ar.unlam.edu.rrhh.CargaNovedades;

public class Jefe extends Empleado implements CargaNovedades{//bono de fin de a�o
	
	private  Double premioMensual;
	private Boolean objetivos; 

	public Jefe(Integer numLegajo, Integer dni, String nombre, String apellido, Calendar fechaDeNacimiento,
			Double salario, Integer antiguedad) {
		super(numLegajo, dni, nombre, apellido, fechaDeNacimiento, salario, antiguedad);
		this.premioMensual = 5000.0;
		this.objetivos=false;
	}
	
	public Jefe() {
		super();
	}
	
	
	public Double calcularAntiguedad() {
		double antiguedad = super.getSalario() * (this.antiguedad*0.05);
		return antiguedad;
	}
	
	public Double salarioBruto() {
		Double bruto;
		if(this.objetivos.equals(true)) {
		 bruto = this.getSalario() + this.calcularAntiguedad() + this.premioMensual;
		}else {
		bruto = this.getSalario() + this.calcularAntiguedad();	
		}
		return bruto;
	}

	public Double salarioNeto(Integer nroMes) {
		Double neto = 0.0;
		Double sinPremio = this.salarioBruto() - this.premioMensual;
		if(super.obtenerFaltasDelMes(nroMes).equals(null)) {
			neto = this.salarioBruto();
		}else {
			neto =  sinPremio-((sinPremio/30)*super.obtenerFaltasDelMes(nroMes))+this.premioMensual;
		}/*ej: 20000.0 + 2000.0 - (22000.0 /30 * 1)*/
		return neto;
	}
	
	public void cumplioObjetivos() {
		this.objetivos=true;
	}

	



	
	
	
	
	
}
