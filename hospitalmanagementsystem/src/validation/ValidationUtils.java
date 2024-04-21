package validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import entity.Doctor;
import entity.Patient;

public class ValidationUtils {
    public static boolean isValidPatientId(String patientId, HashMap<String, Patient> patients) {
        if (patientId.length() != 4 || !patientId.matches("[a-zA-Z0-9]+") || patients.containsKey(patientId)) {
            return false;
        }
        return true;
    }

    public static boolean isValidDoctorId(String doctorId, HashMap<String, Doctor> doctors) {
        if (doctorId.length() != 4 || !doctorId.matches("[a-zA-Z0-9]+") || doctors.containsKey(doctorId)) {
            return false;
        }
        return true;
    }

    public static boolean isValidAppointmentDate(String appointmentDateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            dateFormat.parse(appointmentDateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
