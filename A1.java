/*
 * Name:Haonan Liu
 * Student ID:24516785
 */
public class A1 {
    public static void main(String[] args) {
        System.out.println("Hello, this is my A1!");
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

