package service;

public class MyService {

	private int n = 1;
	private int power = 2;

	public int getN() {
		return n;
	}	
	public int getPower() {
		return power;
	}

	public void setN(int n) {
		this.n = n;
	}
	public void setPower(int p) {
		this.power = p;
	}
	
	public double result() {
		return Math.pow((double)n, (double)power);
	}
}
