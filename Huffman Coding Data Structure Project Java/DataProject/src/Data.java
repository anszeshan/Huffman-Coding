
public class Data {

	    //declaration of data members 
	char c;
	int f;
	
	Data left,right;     //for left and right node 
	
	   //parameterized constructor
	Data(char c, int f, Data left, Data right)
		{
			this.c = c;
			this.f = f;
			this.left = left;
			this.right = right;
		}
	
	   //default constructor
	Data()
		{	
		}
}