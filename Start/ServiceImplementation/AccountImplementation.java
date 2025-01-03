package ServiceImplementation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

import Helper.Helper;
import Service.Account;

public class AccountImplementation implements Account {

    @Override
    public void createAccount(String type) {
        Helper helper = new Helper();
        Scanner input = new Scanner(System.in);
        System.out.print("\t\t\t\tEnter Your Username: ");
        String user = input.nextLine();

        System.out.println("\t\t\t\t__________________________________");
        System.out.println("\t\t\t\t__________________________________");

        System.out.print("\t\t\t\tEnter Your Password: ");
        String pass = input.nextLine();
        String check = getUserType(user);
        if (check.equals("admin") || check.equals("sponsor") || check.equals("ngo")) {
            System.out.println("\t\t\t\t*******||  Failed  ||*********");
            System.out.println("\t\t\t\t    Username Already Exist   ");
        } else {
            try {
                FileWriter mywriter;
                mywriter = new FileWriter(helper.filePath + "/Data/Account/Account.txt", true);
                Formatter formatter = new Formatter(mywriter);
                formatter.format("%s %s %s \r\n\n\n", user, pass, type);
                formatter.close();
            } catch (IOException e) {
                System.out.println("An error occured");
                e.printStackTrace();
            }
            System.out.println("\t\t\t\t*******||  CONGRATULATIONS  ||*********");
            System.out.println("\t\t\t\t    Your Registration is completed!!   ");
        }

    }

    @Override
    public String getUserType(String username) {
        Helper helper = new Helper();
        try {
            File obj1 = new File(helper.filePath + "/Data/Account/Account.txt");
            Scanner scanner = new Scanner(obj1);
            while (scanner.hasNext()) {

                String user = scanner.next();
                String pass = scanner.next();
                String type = scanner.next();

                while (username.equals(user)) {
                    return type;
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return "null";
    }

}
