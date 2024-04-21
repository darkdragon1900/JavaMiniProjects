package operation;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entity.Doctor;
import entity.Patient;

public class Hospital {
	 private HashMap<String, Patient> patients;
	    private HashMap<String, Doctor> doctors;
	    private ArrayList<Appointment> appointments; 

	    public Hospital() {
	        this.patients = new HashMap<>();
	        this.doctors = new HashMap<>();
	        this.appointments = new ArrayList<>();
	    }

	    public void addAppointment(Appointment appointment) {
	        appointments.add(appointment);
	    }

	    public void addPatient(Patient patient) {
	        patients.put(patient.getPatientId(), patient);
	    }

	    public void removePatient(String patientId) {
	        patients.remove(patientId);
	    }

	    public void updatePatient(String patientId, Patient updatedPatient) {
	        patients.put(patientId, updatedPatient);
	    }

	    public void addDoctor(Doctor doctor) {
	        doctors.put(doctor.getDoctorId(), doctor);
	    }

	    public void removeDoctor(String doctorId) {
	        doctors.remove(doctorId);
	    }

	    public void updateDoctor(String doctorId, Doctor updatedDoctor) {
	        doctors.put(doctorId, updatedDoctor);
	    }

	    public ArrayList<Doctor> searchDoctorBySpecialization(String specialization) {
	        ArrayList<Doctor> result = new ArrayList<>();
	        for (Map.Entry<String, Doctor> entry : doctors.entrySet()) {
	            Doctor doctor = entry.getValue();
	            if (doctor.getSpecialization().equalsIgnoreCase(specialization)) {
	                result.add(doctor);
	            }
	        }
	        return result;
	    }

	    public void displayAllPatients() {
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

	    public void displayAllDoctors() {
	        for (Map.Entry<String, Doctor> entry : doctors.entrySet()) {
	            Doctor doctor = entry.getValue();
	            System.out.println("Doctor ID: " + doctor.getDoctorId());
	            System.out.println("Doctor Name: " + doctor.getDoctorName());
	            System.out.println("Specialization: " + doctor.getSpecialization());
	            System.out.println("Contact Number: " + doctor.getContactNumber());
	            System.out.println();
	        }
	    }
	    
	 

	    public ArrayList<Appointment> getAppointmentsByPatient(String patientId) {
	        ArrayList<Appointment> appointmentsByPatient = new ArrayList<>();
	        for (Appointment appointment : appointments) {
	            if (appointment.getPatientId().equals(patientId)) {
	                appointmentsByPatient.add(appointment);
	            }
	        }
	        return appointmentsByPatient;
	    }
	    
	    public boolean scheduleAppointment(String patientId, String doctorId, Date appointmentDate) {
	        
	        Appointment appointment = new Appointment(patientId, doctorId, appointmentDate);
	        appointments.add(appointment);
	        return true; // Return true if appointment is successfully scheduled
	    }
	    
	    public HashMap<String, Patient> getPatients() {
	        return patients;
	    }

	    public HashMap<String, Doctor> getDoctors() {
	        return doctors;
	    }
	    
	    public ArrayList<Appointment> getAppointmentsByDoctor(String doctorId) {
	        ArrayList<Appointment> appointmentsByDoctor = new ArrayList<>();
	        for (Appointment appointment : appointments) {
	            if (appointment.getDoctorId().equals(doctorId)) {
	                appointmentsByDoctor.add(appointment);
	            }
	        }
	        return appointmentsByDoctor;
	    }

}
