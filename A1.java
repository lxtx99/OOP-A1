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
    }
}