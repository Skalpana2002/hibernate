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

public class CreateDoctor {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	Scanner sc = new Scanner(System.in);
	
	public void createDoctor(int h_id, Doctor doctor) {
	
		System.out.println("enter hospital id");
		Hospital hospital = manager.find(Hospital.class, h_id);
		if(hospital != null) {
			List<Doctor> doctors = new ArrayList<Doctor>();
			doctors.add(doctor);
			
			transaction.begin();
			hospital.setDoctors(doctors);
			doctor.setHospital(hospital);
			manager.persist(doctors);
			System.out.println("WELCOME Dr."+doctor.getD_name()+" to "+hospital.getH_name());
			transaction.commit();
		}
		else {
			System.out.println("hospital not present");
		}
	}
	public void updateSalary_id(double salary, int d_id) {
		
		System.out.println("enter Doctor id ");
		System.out.println("enter Dcotor Salary");
		Query q = manager.createQuery("update Doctor d set d.salary=?1 where d.d_id=?2");
		q.setParameter(1, salary);
		q.setParameter(2, d_id);
		
		transaction.begin();
		q.executeUpdate();
		System.out.println("salary updaed");
		transaction.commit();
	}
	
	public void removeDoctor(String d_name) {
		
		System.out.println("Enter Doctor name");
		Doctor doctors= manager.find(Doctor.class, d_name);
		
		if(doctors !=null) {
			transaction.begin();
			manager.remove(doctors);
			System.out.println("Doctor removed");
			transaction.commit();
		}
		else {
			System.out.println("Doctor not found");
		}
	}
	
	public void display_DoctorName(String d_name) {
		
		System.out.println("Enter docotr name");
		Query q = manager.createQuery("select d from Doctor d where d_name=?1");
		q.setParameter(1, d_name);
		
		List<Doctor> doctors = q.getResultList();
		
		for(Doctor d :doctors)
		{
			System.out.println(d.getD_id()+" "+d.getD_name()+" "+d.getD_Qualification()+" "+d.getSalary());
			System.out.println("==============");
		}
	}
	
	public void Specific_HospitalDoctor(String h_name) {
		
		System.out.println("Enter hospital name");
		Query q = manager.createQuery("select d from Doctor d where h.h_name=?1");
		q.setParameter(1, h_name);
		List<Hospital> hospital = q.getResultList();
		
		if(hospital != null) {
			System.out.println(((Hospital) hospital).getDoctors());
		}
		else {
			System.out.println("hospital not present");
		}
		
		}

}
