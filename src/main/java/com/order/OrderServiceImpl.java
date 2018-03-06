package com.order;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(endpointInterface = "com.order.OrderService")
public class OrderServiceImpl implements OrderService{

	

	@Resource
    WebServiceContext ctx;
    public String[] getOrders() {
    	MessageContext msgctx = ctx.getMessageContext();
  	  Map headers = (Map) msgctx.get(MessageContext.HTTP_REQUEST_HEADERS);
            List<String> users = (List<String>) headers.get("username");
            List<String> pwds = (List<String>) headers.get("password");
        return new String[]{"SSD", "Graphic Card", "GPU"};
    }

    
    public boolean addOrder(String order) {
        System.out.println("Saving new order: " + order);
        return true;
    }



}
