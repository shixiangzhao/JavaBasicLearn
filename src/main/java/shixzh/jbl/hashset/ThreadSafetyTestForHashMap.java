package shixzh.jbl.hashset;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

// 快速失败机制保证不会出现多线程并发错误（Fast-Fail）
public class ThreadSafetyTestForHashMap {

	private static Map<Integer, String> map = new HashMap<>();

	public static void main(String[] args) {
		// init map
		for (int i = 0; i < 1000; i++) {
			map.put(i, "value" + i);
		}
		SafetyThreadForIteratorTable sti = new SafetyThreadForIteratorTable("IteratorThread", map);
		sti.start();
		SafetyThreadForAddTable sta = new SafetyThreadForAddTable("AddThread", map);
		sta.start();
	}

}

class SafetyThreadForIteratorMap extends Thread {
	private Map<Integer, String> map;

	SafetyThreadForIteratorMap(String name, Map<Integer, String> map) {
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

class SafetyThreadForAddMap extends Thread {
	private Map<Integer, String> map;

	SafetyThreadForAddMap(String name, Map<Integer, String> map) {
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