package com.example.restservicedemo.agent;

import static org.junit.Assert.*;
import com.example.restservicedemo.service.PersonManager;

import org.junit.Test;

public class InstrIT {
	
	private PersonManager pm = new PersonManager();

	@Test
	public void agentTest() throws InterruptedException{
		
		String res = pm.calculateAge((long) 1);
		assertTrue(true);
	}

}