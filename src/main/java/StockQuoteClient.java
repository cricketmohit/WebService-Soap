import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

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
	}

}
