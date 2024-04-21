package driver;

import validation.ValidationUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import entity.Doctor;
import entity.Patient;
import operation.Appointment;
import operation.Hospital;
import java.util.Date;
//import java.sql.Date;

public class HospitalManagementSystem {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        Hospital hospital = new Hospital();
        
        Date appointmentDateUtil = new Date();
        java.sql.Date appointmentDateSql = new java.sql.Date(appointmentDateUtil.getTime());


        // Add 5 doctors
        hospital.addDoctor(new Doctor("D001", "Dr. Smith", "Cardiology", "1234567890"));
        hospital.addDoctor(new Doctor("D002", "Dr. Johnson", "Neurology", "9876543210"));
        hospital.addDoctor(new Doctor("D003", "Dr. Williams", "Orthopedics", "8765432109"));
        hospital.addDoctor(new Doctor("D004", "Dr. Brown", "Pediatrics", "2345678901"));
        hospital.addDoctor(new Doctor("D005", "Dr. Davis", "Dermatology", "3456789012"));

        // Add 5 patients
        hospital.addPatient(new Patient("P001", "Alice", 30, "Female", "1112223334"));
        hospital.addPatient(new Patient("P002", "Bob", 45, "Male", "2223334445"));
        hospital.addPatient(new Patient("P003", "Charlie", 25, "Male", "3334445556"));
        hospital.addPatient(new Patient("P004", "Diana", 50, "Female", "4445556667"));
        hospital.addPatient(new Patient("P005", "Eve", 35, "Female", "5556667778"));

        int choice;
        do {
            // Display menu
            System.out.println("\nHospital Management System Menu:");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Display All Patients");
            System.out.println("4. Display All Doctors");
            System.out.println("5. Schedule Appointment");
            System.out.println("6. View Appointments by Patient");
            System.out.println("7. View Appointments by Doctor");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            // Read user choice
            choice = scanner.nextInt();

            // Process user choice
            switch (choice) {
                case 1:
                    addPatient(scanner, hospital);
                    break;
                case 2:
                    addDoctor(scanner, hospital);
                    break;
                case 3:
                    hospital.displayAllPatients();
                    break;
                case 4:
                    hospital.displayAllDoctors();
                    break;
                case 5:
                    scheduleAppointment(scanner, hospital);
                    break;
                case 6:
                    viewAppointmentsByPatient(scanner, hospital);
                    break;
                case 7:
                    viewAppointmentsByDoctor(scanner, hospital);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        } while (choice != 8);

        // Close scanner
        scanner.close();
    }

    private static void addPatient(Scanner scanner, Hospital hospital) {
        // Prompt user to add patients
        System.out.println("Enter patient details (ID, Name, Age, Gender, Contact Number):");
        String patientId = scanner.next();
        // Validate patient ID
        if (!ValidationUtils.isValidPatientId(patientId, hospital.getPatients())) {
            System.out.println("Invalid patient ID. Please enter a unique 4-character alphanumeric ID.");
            return;
        }
        String patientName = scanner.next();
        int age = scanner.nextInt();
        String gender = scanner.next();
        String contactNumber = scanner.next();
        Patient patient = new Patient(patientId, patientName, age, gender, contactNumber);
        hospital.addPatient(patient);
        System.out.println("Patient added successfully.");
    }

    private static void addDoctor(Scanner scanner, Hospital hospital) {
        // Prompt user to add doctors
        System.out.println("Enter doctor details (ID, Name, Specialization, Contact Number):");
        String doctorId = scanner.next();
        // Validate doctor ID
        if (!ValidationUtils.isValidDoctorId(doctorId, hospital.getDoctors())) {
            System.out.println("Invalid doctor ID. Please enter a unique 4-character alphanumeric ID.");
            return;
        }
        String doctorName = scanner.next();
        String specialization = scanner.next();
        String doctorContactNumber = scanner.next();
        Doctor doctor = new Doctor(doctorId, doctorName, specialization, doctorContactNumber);
        hospital.addDoctor(doctor);
        System.out.println("Doctor added successfully.");
    }

    private static void scheduleAppointment(Scanner scanner, Hospital hospital) throws ParseException {
        // Prompt user to schedule appointments
        System.out.println("Schedule an appointment :");
        System.out.println("Enter Patient Id");
        String patientId = scanner.next();
        System.out.println("Enter Doctors Id of which you want to fix appointment");
        String doctorId = scanner.next();
        System.out.println("Enter Date of appointment in yyyy-MM-dd format");
      
        String appointmentDateString = scanner.next();
        java.util.Date appointmentDateUtil = new SimpleDateFormat("yyyy-MM-dd").parse(appointmentDateString);
        java.sql.Date appointmentDateSql = new java.sql.Date(appointmentDateUtil.getTime());
        // Validate appointment date
        if (!ValidationUtils.isValidAppointmentDate(appointmentDateString)) {
            System.out.println("Invalid appointment date format. Please enter the date in YYYY-MM-DD format.");
            return;
        }
        Date appointmentDate;
        try {
            appointmentDate = new SimpleDateFormat("yyyy-MM-dd").parse(appointmentDateString);
        } catch (ParseException e) {
            System.out.println("Invalid appointment date format.");
            return;
        }
        // Check doctor's availability and book appointment
        if (hospital.scheduleAppointment(patientId, doctorId, appointmentDateSql)) {
            System.out.println("Appointment scheduled successfully.");
        } else {
            System.out.println("Failed to schedule appointment. Please check doctor availability.");
        }
    }

    private static void viewAppointmentsByPatient(Scanner scanner, Hospital hospital) {
        System.out.println("Enter Patient ID:");
        String patientId = scanner.next();
        ArrayList<Appointment> appointments = hospital.getAppointmentsByPatient(patientId);
        if (appointments.isEmpty()) {
            System.out.println("No appointments found for patient ID: " + patientId);
        } else {
            System.out.println("Appointments for patient ID " + patientId + ":");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }

    private static void viewAppointmentsByDoctor(Scanner scanner, Hospital hospital) {
        System.out.println("Enter Doctor ID:");
        String doctorId = scanner.next();
        ArrayList<Appointment> appointments = hospital.getAppointmentsByDoctor(doctorId);
        if (appointments.isEmpty()) {
            System.out.println("No appointments found for doctor ID: " + doctorId);
        } else {
            System.out.println("Appointments for doctor ID " + doctorId + ":");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }
    
    
}
