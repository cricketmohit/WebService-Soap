import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import net.webservicex.StockQuote;
import net.webservicex.StockQuoteSoap;
public class StockQuoteClient {

	public static void main(String[] args) throws Exception {
//		First way
		StockQuote helloServiceImpl = new StockQuote();
		StockQuoteSoap service = helloServiceImpl.getStockQuoteSoap();

		System.out.println(service.getQuote("Hello"));
		
		
//		Second Way - For different WSDLs like Prod, DEV, binding provider can also be used
		URL url = new URL("http://www.webservicex.com/stockquote.asmx?WSDL");
		QName qname = new QName("http://www.webserviceX.NET/","StockQuote");
		Service serviceTest = Service.create(url, qname);

		StockQuoteSoap service2 = serviceTest.getPort(StockQuoteSoap.class);

		System.out.println(service2.getQuote("mkyong"));
		
//		Third way with binding provider
		 BindingProvider bp = (BindingProvider) service2;
		 Map<String, Object> map = bp.getRequestContext();
		  Map<String, List<String>> headers = new HashMap<String, List<String>>();
		  headers.put("username", Collections.singletonList("concretepage"));
		  headers.put("password", Collections.singletonList("cp1234"));
		
		  map.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		  System.out.println(service2.getQuote("Everyone!"));
	}

}
