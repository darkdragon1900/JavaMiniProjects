package entity;

import java.util.HashMap;
import java.util.Map;

public class Doctor {
	
		private String doctorId;
	    private String doctorName;
	    private String specialization;
	    private String contactNumber;
		
	    public Doctor(String doctorId, String doctorName, String specialization, String contactNumber) {
			super();
			this.doctorId = doctorId;
			this.doctorName = doctorName;
			this.specialization = specialization;
			this.contactNumber = contactNumber;
		}

		public String getDoctorId() {
			return doctorId;
		}

		public void setDoctorId(String doctorId) {
			this.doctorId = doctorId;
		}

		public String getDoctorName() {
			return doctorName;
		}

		public void setDoctorName(String doctorName) {
			this.doctorName = doctorName;
		}

		public String getSpecialization() {
			return specialization;
		}

		public void setSpecialization(String specialization) {
			this.specialization = specialization;
		}

		public String getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
	    
		  public static Doctor getDoctorById(String doctorId , HashMap<String, Doctor> doctors) {
		    	return doctors.get(doctorId);
		    }
		    
		    public static void addDoctor(Doctor doctor, HashMap<String, Doctor> doctors) {
		        doctors.put(doctor.getDoctorId(), doctor);
		    }

		    public static void removeDoctor(String doctorId, HashMap<String, Doctor> doctors) {
		        doctors.remove(doctorId);
		    }

		    public static void updateDoctor(String doctorId, Doctor updatedDoctor, HashMap<String, Doctor> doctors) {
		        doctors.put(doctorId, updatedDoctor);
		    }
		    
		    public static void displayAllDoctors(HashMap<String, Doctor> doctors) {
		        for (Map.Entry<String, Doctor> entry : doctors.entrySet()) {
		            Doctor doctor = entry.getValue();
		            System.out.println("Doctor ID: " + doctor.getDoctorId());
		            System.out.println("Doctor Name: " + doctor.getDoctorName());
		            System.out.println("Specialization: " + doctor.getSpecialization());
		            System.out.println("Contact Number: " + doctor.getContactNumber());
		            System.out.println();
		        }
		    }
  


}
