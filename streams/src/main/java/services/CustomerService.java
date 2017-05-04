package services;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import entities.Customer;
import entities.Product;

public class CustomerService implements CustomerServiceInterface {

	private List<Customer> customers;

	public CustomerService(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public List<Customer> findByName(String name) {
		return customers.stream()
				.filter(c -> c.getName().equals(name))
				.collect(Collectors.toList());
	}

	@Override
	public List<Customer> findByField(String fieldName, Object value) {
		// TODO:
				Function<String, Field> f =
					    (String c) -> {
					        try {
					           return Customer.class.getField(fieldName);
					        }
					        catch(Exception e) {
					        	return null;
					        }
					    };
				
					return customers.stream()
							.filter(c -> f == value)
		.collect(Collectors.toList());
	}

	@Override
	public List<Customer> customersWhoBoughtMoreThan(int number) {
		for(Customer c : customers){
			System.out.println(c.getBoughtProducts().size());
		}
		return customers.stream()
				.filter(c -> c.getBoughtProducts().size() > number)
				.collect(Collectors.toList());
	}

	@Override
	public List<Customer> customersWhoSpentMoreThan(double price) {
		// TODO Auto-generated method stub
		//List <Product> prod = customers.stream().map(c -> c.getBoughtProducts()).map(pl -> pl.forEach(p ->  (p.getPrice())));
		return null;
	}

	@Override
	public List<Customer> customersWithNoOrders() {
		return customers.stream()
				.filter(c -> c.getBoughtProducts().isEmpty())
				.collect(Collectors.toList());
	}

	@Override
	public void addProductToAllCustomers(Product p) {
		// TODO Auto-generated method stub
	}

	@Override
	public double avgOrders(boolean includeEmpty) {
		List<Product> allProducts = customers.stream().flatMap(c -> c.getBoughtProducts().stream()).collect(Collectors.toList());
		return allProducts.stream().map(Product::getPrice).collect(Collectors.toList())
							.stream().mapToDouble(i->i.doubleValue()).sum()/customers.size();
	}

	@Override
	public boolean wasProductBought(Product p) {
		List<List<Product>> llp = customers.stream()
				.map(c -> c.getBoughtProducts())
				.filter(pl -> pl.contains(p))
				.collect(Collectors.toList());
		return !(llp.isEmpty());
	}

	@Override
	public List<Product> mostPopularProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countBuys(Product p) {
		List<Product> allProducts = new ArrayList<>();
		customers.stream().map(c -> c.getBoughtProducts())
				.filter(pl -> pl.contains(p))
				.map(pl -> allProducts.addAll(pl));
		return (int) allProducts.stream().filter(pr -> pr == p).count();
	}

	@Override
	public int countCustomersWhoBought(Product p) {
		List<List<Product>> llp = customers.stream()
				.map(c -> c.getBoughtProducts())
				.collect(Collectors.toList());
		return llp.size();
	}

}
