package stockMarket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Scanner;

public class StockQuoteRead {

	public static void main(String[] args) throws UnsupportedEncodingException {

		Scanner sc = new Scanner(System.in);
		String stock_symbol = sc.nextLine().toString().toLowerCase();
		
		//encoding the symbol for symbols like ^hsi
		String stock_symbol_inurl = URLEncoder.encode(stock_symbol, "UTF-8");
		
		String yahooUrl = "http://finance.yahoo.com/q?s=" + stock_symbol_inurl + "&ql=1";
		
		try {
			URL yahoofinance = new URL(yahooUrl);
			URLConnection yf = yahoofinance.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yf.getInputStream()));
			
			String tag = "<span class=\"time_rtq_ticker\">";//"\"yfs_l84_"+stock_symbol+"\">";
			String newLine;
			    while ((newLine = in.readLine()) != null) 
			    {
			    	if(newLine.toLowerCase().contains(tag.toLowerCase()))
			    	{
			    		// getting the index of "time_rtq_ticker" 
			    		// x is the index of the value and y is the index of span tag right after the value
			    		
			    		int x = newLine.indexOf(tag)+54;
			    		int y = newLine.indexOf( "</span>", x );
			    		System.out.println(stock_symbol.toUpperCase() +" is at "+newLine.substring(x,y));
			    		
			    		
			    		// or we can use regular expression ==> "([\\d]+[\\.]?[\\d]*)
			    	}
			    	
			    }
			          in.close();
			} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Can not find the stock for "+stock_symbol );
			e.printStackTrace();
		}
		
	}

}
