class Pair{
    int node;
    long dist;
    Pair(int node, long dist){
        this.node= node;
        this.dist= dist;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1000000007;
        int m= roads.length;
        long[] distance= new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        int[] count= new int[n];
        List<List<Pair>> adj = new ArrayList<>();
        int t=0;
        while(t++<n) adj.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        pq.offer(new Pair(0,0));
        distance[0]=0;
        count[0]=1;

        while(!pq.isEmpty()){
            Pair top = pq.poll();
            int node = top.node;
            long dist = top.dist;

            if (dist > distance[node]) continue;

            for(Pair nxt : adj.get(node)){
                long d = nxt.dist;
                int nbr= nxt.node;

                if(distance[nbr]> d+dist){
                    distance[nbr] = d+dist;
                    count[nbr]=count[node];
                    pq.add(new Pair(nbr, distance[nbr]));
                }else if ((d+dist) == distance[nbr]) {
                    count[nbr] = (count[nbr] + count[node]) % MOD;
                }
            }
        }

        return count[n-1];
    }
}