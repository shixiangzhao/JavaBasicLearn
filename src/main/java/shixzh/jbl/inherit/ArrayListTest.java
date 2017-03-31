package shixzh.jbl.inherit;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Employee> staff = new ArrayList<>();
		staff.add(new Employee("z1", 100, 1989, 9, 29));
		staff.add(new Employee("z2", 101, 1988, 8, 28));
		staff.add(new Employee("z3", 102, 1987, 7, 27));

		for (Employee st : staff) {
			st.raiseSalary(5);
		}

		for (Employee st : staff) {
			System.out.println(st.toString());
		}
	}

}
