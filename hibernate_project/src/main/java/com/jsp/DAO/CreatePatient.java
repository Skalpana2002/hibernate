package com.jsp.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspDTO.Hospital;
import com.jspDTO.Patient;

public class CreatePatient {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	Scanner sc = new Scanner(System.in);
	
	public void addPatient(int h_id ,Patient patient) {
		System.out.println("enter hospital id");
		Hospital hospital = manager.find(Hospital.class, h_id);
		if(hospital != null) {
			List<Patient> patients = new ArrayList<Patient>();
			patients.add(patient);
			
			transaction.begin();
			hospital.setPatients(patients);
			patient.setHospitalp(hospital);
			manager.persist(patients);
			System.out.println("WELCOME "+patient.getP_name()+" to "+hospital.getH_name());
			transaction.commit();
		}
		else {
			System.out.println("hospital not present");
		}
	}
	
	public void removePatient_id(int p_id) {
		
		System.out.println("Enter patient id");
		Patient patients = manager.find(Patient.class, p_id);
		
		if(patients !=null) {
			transaction.begin();
			manager.remove(patients);
			System.out.println("patient removed");
			transaction.commit();
		}
		else {
			System.out.println("patient not found");
		}
		
	}
	public void displayPatient_name(String p_name) {
		
		System.out.println("Enter patient name");
		Query q = manager.createQuery("select p from Patient p where p_name=?1");
		q.setParameter(1, p_name);
		
		List<Patient> patients = q.getResultList();
		
		for(Patient p :patients)
		{
			System.out.println(p.getP_id()+" "+p.getP_name()+" "+p.getP_address());
		}
	}
	
	public void  DiplayPatient() {
		Query q = manager.createQuery("select p from Patient p ");
		List<Patient> patients = q.getResultList();
		
		for(Patient p  :patients)
		{
			System.out.println(p.getP_id()+" "+p.getP_name()+" "+p.getP_address());
			System.out.println("==============");
		}
	}

}
