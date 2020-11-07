package ar.unlam.edu.rrhh;

public class Persona {

	private Integer dni;
	private String nombre;
	private String apellido;
	private Calendario fechaDeNacimiento;
	private Double salario;
	private Integer antiguedad;
	private Integer absentismo;
	
	public Persona(Integer dni, String nombre, String apellido, Calendario fechaDeNacimiento, Double salario, Integer antiguedad, Integer absentismo) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.salario=salario;
		this.absentismo=absentismo;
		this.antiguedad=antiguedad;
	}

	public Integer getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}


	public Double getSalario() {
		return salario;
	}

	public Calendario getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Calendario fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public Integer getAntiguedad() {
		return antiguedad;
	}

	public Integer getAbsentismo() {
		return absentismo;
	}
	
	
	
}
