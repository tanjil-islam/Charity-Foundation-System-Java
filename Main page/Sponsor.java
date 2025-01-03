import java.util.Scanner;

public class Sponsor extends Control{

    {
        System.out.println("1.Log in");
        System.out.println("2.New account");

    }
    {
        Scanner inputSp = new Scanner(System.in);
        int numSp = inputSp.nextInt();

        int optionSp = numSp;
        if (optionSp <= 2 && optionSp >= 1) {
            switch (optionSp) {

                case 1:

                    System.out.println("1.View details of NGO's fund request");
                    System.out.println("2.Accept and reject the request of the NGO");

                    break;

                case 2:
                    System.out.println("User name: (use only string type)");
                    Scanner newaccSp = new Scanner(System.in);
                    String unameSp = newaccSp.nextLine();
                    System.out.println("Password: (use only integer type)");
                    int upassSp = newaccSp.nextInt();

                    break;

            }
        } else {
            System.out.println("Please enter a integer number from 1 to 2.");
            System.out.println("Thank you please try again.");
        }
    }

}