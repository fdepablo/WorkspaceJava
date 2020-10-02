package fechasv17;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

// Clase para ver manejos de fechas segun la version 1.7 de Java
public class PruebaFechas {

	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("'La hora es: 'yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		System.out.println(df.format(date));
		
		Calendar calendar = Calendar.getInstance();
		calendar = new GregorianCalendar();
		System.out.println(df.format(calendar.getTime()));
		String fecha = "La hora es: 2014-07-23 10:00:00";
		try {
			date = df.parse(fecha);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Hora inicial");
		System.out.println(df.format(calendar.getTime()));
		System.out.println("Establecemos el dia 5 a la fecha inicial");
		calendar.set(Calendar.DAY_OF_MONTH, 5);
		System.out.println(df.format(calendar.getTime()));
		System.out.println("Añadimos 9 horas");
		calendar.add(Calendar.HOUR_OF_DAY, 9);
		System.out.println(df.format(calendar.getTime()));
		System.out.println("Restamos 3 minutos");
		calendar.add(Calendar.MINUTE, -3);
		System.out.println(df.format(calendar.getTime()));
		
		boolean bool = calendar.before(Calendar.getInstance());
		if(new Date().getTime() < calendar.getTimeInMillis()){
			System.out.println("La fecha a valorar es mayor que la fecha sistema");
			System.out.println(df.format(calendar.getTime()));
		}else{
			System.out.println("La fecha a valorar es menor que la fecha sistema");
			System.out.println(df.format(calendar.getTime()));
		}
	}

}
