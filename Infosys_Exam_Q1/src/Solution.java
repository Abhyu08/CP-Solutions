import java.util.Scanner;
/*
 * Problem Statement

We are given a positive integer N

In one operation we choose some divisor z of N which hasn't been picked in any of the after the operation. 
before and divide N by z ie. N = N/Z after the operation.

Also, z must be of form p^k where p is a prime and k is a positive

integer. We stop the operations once N becomes 1.

Input

The first line contains an integer, N, denoting the given number

Constraints

1 <= N <= 10^9

Q1:
Sample Input

8

Sample Output

10

Explanation

Here we can first divide 8 by 2 then by 4 after which it becomes 1 so the maximum number of www.perations is 2 ie m=2 and n=8. So n+m=10 gmail.c

Q2:
Sample Input

1

Sample Output

1
Here N=1 already so we can apply no pperations, so m=0 and n=1.

Q3.
Sample Input

24

Sample Output

27

Here we can first divide N=24 by 2 Now, N=12 we can now divide N by 3 N=4 we can now divide N by 4 N=1 So the maximum
operations = 24+3 = 27
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc = new Scanner(System.in)){
			int n = sc.nextInt();
			int result = maxOperations(n);
			System.out.println(result + n);
		}
		
		
	}
	public static int maxOperations(int n) {
		int operations = 0;
		if(n == 1)
			return 0;
		else{
			int prime = 2,count=0 ;
			while(n > 1) {
				count++;
				int power = (int) Math.pow(prime, count);
				if(power <= n) {
					if( n % power ==0) {
						operations++;
						n/=power;
					}
						
				}else {
					count=0;
					for(int i=prime+1;i<1000000000;i++) {
						if( nextPrime(i) == true) {
							prime = i;
							break;
						}
					}
				}
			}
		}
		return operations;
	}
	public static boolean nextPrime(int no) {
		for(int i=2;i<=Math.sqrt(no);i++) {
			if(no%i == 0) {
				return false;
			}
		}
		return true;
	}

}
