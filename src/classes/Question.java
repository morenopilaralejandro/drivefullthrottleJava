package classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import db.Connect;

public class Question implements QuestionInterface {
	private int idQ; 
	private String img; 
	private String stmnt;
	private String[] oArr;
	private int correctAnswer;
	private int difficulty; 
	private int category;
	
	Question(){}
	Question(int idQ, String img, String stmnt, 
			String o0, String o1, String o2, int correctAnswer, 
			int difficulty, int category) {
		this.idQ=idQ; 
		this.img=img; 
		this.stmnt=stmnt; 
		this.oArr= new String[3];
		this.oArr[0]=o0;
		this.oArr[1]=o1;
		this.oArr[2]=o2;
		this.correctAnswer=correctAnswer; 
		this.difficulty=difficulty; 
		this.category=category; 
	}
	
	@Override
	public QuestionInterface getQuestionById(int id) {
		QuestionInterface res = null;
		try {
			Connection con = new Connect().getCon();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from question where id_q="+id+";");
			while (rs.next()) {
				res=new Question(
						rs.getInt(1), rs.getString(2),  rs.getString(3), 
						rs.getString(4),  rs.getString(5),  rs.getString(6), 
						rs.getInt(7), rs.getInt(8),  rs.getInt(9));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Collection<QuestionInterface> getAllQuestion() {
		ArrayList<QuestionInterface> res = new ArrayList<QuestionInterface>();
		try {
			Connection con = new Connect().getCon();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from question");
			while (rs.next()) {
				res.add(new Question(
						rs.getInt(1), rs.getString(2),  rs.getString(3), 
						rs.getString(4),  rs.getString(5),  rs.getString(6), 
						rs.getInt(7), rs.getInt(8),  rs.getInt(9)));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public void delete() {
		try {
			Connection con = new Connect().getCon();
			Statement stmt = con.createStatement();
			stmt.execute("delete from question where id_q="+this.idQ+";");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public QuestionInterface insert(int idQ, String img, String stmnt, 
			String o0, String o1, String o2,int correctAnswer, 
			int difficulty, int category) {
		QuestionInterface qAux=null;
		int idAux=0;
		try {
			/*idQ parameter == 0 -> auto increment*/
			Connection con = new Connect().getCon();
			if(idQ==0) {
				Statement stmt1 = con.createStatement();
				stmt1.execute("insert into question(img,stmnt,o0,o1,o2,correctAnswer,difficulty,category) values ('"+
						img+"','"+stmnt+"','"+o0+"','"+o1+"','"+o2+"',"+correctAnswer+","+difficulty+","+category+");");
				
				Statement stmt2 = con.createStatement();
				ResultSet rs = stmt2.executeQuery("select last_insert_id();");
				while (rs.next()) {
					idAux=rs.getInt(1);
				}
			}else {
				idAux=idQ;
				Statement stmt1 = con.createStatement();
				stmt1.execute("insert into question(id_q, img,stmnt,o0,o1,o2,correctAnswer,difficulty,category) values ("+
						idQ+",'"+img+"','"+stmnt+"','"+o0+"','"+o1+"','"+o2+"',"+correctAnswer+","+difficulty+","+category+");");
			}
			qAux= new Question(idAux, img, stmnt, o0, o1, o2, correctAnswer, difficulty, category);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qAux;
	}
	
	
	@Override
	public int getIdQ() {
		return idQ;
	}
	
	@Override
	public void setIdQ(int idQ) {
		try {
			Connection con = new Connect().getCon();
			Statement stmt = con.createStatement();
			stmt.execute("update question set id_q="+idQ+
					" where id_q="+this.idQ+";");
			this.idQ = idQ;
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getImg() {
		return img;
	}
	
	@Override
	public void setImg(String img) {
		try {
			Connection con = new Connect().getCon();
			Statement stmt = con.createStatement();
			stmt.execute("update question set img='"+img+
					"' where id_q="+this.idQ+";");
			this.img = img;
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getStmnt() {
		return stmnt;
	}
	
	@Override
	public void setStmnt(String stmnt) {
		try {
			Connection con = new Connect().getCon();
			Statement stmt = con.createStatement();
			stmt.execute("update question set stmnt='"+stmnt+
					"' where id_q="+this.idQ+";");
			this.stmnt = stmnt;
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String[] getoArr() {
		return oArr;
	}
	
	@Override
	public void setoArr(String[] oArr) {
		try {
			Connection con = new Connect().getCon();
			Statement stmt = con.createStatement();
			
			String o0Aux = oArr[0];
			String o1Aux = oArr[1];
			String o2Aux = oArr[2];
			
			stmt.execute("update question set "+
					"o0='"+o0Aux+"', "+
					"o1='"+o1Aux+"', "+
					"o2='"+o2Aux+
					"' where id_q="+this.idQ+";");
			this.oArr = oArr;
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int getCorrectAnswer() {
		return correctAnswer;
	}
	
	@Override
	public void setCorrectAnswer(int correctAnswer) {
		try {
			Connection con = new Connect().getCon();
			Statement stmt = con.createStatement();
			stmt.execute("update question set correctAnswer="+correctAnswer+
					" where id_q="+this.idQ+";");
			this.correctAnswer = correctAnswer;
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int getDifficulty() {
		return difficulty;
	}
	
	@Override
	public void setDifficulty(int difficulty) {
		try {
			Connection con = new Connect().getCon();
			Statement stmt = con.createStatement();
			stmt.execute("update question set difficulty="+difficulty+
					" where id_q="+this.idQ+";");
			this.difficulty = difficulty;
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int getCategory() {
		return category;
	}

	@Override
	public void setCategory(int category) {
		try {
			Connection con = new Connect().getCon();
			Statement stmt = con.createStatement();
			stmt.execute("update question set category="+category+
					" where id_q="+this.idQ+";");
			this.category = category;
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public String toString() {
		return "Question [idQ=" + idQ + ", img=" + img + ", stmnt=" + stmnt + ", oArr=" + Arrays.toString(oArr)
				+ ", correctAnswer=" + correctAnswer + ", difficulty=" + difficulty + ", category=" + category + "]";
	}
	
	
	
}
