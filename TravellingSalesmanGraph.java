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
	*Finds a short route to travel to every single town via a greedy algorithm.  Returns the list of
	*towns visited in order in a string
	*
	*@param n starting town
	*@return String containing order of towns visited
	*/
	public String travel(int n)
	{
		String order = "";
		for(Vertex currVert = towns.get(n); currVert.hasUnvisitedPointers();) //This loop will run for each town visited.  Contains entire algorithm required to find and visit the next town
		{
			Vector<Integer> unvisitedPointers = new Vector<Integer>();
			
			currVert.visit();
			
			order += currVert.getItem();
			
			for(int i = 0; i < currVert.getPointers().size(); i++) //Creates vector of indices of all of the current vertex's unvisited pointers
			{
				if(((Vertex)currVert.getPointers().get(i)).getTimesVisited() == 0)
					unvisitedPointers.add(i);
			}
			
			int closestVert = 0;
			for(int i = 0; i < unvisitedPointers.size(); i++) //finds the closest unvisited vertex
			{
				if((Double)currVert.getValues().get(i) <(Double) currVert.getValues().get(closestVert));
					closestVert = i;
			}
			
			currVert =(Vertex) currVert.getPointers().get(closestVert); //sets current vertex to the closest vertex
		}
		
		return order;
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