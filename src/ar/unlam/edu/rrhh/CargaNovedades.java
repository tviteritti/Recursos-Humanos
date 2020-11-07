package ar.unlam.edu.rrhh;

public interface CargaNovedades {
	
	public Integer obtenerFaltasDelMes(); /*me da la cant. de ausentismo en el mes*/
	public Double LiquidacionFinal(); /*cuando un empleado renuncia o se jubila*/
	public Double salarioNeto(); /* el basico + antiguedad - ausentismo*/
	public Double salarioBruto(); /*el basico + antiguedad */
	public Double calcularAntiguedad(); /*años trabajados * el porcentaje de antiguedad*/
	public String reporteMensual(); /*no dira cuanto falto y cuando le corresponde*/
	public String reporteAnual(); /*nos dara una cant. de dias ausentes y el promedio del salario en los 12 meses*/

	
}
