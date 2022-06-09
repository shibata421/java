package br.com.shibata;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {
		
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(hoje.format(formater));
		
		LocalDate certainDay = LocalDate.of(2099, Month.JANUARY, 25);
		System.out.println(certainDay.format(formater));
		
		Period periodo = Period.between(hoje, certainDay);
		System.out.println(periodo);
	}
}
