package com.jsp.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspDTO.Doctor;
import com.jspDTO.Hospital;
import com.jspDTO.Medical_record;
import com.jspDTO.Patient;

public class MedicalRecord {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	Scanner sc = new Scanner(System.in);
	
	public void addRecord(int p_id ,Medical_record Record) {
		
		System.out.println("enter Patient id");
		Patient patients = manager.find(Patient.class, p_id);
		
		if(patients !=null) {
			List<Medical_record> Records = new ArrayList<Medical_record>();
			Records.add(Record);
			
			transaction.begin();
			patients.setMedicalRecord(Records);
			Record.setPatient(patients);
			manager.persist(Records);
			System.out.println("Record added");
			transaction.commit();
		}
		else {
			System.out.println("patient not present");
		}
	}
	
	public void updateDateOfExamination(String date_of_examination, int m_id) {
		
		System.out.println("enter record id ");
		System.out.println("enter new date");
		Query q = manager.createQuery("update Medical_reocrd m set m.date_of_examination=?1 where m.m_id=?2");
		q.setParameter(1, date_of_examination);
		q.setParameter(2, m_id);
		
		transaction.begin();
		q.executeUpdate();
		System.out.println("date of examination updated");
		transaction.commit();
	}
	
	public void removeRecord(int m_id) {
		
		System.out.println("Enter record id");
		Medical_record Record = manager.find(Medical_record.class, m_id);
		
		if(Record !=null) {
			transaction.begin();
			manager.remove(Record);
			System.out.println("record removed");
			transaction.commit();
		}
		else {
			System.out.println("record not found");
		}
	}
	
	public void patientRecord(String p_name) {
		System.out.println("Enter patient name");
		Query q = manager.createQuery("select m from Record m where p.p_name=?1");
		q.setParameter(1, p_name);
		List<Patient> patients =q.getResultList();
		if(patients !=null) {
			System.out.println(patients.);
		}
		
		else {
			System.out.println("hospital not present");
		}
	}

}
