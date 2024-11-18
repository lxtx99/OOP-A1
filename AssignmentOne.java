/*
 * Name:Haonan Liu
 * Student ID:24516785
 */

import java.util.ArrayList;

public class AssignmentOne {
    public static void main(String[] args) {
        // Part 3 – Using classes and objects 
        System.out.println("------------------------------");
        // Create the first general practitioner object
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr.Liu", "General Practitioner", "Outpatient Doctor");
        System.out.println("------------------------------");
        gp1.printHealthProfessionalInfo();

        // Create the second general practitioner object
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr.Lin", "General Practitioner", "Family Doctor");
        System.out.println("------------------------------");
        gp2.printHealthProfessionalInfo();

        // Create the third general practitioner object
        GeneralPractitioner gp3 = new GeneralPractitioner(103, "Dr.Jack", "General Practitioner", "Surgeon");
        System.out.println("------------------------------");
        gp3.printHealthProfessionalInfo();

        // Create the first other type of health professional object
        Other other1 = new Other(201, "Dr.Zhang", "Other", "Nurse");
        System.out.println("------------------------------");
        other1.printHealthProfessionalInfo();

        // Create the second other type of health professional object
        Other other2 = new Other(202, "Dr.Han", "Other", "Nutritionist");
        System.out.println("------------------------------");
        other2.printHealthProfessionalInfo();

        // Part 5 – Collection of appointments
        System.out.println("------------------------------");

        // Declare an ArrayList to store appointments
        ArrayList<Appointment> appointments = new ArrayList<>();
        
        // Create appointments and add them to the list
        createAppointment(appointments, "Haonan Liu", "1022004", "08:00", gp1);
        createAppointment(appointments, "Shijie Zhang", "1355006", "10:00", gp2);
        createAppointment(appointments, "Shaoqian Mu", "1677826", "11:00", other1);
        createAppointment(appointments, "Thomas", "1022334", "", other2);

        printExistingAppointments(appointments);
        cancelBooking(appointments, "1022334");

        // Print all existing appointments again to show the updated list
        printExistingAppointments(appointments);
    }

    // Method to create a new appointment and add it to the ArrayList
    static void createAppointment(ArrayList<Appointment> appointments, String patientName, String patientPhone, String preferredTime, HealthProfessional doctor) {
        if (patientName == null || patientPhone == null || preferredTime == null || doctor == null) {
            System.out.println("Error: Missing information, unable to create appointment.");
        } else {
            Appointment newAppointment = new Appointment(patientName, patientPhone, preferredTime, doctor);
            appointments.add(newAppointment);
            System.out.println("Appointment created successfully for " + patientName + " with " + doctor.getName() + " at " + preferredTime);
        }
    }
    // Method to print all existing appointments
    static void printExistingAppointments(ArrayList<Appointment> appointments) {
        if (appointments.isEmpty()) {
            System.out.println("No existing appointments.");
        } else {
            for (Appointment appointment : appointments) {
                appointment.printAppointmentDetails();
            }
        }
    }
    // Method to cancel an appointment based on patient's phone number
    static void cancelBooking(ArrayList<Appointment> appointments, String patientPhone) {
        boolean found = false;
        for (Appointment appointment : appointments) {
            if (appointment.getPatientPhone().equals(patientPhone)) {
                appointments.remove(appointment);
                System.out.println("Appointment for patient " + appointment.getPatientName() + " has been cancelled.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Error: No appointment found for phone number " + patientPhone);
        }
    }
}
class HealthProfessional {
    private int ID;             
    private String name;        
    private String doctorType;  

    // Default constructor
    public HealthProfessional() {
        this.ID = 0;
        this.name = "Unknown";
        this.doctorType = "General";
    }

    // The second constructor initializes all instance variables
    public HealthProfessional(int ID, String name, String doctorType) {
        this.ID = ID;
        this.name = name;
        this.doctorType = doctorType;
    }

    // A method to print all instance variables
    public void printHealthProfessionalInfo() {
        System.out.println("Health Professional Details:");
        System.out.println("Doctor ID: " + ID);
        System.out.println("Doctor Name: " + name);
        System.out.println("Doctor Type: " + doctorType);

    }
    public String getName() {
        return name;
    }
}

class GeneralPractitioner extends HealthProfessional {
    private String BusinessScope; 
    
    // Default constructor
    public GeneralPractitioner() {
        super();
        this.BusinessScope = "General Medicine";
    }

    public GeneralPractitioner(int ID, String name, String doctorType, String BusinessScope) {
        super(ID, name, doctorType);
        this.BusinessScope = BusinessScope;
    }

    // Methods for printing details of health professionals
    @Override
    public void printHealthProfessionalInfo() {
        super.printHealthProfessionalInfo();  
        System.out.println("Business Scope: " + BusinessScope);
    }
}
class Other extends HealthProfessional {
    private String profession; 

    // Default constructor
    public Other() {
        super();  
        this.profession = "Unknown Profession";  
    }

    public Other(int ID, String name, String doctorType, String profession) {
        super(ID, name, doctorType); 
        this.profession = profession;
    }

    // Methods for printing details of health professionals
    @Override
    public void printHealthProfessionalInfo() {
        super.printHealthProfessionalInfo();  
        System.out.println("Profession: " + profession);  
    }
}

class Appointment {
    private String patientName;       
    private String patientPhone;      
    private String preferredTime;     
    private HealthProfessional doctor; 

    // Default constructor
    public Appointment() {
        this.patientName = "Unknown";
        this.patientPhone = "Unknown";
        this.preferredTime = "08:00"; 
        this.doctor = null;           
    }

    public Appointment(String patientName, String patientPhone, String preferredTime, HealthProfessional doctor) {
        this.patientName = patientName;
        this.patientPhone = patientPhone;
        this.preferredTime = preferredTime;
        this.doctor = doctor;
    }
    public String getPatientName() {
        return patientName;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    // Method to print the appointment details
    public void printAppointmentDetails() {
        System.out.println("Patient Name: " + patientName);
        System.out.println("Phone: " + patientPhone);
        System.out.println("Preferred Time: " + preferredTime);
        System.out.println("Doctor Name: " + doctor.getName());
        System.out.println("------------------------------");
    }
}