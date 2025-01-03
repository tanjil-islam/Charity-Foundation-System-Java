package ServiceImplementation;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import Helper.Helper;
import Service.Account;
import Service.Login;

public class LoginImplement implements Login {
    public boolean login(String username, String password) {

        Helper helper = new Helper();
        try {
            File obj1 = new File(helper.filePath + "/Data/Account/Account.txt");
            Scanner scanner = new Scanner(obj1);
            while (scanner.hasNext()) {

                String user = scanner.next();
                String pass = scanner.next();
                String type = scanner.next();

                while (username.equals(user) && password.equals(pass)) {
                    return true;
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public void loginSucessMessage() {
        System.out.println("\t\t\t\t**********************************");
        System.out.println("\t\t\t\t!!!!!!!  LOGIN SUCCESSFUL  !!!!!!!");
        System.out.println("\t\t\t\t**********************************");
        System.out.println(" \n ");
    }

    @Override
    public int logInFailureMessage() {
        System.out.println("\t\t\t	EEEEEEE   RRRRRRR    0000000  0000000  RRRRRR		");
        System.out.println("\t\t\t	EE        RR    RRR  00   00  00   00  RR   RRR		");
        System.out.println("\t\t\t	EEEEEEE   RRRRRR     00   00  00   00  RRRRRR		");
        System.out.println("\t\t\t	EE        RR   RRR   00   00  00   00  RR    RRR    ");
        System.out.println("\t\t\t	EEEEEEE   RR    RRRR 0000000  0000000  RR     RRRR	");
        System.out.println("\n");
        System.out.println("\t\t\t        !!!!!!!!!!!!!   PLEASE TRY AGAIN   !!!!!!!!!!!!!!   ");
        System.out.println("\n");
        System.out.println("1.Try again");
        System.out.println("2.Exit");
        Helper helper = new Helper();
        int option = helper.takeOptions(2);
        return option;

    }

    @Override
    public String[] takeCredentials() {
        System.out.println("***Please enter your credentials***");
        System.out.println("User name: ");
        Scanner credentialRead = new Scanner(System.in);
        String username = credentialRead.nextLine();
        System.out.println("Password: ");
        String password = credentialRead.nextLine();
        String[] credentials = { username, password };
        return credentials;
    }

    @Override
    public String[] systemLogin() {
        int tryagain = 1;
        do {
            String[] credentials = takeCredentials();
            boolean loggedIn = login(credentials[0], credentials[1]);
            if (loggedIn) {
                loginSucessMessage();
                tryagain = 0;
                Account account = new AccountImplementation();
                String[] returnArray = {credentials[0],account.getUserType(credentials[0])};
                return returnArray;
            } else {
                tryagain = logInFailureMessage();
                if (tryagain == 2) {
                    String[] returnArray = {"0","0"};
                    return returnArray;
                }
            }
        } while (tryagain != 0);
        String[] returnArray = {"0","0"};
        return returnArray;
    }
}
