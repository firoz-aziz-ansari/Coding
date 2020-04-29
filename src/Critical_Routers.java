import java.util.ArrayList;
import java.util.Iterator;

class Graph{
    private int V;
    private ArrayList<Integer> adj[];

    Graph(int n){
        V = n;
        adj = new ArrayList[n];
        for (int i=0; i<n; i++)
            adj[i] = new ArrayList<Integer>();
    }

    void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    int getNumNodes(){
        return V;
    }

    ArrayList<Integer>[] getEdge(){
        return adj;
    }

}

class Articulation{

    private Graph G;
    private boolean artP[];
    private boolean visited[];
    private int numOfNodes;
    private ArrayList<Integer> adjNodes[];
    private int disc[];
    private int low_adj_time[];
    private int parent[];
    private int time;

    Articulation(Graph g){
        G=g;
        numOfNodes=g.getNumNodes();
        adjNodes = g.getEdge();
        artP = new boolean[numOfNodes];
        visited = new boolean[numOfNodes];
        disc = new int[numOfNodes];
        low_adj_time = new int[numOfNodes];
        parent = new int[numOfNodes];
        time = 0;

        for (int i=0; i < numOfNodes; i++){
            artP[i] = false;
            visited[i] = false;
            parent[i] = -1;
        }

    }

    void find_articulate_util(int u, boolean visited[], int disc[], int low_adj_time[], int parent[], boolean artP[]){
        int child = 0;
        visited[u] = true;
        time++;
        disc[u] = time;
        low_adj_time[u] = time;

        Iterator<Integer> j = adjNodes[u].iterator();

        while (j.hasNext()){
            int v = j.next();

            if (visited[v] != true){

                child++;
                parent[v] = u;

                find_articulate_util(v, visited, disc, low_adj_time, parent, artP);

                low_adj_time[u] = Math.min(low_adj_time[u], low_adj_time[v]);

                if (parent[u] == -1 && child > 1){
                    artP[u] = true;
                }

                if (parent[u] != -1 && disc[u] < low_adj_time[v]){
                    artP[u] = true;
                }

            }

            else if (v != parent[u]){
                low_adj_time[u] = Math.min(low_adj_time[u], disc[v]);
            }

        }
    }

    boolean[] find_articulate(){
        find_articulate_util(2, visited, disc, low_adj_time, parent, artP);
        for (int i=0; i<numOfNodes; i++){
            System.out.println("Node "+i+" : "+low_adj_time[i]);
        }
        return artP;
    }


}

public class Critical_Routers {

    public static void main(String args[]){

        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 5);
        g.addEdge(5, 6);
        g.addEdge(3, 4);



        Articulation a = new Articulation(g);
        boolean articulation_points[] = a.find_articulate();
        System.out.println();
        for (int i=0; i<articulation_points.length; i++){
            if (articulation_points[i] == true){
                System.out.print(i+ " ");
            }
        }
    }
}
