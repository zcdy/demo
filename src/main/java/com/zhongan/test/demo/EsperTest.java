package com.zhongan.test.demo;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

public class EsperTest {
	public static void main(String[] args) {
		EsperThread esperThread=new EsperThread("test1","com.zhongan.test.demo","select count(clientIP) as epl__value FROM event1.win:time_batch(5 sec, \"FORCE_UPDATE, START_EAGER\")",3);
//		EsperThread esperThread=new EsperThread("test1","com.zhongan.test.demo","SELECT clientIP,count(*) AS epl__value FROM event1.win:time_batch(5 sec, \"FORCE_UPDATE, START_EAGER\")",3);
		esperThread.start();
//	    Configuration config = new Configuration();
//	    config.addEventTypeAutoName("com.zhongan.test.demo");
//	    EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
//
//	    //String epl = "select count(*) as count from OrderEvent.win:time_batch(3 sec,\"FORCE_UPDATE,START_EAGER\")";
//	    String epl = "select size from OrderEvent.win:time(3 sec).std:size()";
//	    EPStatement statement = epService.getEPAdministrator().createEPL(epl);
//
//	    MyListener listener = new MyListener();
//	    statement.addListener(listener);
//
//	    for (int i=0; i< 10; i++) {
//		    OrderEvent event = new OrderEvent("shirt", 74.50);
//		    epService.getEPRuntime().sendEvent(event);	
//		    if (i == 4) {
//			    try {
//					Thread.sleep(2);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}		    	
//		    }
//	    }

	    
	}

}
