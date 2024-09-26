class BellmanFord{
    List<Node> nodes = new LinkedList<Node>();
    List<Edge> edges = new LinkedList<Edge>();

    static class Node{
        int d ;
        Node parent = null ;
    }

    static class Edge {
        Node u, v;
        int weight;
        public Edge(Node src, Node dest, int weight) {
            this.u = src;
            this.v = dest;
            this.weight = weight;
        }
    }

    void initalizeSingleSource(Node s){
        for(Node u : nodes){
            u.parent = null ;
            u.d = Integet.MAX_VALUE ;
        }
        s.d = 0 ;
    }

    void relax(Edge e){
        if(e.v.d > e.u.d + e.w){
            e.v.d = e.u.d + e.w ;
            e.v.parent = e.u ;
        }
    }

    void bellmanFord(Node s){
        initalizeSingleSource(s);
        for(int i=0 ; i<nodes.size()-1 ; i++){
            for(Edge e : edges)
                relax(e);
        }
        for(Edge e: edges){
            if(e.v.d > e.u.d + e.w)
                return false ;
        }
        return true ;
    }
}