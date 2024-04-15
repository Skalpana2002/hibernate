package DataAccessObject;

import java.util.ArrayList;
import java.util.List;

import DataTransforObject.Doctor;
import DataTransforObject.Hospital;
import DataTransforObject.MedicalRecord;
import DataTransforObject.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MedicalRecordDao {
	
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	  EntityManager manager=factory.createEntityManager();
	  EntityTransaction transaction=manager.getTransaction();
	  
	  public void createmedicalrecord(MedicalRecord medicalrecord)
		{
		  transaction.begin();
		  manager.persist(medicalrecord);
		  transaction.commit();
		}
		public void updatemedicalrecord(int id, String Date_of_examination)
		{
			MedicalRecord medicalrecord=manager.find(MedicalRecord.class,id);
			if( medicalrecord!=null)
			{
				transaction.begin();
				medicalrecord.setDate_of_examination(Date_of_examination);
				manager.merge(medicalrecord);
				transaction.commit();
			}
			else
			{
			  System.out.println("Medicalrecord is not exist.....");	
			}
		}
		public void removesmedicalrecordid(int id)
		{
			MedicalRecord medicalrecord=manager.find(MedicalRecord.class, id);
			if(medicalrecord !=null)
			{
				transaction.begin();
				manager.remove(medicalrecord);
				transaction.commit();
			}
			else
			{
				System.out.println("It is not found....");
			}
		}
		public void dispaymedicalrecord(int id)
		{
			Patient patient=manager.find(Patient.class,id);
			if(patient !=null)
			{
			   List<MedicalRecord> medicalrecord=patient.getMediacalRecord();
			   for(MedicalRecord m : medicalrecord)
			   {
				   System.out.println(m.getRecord_id()+" "+m.getProblem()+" "+m.getDate_of_examination());
			   }
			}
		}
	
}
