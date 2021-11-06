import java.io.BufferedReader;
import java.io.InputStreamReader;


class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            int n = Integer.parseInt(line);
            line = br.readLine();
            String[] str = line.split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int arr[] = new int[n];
            line = br.readLine();
            String[] strs = line.trim().split(" ");

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(strs[i]);
                if (arr[i] == a)
                    arr[i] = 0;
                else if (arr[i] == b) arr[i] = 1;
            }
            System.out.println("\n\n");

            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");

            int count = 0;
            if (n > 3)
                for (int i = 1; i < n - 1; i++) {
                    if (arr[i] == arr[i - 1] || arr[i] == arr[i + 1])
                        continue;
                    else {
                        
                        count++;
                    }
                }
            System.out.println("\n" + count);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//end
}
