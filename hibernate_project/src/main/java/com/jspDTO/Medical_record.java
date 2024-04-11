package com.jspDTO;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Medical_record {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int m_id;
	private String problem;
	private String date_of_examination;
	
	@ManyToOne
	Patient patient;

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getDate_of_examination() {
		return date_of_examination;
	}

	public void setDate_of_examination(String date_of_examination) {
		this.date_of_examination = date_of_examination;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	

}
	
	


