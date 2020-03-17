package com.ghlegacy.codesample;

public class RunLengthEncode 
{

  public static void main(String[] args) {

		System.out.println( "aaabb = " + runLengthEncode("aaabb"));
		System.out.println( "aaabbccccdd = " + runLengthEncode("aaabbccccdd"));
		System.out.println( "aaabbccccdda = " + runLengthEncode("aaabbccccdda"));
		System.out.println( "abcd = " + runLengthEncode("abcd"));
		System.out.println( "aabcccccccccddddde = " + runLengthEncode("aabcccccccccddddde"));
		System.out.println( "a = " + runLengthEncode("a"));
		System.out.println( runLengthEncode(""));
	}

	private static String runLengthEncode(String s) 
	{
		if(s.isEmpty())
		{
			return "There is no string to process.";
		}
		/* StringBuffer is thread-safe and synchronized, so it can cause slow 
		 * performance if thread safety is not required.
		 * 
		 * StringBuffer & StringBuilder classes are mutable unlike String class.
		 * */
//		StringBuffer dest = new StringBuffer();
		StringBuilder dest = new StringBuilder();
	    for (int i = 0; i < s.length(); i++) {
	        int runLength = 1;
	        while (i + 1 < s.length()
	                && s.charAt(i) == s.charAt(i + 1)) {
	            runLength++;
	            i++;
	        }
	        
	        dest.append(s.charAt(i));
	        dest.append(runLength);
	    }
	    return dest.toString();
	}

}
