package com.jsp.controller;

import java.util.Scanner;

import com.jsp.DAO.CreateDoctor;
import com.jsp.DAO.CreatePatient;
import com.jsp.DAO.Create_Hospital;
import com.jsp.DAO.MedicalRecord;
import com.jspDTO.Doctor;
import com.jspDTO.Hospital;
import com.jspDTO.Medical_record;
import com.jspDTO.Patient;


public class main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean flag=false;
		Create_Hospital hos = new Create_Hospital();
		CreateDoctor doc = new CreateDoctor();
		CreatePatient pat = new CreatePatient();
		MedicalRecord med = new MedicalRecord();
		
		Hospital hospital;
		Doctor doctor;
		Patient patient;
		Medical_record Record;
		
		String date_of_examination = sc.next(); 
		String newName = sc.next();
		String h_name = sc.next();
		String d_name = sc.next();
		String p_name = sc.next();
		double salary = sc.nextDouble();
		int h_id = sc.nextInt();
		int d_id = sc.nextInt();
		int p_id = sc.nextInt();
		int m_id = sc.nextInt();
		
		
		for( ; !flag; )
		{
			System.out.println("1.Add Hospital");
			System.out.println("2.Add Doctor");
			System.out.println("3.Add Patient");
			System.out.println("4.Add Medical Record");
			System.out.println("5.Exit");
			int choose = sc.nextInt();
			
			switch(choose)
			{
				case 1:
				{
					System.out.println("1.Create Hospital");
					System.out.println("2.Update Hospital Name");
					System.out.println("3.Remove Hospital");
					System.out.println("4.Display Hospital based on Name");
					System.out.println("5.Display Hospital");
					System.out.println("6.Exit");
					int ch1 = sc.nextInt();
					
					switch(ch1)
					{
					case 1:
					{
						hos.CreateHospital(hospital);
						int c = sc.nextInt();
						System.out.println("1.Create Doctor");
						System.out.println("2.Exit");
						switch(c)
						{
						case 1:
						{
							if(hospital !=null)
							{
								doc.createDoctor(h_id, doctor);
							}
							else {
								System.out.println("Hospital not exist");
							}
							int c3 = sc.nextInt();
							System.out.println("1.Book Appointment");
							System.out.println("2.Exit");
							switch(c3)
							{
							case 1:
							{
								if(doctor != null)
								{
									pat.addPatient(h_id, patient);
								}
								else
								{
									System.out.println("Doctor not available");
								}
								break;
							}
							case 2:
							{
								flag =true;
								break;
							}
							default:
							{
								System.out.println("choose correct option");
							}
							}
						}
						case 2:
						{
							flag =true;
							break;
						}
						default:
						{
							System.out.println("choose correct option");
						}
						}
						
						break;
					}
					case 2:
					{
						hos.updateHospitalName(h_id, newName);
						break;
					}
					case 3:
					{
						hos.removeHospital(h_id);
						break;
					}
					case 4:
					{
						hos.display_HospitalName(h_name);
						break;
					}
					case 5:
					{
						hos.display_Hospital();
						break;
					}
					case 6 :
					{
						flag= true;
						break;
					}
					default :
					{
						System.out.println("Choose correct option");
					}
					}
				}
				case 2:
				{
					System.out.println("1.Create Doctor");
					System.out.println("2.Update Salary based on id");
					System.out.println("3.Remove Doctor");
					System.out.println("4.Display Doctor based on name");
					System.out.println("5.Display Doctor based on hospital name");
					System.out.println("6.Exit");
					
					int ch1 = sc.nextInt();
					
					switch(ch1)
					{
					case 1:
					{
						doc.createDoctor(h_id, doctor);
						int c1 = sc.nextInt();
						System.out.println("1.Book Appointment");
						System.out.println("2.Exit");
						switch(c1)
						{
						case 1:
						{
							if(doctor != null)
							{
								pat.addPatient(h_id, patient);
							}
							else
							{
								System.out.println("Doctor not available");
							}
							break;
						}
						case 2:
						{
							flag =true;
							break;
						}
						default:
						{
							System.out.println("choose correct option");
						}
						}
						break;
					}
					case 2:
					{
						doc.updateSalary_id(salary, d_id);
						break;
					}
					case 3:
					{
						doc.removeDoctor(d_name);
						break;
					}
					case 4:
					{
						doc.display_DoctorName(d_name);
						break;
					}
					case 5:
					{
						doc.Specific_HospitalDoctor(h_name);
						break;
					}
					case 6:
					{
						flag = true;
					}
					default :
					{
						System.out.println("Choose correct option");
					}
					System.out.println("Thank you");
					}
				}
				case 3:
				{
					System.out.println("1.Add Patient");
					System.out.println("2.Remove Patient based on id");
					System.out.println("3.Display patient based on name");
					System.out.println("4.Display patient");
					System.out.println("5.Exit");
					
					int c2 = sc.nextInt();
					
					switch(c2) {
						case 1:
						{
							pat.addPatient(h_id, patient);
							break;
						}
						case 2:
						{
							pat.removePatient_id(p_id);
							break;
						}
						case 3:
						{
							pat.displayPatient_name(p_name);
							break;
						}
						case 4:
						{
							pat.DiplayPatient();
							break;
						}
						case 5:
						{
							flag = true;
							break;
						}
						default :
						{
							System.out.println("Choose correct option");
						}
						
					}
				}
				case 4:
				{
					System.out.println("1.Add Medical Record");
					System.out.println("2.update date of examination");
					System.out.println("3.Remove Record");
					System.out.println("4.patient Record");
					System.out.println("5.Exit");
					int c2 = sc.nextInt();
					switch(c2) 
					{
						case 1:
						{
							med.addRecord(p_id, Record);
							break;
						}
						case 2:
						{
							med.updateDateOfExamination(date_of_examination, m_id);
							break;
						}
						case 3:
						{
							med.removeRecord(m_id);
							break;
						}
						case 4:
						{
							med.patientRecord(p_name);
							break;
						}
						case 5:
						{
							flag = true;
							break;
						}
						default :
						{
							System.out.println("Choose correct option");
						}
					}
				}
				case 5:
				{
					flag= true;
					break;
				}
				default :
				{
					System.out.println("choose correct option");
				}
			}
		}
		System.out.println("thank you");
	}
}

