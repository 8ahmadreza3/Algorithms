import java.util.*;

public class Graph {
    List<Node> nodes = new LinkedList<Node>();
    static int WHITE = 0, GRAY = 1, BLACK = 2 , timer = 0;

    class Node{
        String label;
        int color;
        int d ;
        int f ;
        List<Node> neighbors = new LinkedList<Node>();
        Node parent = null ;
    }

    void BFS(Node root){
        for(Node u: nodes){
            u.parent = null ;
            u.d = Integer.MAX_VALUE ;
            u.color = WHITE ;
            Queue<Node> q = new Queue<Node>();
            System.out.println(u.label);
        }
        root.color = GRAY ;
        root.d = 0;
        q.enqueue(root) ;
        while(!q.isEmpty()){
            Node u = q.dequeue();
            for(Node v : u.neighbors){
                if(v.color == WHITE){
                    System.out.println(v.label);
                    v.parent = u ;
                    v.d = u.d + 1 ;
                    v.color = Gray ;
                    q.enqueue(v);
                }
            }
            u.color = BLACK ;
        }
    }

    void DFS(){
        for(Node u : nodes){
            u.parent = null ;
            u.d = Integet.MAX_VALUE ;
            u.color = WHITE ;
            u.f = Integer.MAX_VALUE ;
        }
        for(Node u : nodes){
            if(u.color == WHITE){
                u.color = GRAY ;
                u.d = ++timer ;
                dfs_visit(u);
            }
        }
    }

    void dfs_visit(Node u){
        for(Node v: u.neighbors){
            if(v.color == WHITE){
                v.parent = u ;
                v.d = ++timer ;
                v.color = GRAY ;
                dfs_visit(v);
            }
        }
        u.color = BLACK ;
        u.f = ++timer ;
    }
}
