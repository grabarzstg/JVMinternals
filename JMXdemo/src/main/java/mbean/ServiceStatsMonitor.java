package mbean;

import mbean.IServiceStatsMonitor;
import mbean.ServiceStats;
import service.MyService;

public class ServiceStatsMonitor implements IServiceStatsMonitor {
	
	private MyService ms;
	
	public ServiceStatsMonitor(MyService ms) {
		this.ms = ms;
	}

	//@Override
	public ServiceStats getServiceStats() {
		return new ServiceStats(ms.getN(), ms.getPower());
	}


}
