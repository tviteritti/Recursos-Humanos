package ar.unlam.edu.persona;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

import ar.unlam.edu.calendario.Calendario;
import ar.unlam.edu.rrhh.CargaNovedades;

public class Persona implements CargaNovedades {

	private Integer dni; /* hashcode */
	private String nombre;
	private String apellido;
	private Calendar fechaDeNacimiento;
	protected Double salario;
	private Integer numLegajo; /* hashcode */
	protected Integer antiguedad;
	protected Integer ausentismo[];
	private Boolean estado;

	public Persona(Integer numLegajo, Integer dni, String nombre, String apellido, Calendar fechaDeNacimiento,
			Double salario, Integer antiguedad) {
		this.numLegajo = numLegajo;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = Calendar.getInstance();
		this.salario = salario;
		this.ausentismo = new Integer[12];
		this.antiguedad = antiguedad;
		this.estado = true;
	}

	public Persona(Integer id) {
		this.dni = id;
	}
	
	public Persona () {
		
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

	public void setFaltas(Integer[] ausentismo) {
		this.ausentismo = ausentismo;
	}

	public String getFecha_nac() {
		Integer dia = fechaDeNacimiento.get(fechaDeNacimiento.DATE);
		Integer mes = fechaDeNacimiento.get(fechaDeNacimiento.MONTH);
		Integer ano = fechaDeNacimiento.get(fechaDeNacimiento.YEAR);
		String fecha = dia + "/" + mes + "/" + ano;
		return fecha;
	}

	public void setFecha_nac(Integer dia, Integer mes, Integer ano) {
		fechaDeNacimiento.set(Calendar.DATE, dia);
		fechaDeNacimiento.set(Calendar.MONTH, mes);
		fechaDeNacimiento.set(Calendar.YEAR, ano);
	}

	public Integer getEdad() {
		Calendar today = Calendar
				.getInstance(); /* instancio un calendario nuevo, pero este me dice el tiempoa actual */
		int dif_ano = today.get(Calendar.YEAR)
				- fechaDeNacimiento.get(Calendar.YEAR); /* resto el actual - el asignado */
		int dif_mes = today.get(Calendar.MONTH)
				- fechaDeNacimiento.get(Calendar.MONTH); /* resto el actual - el asignado */
		int dif_dia = today.get(Calendar.DAY_OF_MONTH)
				- fechaDeNacimiento.get(Calendar.DAY_OF_MONTH); /* resto el actual - el asignado */
		if (dif_mes < 0 || (dif_mes == 0 && dif_dia < 0)) { /* condiono para que me diga el anio exacto */
			dif_ano = dif_ano - 1;
		}
		return dif_ano;
	}

	@Override
	public Integer obtenerFaltasDelMes(Integer nroMes) {

		return ausentismo[nroMes -1];
	}

	@Override
	public Double LiquidacionFinal() {
		Calendar hoy = Calendar.getInstance();
		Double salarioPorDia = salarioBruto() / 30;
		Integer diasRestantes = 30 - hoy.get(Calendar.DAY_OF_MONTH);
		Double salarioLiquidado = salarioNeto(hoy.get(Calendar.MONTH) + 1) - (salarioPorDia * diasRestantes);

		return salarioLiquidado;
	}

	@Override
	public Double salarioNeto(Integer nroMes) {
		Double resta = (this.salario / 30) * ausentismo[nroMes - 1];
		return salarioBruto() - resta;
	}

	@Override
	public Double salarioBruto() {
		Double bruto = this.salario + (this.salario * 5 / 100) * this.antiguedad; /*5%*/
		return bruto;
	}

	@Override
	public Double calcularAntiguedad() {
		double antiguedad = this.salario * (this.antiguedad*0.05);
		return antiguedad;
	}

	@Override
	public String reporteMensual(Integer nroMes) {

		return "Saldo= " + salarioNeto(nroMes) + ", ausentismo= " + ausentismo[nroMes - 1];
	}

	@Override
	public String reporteAnual() {
		Double anualSaldo = 0.0;
		Integer anualFaltas = 0;
		for (int i = 1; i < 13; i++) {
			anualSaldo += salarioNeto(i);
		}
		for (int i = 0; i < 12; i++) {
			anualFaltas += ausentismo[i];
		}

		return "Saldo= " + anualSaldo + ", ausentismo= " + anualFaltas;
	}

	@Override
	public void setDiasAusentesEnUnMes(Integer diasAusentes, Integer nroMes) {
		this.ausentismo[nroMes -1] = diasAusentes;

	}

	public Double calcularAusentismo(Integer nroMes) {
		Double ausentismo = 0.0;
		ausentismo = (this.salario / 30.0)*this.obtenerFaltasDelMes(nroMes); 
		return ausentismo;
	}

	public Integer obtenerFaltasAnuales() { /*para que me de todos los dias que fue ausente */
		Integer suma=0;
        for (int i = 0; i <ausentismo.length; i++) {
        	if(ausentismo[i]==null) { /*como el array almacena ibjetos wrapper sojn null y no 0 hay que convertir*/
        		ausentismo[i]=0;
        	}
            suma+=ausentismo[i];
        }
		return suma;
	}

	public void renunciarJubilarce() {
		this.estado = false;
		
	}
	
	public void darAlta() {
		this.estado = true;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
	public Boolean darBaja() {
		return this.estado = false;
	}
	
	
	
	
}
