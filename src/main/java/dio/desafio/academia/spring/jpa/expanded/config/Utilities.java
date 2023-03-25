package dio.desafio.academia.spring.jpa.expanded.config;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utilities {
	
	public static Instant converteParaInstant(String data,String horaMinutoSegundo)
	{
		// convert String to LocalDate and to Instant

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate ldData = LocalDate.parse(data, formatter);
		
		String strInstant = ldData.format(DateTimeFormatter.ISO_LOCAL_DATE);
		strInstant = strInstant + horaMinutoSegundo;		
		
		return Instant.parse(strInstant); 		
		
	}

}
