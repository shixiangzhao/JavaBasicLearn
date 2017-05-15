package shixzh.jbl.collection;

import java.util.HashMap;
import java.util.Map;

import shixzh.jbl.inherit.Employee;

public class MapTest {

	public static void main(String[] args) {
		Map<String, Employee> staff = new HashMap<>();
		staff.put("101", new Employee("shixiang"));
		staff.put("102", new Employee("shijiao"));
		staff.put("103", new Employee("wenjian"));
		staff.put("104", new Employee("cuihuan"));
		System.out.println(staff);

		staff.remove("102");
		System.out.println(staff);

		staff.put("101", new Employee("daniel"));
		System.out.println(staff);

		for (Map.Entry<String, Employee> entry : staff.entrySet()) {
			String key = entry.getKey();
			Employee value = entry.getValue();
			System.out.println("key = " + key + ", value = " + value);
		}
	}

}
