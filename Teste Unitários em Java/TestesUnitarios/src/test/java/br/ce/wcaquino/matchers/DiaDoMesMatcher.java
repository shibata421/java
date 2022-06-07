package br.ce.wcaquino.matchers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import br.ce.wcaquino.utils.DataUtils;

public class DiaDoMesMatcher extends TypeSafeMatcher<Date> {

	private Date data;
	
	public DiaDoMesMatcher(Date data) {
		this.data = data;
	}
	
	@Override
	public void describeTo(Description description) {
		description.appendText(String.valueOf(new SimpleDateFormat().format(data)));
	}

	@Override
	protected boolean matchesSafely(Date data) {
		return DataUtils.isMesmaData(this.data, data);
	}

}
