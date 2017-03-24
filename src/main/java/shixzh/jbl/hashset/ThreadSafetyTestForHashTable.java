package shixzh.jbl.hashset;

import java.util.Iterator;
import java.util.Map;
import java.util.Hashtable;
import java.util.Map.Entry;

// 在执行get,put等一次性读写操作时，使用了同步机制，避免了多个线程 同时读写Hashtable
public class ThreadSafetyTestForHashTable {

	private static Map<Integer, String> map = new Hashtable<>();

	public static void main(String[] args) {
		// init map
		for (int i = 0; i < 1000; i++) {
			map.put(i, "value" + i);
		}
		SafetyThreadForIteratorMap sti = new SafetyThreadForIteratorMap("IteratorThread", map);
		sti.start();
		SafetyThreadForAddMap sta = new SafetyThreadForAddMap("AddThread", map);
		sta.start();
	}

}

class SafetyThreadForIteratorTable extends Thread {
	private Map<Integer, String> map;

	SafetyThreadForIteratorTable(String name, Map<Integer, String> map) {
		super(name);
		this.map = map;
	}

	public void run() {
		Iterator<Entry<Integer, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Integer, String> entry = (Entry<Integer, String>) it.next();
			System.out.println("KEY: " + entry.getKey() + " , VALUE: " + entry.getValue());
		}
	}
}

class SafetyThreadForAddTable extends Thread {
	private Map<Integer, String> map;

	SafetyThreadForAddTable(String name, Map<Integer, String> map) {
		super(name);
		this.map = map;
	}

	public void run() {
		int id = 10000;
		for (int i = 0; i < 100; i++) {
			int newId = id + i;
			map.put(id + i, "value" + newId);
			System.out.println("ADD KEY: " + newId + " , ADD VALUE: value" + newId);
		}
	}
}