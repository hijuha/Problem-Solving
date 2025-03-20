package Silver.p1764;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<String> noListenAndWatches = new LinkedList<>();

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            map.put(br.readLine(), 1);
        }

        for (int i = 0; i < m; ++i) {
            String str = br.readLine();

            if (map.containsKey(str)) {
               noListenAndWatches.add(str);
            }
        }

        System.out.println(noListenAndWatches.size());
        Collections.sort(noListenAndWatches);
        noListenAndWatches.forEach(System.out::println);

        br.close();
    }
}
