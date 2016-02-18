import java.util.Vector;

public class TravellingSalesmanGraph
{
	private Vector<Vertex<String>> towns;
	
	/**
	*Constructs a TravellingSalesmanGraph with a certain number of towns, each with a randomly decided distance from each other.
	*
	*@param int n number of towns
	*/
	public TravellingSalesmanGraph(int n)
	{
		towns = new Vector<Vertex<String>>();

		for(int i = 0; i < n; i++)
		{
			Vertex vert = new Vertex<String>(Integer.toString(i + 1));
						
			towns.add(vert);
			
			for(int j = 0; j < i; j++) //Adds from the new vertex to every existing vertex 
			{	
				vert.addConnection(towns.get(j), Math.random() * 100.0);
			}
		}
	}
	
	
	/**
	*Returns a string representation of the Current Graph.  
	*Lists each vertex in the graph, along with each of the graph's pointers.
	*
	*@return String representation of the graph
	*/
	public String toString()
	{
		String map = "";
		for(int i = 0; i < towns.size(); i++)
		{
			Vertex t = towns.get(i);
			String town = t.getItem().toString();
			map += town;
			map += ",";
			map += "\n";
		}
		return map;
	}
	
}