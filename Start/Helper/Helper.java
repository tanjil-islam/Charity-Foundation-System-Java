package Helper;

import java.util.Scanner;

public class Helper {

    public String filePath = "G:/java/FinalProject/Start";

    public int takeOptions(int limit) {
        int option = 0;
        do {try {
            System.out.println("Please choose an option");
            Scanner input = new Scanner(System.in);
            option = input.nextInt();
        } catch (Exception e) {
            System.out.println("You have entered wrong value");
        }
            
        } while (option > limit || option < 1);

        return option;
            
    }

    public void showOption(String[] options)
    {
        for(int i=0; i<options.length; i++)
        {
            System.out.println(i+1 +"."+options[i]);
        }
    }

}
