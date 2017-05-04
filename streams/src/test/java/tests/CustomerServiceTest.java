package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import services.CustomerService;
import services.CustomerServiceInterface;
import entities.Customer;
import entities.Product;

public class CustomerServiceTest {

	@Test
	public void testFindByName() {
		CustomerServiceInterface cs = new CustomerService(DataProducer.getTestData(10));
		
		List<Customer> res = cs.findByName("Customer: 0");
		assertNotNull("Result can't be null", res);
		assertEquals(1, res.size());
	}
	
	@Test
	public void testFindByField() {
		CustomerServiceInterface cs = new CustomerService(DataProducer.getTestData(10));
		
		List<Customer> res = cs.findByField("name", "Customer: 0");
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
	public void testcustomersWhoSpentMoreThan(){
		assertFalse(true);
	}
	
	@Test
	public void testcustomersWithNoOrders() {
		CustomerServiceInterface cs = new CustomerService(DataProducer.getTestData(10));
		
		List<Customer> res = cs.customersWithNoOrders();
		assertNotNull("Result can't be null", res);
		assertEquals(3, res.size());
	}
	
	@Test
	public void testaddProductToAllCustomers(){
		assertFalse(true);
	}
	
	@Test
	public void testavgOrders(){
		assertFalse(true);
	}
	
	@Test
	public void testwasProductBought(){
		Product tp = DataProducer.getFirstTestProduct();
		CustomerServiceInterface cs = new CustomerService(DataProducer.getTestData(10));
		
		boolean res = cs.wasProductBought(tp);
		assertNotNull("Result can't be null", res);
		assertEquals(true, res);
	}
	
	@Test
	public void testwasmostPopularProduct(){
		assertFalse(true);
	}
	
	@Test
	public void testcountBuys() {
		Product tp = DataProducer.getFirstTestProduct();
		CustomerServiceInterface cs = new CustomerService(DataProducer.getTestData(10));
		
		int res = cs.countBuys(tp);
		assertNotNull("Result can't be null", res);
		assertEquals(0, res);
	}
	
	@Test
	public void testcountCustomersWhoBought() {
		Product tp = DataProducer.getFirstTestProduct();
		CustomerServiceInterface cs = new CustomerService(DataProducer.getTestData(10));
		
		int res = cs.countCustomersWhoBought(tp);
		assertNotNull("Result can't be null", res);
		assertEquals(10, res);
	}

}
