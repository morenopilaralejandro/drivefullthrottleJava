package classes;

public class QuestionFactory {
	public static QuestionInterface getQuestionObject() {
		return new Question();
	}
}
