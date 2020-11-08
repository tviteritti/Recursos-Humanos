package ar.unlam.edu.persona;

import java.util.ArrayList;
import java.util.Calendar;

import ar.unlam.edu.calendario.Calendario;
import ar.unlam.edu.rrhh.CargaNovedades;

public class Persona implements CargaNovedades{


	private Integer dni; /*hashcode*/
	private String nombre;
	private String apellido;
	private Calendar fechaDeNacimiento;
	private Double salario;
	private Integer numLegajo; /* hashcode*/
	private Integer antiguedad;
	private Integer ausentismo[];
	
	
	
	public Persona(Integer numLegajo, Integer dni, String nombre, String apellido, Calendario fechaDeNacimiento, Double salario, Integer antiguedad, Integer ausentismo) {
		this.numLegajo = numLegajo;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = Calendar.getInstance();
		this.salario=salario;
		this.ausentismo=new Integer[12];
		this.antiguedad=antiguedad;
	}

	public Persona() {
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((numLegajo == null) ? 0 : numLegajo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (numLegajo == null) {
			if (other.numLegajo != null)
				return false;
		} else if (!numLegajo.equals(other.numLegajo))
			return false;
		return true;
	}
	
	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Integer getNumLegajo() {
		return numLegajo;
	}

	public void setNumLegajo(Integer numLegajo) {
		this.numLegajo = numLegajo;
	}

	public Integer getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}

	
	public Integer[] getAusentismo() {
		return ausentismo;
	}

	public void setAusentismo(Integer[] ausentismo) {
		this.ausentismo = ausentismo;
	}

	public String getFecha_nac() {
		Integer dia = fechaDeNacimiento.get(fechaDeNacimiento.DATE);
		Integer mes = fechaDeNacimiento.get(fechaDeNacimiento.MONTH);
		Integer ano = fechaDeNacimiento.get(fechaDeNacimiento.YEAR);
		String fecha = dia+"/"+mes+"/"+ano;
		return fecha;
	}

	public void setFecha_nac(Integer dia, Integer mes, Integer ano) {
		fechaDeNacimiento.set(Calendar.DATE, dia);
		fechaDeNacimiento.set(Calendar.MONTH, mes);
		fechaDeNacimiento.set(Calendar.YEAR, ano);	
	}
	
	public Integer getEdad() {
		Calendar today = Calendar.getInstance(); /*instancio un calendario nuevo, pero este me dice el tiempoa actual*/
		 int dif_ano = today.get(Calendar.YEAR) -  fechaDeNacimiento.get(Calendar.YEAR); /*resto el actual - el asignado*/
	     int dif_mes = today.get(Calendar.MONTH) -fechaDeNacimiento.get(Calendar.MONTH); /*resto el actual - el asignado*/
	     int dif_dia = today.get(Calendar.DAY_OF_MONTH) - fechaDeNacimiento.get(Calendar.DAY_OF_MONTH); /*resto el actual - el asignado*/
	     if (dif_mes < 0 || (dif_mes == 0 && dif_dia < 0)) { /*condiono para que me diga el anio exacto*/
	            dif_ano = dif_ano - 1; 
	        }
	        return dif_ano;
	}

	@Override
	public Integer obtenerFaltasDelMes(Integer nroMes) {
		
		
		return ausentismo[nroMes-1];
	}

	@Override
	public Double LiquidacionFinal(Integer nroMes) {
		Calendar hoy = Calendar.getInstance();
		Double salarioPorDia=salarioBruto()/30;
		Integer diasRestantes=30-hoy.DAY_OF_MONTH;
		Double salarioLiquidado=salarioNeto(nroMes)-(salarioPorDia*diasRestantes);
		
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
		Double anualFaltas=0.0;
		for (Integer integer : ausentismo) {
			anualSaldo+=salarioNeto(integer);
		}
		for (Integer integer : ausentismo) {
			anualFaltas+=ausentismo[integer];
		}
		
		return "Saldo= "+ anualSaldo+", ausentismo= "+anualFaltas;
	}
	
	
	//AUSENTISMO Y ASIGNACION DE FECHA DE AUSENTISMO
	private ArrayList <Calendar> fechas; /* un array de calendario para almacenar las fechas*/
	private Integer diasFaltados; /*un contador de ausentismo*/
	public void marcarAusente(Integer dia, Integer mes, Integer ano) {
		Calendar aux = Calendar.getInstance(); /* se instancia el nuevo calendario aux*/
		aux.set(ano, mes, dia);
		fechas.add(aux);
		this.diasFaltados++; /*aumenta*/
	}

	
	public String verificarDiasAusentes() {
		String reporte=null;
		for (int i = 0; i < fechas.size(); i++) {
			reporte = fechas.get(i).get(Calendar.DATE)+"/"+fechas.get(i).get(Calendar.MONTH)+"/"+fechas.get(i).get(Calendar.YEAR);
		} /*no da un string de fecha en formato dd/mm/yyyy */
		return reporte;
	}
	
	public Integer obtenerDiasAusentes() {
		return this.diasFaltados;  /*retorna el contador de los dias ausentes*/
	}
}
