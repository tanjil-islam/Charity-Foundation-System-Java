import java.util.Scanner;

public class Control

{
    {
        System.out.println("            --Welcome to Autistic Children Welfare--");
        System.out.println();
    }

    {
        System.out.println("1.Admin");
        System.out.println("2.Sponsor");
        System.out.println("3.Volunteer");
    }
    {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        int option = num;
        if (option <= 3 && option >= 1) {
            switch (option) {

                case 1:
                    System.out.println("1.Admin");
                    //Admin admin = new Admin("admin", 1234);
                    break;

                case 2:
                    System.out.println("2.sponsor");
                    Sponsor sponsor = new Sponsor();
                    break;

                case 3:
                    System.out.println("3.volunteer");
                    Volunteer volunteer = new Volunteer();
                    break;
                default: {
                    System.out.println("Hi");
                }
            }

        } else {
            System.out.println("Please enter a integer number from 1 to 3.");
            System.out.println("Thank you please try again.");
        }

    }

}