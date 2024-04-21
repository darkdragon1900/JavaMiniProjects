package operation;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import entity.AppointmentRecord;
import entity.Doctor;
import entity.Patient;

public class Appointment {
	  private String patientId;
	    private String doctorId;
	    private Date appointmentDate;
	    
	    public Appointment(String patientId, String doctorId, Date appointmentDate) {
	        this.patientId = patientId;
	        this.doctorId = doctorId;
	        this.appointmentDate = appointmentDate;
	    }
	
	private ArrayList<AppointmentRecord> appointments;
	
	public Appointment() {
		this.appointments = new ArrayList<>();
	}
	
	public String getDoctorId() {
        return doctorId;
    } 
	
	public String getPatientId() {
        return patientId;
    } 
	
	public void scheduleAppointment(String patientId, String doctorId, Date appointmentDate , HashMap<String , Patient> patients, HashMap<String , Doctor> doctors )
	{
		if(!doctors.containsKey(doctorId)) {
			 System.out.println("Doctor with ID " + doctorId + " does not exist.");
	            return;
		}
		
		if (!patients.containsKey(patientId)) {
            System.out.println("Patient with ID " + patientId + " does not exist.");
            return;
        }

        for (AppointmentRecord appointment : appointments) {
            if (appointment.getDoctorId().equals(doctorId) && appointment.getAppointmentDate().equals(appointmentDate)) {
                System.out.println("Appointment conflict! Doctor is already booked at this time.");
                return;
            }
        }
        
        String appointmentId = UUID.randomUUID().toString();
        AppointmentRecord newAppointment = new AppointmentRecord(patientId, doctorId, appointmentId, appointmentDate);
        appointments.add(newAppointment);
        
        
	}
	
	public void cancelAppointment(String appointmentId) {
        for (Iterator<AppointmentRecord> iterator = appointments.iterator(); iterator.hasNext();) {
            AppointmentRecord appointment = iterator.next();
            if (appointment.getAppointmentId().equals(appointmentId)) {
                iterator.remove();
                return;
            }
        }
        System.out.println("Appointment with ID " + appointmentId + " not found.");
    }

	public ArrayList<AppointmentRecord> displayAppointmentsByDoctor(String doctorId) {
        ArrayList<AppointmentRecord> doctorAppointments = new ArrayList<>();
        for (AppointmentRecord appointment : appointments) {
            if (appointment.getDoctorId().equals(doctorId)) {
                doctorAppointments.add(appointment);
            }
        }
        return doctorAppointments;
    }

	  public ArrayList<AppointmentRecord> displayAppointmentsByPatient(String patientId) {
	        ArrayList<AppointmentRecord> patientAppointments = new ArrayList<>();
	        for (AppointmentRecord appointment : appointments) {
	            if (appointment.getPatientId().equals(patientId)) {
	                patientAppointments.add(appointment);
	            }
	        }
	        return patientAppointments;
	    }

}
