package questions.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CreateUndirectedGraphWithWeight {
    public ArrayList<EdgeUndirectedGraphWithWeight>[] create() throws IOException {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter No of Vertex");
        int vertex = scn.nextInt();
        System.out.println("Enter No of Edges");
        int edge = scn.nextInt();

        ArrayList<EdgeUndirectedGraphWithWeight>[] graph = new ArrayList[vertex];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<EdgeUndirectedGraphWithWeight>();
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int neighbor = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[source].add(new EdgeUndirectedGraphWithWeight(source, neighbor, weight));
            graph[neighbor].add(new EdgeUndirectedGraphWithWeight(neighbor, source, weight));
        }
        return graph;
    }
}
