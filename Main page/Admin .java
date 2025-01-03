import java.util.*;
import java.util.Scanner;

public class Admin extends Control {

    // public String username;
    // public int password;

    // public Admin(String u, int p) {
    //     this.username = u;
    //     this.password = p;
    // }

    {
        System.out.println("1.Log in");
        System.out.println("2.New account");

    }
    {
        Scanner inputAd = new Scanner(System.in);
        int numAd = inputAd.nextInt();

        int optionAd = numAd;
        if (optionAd <= 2 && optionAd >= 1) {
            switch (optionAd) {

                case 1: {
                    // final String username = "admin";
                    // final int password = 1234;

                    System.out.println("Enter your user name: ");
                    Scanner logaccAd = new Scanner(System.in);
                    String nameAd = logaccAd.nextLine();

                    System.out.println("Enter your password: ");
                    int passAd = logaccAd.nextInt();

                    if (username == nameAd && password == passAd) {
                        System.out.println("1.Admin can view all history of Sponsor and NGO");
                        System.out.println("2.Admin can manage the profile of NGO's and Sponsor's ");
                        System.out.println("3.Verify and approve or reject profile of NGO's and Sponsor's ");

                    }
                }
                    break;

                case 2:
                    System.out.println("User name: (use only string type)");
                    Scanner newaccAd = new Scanner(System.in);
                    String unameAd = newaccAd.nextLine();
                    System.out.println("Password: (use only integer type)");
                    int upassAd = newaccAd.nextInt();

                    break;

            }
        } else {
            System.out.println("Please enter a integer number from 1 to 2.");
            System.out.println("Thank you please try again.");
        }
    }

}