package ar.unlam.edu.persona;

import java.util.Calendar;

import ar.unlam.edu.calendario.Calendario;
import ar.unlam.edu.rrhh.CargaNovedades;

public class Jefe extends Empleado implements CargaNovedades{//bono de fin de año

	public Jefe(Integer numLegajo, Integer dni, String nombre, String apellido, Calendar fechaDeNacimiento,
			Double salario, Integer antiguedad) {
		super(numLegajo, dni, nombre, apellido, fechaDeNacimiento, salario, antiguedad);
		
	}




	@Override
	public Double LiquidacionFinal() {
		Calendar hoy = Calendar.getInstance();			
		Double salarioPorDia=salarioBruto()/30;
		Integer diasRestantes=30-hoy.get(Calendar.DAY_OF_MONTH);
		Double salarioLiquidado=salarioNeto(hoy.get(Calendar.MONTH)+1)-(salarioPorDia*diasRestantes);		
		
		return salarioLiquidado;
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

	@Override
	public Double calcularAntiguedad() {
		double antiguedad=this.antiguedad*(this.antiguedad*5/100);
		return antiguedad;
	}

	@Override
	public String reporteMensual(Integer nroMes) {
		
		
		return "Saldo= "+ salarioNeto(nroMes)+", ausentismo= "+ausentismo[nroMes-1];
	}

	@Override
	public String reporteAnual() {
		Double anualSaldo=0.0;
		Integer anualFaltas=0;
		for (int i = 1; i < 13; i++) {
			anualSaldo+=salarioNeto(i);
		} 	
		for (int i = 0; i < 12; i++) {
			anualFaltas+=ausentismo[i];
		}
		
		return "Saldo= "+ anualSaldo+", ausentismo= "+anualFaltas;
	}
	
	
	

	



	
	
	
	
	
}
