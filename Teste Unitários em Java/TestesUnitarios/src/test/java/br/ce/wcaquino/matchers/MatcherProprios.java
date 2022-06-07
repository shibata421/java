package br.ce.wcaquino.matchers;

import java.util.Calendar;
import java.util.Date;

import br.ce.wcaquino.utils.DataUtils;

public class MatcherProprios {

	public static DiaDaSemanaMatcher caiEm(Integer diaSemana) {
		return new DiaDaSemanaMatcher(diaSemana);
	}
	
	public static DiaDaSemanaMatcher caiNumaSegunda() {
		return new DiaDaSemanaMatcher(Calendar.MONDAY);
	}
	
	public static DiaDoMesMatcher ehHoje() {
		return new DiaDoMesMatcher(new Date());
	}
	
	public static DiaDoMesMatcher ehAmanha() {
		return new DiaDoMesMatcher(DataUtils.adicionarDias(new Date(), 1));
	}

	public static DiaDoMesMatcher ehHojeComDiferencaDias(int dias){
		return new DiaDoMesMatcher(DataUtils.adicionarDias(new Date(), dias));		
	}
}
