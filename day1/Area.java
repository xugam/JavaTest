import java.util.Scanner;
public class Area {
    public static void main(String[] args) {
        int length =0  , width = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of Rectangle:");
        length = sc.nextInt();
        System.out.print("Enter width of Rectangle:");
        width = sc.nextInt();
        int Area = length * width;
        System.out.print("Area of Rectangle:" + Area);
    }
}
