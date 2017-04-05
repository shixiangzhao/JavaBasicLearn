package shixzh.jbl.inherit;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.Scanner;

@SuppressWarnings("rawtypes")
public class ReflectionTest {

	public static void main(String[] args) {
		// simpleTest();
		String name;
		if (args.length > 0) {
			name = args[0];
		} else {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter class name(e.g. java.util.Date): ");
			name = scanner.next();
		}

		try {
			Class c1 = Class.forName(name);
			Class superc1 = c1.getSuperclass();
			String modifiers = Modifier.toString(c1.getModifiers());
			if (modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			System.out.print("class " + name);
			if (superc1 != null && superc1 != Object.class) {
				System.out.print(" extends " + superc1.getName());
			}
			System.out.print("\n{ // print fields\n");
			printFields(c1);
			System.out.println("  // print constructors");
			printConstructors(c1);
			System.out.println("  // print methods");
			printMethods(c1);
			System.out.println("}");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.exit(0);

	}

	private static void printFields(Class c1) {
		Field[] fields = c1.getFields();
		for (Field f : fields) {
			Class retType = f.getType();
			String name = f.getName();
			System.out.print("  ");
			String modifiers = Modifier.toString(f.getModifiers());
			if (modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			System.out.println(retType + " " + name + ";");
		}

	}

	private static void printMethods(Class c1) {
		Method[] methods = c1.getMethods();
		for (Method m : methods) {
			Class retType = m.getReturnType();
			String name = m.getName();
			System.out.print("  ");
			String modifiers = Modifier.toString(m.getModifiers());
			if (modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			System.out.print(retType.getName() + " " + name + "(");
			Class[] paramTypes = m.getParameterTypes();
			for (int j = 0; j < m.getParameterCount(); j++) {
				if (j > 0) {
					System.out.print(", ");
				}
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}

	private static void printConstructors(Class c1) {
		Constructor[] constructors = c1.getConstructors();
		for (Constructor c : constructors) {
			String name = c.getName();
			System.out.print("  ");
			String modifiers = Modifier.toString(c.getModifiers());
			if (modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			System.out.print(name + "(");
			Class[] paramTypes = c.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++) {
				if (j > 0) {
					System.out.print(", ");
				}
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}

	@SuppressWarnings("unused")
	private static void simpleTest() {
		Employee s1 = new Employee("carl", 100, 1989, 5, 31);
		Manager s2 = new Manager("bob", 100, 1989, 5, 31);
		System.out.println(s1.getClass().getName() + ", " + s1.getName());
		System.out.println(s2.getClass().getName() + ", " + s2.getName());

		Date date = new Date();
		Class c1 = date.getClass();
		String c1Name = c1.getName();
		System.out.println(c1Name);
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
		System.out.println(cl1 + ", " + cl2 + ", " + cl3);

		if (s1.getClass() == Employee.class) {
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
