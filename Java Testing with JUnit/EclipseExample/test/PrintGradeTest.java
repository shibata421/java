import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrintGradeTest {

	@Test
	void test() {
		PrintGrade pg = new PrintGrade();
		String result = pg.print(95);
		assertEquals("You got an A!", result);
	}

}
