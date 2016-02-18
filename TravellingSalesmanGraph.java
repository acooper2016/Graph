public class TravellingSalesmanGraph
{
	private Vector<Vertex<String>> towns;
	
	/**
	*Constructs a TravellingSalesmanGraph with a certain number of towns, each with a randomly decided distance from each other.
	*
	*@param n number of towns
	*/
	public TravellingSalesmanGraph(int n)
	{
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
	
}