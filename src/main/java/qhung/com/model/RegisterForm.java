package qhung.com.model;

public class RegisterForm {
 private String profNo; 
 private String courseNo;
public String getProfNo() {
	return profNo;
}
public void setProfNo(String profNo) {
	this.profNo = profNo;
}
public String getCourseNo() {
	return courseNo;
}
public void setCourseNo(String courseNo) {
	this.courseNo = courseNo;
}
public RegisterForm() {

}
public RegisterForm(String profNo, String courseNo) {
	this.profNo = profNo;
	this.courseNo = courseNo;
} 
 
}
