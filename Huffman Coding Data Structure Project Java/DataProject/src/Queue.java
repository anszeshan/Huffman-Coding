
class Queue {
	   //declaration of data members 
    private int front, rear, capacity;
    private Data queue[];
    int size;
 
        //parameterized constructor
	public Queue(int c)
		{
	    	front = rear = 0;
	        capacity = c;
	        this.queue=new Data[capacity];
	    }
 
	   //enqueue function 
	void enqueue(Data data)
		{
	        if (capacity == rear)   //condition check the capacity is equal to rear
		        {
		            return;
		        }
	        else 
		        {
		            queue[rear] = data;
		            rear++;                    //increment in rear
		            size++;					   //increment in size
		        }
	    }
 
	   //dequeue function
    void dequeue()
	    {
	        if (front == rear)     //condition check the front is equal to rear
		        {
		            return;        //return
		        }
	        else 
		        {
		            for (int i = 0; i < rear - 1; i++)     //for loop
			            {
			                queue[i] = queue[i + 1];
			            }
		            if (rear < capacity)     //condition check the capacity is greater than rear
		                queue[rear] = null;             
		            rear--;size--;        //decrement in rear and size
		        }
	        return;                 //return
	    }
 
       //boolean function for check the queue is full or not
    boolean isFull() 
	    {
	    	if (capacity == rear)    //condition check the capacity is equal to rear
		    	{
		    		return true;       //return true
		    	}
	    	else
	    		return false;            //return false
	    }
    
       //boolean function for check the queue is empty or not
    boolean isEmpty() 
	    {
	    	if (front == rear)       //condition check the front is equal to rear
		    	{
		    		return true;           //return true
		    	}
	    	else
	    		return false;             //return false 
	    }
 
        //peek function of Data (Class) type
    Data peek()
	    {
	        return queue[front];     //return front of queue
	    }

        //capacity function for getting capacity of queue
	public int getCapacity()
		{
			return capacity;         //return capacity of queue
		}
    
}
 