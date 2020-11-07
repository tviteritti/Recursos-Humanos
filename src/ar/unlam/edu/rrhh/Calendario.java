package ar.unlam.edu.rrhh;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Calendario extends GregorianCalendar{

	public Calendario(int year, int month, int dayOfMonth) {
		super(año, mes - 1, dia);
		setLenient(false);
		
	}

	public MiCalendar(Calendar cal)
	{
		setDia(cal.get(DAY_OF_MONTH));
		setMes(cal.get(MONTH) + 1);
		setAño(cal.get(YEAR));
	}
	
	
	public int getDia()
	{
		return get(DAY_OF_MONTH);
	}
	
	
	public int getMes()
	{
		return get(MONTH) + 1;
	}
	
	
	public int getAño()
	{
		return get(YEAR);
	}
	
	
	public void setDia(int dia)
	{
		set(DAY_OF_MONTH, dia);
	}
	
	
	public void setMes(int mes)
	{
		set(MONTH, mes-1);
	}
	
	
	public void setAño(int año)
	{
		set(YEAR, año);
	}
	
	
	@Override
	public String toString()
	{
		return String.format("%02d/%02d/%04d", getDia(), getMes(), getAño());
	}

    public Date toDate() {
        return new Date(this.getTimeInMillis());
    }
	
}
