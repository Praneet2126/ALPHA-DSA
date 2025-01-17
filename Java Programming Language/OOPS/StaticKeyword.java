package OOPS;

public class StaticKeyword {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("ABCD");
        System.out.println(s1.getName());

        // s1.schoolName = "PES";

        Student s2 = new Student();
        s2.setName("XYZ");
        System.out.println(s2.getName());
        
        System.out.println(Student.schoolName); // accessing in static way. s2.school name also fine.
    }
}

class Student {
    static int percentage(int math, int phy, int chem) {
        return math+phy+chem / 3;
    }

    String name;
    int roll;
    static String schoolName;

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }
}
