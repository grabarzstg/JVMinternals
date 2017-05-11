package mbean;

import java.beans.ConstructorProperties;

public class ServiceStats {
	
	public ServiceStats() {
		super();
	}

	private int n;
	private int power;
	
	public int getN() {
		return n;
	}
	public int getPower() {
		return power;
	}
	
	public void setN(int a) {
		this.n = a;
	}
	public void setPower(int p) {
		this.power = p;
	}
	
	@ConstructorProperties({"n", "power"}) 
	public ServiceStats(int n, int power) {
		super();
		this.n = n;
		this.power = power;
	} 

}
