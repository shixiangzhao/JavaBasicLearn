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
		
		Manager carl = new Manager("carl", 104, 1989, 12, 11);
		Manager boss = new Manager("carl", 104, 1989, 12, 11);
		boss.setBonus(50);
		System.out.println("boss.toString(): " + boss.toString());
		System.out.println("carl.equals(boss): " + carl.equals(boss));
		System.out.println("shi1.hashCode(): " + shi1.hashCode());
		System.out.println("shi3.hashCode(): " + shi3.hashCode());
		System.out.println("bob.hashCode(): " + bob.hashCode());
		System.out.println("carl.hashCode(): " + carl.hashCode());
	}

}
