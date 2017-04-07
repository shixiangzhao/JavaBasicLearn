package shixzh.jbl.collection;

import java.util.Objects;

public class Item implements Comparable<Item> {

	private String descreption;
	private int partNumber;

	public Item(String descreption, int partNumber) {
		this.descreption = descreption;
		this.partNumber = partNumber;
	}

	public String getDescreption() {
		return descreption;
	}

	@Override
	public String toString() {
		return "[descreption=" + descreption + ",partNumber=" + partNumber + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Item other = (Item) obj;
		return Objects.equals(this.descreption, other.descreption) && Objects.equals(this.partNumber, other.partNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(descreption, partNumber);
	}

	@Override
	public int compareTo(Item other) {
		return Integer.compare(this.partNumber, other.partNumber);
	}

}
