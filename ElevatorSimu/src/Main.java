import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in) ;

        System.out.print("Enter the number of customer in the simulation system : ");
        int n   = scan.nextInt() ;


        Elevator elevator  =new Elevator() ;

        for (int i = 0 ; i  < n ; i++ ) {
            elevator.addCustomer();

        }

        elevator.desc();

    }
}