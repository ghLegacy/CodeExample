package com.ghlegacy.codesample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class TestJSON {

	/**
	 * @param rd
	 * @return String
	 * @throws IOException
	 */
	private static String readAll(Reader rd) throws IOException 
	{
	    StringBuilder sb = new StringBuilder();
	    String line = null;
	    
        while ((line = ((BufferedReader) rd).readLine()) != null) {
            sb.append(line + "\n");
        }
	   
	    return sb.toString();
	}
	
	/**
	 * @param url
	 * @return JSONArray
	 * @throws IOException
	 * @throws JSONException
	 */
	private static JSONArray readJsonFromUrl(String url) throws IOException, JSONException 
	{
	    InputStream is = new URL(url).openStream();
	    
	    try 
	    {
	    	BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		    String jsonText = readAll(rd);
		    
		    //System.out.println(jsonText);
		    JSONArray jsonArray = new JSONArray(jsonText);
		    return jsonArray;
		 } 
	     finally 
	     {
		     is.close();
		 }
	}
	
	/**
	 * @param jsonArray
	 * @throws JSONException
	 */
	private static void createCSVFile(JSONArray jsonArray)
			throws JSONException {
		int lenght = jsonArray.length();
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("C:/GoEuro/csv.txt", "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		for(int i=0; i< lenght; i++) { 
			JSONObject jsonObj = new JSONObject();
			jsonObj = jsonArray.getJSONObject(i);
			
			writer.println(jsonObj.getInt("_id") + "," +
 				   jsonObj.getString("name") + "," +
 				   jsonObj.getString("type") + "," +
 				   jsonObj.getJSONObject("geo_position").getDouble("latitude") + "," +
 				   jsonObj.getJSONObject("geo_position").getDouble("longitude") );
		}
		
		writer.close();
	}
		
	/**
	 * @param args
	 * @throws IOException
	 * @throws JSONException
	 */
	public static void main(String [ ] args) throws IOException, JSONException
	{
		
		if(!args[0].isEmpty() )
		{
			JSONArray jsonArray = readJsonFromUrl("http://api.goeuro.com/api/v2/position/suggest/en/"+args[0]);
			
			if(jsonArray != null && jsonArray.length() > 0) {
				createCSVFile(jsonArray);
                System.out.println("Check the output file for CSV data");
			}
			else {
				System.out.println("No match found.");
			}
		}
		else
		{
			System.out.println("Please enter a city name: ");
		}
			
	}

	
}
