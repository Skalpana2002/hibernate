package Driver;

import java.util.Scanner;

import DataAccessObject.DoctorDao;
import DataAccessObject.HospitalDao;
import DataAccessObject.MedicalRecordDao;
import DataAccessObject.PatientDao;
import DataTransforObject.Doctor;
import DataTransforObject.Hospital;
import DataTransforObject.MedicalRecord;
import DataTransforObject.Patient;


public class Main {
	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("which one you want select");
		System.out.println("1.Hospital");
		System.out.println("2.Doctor");
		System.out.println("3.Patient");
		System.out.println("4.MedicalRecord");
		int Option=sc.nextInt();
        switch(Option)
        {
        	case 1:
        	{
        		System.out.println("which one you want select");
        		System.out.println("1.insert");
        		System.out.println("2.delete");
        		System.out.println("3.update");
        		System.out.println("4.display");
        		int number=sc.nextInt();
        		if(number==1)
        		{
        			HospitalDao hospitaldao=new HospitalDao();
        			Hospital hospital=new Hospital();
        			hospital.setHos_id(1);
        			hospital.sethName("Santhiram");
        			hospital.sethCity("Nandyal");
        			hospital.sethAddress("panyam");
        			Hospital hospital1=new Hospital();
        			hospital1.setHos_id(2);
        			hospital1.sethName("Ballagi");
        			hospital1.sethCity("kurnool");
        			hospital1.sethAddress("kodareddy bridge");
        			Hospital hospital2=new Hospital();
        			hospital2.setHos_id(3);
        			hospital2.sethName("Goverment hospital");
        			hospital2.sethCity("Rudravaram");
        			hospital2.sethAddress("pachaythiboard back");
        			hospitaldao.createHospital(hospital);
        			hospitaldao.createHospital(hospital1);
        			hospitaldao.createHospital(hospital2);
        			System.out.println("data inserted successfully...");
        			
        		}
        		else if(number==2)
        		{
        			HospitalDao hospitaldao1=new HospitalDao();
        			hospitaldao1.removeHospital(1);
        			System.out.println("data revomed(or) deleted successfully...");
        		}
        		else if(number==3)
        		{
        			HospitalDao hospitaldao2=new HospitalDao();
        		    hospitaldao2.updateHospitalName(2,"suoreddy");
        		    System.out.println("data is updated successfully...");
        		}
        		else if(number==4)
        		{
        			HospitalDao hospitadao3=new HospitalDao();
        			hospitadao3.viewHospitalByName("Government hospital");
        			System.out.println("data view(or)displayed successfully...");
        		}
        		else
        		{
        			System.out.println("Invalid...");
        		}
        	}
        	case 2:
        	{
        		System.out.println("which one you want select");
        		System.out.println("1.insert");
        		System.out.println("2.delete");
        		System.out.println("3.update");
        		System.out.println("4.display");
        		int number=sc.nextInt();
        		if(number==1)
        		{
        		  DoctorDao doctorDao=new DoctorDao();
        		  Doctor doctor1=new Doctor();
        		
        		  doctor1.setDoc_id(1);
        		  doctor1.setdName("Radhika");
        		  doctor1.setQualification("MBBS");
        		  doctor1.setSalary(200000.00);
        		  
        		  Doctor doctor2=new Doctor();
          		
        		  doctor2.setDoc_id(2);
        		  doctor2.setdName("Supriya");
        		  doctor2.setQualification("MBBs");
        		  doctor2.setSalary(300000.00);
        		  
        		  Doctor doctor3=new Doctor();
          		
        		  doctor3.setDoc_id(3);
        		  doctor3.setdName("hari priya");
        		  doctor3.setQualification("MBBS");
        		  doctor3.setSalary(2004000);
        		  doctorDao.createDoctor(Option, doctor1);
        		  doctorDao.createDoctor(Option, doctor2);
        		  doctorDao.createDoctor(Option, doctor3);
        		  
        		  System.out.println("data is inserted successfully...");
        		}
        		else if(number==2)
        		{
        			DoctorDao doctordao1=new DoctorDao();
        			doctordao1.removeDoctor(1);
        			System.out.println("data is remove (or) deleted successfully...");
        		}
        		else if(number==3)
        		{
        			DoctorDao doctordao2=new DoctorDao();
        			doctordao2.updateDoctorSalary(4000000);
        			System.out.println("data is updated successfully...");
        		}
        		else if(number==4)
        		{
        			DoctorDao doctordao3=new DoctorDao();
        			doctordao3.viewDoctorByName("supriya");
        			System.out.println("data view(or) displayed successfully...");
        		}
        		else
        		{
        			System.out.println("Invalid....");
        		}
        	}
        	case 3:
        	{
        		System.out.println("which one you want select");
        		System.out.println("1.insert");
        		System.out.println("2.delete");
        		System.out.println("3.display based on Name");
        		System.out.println("4.display");
        		int number=sc.nextInt();
        		if(number==1)
        		{
        			PatientDao patientdao1= new PatientDao();
        			Patient patient1=new Patient();
        			
        			patient1.setP_id(1);
        			patient1.setpName("Ranga");
        			patient1.setDiagnosis("Eye Problem");
        			patient1.setAddress("Tuvvapalle");
        			
        			Patient patient2=new Patient();

        			patient2.setP_id(2);
        			patient2.setpName("Rani");
        			patient2.setDiagnosis("Sugar");
        			patient2.setAddress("hebbal");
        			
        			Patient patient3=new Patient();

        			patient3.setP_id(3);
        			patient3.setpName("Raj");
        			patient3.setDiagnosis("fever");
        			patient3.setAddress("delhi");
        			
        			patientdao1.createPatient(Option, patient1);
        			patientdao1.createPatient(Option, patient2);
        			patientdao1.createPatient(Option, patient3);
        			
        			System.out.println("Data inserted successfully....");
        
        		}
        		else if(number==2)
        		{
        			PatientDao patientdao2= new PatientDao();
        			patientdao2.removePatient(2);
        			System.out.println("data remove (or) deleted Successfully....");
        		}
        		else if(number==3)
        		{
        			PatientDao patientdao3= new PatientDao();
        			patientdao3.viewPatientByName("Raj");
        			System.out.println("data is displayed based on name successfully...");
        		}
        		else if(number==3)
        		{
        			PatientDao patientdao4= new PatientDao();
        			patientdao4.viewallPatient();
        			System.out.println("data is displayed..");
        		}
        	}
        	case 4:
        	{
        		System.out.println("which one you want select");
        		System.out.println("1.insert");
        		System.out.println("2.delete");
        		System.out.println("3.update");
        		System.out.println("4.display");
        		int number=sc.nextInt();
        		if(number==1)
        		{
        			MedicalRecordDao medicaldao1=new MedicalRecordDao();
        		    MedicalRecord medical1=new MedicalRecord();
        		    medical1.setRecord_id(1);
        		    medical1.setProblem("fever");
        		    medical1.setDate_of_examination("12/04/2023");
        		   
        		    MedicalRecord medical2=new MedicalRecord();
        		    medical2.setRecord_id(2);
        		    medical2.setProblem("stamack pain");
        		    medical2.setDate_of_examination("19/08/2015");
        		   
        		    MedicalRecord medical3=new MedicalRecord();
        		    medical1.setRecord_id(3);
        		    medical1.setProblem("hand pain");
        		    medical1.setDate_of_examination("25/05/2024");
        		    medicaldao1.createmedicalRecord(medical1);
        		    medicaldao1.createmedicalRecord(medical2);
        		    medicaldao1.createmedicalRecord(medical3);
        		    
        		 System.out.println("data inserted successfully...");
        		}
        		else if(number==2)
        		{
        			MedicalRecordDao medicaldao2=new MedicalRecordDao();
        			medicaldao2.removesmedicalrecordid(1);
        			System.out.println("data remove (or) deleted successfully...");
        			
        		}
        		else if(number==3)
        		{
        			MedicalRecordDao medicaldao3=new MedicalRecordDao();
        			medicaldao3.updatemedicalrecord(1, "23/05/2024");
        			System.out.println("data is upsdated successfully...");
        		}
        		else if(number==4)
        		{
        			MedicalRecordDao medicaldao4=new MedicalRecordDao();
        			medicaldao4.dispaymedicalRecord(1);
        			System.out.println("data is displayed successfully...");
        		}
        	}
        }
	}

}
