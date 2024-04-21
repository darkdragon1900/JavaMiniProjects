package entity;

import java.util.HashMap;
import java.util.Map;

public class Patient {
	
	private static HashMap<String, Patient> patients = new HashMap<>();
	
		private String patientId;
		private String patientName;
		private int age;
		private String gender;
		private String contactNumber;
	
		public Patient(String patientId, String patientName, int age, String gender, String contactNumber) {
			super();
			this.patientId = patientId;
			this.patientName = patientName;
			this.age = age;
			this.gender = gender;
			this.contactNumber = contactNumber;
		}

		public String getPatientId() {
			return patientId;
		}

		public void setPatientId(String patientId) {
			this.patientId = patientId;
		}

		public String getPatientName() {
			return patientName;
		}

		public void setPatientName(String patientName) {
			this.patientName = patientName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
		
		public static Patient getPatientById(String patientId) {
			return patients.get(patientId);
		}
		
		public static void addPatient(Patient patient) {
			patients.put(patient.getPatientId(), patient);
		}
		
		public static void removePatient(String patientId) {
			patients.remove(patientId);
		}
		
		public static void updatePatient(String patientId, Patient updatedPatient) {
			patients.put(patientId, updatedPatient);
		}
		
		public static void displayAllPatients() {
			
			 for (Map.Entry<String, Patient> entry : patients.entrySet()) {
			        Patient patient = entry.getValue();
			        System.out.println("Patient ID: " + patient.getPatientId());
			        System.out.println("Patient Name: " + patient.getPatientName());
			        System.out.println("Age: " + patient.getAge());
			        System.out.println("Gender: " + patient.getGender());
			        System.out.println("Contact Number: " + patient.getContactNumber());
			        System.out.println();
			    }
		}
		

	

}
