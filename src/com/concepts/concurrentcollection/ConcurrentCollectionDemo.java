package com.concepts.concurrentcollection;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCollectionDemo {

	public static ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<String, String>();
	
	public static void main(String[] args) {
		
		chm.put("101", "One");
		chm.put("102", "Two");
		
		Runnable r = () -> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				chm.put("103", "Three");
		};
		Thread t = new Thread(r);
		t.start();
		
		Set s = chm.keySet();
		
		Iterator<String> itr = s.iterator();
		
		while(itr.hasNext()) {
			
			System.out.println(chm.get(itr.next().toString()));
			
		}

		System.out.println(chm);
	}

}
