/**
 * 
 */
package com.ghlegacy.codesample;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author muhi
 *
 */
public class AddRemoveStringFromLinkedList {

	private LinkedList<String> alist = new LinkedList<String>();
	/**
	 * @param args
	 */
	
	public void setup()
	{
		alist.add("Joe");
		alist.add("Bob");
		alist.add("July");
	}
	
	public void remove(String input)
	{
		boolean match = false;
		for(Iterator<String> iterator =alist.iterator(); iterator.hasNext(); ) {
            if(iterator.next().equalsIgnoreCase(input)) { 
                iterator.remove();
                match = true;
                break;
                }
		}
		if(!match)
			System.out.println("Person not in");
	}
	
	public static void main(String[] args) {
		
		AddRemoveStringFromLinkedList dieObj = new AddRemoveStringFromLinkedList();
		dieObj.setup();
		
		dieObj.remove("Joe");
		
		for(String x : dieObj.alist)
			System.out.println(x);

	}
	
	

}
