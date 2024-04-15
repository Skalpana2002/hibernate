package DataAccessObject;

import java.util.ArrayList;
import java.util.List;

import DataTransforObject.Doctor;
import DataTransforObject.Hospital;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class DoctorDao {
	
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	  EntityManager manager=factory.createEntityManager();
	  EntityTransaction transaction=manager.getTransaction();
	  
	  public void createDoctor(int hospitalId , Doctor doctor)
	  {
		  Hospital hospital = manager.find(Hospital.class, hospitalId);
		  if(hospital !=null) {
				List<Doctor>doctorList=new ArrayList<Doctor>();
				doctorList.add(doctor);
				transaction.begin();
				hospital.setDoctor(doctorList);
				doctor.setHospital(hospital);
				manager.persist(doctor);
				System.out.println("WELCOME Dr."+doctor.getdName()+"to"+hospital);
				transaction.commit();
				
			}else {
				System.out.println("Doctor name is not there");
			}
	  }
	  
	  public void updateDoctorSalary(int id)
	  {
		  Doctor doctor = manager.find(Doctor.class,id);
			if(doctor != null)
			{
				transaction.begin();
				doctor.setSalary(id);
				manager.merge(doctor);
				System.out.println("doctor salary updated successfully");
				transaction.commit();
				
			}
			else {
				System.out.println("doctor salary is not there");
			}
	  }
	  public void removeDoctor(int id1)
		{
			Doctor doctor = manager.find(Doctor.class,id1);
			if(doctor != null)
			{
				transaction.begin();
		
				manager.remove(doctor);
				System.out.println("doctor name removed successfully");
				transaction.commit();
				
			}
			else {
				System.out.println("doctor does not exist");
			}
		}
	  public void  viewDoctorByName(String name)
		{
			Query q=manager.createQuery("select d from doctor d where d.name=?1");
			q.setParameter(1, name);
			List<Doctor> doctor=q.getResultList();
			for(Doctor d:doctor)
			{
				System.out.println(d.getDoc_id());
				System.out.println(d.getdName());
				System.out.println(d.getQualification());
				System.out.println(d.getSalary());

				
			}
		}
	  public void viewallDoctor(int hos_Id)
		{
			Query q=manager.createQuery("select d from Doctor d where d.hos_Id=?1");
			List<Doctor> doctor=q.getResultList();
			
			
			
			
//			for(Doctor d1:doctor)
//			{
//				System.out.println(d1.getDoc_id());
//				System.out.println(d1.getdName());
//				System.out.println(d1.getQualification());
//				System.out.println(d1.getSalary());
//				
//
//			}
		}

}
