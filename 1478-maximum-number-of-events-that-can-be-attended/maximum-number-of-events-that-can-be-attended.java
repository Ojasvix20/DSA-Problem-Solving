class Solution {
    public int maxEvents(int[][] events) {

        int n= events.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events, (a,b)->(a[0]-b[0]));
        int day=events[0][0];
        int i=0;
        int count=0;

        while(i<n || !pq.isEmpty()){

            if(pq.isEmpty()){
                day=events[i][0];
            }

            while(i<n && events[i][0]==day){
                pq.offer(events[i][1]);
                i++;
            }
            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }
            if(!pq.isEmpty()){
                pq.poll();
                count++;
            }
            day++;
        }
        return count;
    }
}