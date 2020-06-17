package com.zhongan.test.demo;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class MyListener implements UpdateListener {

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		System.out.println("cccccccccccc");
		EventBean event = newEvents[0];
		if (event.get("epl__value") == null) {
			System.out.println("aaaaaaaaa");
			System.out.println("epl__value====0");
		} else {
			System.out.println("bbbbbbbbbbb");
			System.out.println("epl__value=" + event.get("epl__value"));
		}

		

	}

}
