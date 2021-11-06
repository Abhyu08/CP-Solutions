import java.io.BufferedReader;
import java.io.InputStreamReader;
/*https://www.codechef.com/IPC20D2/problems/CHGM*/
public class Codechef {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int testcases = Integer.parseInt(br.readLine());
            while (testcases-- > 0) {
                String str = br.readLine();
                String[] parts = str.trim().split(" ");
                int dishes = Integer.parseInt(parts[0]);
                int turn = -1;
                if (parts[1].equalsIgnoreCase("T"))
                    turn = 1;
                else turn = 0;
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
