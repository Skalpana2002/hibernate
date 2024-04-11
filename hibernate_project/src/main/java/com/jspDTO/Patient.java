package com.jspDTO;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int p_id;
	private String p_name;
	private String diagnosis;
	private String P_address;
	
	@ManyToOne
	Hospital hospitalp;
	
	@OneToMany
	@JoinColumn
	List<Medical_record> Record;
	
	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getP_address() {
		return P_address;
	}

	public void setP_address(String p_address) {
		P_address = p_address;
	}

	public Hospital getHospitalp() {
		return hospitalp;
	}

	public void setHospitalp(Hospital hospitalp) {
		this.hospitalp = hospitalp;
	}

	public List<Medical_record> getRecord() {
		return Record;
	}

	public void setMedicalRecord(List<Medical_record> Record) {
		this.Record = Record;
	}

	
	

}
