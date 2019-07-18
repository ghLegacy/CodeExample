package com.ghlegacy.codesample;

import java.util.*;


/**
 * As the class name says ...
 */
public class CodingFun
{
    public int x;
    static int y;
    
    void cal(int a, int b){
            x +=  a ;
            y +=  b;
        }    
    
    private static final int size = 20;
    private static final int N = 100000;
    
    public static void main(String[] args) {
            
//	    checkLambdaExp();
//	     
//	    leftSidedPyramid(5);
//	     
//	    int aa = divide(4,0);
//	             
//	    checkStaticAccess();     
//	            
//	    System.out.println("small:" + findSmallestValueInArray(new int[size]));
//	            
//	    funWithHash();
//	    	
//		System.out.println(balancedParenthensies("{([])}"));
//		System.out.println(balancedParenthensies("{(a},b)"));
//		System.out.println(balancedParenthensies("{)(a,b}"));
    	int[] st = new int[] {0,1,1,0,0,0,1,1};
    	int day = 2;
    	List<Integer> res = stateChange(st, day);
//    	for(Integer a : res)
//    		System.out.print(a);
    			
      } //end of main method

    public static List<Integer> stateChange(int[] states, int days)
    {
    	int start, end;
    	start = end = 0;
    	List<Integer> result = null;
    	int[] currst = states;
    	int[] nextst = new int[8];
    	
	    for(int j=0; j< days; j++)
	    {
	    	result = new ArrayList<Integer>();
		    	
	    	for(int i=0; i<=7; i++)
	    	{
	    		if(	(i==0 && currst[i+1] != start) || 
	    			(i>0 && 
	    					(
	    							(i==7 && currst[i-1] != end) || 
	    							(i<7 && currst[i-1] != currst[i+1])
	    					) ) )
	    		{
	    			if(currst[i] == 0) { nextst[i] = 1; }
	    			else { nextst[i] = 0; }
	    			
	    			result.add(nextst[i]);
	    		}
	    		else { result.add(currst[i]); }
	    		
	    		System.out.print(result.get(i));
	    	}
	    	
	    	System.out.println("");
	    	currst = Arrays.copyOf(nextst,nextst.length);
	    	
	    }
    	
    	return result;
    }
    
    private static void funWithHash() 
    {
    	Hashtable<String, Integer> numbers = new Hashtable<String, Integer>();   
    	   numbers.put("one", 1);
    	   numbers.put("two", 2);
    	   numbers.put("three", 3);

    	   try {
			Integer n = numbers.get("two");
			   if (n != null) {
			     System.out.println("two = " + n);
			     System.out.println(numbers.hashCode());
			   }
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
    }
    
   /*
    * Sort an array that contains values from -x to x 
    * and returns the smallest integer
    */
	public static int findSmallestValueInArray(int[] A) 
	{
		Random rnd = new Random();
		for (int i = 0; i < size; i++) {
			A[i] = rnd.nextInt(N + N) - N;
		}

		Arrays.sort(A);
		displayArray(A);

		return A[0];
	}

	private static void displayArray(int[] darray)
	{
		for(int a=0; a<darray.length; a++)
		{
			System.out.println(darray[a]);
		}
	}
    
    private static void checkStaticAccess()
    {
        CodingFun obj1 = new CodingFun();
        CodingFun obj2 = new CodingFun();   
                obj1.x = 0;
                obj1.y = 0;
                obj1.cal(1, 2);
                obj2.x = 0;
                obj2.cal(2, 3);
                System.out.println(obj1.x + " " + obj2.y);
    }

    /*
     *  Check balanced parenthesis in a stream
     */
    public static boolean balancedParenthensies(String s) {
        
        Stack<Character> stack  = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {

                stack.push(c);

            }else if(c == ']') {
                if(stack.isEmpty()) return false;
                if(stack.pop() != '[') return false;

            }else if(c == ')') {
                if(stack.isEmpty()) return false;
                if(stack.pop() != '(') return false;

            }else if(c == '}') {
                if(stack.isEmpty()) return false;
                if(stack.pop() != '{') return false;
            }

        }
        return stack.isEmpty();
    }
    
    /**
     * 
     */
    private static void checkLambdaExp()
    {
        List<Person> personList = Person.createShortList();
         
         // Sort with Inner Class
         Collections.sort(personList, new Comparator<Person>(){
             public int compare(Person p1, Person p2){
                 return p1.getSurName().compareTo(p2.getSurName());
             }
         });
         
         System.out.println("=== Sorted Asc SurName ===");
         for(Person p:personList){
           p.printName();
         }
         
         // Use Lambda instead
         
         // Print Asc
         System.out.println("=== Sorted Asc SurName ===");
         //Collections.sort( personList, (Person p1, Person p2) -> p1.getSurName().compareTo(p2.getSurName())));
       
         for(Person p:personList){
           p.printName();
         }
         
         // Print Desc
         System.out.println("=== Sorted Desc SurName ===".hashCode());
         //Collections.sort(personList, (p1,  p2) -> p2.getSurName().compareTo(p1.getSurName()));
       
         for(Person p:personList){
           p.printName();
         }
    }

    /**
     * Produces output as
     *              #
     *             ##
     *            ###
     *           ####    
     */
    private static void leftSidedPyramid(int n)
    {
         for(int i=1; i<=n; i++)
         {
             for(int j =n; j>=1 ;j--)
             {
                 if(i<j)
                     System.out.print( " " );
                 else
                     System.out.print("#");
             }
             
             System.out.println();
         }
    }
    
    /*
     * This method checks the order of print outputs of try-catch-finally block 
     * */
    public static int divide(int a, int b) {
        
            int c=-1;
            
            try {
                c=a/b;
            }
            catch(Exception e) {
                System.err.print( "Exception");
            }
            finally {
                System.err.print( "Finally");
            }
            
            return c;
    }
    
  
}