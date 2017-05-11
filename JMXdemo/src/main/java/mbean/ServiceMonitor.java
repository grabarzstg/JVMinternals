package mbean;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

import service.MyService;

public class ServiceMonitor extends NotificationBroadcasterSupport implements
		ServiceMonitorMBean {

	private MyService ms;
	private int sequenceNumber = 0;

	public ServiceMonitor(MyService s) {
		this.ms = s;
	}

	//@Override
	public void setPower(int pow) {
		ms.setPower(pow);

		if (pow >= 0 && pow <= 5) {
			Notification not = new AttributeChangeNotification(this,
					sequenceNumber++, System.currentTimeMillis(),
					"Niska wartosc potegi", "pow", "int", ms.getPower(),
					pow);
			not.setUserData("zmieniono potege na " + pow);
			sendNotification(not);
		}else if(pow >= 6 && pow <= 10) {
			Notification not = new AttributeChangeNotification(this,
					sequenceNumber++, System.currentTimeMillis(),
					"Srednia wartosc potegi", "pow", "int", ms.getPower(),
					pow);
			not.setUserData("zmieniono potege na " + pow);
			sendNotification(not);
		}else if(pow > 10) {
			Notification not = new AttributeChangeNotification(this,
					sequenceNumber++, System.currentTimeMillis(),
					"Wysoka wartosc potegi", "pow", "int", ms.getPower(),
					pow);
			not.setUserData("zmieniono potege na " + pow);
			sendNotification(not);
		}

	}

	@Override
	public MBeanNotificationInfo[] getNotificationInfo() {
		String[] types = new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE };

		String name = AttributeChangeNotification.class.getName();
		String desc = "Zmiana wartosci atrybutu";
		MBeanNotificationInfo info = new MBeanNotificationInfo(types, name,
				desc);
		return new MBeanNotificationInfo[] { info };
	}

	//@Override
	public int getPower() {
		return ms.getPower();
	}


}
