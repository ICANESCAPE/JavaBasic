package reflect.package1;

import java.util.HashMap;

abstract class AbstractStudent{
    @Override
    public abstract String toString();
}

public class Student extends AbstractStudent implements Comparable{

    // 实例变量
    String name;
    int age;

    // 静态变量
    public static HashMap<String,Student> studentFactory;

    static {
        studentFactory = new HashMap<String, Student>();
    }

    /**
     * 构造函数: 无参数
     */
    public Student(){}

    /**
     * 带参数构造函数
     * @param name
     * @param age
     */
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }


    /**
     * 重写父类函数
     * @return
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int compareTo(Object o) {
        return 0;
    }

    // 普通方法
    public Student newStudent(String name, int age){
        if(studentFactory.get(name) != null) { return studentFactory.get(name);}
        Student s = new Student(name, age);
        studentFactory.put(name, s);
        return s;
    }

    public static Student searchStudent(String name){
        return studentFactory.get(name);
    }


}

