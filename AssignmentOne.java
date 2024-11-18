/*
 * Name:Haonan Liu
 * Student ID:24516785
 */

import java.util.ArrayList;

public class AssignmentOne {
    public static void main(String[] args) {
        // Part 3 – Using classes and objects 
        System.out.println("------------------------------");

        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr.Liu", "General Practitioner", "Outpatient Doctor");
        System.out.println("------------------------------");
        gp1.printHealthProfessionalInfo();

        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr.Lin", "General Practitioner", "Family Doctor");
        System.out.println("------------------------------");
        gp2.printHealthProfessionalInfo();

        GeneralPractitioner gp3 = new GeneralPractitioner(103, "Dr.Jack", "General Practitioner", "Surgeon");
        System.out.println("------------------------------");
        gp3.printHealthProfessionalInfo();

        Other other1 = new Other(201, "Dr.Zhang", "Other", "Nurse");
        System.out.println("------------------------------");
        other1.printHealthProfessionalInfo();

        Other other2 = new Other(202, "Dr.Han", "Other", "Nutritionist");
        System.out.println("------------------------------");
        other2.printHealthProfessionalInfo();

        // Part 5 – Collection of appointments
        System.out.println("------------------------------");

        ArrayList<Appointment> appointments = new ArrayList<>();

        createAppointment(appointments, "Haonan Liu", "1022004", "08:00", gp1);
        createAppointment(appointments, "Shijie Zhang", "1355006", "10:00", gp2);
        createAppointment(appointments, "Shaoqian Mu", "1677826", "11:00", other1);
        createAppointment(appointments, "Thomas", "1022334", "14:30", other2);

        printExistingAppointments(appointments);

        cancelBooking(appointments, "1022334");

        printExistingAppointments(appointments);
    }

    static void createAppointment(ArrayList<Appointment> appointments, String patientName, String patientPhone, String preferredTime, HealthProfessional doctor) {
        if (patientName == null || patientPhone == null || preferredTime == null || doctor == null) {
            System.out.println("Error: Missing information, unable to create appointment.");
        } else {
            Appointment newAppointment = new Appointment(patientName, patientPhone, preferredTime, doctor);
            appointments.add(newAppointment);
            System.out.println("Appointment created successfully for " + patientName + " with " + doctor.getName() + " at " + preferredTime);
        }
    }

    static void printExistingAppointments(ArrayList<Appointment> appointments) {
        if (appointments.isEmpty()) {
            System.out.println("No existing appointments.");
        } else {
            for (Appointment appointment : appointments) {
                appointment.printAppointmentDetails();
            }
        }
    }

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


    public HealthProfessional() {

        this.ID = 0;
        this.name = "Unknown";
        this.doctorType = "General";
    }


    public HealthProfessional(int ID, String name, String doctorType) {
        this.ID = ID;
        this.name = name;
        this.doctorType = doctorType;
    }


    public void printHealthProfessionalInfo() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Doctor Type: " + doctorType);
        System.out.println("Health Professional Details:");
    }
    public String getName() {
        return name;
    }
}

class GeneralPractitioner extends HealthProfessional {
    private String BusinessScope;  

    
    public GeneralPractitioner() {
        super();  
        this.BusinessScope = "General Medicine";
    }


    public GeneralPractitioner(int ID, String name, String doctorType, String BusinessScope) {
        super(ID, name, doctorType);  
        this.BusinessScope = BusinessScope;
    }


    @Override
    public void printHealthProfessionalInfo() {
        super.printHealthProfessionalInfo();  
        System.out.println("BusinessScope: " + BusinessScope);
    }
}
class Other extends HealthProfessional {
    private String specialty; 


    public Other() {
        super();  
        this.specialty = "Unknown Specialty";  
    }


    public Other(int ID, String name, String doctorType, String specialty) {
        super(ID, name, doctorType);  
        this.specialty = specialty;
    }

  
    @Override
    public void printHealthProfessionalInfo() {
        super.printHealthProfessionalInfo(); 
        System.out.println("Specialty: " + specialty);  
    }
}
class Appointment {

    private String patientName;       
    private String patientPhone;      
    private String preferredTime;     
    private HealthProfessional doctor; 


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

    public void printAppointmentDetails() {
        System.out.println("Patient Name: " + patientName);
        System.out.println("Phone: " + patientPhone);
        System.out.println("Preferred Time: " + preferredTime);
        System.out.println("Doctor: " + doctor.getName());
        System.out.println("------------------------------");
    }
}