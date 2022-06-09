public class PrintGrade {
	public String print(int grade) {
		if (grade > 93) {
			return "You got an A!";
		} else if (grade > 83) {
			return "You got an B!";
		} else if (grade > 73) {
			return "You got an C!";
		} else {
			return "You need to study more!";
		}

	}
}
