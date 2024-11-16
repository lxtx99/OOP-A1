/*
 * Name:Haonan Liu
 * Student ID:24516785
 */
public class A1 {
    public static void main(String[] args) {
        // Part 3 – Using classes and objects 

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

    // 打印预约信息的方法
    public void printAppointmentInfo() {
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Phone: " + patientPhone);
        System.out.println("Preferred Time: " + preferredTime);
        System.out.println("Doctor Information:");
        if (doctor != null) {
            doctor.printHealthProfessionalInfo();  // 打印医生的信息
        } else {
            System.out.println("No doctor selected.");
        }
    }
}