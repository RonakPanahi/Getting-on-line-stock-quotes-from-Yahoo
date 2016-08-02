/**
 * AUTHOR: RONAK PANAHI
 * Date: November 2015
 * Getting on-line stock quotes from Yahoo ***(with a Socket)***
 */
 
 
package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GetStock {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String stock_symbol = sc.nextLine().toString().toLowerCase();
		
		
		 try {
			 	String host = "finance.yahoo.com";
			 	Socket s = new Socket(host, 80);
			 	
			 	PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			 	pw.print("GET /q?s=" + stock_symbol + "&ql=1" + " HTTP/1.1\r\n");
			 	pw.print("Host: "+ host + "\r\n\r\n");
				pw.flush();
			 	
			 	BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				
				String tag = "<span class=\"time_rtq_ticker\">";
				String newLine;
				    while ((newLine = br.readLine()) != null) 
				    {
				    	if(newLine.toLowerCase().contains(tag.toLowerCase()))
				    	{
				    		int x = newLine.indexOf(tag)+54;
				    		int y = newLine.indexOf( "</span>", x );
				    		System.out.println(stock_symbol.toUpperCase() +" is at "+newLine.substring(x,y));
				    		break;
				    	}
				    }
				   
				pw.close();
			 	br.close();
				s.close();
		 	}
		  catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Can not find the stock for "+stock_symbol );
			e.printStackTrace();
		}
		sc.close();  

	}

}
