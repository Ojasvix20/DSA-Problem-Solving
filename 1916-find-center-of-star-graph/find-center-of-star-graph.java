// class Solution {
//     public int findCenter(int[][] edges) {
//         int m=edges.length;
//         int n=m+1;
//         int maxNode = 0;
//         for (int[] e : edges) {
//             maxNode = Math.max(maxNode, Math.max(e[0], e[1]));
//         }

//         List<List<Integer>> adj = new ArrayList<>();
//         for(int i=0; i<=n;i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int i=0;i<m; i++){
//             int u=edges[i][0];
//             int v=edges[i][1];
//             adj.get(u).add(v);
//             adj.get(v).add(u);

//         }
// 	    for(int i=1; i<=maxNode;i++){
// 	    	if(adj.get(i).size()==edges.length){
// 	    		return i;
// 	    	}
// 	    }
//         return -1;
//     }
// }

// ADJ MATRIX approach

// class Solution {
//     public int findCenter(int[][] edges) {

//         int n=edges.length+1;

//         int[][] adj = new int[n + 1][n + 1];

//         for (int[] e : edges) {
//             int u = e[0];
//             int v = e[1];
//             adj[u][v] = 1;
//             adj[v][u] = 1;
//         }


//         for (int i = 1; i <= n; i++) {
//             int degree = 0;
//             for (int j = 1; j <= n; j++) {
//                 degree += adj[i][j];
//             }
//             if (degree == n - 1) {
//                 return i;
//             }
//         }

//         return -1;
//     }
// }

// indegree approach

// class Solution {
//     public int findCenter(int[][] edges) {
//         int n=edges.length+1;
//         int[] degree = new int[n+1];
//         for(int i=0; i<edges.length; i++){
//             int u=edges[i][0];
//             int v=edges[i][1];

//             degree[u]++;
//             degree[v]++;
//         }
//         for(int i=1; i<=n;i++){
//             if(degree[i]==n-1){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }

// OPTIMAL APPROACH :
class Solution {
    public int findCenter(int[][] edges) {
        if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        } else {
            return edges[0][1];
        }
    }
}
