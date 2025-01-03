import java.util.Scanner;

public class Volunteer extends Control{

    {
        System.out.println("1.Log in");
        System.out.println("2.New account");

    }
    {
        Scanner inputVo = new Scanner(System.in);
        int numVo = inputVo.nextInt();

        int optionVo = numVo;
        if (optionVo <= 2 && optionVo >= 1) {
            switch (optionVo) {

                case 1:

                    System.out.println("1.Request for fund to any Sponsor");
                    System.out.println("2.NGO can see the history of Sponsor ");
                    System.out.println("3.NGO can see its status of its requests ");

                    break;

                case 2:
                    System.out.println("User name: (use only string type)");
                    Scanner newaccVo = new Scanner(System.in);
                    String unameVo = newaccVo.nextLine();
                    System.out.println("Password: (use only integer type)");
                    int upassVo = newaccVo.nextInt();

                    break;

            }
        } else {
            System.out.println("Please enter a integer number from 1 to 2.");
            System.out.println("Thank you please try again.");
        }
    }

}