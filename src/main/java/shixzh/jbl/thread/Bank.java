package shixzh.jbl.thread;

public abstract class Bank {

	public abstract void transfer(int from, int to, double amount) throws InterruptedException;

	public abstract double getTotalBalance();

	public abstract int size();
}
