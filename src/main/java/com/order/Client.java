package com.order;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;



public class Client{
	
		public static void main(String args[]) throws Exception {
			URL url = new URL("http://localhost:8888/service/order?wsdl");
			QName qname = new QName("http://order.com/","OrderServiceImplService"); 
			Service service = Service.create(url, qname);
			OrderService orderService = service.getPort(OrderService.class);

	        System.out.println(Arrays.toString(orderService.getOrders()));
	        System.out.println("Order completed: " + orderService.addOrder("Mother Board"));
	    }

		}
	


