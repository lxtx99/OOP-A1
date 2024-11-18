/*
 * Name:Haonan Liu
 * Student ID:24516785
 */

import java.util.ArrayList;

public class AssignmentOne {
    public static void main(String[] args) {
        // Part 3 – Using classes and objects 
        System.out.println("------------------------------");
        // 创建第一个全科医生对象
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr.Liu", "General Practitioner", "Outpatient Doctor");
        System.out.println("------------------------------");
        gp1.printHealthProfessionalInfo();

        // 创建第二个全科医生对象
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr.Lin", "General Practitioner", "Family Doctor");
        System.out.println("------------------------------");
        gp2.printHealthProfessionalInfo();

        // 创建第三个全科医生对象
        GeneralPractitioner gp3 = new GeneralPractitioner(103, "Dr.Jack", "General Practitioner", "Surgeon");
        System.out.println("------------------------------");
        gp3.printHealthProfessionalInfo();

        // 创建第一个其他类型的卫生专业人员对象
        Other other1 = new Other(201, "Dr.Zhang", "Other", "Nurse");
        System.out.println("------------------------------");
        other1.printHealthProfessionalInfo();

        // 创建第二个其他类型的卫生专业人员对象
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
        createAppointment(appointments, "Thomas", "1022334", "09:00", other2);

        // Print all existing appointments
        printExistingAppointments(appointments);

        // Cancel an appointment
        cancelBooking(appointments, "1022334");

        // Print all existing appointments again to show the updated list
        printExistingAppointments(appointments);
    }
    // Method to create a new appointment and add it to the ArrayList
    public static void createAppointment(ArrayList<Appointment> appointments, String patientName, String patientPhone, String preferredTime, HealthProfessional doctor) {
        if (patientName == null || patientPhone == null || preferredTime == null || doctor == null) {
            System.out.println("Error: Missing information, unable to create appointment.");
        } else {
            Appointment newAppointment = new Appointment(patientName, patientPhone, preferredTime, doctor);
            appointments.add(newAppointment);
            System.out.println("Appointment created successfully for " + patientName + " with " + doctor.getName() + " at " + preferredTime);
        }
    }
    // Method to print all existing appointments
    public static void printExistingAppointments(ArrayList<Appointment> appointments) {
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
    // 实例变量
    private int ID;             // 医生的ID（仅数字）
    private String name;        // 医生的姓名
    private String doctorType;  // 医生的类型（例如：内科医生、外科医生等）

    // 默认构造函数
    public HealthProfessional() {
        // 初始化实例变量为默认值
        this.ID = 0;
        this.name = "Unknown";
        this.doctorType = "General";
    }

    // 第二个构造函数，初始化所有实例变量
    public HealthProfessional(int ID, String name, String doctorType) {
        this.ID = ID;
        this.name = name;
        this.doctorType = doctorType;
    }

    // 打印所有实例变量的方法
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
    private String BusinessScope;  // 新增的实例变量，用于区分全科医生的服务领域

    // 默认构造函数
    public GeneralPractitioner() {
        super();  // 调用基类默认构造函数
        this.BusinessScope = "General Medicine";
    }

    // 带参数的构造函数
    public GeneralPractitioner(int ID, String name, String doctorType, String BusinessScope) {
        super(ID, name, doctorType);  // 调用基类构造函数
        this.BusinessScope = BusinessScope;
    }

    // 打印卫生专业人员详细信息的方法
    @Override
    public void printHealthProfessionalInfo() {
        super.printHealthProfessionalInfo();  // 调用基类的打印方法
        System.out.println("BusinessScope: " + BusinessScope);
    }
}
class Other extends HealthProfessional {
    private String specialty;  // 修改实例变量名为 specialty

    // 默认构造函数
    public Other() {
        super();  // 调用基类的默认构造函数
        this.specialty = "Unknown Specialty";  // 默认值
    }

    // 带参数的构造函数
    public Other(int ID, String name, String doctorType, String specialty) {
        super(ID, name, doctorType);  // 调用基类的带参数构造函数
        this.specialty = specialty;
    }

    // 打印卫生专业人员详细信息的方法
    @Override
    public void printHealthProfessionalInfo() {
        super.printHealthProfessionalInfo();  // 调用基类的打印方法
        System.out.println("Specialty: " + specialty);  // 打印专家的专业领域
    }
}
class Appointment {
    // 实例变量
    private String patientName;       // 患者姓名
    private String patientPhone;      // 患者手机号
    private String preferredTime;     // 首选时间段
    private HealthProfessional doctor; // 选定的医生

    // 默认构造函数
    public Appointment() {
        this.patientName = "Unknown";
        this.patientPhone = "Unknown";
        this.preferredTime = "08:00"; // 默认时间
        this.doctor = null;           // 默认没有选定医生
    }

    // 带参数的构造函数
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
        System.out.println("Doctor: " + doctor.getName());
        System.out.println("------------------------------");
    }
}