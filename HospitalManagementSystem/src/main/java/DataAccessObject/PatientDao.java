package DataAccessObject;

import java.util.ArrayList;
import java.util.List;

import DataTransforObject.Doctor;
import DataTransforObject.Hospital;
import DataTransforObject.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class PatientDao {
	
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	  EntityManager manager=factory.createEntityManager();
	  EntityTransaction transaction=manager.getTransaction();
	  
	  public void createPatient(int hospitalId , Patient patient)
	  {
		  Hospital hospital = manager.find(Hospital.class, patient);
		  if(hospital !=null) {
				List<Patient>patientList=new ArrayList();
				patientList.add(patient);
				transaction.begin();
				hospital.setPatient(patientList);
				patient.setHospital(hospital);
				manager.persist(patient);
				System.out.println("WELCOME Dr."+patient.getpName()+"to"+hospital.gethName());
				transaction.commit();
				
			}else {
				System.out.println("patient name is not there");
			}
	  }
	  
	  public void removePatient(int id1)
		{
			Patient patient = manager.find(Patient.class,id1);
			if(patient != null)
			{
				transaction.begin();
		
				manager.remove(patient);
				System.out.println("patient name removed successfully");
				transaction.commit();
				
			}
			else {
				System.out.println("patient does not exist");
			}
		}
	  public void  viewPatientByName(String name)
			{
				Query q=manager.createQuery("select p from Patient p where p.name=?1");
				q.setParameter(1, name);
				List<Patient> patient=q.getResultList();
				for(Patient p:patient)
				{
					System.out.println(p.getP_id());
					System.out.println(p.getpName());
					System.out.println(p.getDiagnosis());
					System.out.println(p.getAddress());

					
				}
			}
	  
	  public void viewallPatient()
		{
			Query q=manager.createQuery("select p from Patient p");
			List<Patient> patient=q.getResultList();
			for(Patient p1:patient)
			{
				System.out.println(p1.getP_id());
				System.out.println(p1.getpName());
				System.out.println(p1.getDiagnosis());
				System.out.println(p1.getAddress());


			}
		}


}
