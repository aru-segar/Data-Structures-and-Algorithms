package tutorial07;

public class ListQueue {
    public class Node
    {
        public int data;

        public Node next;

        public Node(int d, Node n)
        {
            data = d ;
            next = n ;
        }
    }
    
    private Node first, last ;
    
    public ListQueue()
    {
        first = null ;
        last  = null ;
    }
    
    public void queue(int d)
    {
       // TODO complete code 
    }

    public int dequeue()
    {
       // TODO complete code  
    }
    
    public void clear()
    {
        // TODO complete code 
    }

    public int length()
    {
        // TODO complete code
    }

    public boolean isEmpty()
    {
        // TODO complete code        
    }    

    public String toString()
    {
        // TODO complete code
    }

    public int front()
    {
        // TODO complete code
    }

    public int last()
    {
        // TODO complete code
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}