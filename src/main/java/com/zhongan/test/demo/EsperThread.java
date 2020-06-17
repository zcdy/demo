package com.zhongan.test.demo;

import java.util.HashMap;
import java.util.Map;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

public class EsperThread extends Thread{
    // 通过构造方法给线程名字赋值  
	private String name;
	private String eventTypeName;
	private String epl;
	private int count;
	private boolean isRun = true;
	Map<String, Object> event1 = new HashMap<String, Object>();
    public EsperThread(String name,String eventTypeName,String epl,int count) {  
         this.name = name;
         this.eventTypeName = eventTypeName;
         this.epl = epl;
         this.count = count;
		 event1.put("clientIP", String.class);
		 event1.put("domain", String.class);
		 event1.put("bodySize", int.class);
     
    }  

    @Override  
    public void run() {
    	EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();
    	EPAdministrator admin = epService.getEPAdministrator();
    	admin.getConfiguration().addEventType("event1", event1);
//	    Configuration config = new Configuration();
//	    config.addEventTypeAutoName(this.eventTypeName);
//	    EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);
	    //String epl = "select count(*) as count from OrderEvent.win:time_batch(3 sec,\"FORCE_UPDATE,START_EAGER\")";
//	    String epl = "select size from OrderEvent.win:time(3 sec).std:size()";
	    EPStatement statement = admin.createEPL(this.epl);
	    MyListener listener = new MyListener();
	    statement.addListener(listener);
        while (true) {  
    	    for (int i=0; i< this.count&&isRun; i++) {
    			Map<String,Object> ap1 = new HashMap<String,Object>();
    			ap1.put("clientIP", "1.1.1.2");
    			ap1.put("domain", "zhongan.io/fake/2019-04-10T12:30:10.944072388");
    			ap1.put("bodySize", 190);
    		    
    		    epService.getEPRuntime().sendEvent(ap1,"event1");
    		    if (i == this.count -1) {
    		    	isRun = false;
    		    }
    	    }    	    
    	    
        }  
    }

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	} 
    
}
