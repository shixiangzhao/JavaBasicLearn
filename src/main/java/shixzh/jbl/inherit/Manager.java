package shixzh.jbl.inherit;

public class Manager extends Employee {

	private double bonus;

	public Manager(String name, double salary, int year, int mouth, int day) {
		super(name, salary, year, mouth, day);
		this.bonus = 0;
	}

	@Override
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject)) {
			return false;
		}
		Manager other = (Manager) otherObject;
		return this.bonus == other.bonus;
	}

	@Override
	public int hashCode() {
		return super.hashCode() + 17 * new Double(bonus).hashCode();
	}

	@Override
	public String toString() {
		return super.toString() + "[bonus=" + bonus + "]";
	}

}
