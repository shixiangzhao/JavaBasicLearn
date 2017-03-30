package shixzh.jbl.inherit;

public class EqualsTest {

	public static void main(String[] args) {

		Employee shi1 = new Employee("shixzh", 104, 1989, 12, 11);
		Employee shi2 = shi1;
		Employee shi3 = new Employee("shixzh", 104, 1989, 12, 11);
		Employee bob = new Employee("Bob", 105, 1987, 10, 11);

		System.out.println("shi1==shi2: " + (shi1 == shi2));
		System.out.println("shi1==shi3: " + (shi1 == shi3));
		System.out.println("shi1.equals(shi3): " + shi1.equals(shi3));
		System.out.println("shi1.equals(bob): " + shi1.equals(bob));
		System.out.println("bob.toString(): " + bob.toString());
	}

}
