package java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);
		int anos = olimpiadasRio.getYear() - hoje.getYear();
		System.out.println(anos);
		
//		Period periodo = Period.between(hoje, olimpiadasRio);
		LocalDate proximasOlimpiadas = olimpiadasRio.plusYears(4);
		System.out.println(proximasOlimpiadas);
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(formatador.format(proximasOlimpiadas));
		
		DateTimeFormatter formatador2 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatador2));
		
		LocalTime intervalo = LocalTime.of(15, 30);
		System.out.println(intervalo);
	}
}
