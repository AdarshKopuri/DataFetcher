package data;

import java.io.*;
import java.net.*;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;

public class DataFetcher {

	public static void main(String args[]) {
		
		final String url= "http://localhost:8200//consumer-api/getDataa";
	String s=	getData(url,"user","password");
	System.out.println(s);
	}
	
	public static String getData(String urlString, String username, String password) {
		HttpURLConnection connection= null;
		try {
			URL url= new URI(urlString).toURL();
			 connection= (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			 String auth = username + ":" + password;
	            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
	            connection.setRequestProperty("Authorization", "Basic " + encodedAuth);
            
			int responsecode= connection.getResponseCode();
			if(responsecode== HttpURLConnection.HTTP_OK) {
				
//				InputStream stream=connection.getInputStream();    
//				int i;    
//				while((i=stream.read())!=-1){    
//				System.out.print((char)i);  		
//				}    
				
				return "success";
			}
			else {
				return "Error: "+responsecode;
			}  
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			connection.disconnect();
		}
		return "Unable to fetch data";
	

	}
	
	
}
