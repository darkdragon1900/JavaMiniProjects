package entity;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentRecord {
	
	 	private String patientId;
	    private String doctorId;
	    private String appointmentId;
	    private Date appointmentDate;
	
	    public AppointmentRecord(String patientId, String doctorId, String appointmentId, Date appointmentDate) {
			super();
			this.patientId = patientId;
			this.doctorId = doctorId;
			this.appointmentId = appointmentId;
			this.appointmentDate = appointmentDate;
		}

		public String getPatientId() {
			return patientId;
		}

		public void setPatientId(String patientId) {
			this.patientId = patientId;
		}

		public String getDoctorId() {
			return doctorId;
		}

		public void setDoctorId(String doctorId) {
			this.doctorId = doctorId;
		}

		public String getAppointmentId() {
			return appointmentId;
		}

		public void setAppointmentId(String appointmentId) {
			this.appointmentId = appointmentId;
		}

		public Date getAppointmentDate() {
			return appointmentDate;
		}

		public void setAppointmentDate(Date appointmentDate) {
			this.appointmentDate = appointmentDate;
		}
	    
	    
	  
}
