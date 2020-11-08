package ar.unlam.edu.persona;

import java.util.Calendar;

import ar.unlam.edu.calendario.Calendario;

public class Persona {


	private Integer dni; /*hashcode*/
	private String nombre;
	private String apellido;
	private Calendar fechaDeNacimiento;
	private Double salario;
	private Integer numLegajo; /* hashcode*/
	private Integer antiguedad;
	private Integer ausentismo;
	
	
	
	public Persona(Integer numLegajo, Integer dni, String nombre, String apellido, Calendario fechaDeNacimiento, Double salario, Integer antiguedad, Integer ausentismo) {
		this.numLegajo = numLegajo;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = Calendar.getInstance();
		this.salario=salario;
		this.ausentismo=ausentismo;
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

	public Integer getAusentismo() {
		return ausentismo;
	}

	public void setAusentismo(Integer ausentismo) {
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
	
}
