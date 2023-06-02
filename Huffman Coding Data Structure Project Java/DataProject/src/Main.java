import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args)
		{
	
			System.out.println("_*_*_*_*_HULFMAN ALGORITHM_*_*_*_*_*_");
			 sleeping();            //calling of sleeping function from main
			 menu();				 //calling of menu function from main
	
			System.out.print("POINT < 1 > READING TEXT FROM ORIGINAL FILE");   //for first point
			sleeping();        //calling of sleeping function from main
	
			  //READING FROM FILE
			String string=null;     //make string null
				try 
					{
						BufferedReader reader = new BufferedReader(new FileReader("ORIGINAL.txt"));	   //reading the data from file	
						string = reader.readLine();      //storing the data of file in string variable 
						reader.close();               //closing the file
					} 
				catch (IOException e) 
					{
						e.printStackTrace();
					}
	
			System.out.println(string+"\n");     //print the data of file
			
			System.out.print("POINT < 2 > CALCULATING ORIGINAL SIZE IN BITS");     //for second point
			sleeping();            //calling of sleeping function from main
			int size = string.length()*7;                //store string size in size variable
			System.out.println("SIZE OCCUPIED= "+size);         //print the size of string
	
			   //FINDING FREQUENCY OF CHARACTERS
			ArrayList<Data> data=new ArrayList<Data>();    //arraylist of Data type
			
			for(int i=0;i<string.length();i++)     //for loop till string length
				{
				      //declaration of variables
					int count=0;
					boolean flag=false;
					for(int k=0;k<string.length();k++)   //for loop till string length
						{
							for(int j=0;j<data.size();j++)       //for loop till data size 
								{
									if(data.get(j).c==string.charAt(i)) 
										{
											flag=true;   //break loop
										}
								}
							if(string.charAt(i)==string.charAt(k)) 
								{
									count++;     //increment in count value
								}
						}
					if(!flag)   //condition
						{
							Data t = new Data(string.charAt(i),count,null,null);
							data.add(t);     //add data in arraylist
						}
				}
			
			 //PRINTING UNIQUE CHARACTERS
			System.out.print("\nPOINT < 3 > PRINTING UNIQUE CHARACTERS");   //for third point
			sleeping();        
			for(int i=0;i<string.length();i++)      //for loop till string length
				{
					int count=0;
					for(int j=0;j<string.length();j++)   //for loop till string length
						{
							if(string.charAt(i)==string.charAt(j)) 
								{
									count++;      //increment in count value
								}
						} 
					if(count == 1)      //condition if count is equal to one
						{
							System.out.println(string.charAt(i)+" (UNIQUE)");     //print unique character
						}
				}
			
			   //ENQUEING IN QUEUE
			Queue obj = new Queue(data.size());
			
			  //PRINTING FREQUENCY OF EACH CHARACTER
			System.out.println("POINT < 4 > PRINTING FREQUENCY OF EACH CHARACTER");   //for 4th point
			  sleeping();    //calling of sleeping function from main
			System.out.println("\nCHARCTER  | FREQUENCY");    //print
			for (Data i : data)      //for each loop
				{
					System.out.println(i.c+"         |     " +i.f);
					obj.enqueue(i);       //calling enqueue function from queue class
				}
			
			 //GENERATING TREE
			int n=obj.size-1;
			for (int i=0;i<n;i++) 
				{
					obj=sort(obj);     //SORTING
					
					Data d1=obj.peek();
					obj.dequeue();       //calling dequeue function from queue class
					Data root = new Data('*',(d1.f+obj.peek().f),d1,obj.peek());
					obj.dequeue();             //calling dequeue function from queue class
					obj.enqueue(root);       //calling enqueue function from queue class by passing root
				}
			
			  //PRINTING TREE IN INORDER
			System.out.println("\nPOINT < 5 > PRINTING TREE IN INORDER");  //for 5th point
			sleeping();         //calling of sleeping function from main
			print(obj.peek());      //passing peek value in print function
			
			
			   //GENERATING CODE
			System.out.print("POINT < 6 >  PRINTING HULFMAN TABLE");     //for 6th point
			sleeping();         //calling of sleeping function from main
			ArrayList<temp>arr=new ArrayList<>();            //arraylist
			System.out.println("\nCHARCTER  |    CODE");           //print hulfman table
			code(obj.peek(),"",arr);         //passing peek value and arr in code function
			
			  //ENCODING IN BITS		
			System.out.println("POINT < 7 > PLEASE WAIT THE STRING IS ENCODING");    //for 7th point
			  sleeping();        //calling of sleeping function from main
			String estring=new String();
			char a[]=string.toCharArray();       //character array
			for (int i=0;i<a.length;i++)      //for loop till character array size
				{
					for(int j=0;j<arr.size();j++)     //for loop till arraylist size
						{
							char b = arr.get(j).c;     //storing character in b
							if(a[i] == b) 
								{
									String plus = arr.get(j).s;
									estring = estring+plus;
								}
						}
				}
			
			    //PRINTING ENCODED FILE
			System.out.println("STRING ENCODED SUCCCESSFULLY");
			System.out.println(estring);
			
			   //SIZE OF ENCODED.TXT
			System.out.print("SIZE OF ENCODED.TXT IS ");
			System.out.println(estring.length());
			
			   //WRITING DATA IN ENCODED.TXT
			System.out.print("\nSTORING ENCODING IN SEPARATE FILE (ENCODED.txt)");
			sleeping();     //calling of sleeping function from main
				try 
					{
						FileWriter fwriter=new FileWriter(new File("ENCODED.txt"));   
						fwriter.write(estring);	
						fwriter.close();
						System.out.println("\nDATA WRITTEN IN ENCODED.TXT");
					} 
				catch (Exception e) 
					{
						e.printStackTrace();
					}
			
			
			   //READING FROM ENCODED.TXT
			System.out.print("\nREADING DATA FROM ENCODED FILE");
			sleeping();          //calling of sleeping function from main
			String readed=new String();
			try 
				{
					BufferedReader reader = new BufferedReader(new FileReader("ENCODED.txt"));		
					readed=reader.readLine();
					reader.close();
				} 
			catch (IOException e) 
				{
					e.printStackTrace();
				}
					
			   //READED FROM ENCODED.TXT
			System.out.println("\nDATA FROM ENCODED.TXT");
			System.out.println(readed);
			
			   //BREAKING INTO PEICES OF 7
			System.out.println("\nBREAKING INTO PIECES OF 7");
			sleeping();           //calling of sleeping function from main
			String codewords = new String();
			int i=0;            //declaration of variable
			while(i<readed.length())       //while loop
				{
					String st=new String();
					int k=0;            //declaration of variable
					
					for(int j=0;j<7 && i<readed.length();j+=1)   //for loop
						{
							st=st+readed.charAt(i);i++;
							k++;          //increment in k value
						}
					while(k<7) 
						{
							st=st+"0";
							k++;       //increment in k value
						}
					System.out.println(st);
					codewords = codewords+((char) binary_to_decimal(st,0));
				}
			
			   //THE SECRET STRING
			System.out.print("\nTHE CODEWORDS ARE ");
			   sleeping();
			System.out.println(codewords);
			
			   //CODEWORDS TO BINARY
			System.out.print("POINT < 8 > RECONSTRUCTING USING ENCODED.txt");    //for 8th part
			   sleeping();     //calling of sleeping function
			System.out.print("CONVERTING THIS ( "+codewords+" ) INTO (0/1 FORM)");
			   sleeping();      //calling of sleeping function
			int size_of_Arrays = codewords.length();
			int values [] = new int[size_of_Arrays];
			String strings [] = new String[size_of_Arrays];
			String plusall = new String();
			for(int w=0;w<codewords.length();w++)   //for loop
				{
					values[w]=(int) codewords.charAt(w);
					strings[w]=decimal_to_binary(values[w],"");
					if(strings[w].length()<7) 
						{
							while(strings[w].length()!=7)    //while loop
								{
									strings[w]="0"+strings[w];
								}
						}
					plusall=plusall+strings[w];
				}
			
			System.out.println(plusall+"\n");     //print 
			
			System.out.print("NOW CONVERTING FROM 0/1 TO ALPHABETS (RECONSTRUCTING)");
			  sleeping();
			System.out.print("PLZ WAIT WHILE FETCHING CHARACTERS FROM TREE");
			  sleeping();
			String finalstring = new String();
			for(int d=0;d<plusall.length() && d<estring.length();d++)    //for loop
				{
					//NOTE USE d<estring.length() IF YOU WANT TO GET SAME DATA WHICH IS WRITEN IN ORIGINAL.txt
					Data root = obj.peek();    //store peek value in root
					while((root.left == null && root.right == null) == false)    //while loop
						{
							if(plusall.charAt(d) == '1') 
								root = (root.right);
							else if(plusall.charAt(d) == '0')
								root = root.left;
							d = d+1;
						}
						d = d-1;
						   less_sleep();    //calling of less sleep function
						System.out.println(root.c);       //print
						String currenntNodeChar = String.valueOf(root.c);
						finalstring = finalstring+currenntNodeChar;
				}
			
			System.out.println("\nTHE RECONSTRUCTED STRING IS ");
			System.out.println(finalstring);     //print reconstructed string
			
			  //WRITING DATA IN RECUNSTRUCTED.TXT
			System.out.print("CONSTRUCTING THE RECONSTRUCTED.txt");
			  sleeping();
			try 
				{
					FileWriter fwriter=new FileWriter(new File("RECONSTRUCTED.txt"));
					fwriter.write(finalstring);	    //writing
					fwriter.close();
					System.out.println("\nDATA WRITTEN IN RECONSTRUCTED.TXT");
				} 
			catch (Exception e) 
				{
					e.printStackTrace();
				}
			
			  //READING DATA FROM ALL 3 FILES
			System.out.print("\nPOINT < 9 > PLZ WAIT GENERATING REPORT (TESTING)");  //for 9th part
			  sleeping();    //calling of sleeping function
			String str1=new String(),str2 = new String(),str3=new String();
			try 
				{
					BufferedReader reader = new BufferedReader(new FileReader("ORIGINAL.txt"));		
					str1 = reader.readLine();    //for reading from original.txt file
					reader.close();
					BufferedReader reader2 = new BufferedReader(new FileReader("RECONSTRUCTED.txt"));		
					str2 = reader2.readLine();     //for reading from reconstructed.txt file
					reader2.close();
					BufferedReader reader3 = new BufferedReader(new FileReader("ENCODED.txt"));		
					str3 = reader3.readLine();        //for reading from encoded.txt file
					reader3.close();
				}
			catch (IOException e) 
				{
					e.printStackTrace();
				}
			boolean equalbits = false;
			if(str1.length() == str2.length())
				equalbits = true;   //break if statement
				
			System.out.println("\nPRINTING SIZE OF BOTH FILES");
			  sleeping();    //calling of sleeping function
			     //print the length of three files
			System.out.println("ORIGINAL.txt= "+str1.length());
			System.out.println("RECONSTRUCTED.txt= "+str2.length());
			System.out.println("ENCODED.txt= "+str3.length());
			
			if(equalbits) 
				{
					boolean samechar=true;
					for(int f=0;f<str1.length();f++)    //for loop till string length
						{
							if(str1.charAt(f)!=str2.charAt(f)) 
								{
									samechar = false;   //loop breaks
								}
						}
					if(samechar) 
						{
							System.out.println("BOTH FILES TEXT MATCHED ( SAME CONTENT ) ");
							  sleeping();     //calling of sleeping function
							System.out.println("_*_*_*_TEST PASSED_*_*_*_\n\n");
						}
					else 
						{
							System.out.println("_*_*_*_TEST FAILED_*_*_*_\n\n");
						}
				}
			else     //execute if files content don't match
				{
					System.out.println("BOTH FILE CONTENTS NOT MATCHED");
					sleeping();            //calling of sleeping function
					System.out.println("_*_*_*_TEST FAILED_*_*_*_\n\n");
				}
			
			   //GOOD BYE MSG
			String goodbye="GOOD BYE THANK YOU :)";   
			for(int e=0;e<goodbye.length();e++)    //for loop
				{
					try 
					{
						for(int y=0;y<8;y++)
							Thread.sleep(1*35);
					}
					catch (InterruptedException e1)
					{
					}
					  System.out.print(goodbye.charAt(e));    
				}	
		}
	       
		   //sorting function for sort the data
	    public static Queue sort(Queue obj) 
		    {
		   	 Data [] arr = new Data[obj.size];    //array list
		   	 
		   	 for (int i = 0; i < arr.length; i++)    //for loop until the length of array
			   	 {
						arr[i]=obj.peek();
						obj.dequeue();              //calling of enqueue function
				 }
		   		
		   	 int n = arr.length;        //store length of arraylist in n 
			        Data temp = null;        //make temp null
			         for(int i=0; i < n; i++)        //for loop
				         {  
				        	 for(int j=1; j < (n-i); j++)     //for loop
					        	 {  
					                if(arr[j-1].f < arr[j].f)    //sorting algo/code
						                {  
						                	temp = arr[j-1];  
					                        arr[j-1] = arr[j];  
					                        arr[j] = temp;  
						                }             
					             }  
				         }  
			     
			       Queue obj2 = new Queue(n);    //making object of queue class
			    for (int i = 0; i < n; i++)      //for loop
				    {
						obj2.enqueue(arr[i]);
					}
			    
			    return obj2;       //return obj2
		   }
	       
	      //print function in inorder
	   static void print(Data data) 
		   { 
			   if(data == null)      //condition if data is equal to null
				   { 
						return;         //return
				   }
			   print(data.left);          //left node
				System.out.println(data.c+"  "+data.f);    //center
			   print(data.right);      //right node
			   
		   }
	   
	        //static code function 
	   static void code(Data data,String c,ArrayList<temp>arr) 
		   { 
			   if(data == null)   //condition if data is null
				   {
					   return;
				   }
			   	code(data.left,c.concat("0"),arr);    //recursively call the function
			   if(data.c!='*') 
				   {
					   System.out.println(data.c+"         |     " +c);     //display
					   arr.add(new temp(data.c,c));       //add value in arraylist
				   }
			    code(data.right,c.concat("1"),arr);      //recursively call the function
		   }
	   
	      //menu function for showing menu first on screen
	   static void menu() 
		   {
		            //display as it on screen
			   System.out.println("_*_*_*_*_PROJECT POINTS_*_*_*_*_");
			   System.out.println("< 1 > READ DATA FROM ORIGINAL.TXT");
			   System.out.println("< 2 > CALCULATE ORIGINAL SIZE IN BITS");
			   System.out.println("< 3 > UNIQUE CHARACTERS");
			   System.out.println("< 4 > FREQUENCY OF EACH CHARACTER");
			   System.out.println("< 5 > PRINT ( INORDERLY ) ");
			   System.out.println("< 6 > HULFMAN TABLE");
			   System.out.println("< 7 > STORE ENCODING IN SEPARATE FILE");
			   System.out.println("< 8 > RECONSTRUCT USING ENCODED");
			   System.out.println("< 9 > REPORT ( BONUS )\n");
		   }
	   
	       //sleeping function for waiting
	   public static void sleeping() 
		   {
				try 
					{
						for(int i=0;i<8;i++)     //for loop 
							{
								Thread.sleep(2*100);
								System.out.print(".");   //print dot and wait
							}
						System.out.println();
					} 
				catch (InterruptedException e1)
					{
					}
		   }
	   
	       //less sleep function 
	   public static void less_sleep() 
		   {
				try 
					{
						for(int i=0;i<8;i++)   //for loop
							{
								Thread.sleep(1*60);
							}
					}
				catch (InterruptedException e1)
					{
					}
		   }
	   
	       //static public function of decimal to binary
		static public String decimal_to_binary(int dec_num,String s) 
			{
		        if (dec_num > 0) 
			        {
			            s = (String.valueOf(dec_num % 2))+s;
			        	return decimal_to_binary(dec_num / 2,s);    //recursively call the function
			        }
		        return s;
		    }
	   
		   //static public function of binary to decimal 
		static public int binary_to_decimal(String binary_num,int size)
		    {
		        int n = binary_num.length();
		        if (size == n-1)
		        return binary_num.charAt(size) - '0';
		         
		        return ((binary_num.charAt(size) - '0') << (n-size-1)) +
		                binary_to_decimal(binary_num, size+1);       //recursively call the function
		    }
	   
		    //static temp class
	    static class temp
		    {
	    	       //declaration of data members
		    	char c;
		    	String s;
		    	     //parameterized constructor
		    	  temp(char c,String s)
			    	{
			    		this.c = c;
			    		this.s = s;
			    	}
		    }
}