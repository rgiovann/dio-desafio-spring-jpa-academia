package dio.desafio.academia.spring.jpa.expanded.config;
/**
 *   Singleton  Utilities
 */

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utilities {
	
	private static class UtilitiesInstanceHolder{
		public static Utilities instanceUtilities = new Utilities();
	}
	
	private Utilities(){
		super();
	}
	
	public static Utilities getInstancia()
	{
		return UtilitiesInstanceHolder.instanceUtilities;
	}
	
	public Instant converteParaInstant(String data,String horaMinutoSegundo)
	{
		// convert String to LocalDate and to Instant

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate ldData = LocalDate.parse(data, formatter);
		
		String strInstant = ldData.format(DateTimeFormatter.ISO_LOCAL_DATE);
		strInstant = strInstant + horaMinutoSegundo;		
		
		return Instant.parse(strInstant); 		
		
	}

}
