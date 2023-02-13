package qhung.com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Professor {
	@Id
	private String profNo; 
	private String profName;
	
	public Professor() {
		
	}
	public Professor(String profNo, String profName) {
		this.profNo = profNo;
		this.profName = profName;
	}
	public String getProfNo() {
		return profNo;
	}
	public void setProfNo(String profNo) {
		this.profNo = profNo;
	}
	public String getProfName() {
		return profName;
	}
	public void setProfName(String profName) {
		this.profName = profName;
	} 
	
}
