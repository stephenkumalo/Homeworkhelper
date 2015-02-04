package helper;
import java.util.Date;

public class Homework {
private Date homeworkDueDate;
private String homeworkInfo;
private int points;
private Date homeworkRoughDraft;
private int problemNumber;


public Date getHomeworkDueDate() {
	return homeworkDueDate;
}
public void setHomeworkDueDate(Date homeworkDueDate) {
	this.homeworkDueDate = homeworkDueDate;
}
public String getHomeworkInfo() {
	return homeworkInfo;
}
public void setHomeworkInfo(String homeworkInfo) {
	this.homeworkInfo = homeworkInfo;
}
public int getPoints() {
	return points;
}
public void setPoints(int points) {
	this.points = points;
}
public Date getHomeworkRoughDraft() {
	return homeworkRoughDraft;
}
public void setHomeworkRoughDraft(Date homeworkRoughDraft) {
	this.homeworkRoughDraft = homeworkRoughDraft;
}
public int getProblemNumber() {
	return problemNumber;
}
public void setProblemNumber(int problemNumber) {
	this.problemNumber = problemNumber;
}


}
