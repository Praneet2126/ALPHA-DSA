package OOPS;

public class Constructors {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "abcd";
        s1.roll = 251;
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;

        Student s2 = new Student(s1);
        s2.password = "xyz";

        s1.marks[0] = 90; 
        for(int i=0; i<3; i++) {
            System.out.println(s2.marks[i]);
        }
    }
}

// constructors
class Student {
    String name;
    int roll;
    String password;
    int marks[];

    // shallow copy ctor 
    Student(Student s1) {
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;
        this.marks = s1.marks;     // only reference is passed here.
    }

    // deep copy
    // Student(Student s1) {
    //     marks = new int[3];
    //     this.name = s1.name;
    //     this.roll = s1.roll;
    //     for(int i=0; i<marks.length; i++) {
    //         this.marks[i] = s1.marks[i];
    //     }
    // }


    // non param ctor
    Student() {
        System.out.println("Ctor is called");
        marks = new int[3];
    }

    // param ctor
    Student(String name) {
        this.name = name;
        marks = new int[3];
    }
}