import java.io.BufferedReader;
import java.io.InputStreamReader;


class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));
            String line = br.readLine();
            String[] str = line.split(" ");
            int n = Integer.parseInt(str[0]);
            int t = Integer.parseInt(str[1]);
            t =(int) Math.round((t-32)/1.8);
            for (int i = 0; i < n; i++) {
                int lamp_temp = Integer.parseInt(br.readLine());
                if(lamp_temp <= t)
                    System.out.println("Yes");
                else System.out.println("No");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//end
}
