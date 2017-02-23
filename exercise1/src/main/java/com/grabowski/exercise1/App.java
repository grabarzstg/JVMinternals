package com.grabowski.exercise1;

import java.util.HashMap;
import java.util.Map;

public class App 
{
	static class Key {
	      Integer id;
	 
	      Key(Integer id) {
	         this.id = id;
	      }
	   }
	
	public static void main(String[] args) {
	      Map m = new HashMap();
	      while (true)
	         for (int i = 0; i < 10000; i++)
	            if (!m.containsKey(new Key(i)))
	               m.put(new Key(i), "Number:" + i);
	   }
    
}
