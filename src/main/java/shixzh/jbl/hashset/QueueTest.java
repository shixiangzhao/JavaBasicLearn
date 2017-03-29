package shixzh.jbl.hashset;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		List<Integer> list = new LinkedList<>();
		for(int i = 0; i < 100000; i++){
			list.add(i);
		}
		for(int i = 0; i < list.size(); i++){
			System.out.print(list.get(i) + " ");
		}
		Date date1 = new Date();
		System.out.println();
		System.out.println((date1.getTime()-date.getTime())/1000);
		
	}

}
