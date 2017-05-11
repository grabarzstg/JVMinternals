package sparkdemo;

import static spark.Spark.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import mbean.ServiceMonitor;
import mbean.ServiceStatsMonitor;
import service.MyService;

public class Main {


	public static void main(String[] args) throws Exception {
		
		MyService ms = new MyService();
		
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		
		ObjectName monitorName = new ObjectName("jmxspark:type=Server,name=MyService");
		ServiceMonitor sm = new ServiceMonitor(ms);
		mbs.registerMBean(sm, monitorName);
		
		ObjectName statsMonitorName = new ObjectName("jmxspark:type=Server,name=ServiceStats");
		ServiceStatsMonitor ssm = new ServiceStatsMonitor(ms);
		mbs.registerMBean(ssm, statsMonitorName);
		
    	get("/power/:arg", (req, res) -> 
		{
			ms.setN(Integer.parseInt(req.params(":arg")));
			return ms.result();
		});
	}
}

