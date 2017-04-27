package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import services.CustomerService;
import services.CustomerServiceInterface;
import entities.Customer;

public class CustomerServiceTest {

	@Test
	public void testFindByName() {
		CustomerServiceInterface cs = new CustomerService(DataProducer.getTestData(10));
		
		List<Customer> res = cs.findByName("Customer: 0");
		assertNotNull("Result can't be null", res);
		assertEquals(1, res.size());
	}
	
	@Test
	public void testcustomersWhoBoughtMoreThan() {
		CustomerServiceInterface cs = new CustomerService(DataProducer.getTestData(10));
		
		List<Customer> res = cs.customersWhoBoughtMoreThan(3);
		assertNotNull("Result can't be null", res);
		assertEquals(4, res.size());
	}

	@Test
	public void testcustomersWithNoOrders() {
		CustomerServiceInterface cs = new CustomerService(DataProducer.getTestData(10));
		
		List<Customer> res = cs.customersWithNoOrders();
		assertNotNull("Result can't be null", res);
		assertEquals(3, res.size());
	}

}
