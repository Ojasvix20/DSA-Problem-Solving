import java.util.*;
import java.io.*;

class Pair {
    int node;
    int dist;
    Pair(int n, int dist) {
        this.node = n;
        this.dist = dist;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        int m = times.length;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {

            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adj.get(u).add(new Pair(v, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            int d = top.dist;
            int u = top.node;

            if (d > distance[u]) continue;

            for (Pair nbr : adj.get(u)) {
                int v = nbr.node;
                int newD = d + nbr.dist;

                if (distance[v] > newD) {
                    distance[v] = newD;
                    pq.offer(new Pair(v, newD));
                }
            }
        }

        int ans = -1;
        for (int i = 1; i <= n; i++){
            if (distance[i] == Integer.MAX_VALUE) return -1;
            ans= Math.max(ans, distance[i]);
        }
        return ans;    
    }
}