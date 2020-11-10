package ar.unlam.edu.rrhh;

public interface CargaNovedades {
	
	public Integer obtenerFaltasDelMes(Integer nroMes); /*me da la cant. de ausentismo en el mes*/
	public Double LiquidacionFinal(); /*cuando un empleado renuncia o se jubila*/
	public Double salarioNeto(Integer nroMes); /* el basico + antiguedad - ausentismo*/
	public Double salarioBruto(); /*el basico + antiguedad */
	public Double calcularAntiguedad(); /*a�os trabajados * el porcentaje de antiguedad*/
	public String reporteMensual(Integer nroMes); /*no dira cuanto falto y cuando le corresponde*/
	public String reporteAnual(); /*nos dara una cant. de dias ausentes y el promedio del salario en los 12 meses*/
	public void setDiasAusentesEnUnMes(Integer diasAusentes, Integer nroMes);//setear los dias ausentes en un mes deteminado
	public void renunciarJubilarce();//estado pasa a false
	public Boolean estado();
	
}
