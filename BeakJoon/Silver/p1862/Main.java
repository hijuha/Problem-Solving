package Silver.p1862;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        int result = 0 ;

        for (int i = 0; i < n.length(); ++i) {
            result = result * 9 + toDigit(n.charAt(i) - '0');
        }

        System.out.println(result);
        br.close();
    }

    public static int toDigit(int num) {
        if (num < 4)
            return num;

        return num - 1;
    }
}
