public class Vertex<E>
{
	private E item;						//Value of the vertex
	private Vector<Vertex<E>> pointers; //Holds all Vertexes this vertex points to
	private Vector<Double> values;		//"Values" (distances, types etc.) of each connection. 
	private int timesVisited;			//Number of times "visited" by a program.  
	
	/**
	*Constructor, Creates a new Vertex with a given item
	*
	*@param E i item of the new Vertex
	*/
	public Vertex(E i)
	{
		item = i;
		pointers = new Vector<Vertex<E>>();
		values = new Vector<Double>();
		timesVisited = 0;
	}
	
	/**
	*Sets item of the vertex
	*
	*@param E i val new item of the vertex
	*/
	public void setItem(E i)
	{
		item = i;
	}
	
	/**
	*Creates a two way connection to another given vertex.  
	*Both Vertices will point to each other, and each of those 
	*connections will have the same value
	*
	*@param Vertex<E> vertex vertex being connected to this vertex
	*@param val value of new connection
	*/
	public void addConnection(Vertex<E> vertex, double  val)
	{
		pointers.add(vertex);
		values.add(val);
		vertex.addPointer(this, val);
	}
	
	/**
	*Creates a one way connection to a given pointer.  
	*Used as a helper method for addConnection().
	*
	*@param vertex vertex that this vertex will now point to
	*@param val value of the new connection
	*/
	public void addPointer(Vertex<E> vertex, double val)
	{
		pointers.add(vertex);
		values.add(val);
	}
	
	/**
	*Increments number of times Visited
	*/
	public void visit()
	{
		timesVisited++;
	}
	
	/**
	*Accessor for item
	*
	*@return This Vertex's item
	*/
	public E getItem()
	{
		return item;
	}
	
	/**
	*Accessor for timesVisited 
	*
	*@return number of times this vertex has been visited
	*/
	public int getTimesVisited()
	{
		return timesVisited;
	}
	
	/**
	*Returns List containing all vertices this Vertex points to
	*
	*@return List containing of this Vertex's pointers.
	*/
	public Vector<Vertex<E>> getPointers()
	{
		return pointers;
	}
	
	/**
	*Returns list containing all values corresponding to this Vertex's pointers
	*
	*@return List containing the values of each of this Vertex's pointes
	*/
	public Vector<Double> getValues()
	{
		return values;
	}
}