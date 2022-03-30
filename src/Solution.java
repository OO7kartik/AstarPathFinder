import java.util.List;
import java.util.Stack;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int startTime = 0;
        Stack<Integer> st = new Stack<>();

        for (String log : logs) {
            String[] parts = log.split(":");

            int fId = Integer.parseInt(parts[0]);
            int endTime = Integer.parseInt(parts[2]);

            if (parts[1].equals("start")) {
                if (st.size() != 0) {
                    res[st.peek()] += endTime - startTime + 1;
                }
                startTime = endTime;
                st.push(fId);
            } else {
                res[st.pop()] += endTime - startTime + 1;
                startTime = endTime + 1;
            }
        }

        return res;
    }
}