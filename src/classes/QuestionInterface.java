package classes;

import java.util.Collection;

public interface QuestionInterface {
	public QuestionInterface getQuestionById(int id);
	public Collection<QuestionInterface> getAllQuestion();
	
	public void delete();
	public QuestionInterface insert(
			int idQ,
			String img,
			String stmnt ,
			String o0 ,
			String o1 ,
			String o2 ,
			int correctAnswer,
			int difficulty,
			int category
	);
	
	public int getIdQ();
	public void setIdQ(int idQ);
	
	public String getImg();
	public void setImg(String img);

	public String getStmnt();
	public void setStmnt(String stmnt);

	public String[] getoArr();
	public void setoArr(String[] oArr);

	public int getCorrectAnswer();
	public void setCorrectAnswer(int correctAnswer);

	public int getDifficulty();
	public void setDifficulty(int difficulty);

	public int getCategory();
	public void setCategory(int category);
}
