package org.pt.learn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table (name="MAGAZINE_QUIZ_QUES")
public class MagazineQuizQues {
	
	@Id
	@GeneratedValue
	@Column (name="QUIZ_QUES_ID")
	private Long quizQuesId;
	
	@Column (name="QUESTION")
	private String question;
	
	@Column (name="QPTION1")
	private String option1;
	
	@Column (name="QPTION2")
	private String option2;
	
	@Column (name="QPTION3")
	private String option3;
	
	@Column (name="QPTION4")
	private String option4;
	
	@Column (name="ANSWER")
	private int answer;
	
	@Column (name="QUES_ORDER_NO")
	private int quesOrderNo;
	
	@Column (name="ANS_DESCRIPTION")
	private String ansDescription;
	
	// Snippet.LIST_COURSE_TYPE.get(0)+pageId+"PAGE"
	// TheMagazineCourse+ PAGE_ID + PAGE
	@Column (name="COURSE_TYPE_ID", nullable=false)
	private String courseTypeId;
	
	@Transient
	private String result;


	public Long getQuizQuesId() {
		return quizQuesId;
	}

	public void setQuizQuesId(Long quizQuesId) {
		this.quizQuesId = quizQuesId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public String getAnsDescription() {
		return ansDescription;
	}

	public void setAnsDescription(String ansDescription) {
		this.ansDescription = ansDescription;
	}

	public String getCourseTypeId() {
		return courseTypeId;
	}

	public void setCourseTypeId(String courseTypeId) {
		this.courseTypeId = courseTypeId;
	}
	

	public int getQuesOrderNo() {
		return quesOrderNo;
	}

	public void setQuesOrderNo(int quesOrderNo) {
		this.quesOrderNo = quesOrderNo;
	}
	
	

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "MagazineQuizQues [quizQuesId=" + quizQuesId + ", question="
				+ question + ", option1=" + option1 + ", option2=" + option2
				+ ", option3=" + option3 + ", option4=" + option4 + ", answer="
				+ answer + ", ansDescription=" + ansDescription
				+ ", courseTypeId=" + courseTypeId + "]";
	}

	
}
