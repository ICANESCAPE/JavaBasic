package reflect;

import reflect.package1.Student;

import java.lang.reflect.Constructor;
import java.util.HashSet;

public class Test {
    public static void main(String [] args) throws Exception{
        // 三种获取类名的方式

        // 方式一
        Student s1 = new Student();
        System.out.println(s1.getClass().getName());

        // 方式二
        Class clazz = Class.forName("reflect.package2.Student");
        System.out.println(clazz.getName());

        // 方式三
        clazz = Student.class;
        System.out.println(clazz.getName());

        // 方式四

        Test t = new Test();
        ClassLoader classLoader = t.getClass().getClassLoader();
        clazz = classLoader.loadClass("reflect.package2.Student");
        System.out.println(clazz.getName());
        System.out.println(t.getClass().getClassLoader().getClass());

        String s = new String();
        // 为什么String 拿不到classloader
        System.out.println(s.getClass().getClassLoader());

        // 测试容器类
        HashSet<String> set = new HashSet<String>();
        System.out.println(set.getClass().getClassLoader());


        // 测试反射
        testStudent();
    }

    public static void testStudent() throws Exception{

        System.out.println("\n\n\n——————————————————————————");
        Student s1 = new Student();
        Class clazz = s1.getClass();

        // 获取Class对象
        System.out.println(clazz.getName());

        // 类的一些关键性的元素

        // 构造函数
        System.out.println("———————————构造函数————————————");
        Constructor [] constructors = clazz.getConstructors();
        for(Constructor c : constructors){
            System.out.println(c);
            Object object = c.newInstance("ghj",12);
            object = (Student) object;
        }



        // 普通函数


        // 类变量


        // 对象变量


        // 新建一个对象



        System.out.println("\n\n\n——————————————————————————");

    }
}
