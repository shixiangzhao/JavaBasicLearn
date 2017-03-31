package shixzh.jbl.inherit;

import java.util.Date;

public class ReflectionTest {

	public static void main(String[] args) {
		Employee s1 = new Employee("carl", 100, 1989, 5, 31);
		Manager s2 = new Manager("bob", 100, 1989, 5, 31);
		System.out.println(s1.getClass().getName() + " " + s1.getName());
		System.out.println(s2.getClass().getName() + " " + s2.getName());
		
		Date date = new Date();
		Class c1 = date.getClass();
		String name = c1.getName();
		System.out.println(name);
		System.out.println(c1.toString());
		
		String className = "java.util.Date";
		try {
			Class c2 = Class.forName(className);
			Object m = Class.forName(className).newInstance();
			System.out.println(c2.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		Class cl1 = Date.class;
		Class cl2 = int.class;
		Class cl3 = Double[].class;
		System.out.println(cl1 + " " + cl2 + " " + cl3);
		
		if(s1.getClass() == Employee.class) {
			try {
				System.out.println(s1.getClass().newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
	}
}
