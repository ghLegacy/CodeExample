package com.ghlegacy.codesample;

import java.io.*;
import java.util.*;

public class ReverseArrayElement 
{
	public static void main(String[] args) 
  {
		char[] input = new char[]{'a','e','w','f','d'};
		char[] result = reverseElement(input);
		System.out.println(Arrays.toString(result));
	}

	private static char[] reverseElement(char[] aChar)
	{
		int midpoint = 0;
		
		if(aChar.length % 2 ==0 )
		{
			midpoint = aChar.length/2; 
		}
		else
		{
			midpoint = (aChar.length -1)/2;
		}
		
		char tmp;
		for(int i=0; i< midpoint; i++)
		{
			tmp = aChar[i];
			aChar[i]= aChar[aChar.length - i-1];
			aChar[aChar.length -i-1] = tmp;
		}
		
		return aChar;
	}

}
