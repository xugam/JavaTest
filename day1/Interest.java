import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double principal, rate, time;
        System.out.print("Enter the principal amout: ");
         principal = sc.nextInt();
         System.out.print("Enter the rate: ");
         rate = sc.nextInt();
         System.out.print("Enter the time: ");
         time = sc.nextInt();
        double interest = (principal*rate*time)/100;
        System.out.println("The interest is: "+interest);
    }
}
