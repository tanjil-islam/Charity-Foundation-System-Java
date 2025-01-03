package ServiceImplementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

import Helper.Helper;
import Service.Account;
import Service.Login;
import Service.Startup;

public class StartupImplementation implements Startup {
    protected Helper helper;

    public StartupImplementation(Helper helper) {
        this.helper = helper;
    }

    public void showStartupOptions() {
        System.out.println("       --Welcome to Autistic Children Welfare--");
        String[] options = { "Admin", "Sponsor", "Volunteer", "Exit" };
        int chossenOption = 0;
        while (chossenOption != 4) {
            this.helper.showOption(options);
            chossenOption = this.helper.takeOptions(4);
            navigateOptions(chossenOption);
        }
    }

    @Override
    public void navigateOptions(int option) {
        Login login = new LoginImplement();
        String loggedIn;
        if (option == 1) {
            String[] options = { "Create account", "Login" };
            this.helper.showOption(options);
            int chossenOption = this.helper.takeOptions(2);
            if (chossenOption == 1) {
                Account account = new AccountImplementation();
                account.createAccount("admin");
                showStartupOptions();
            } else {
                String[] data = login.systemLogin();
                loggedIn = data[1];
                if (loggedIn.equals("admin")) {
                    adminPart();
                } else {
                    System.out.println("================================");
                    System.out.println("Permission denied");
                    System.out.println("================================");
                }

            }
        } else if (option == 2) {
            String[] options = { "Create account", "Login" };
            this.helper.showOption(options);
            int chossenOption = this.helper.takeOptions(2);
            if (chossenOption == 1) {
                Account account = new AccountImplementation();
                account.createAccount("sponsor");
                showStartupOptions();
            } else {
                String[] data = login.systemLogin();
                loggedIn = data[1];
                if (loggedIn.equals("sponsor")) {
                    sponsorPart(data[0]);
                } else {
                    System.out.println("================================");
                    System.out.println("Permission denied");
                    System.out.println("================================");
                }
            }
        } else if (option == 3) {
            String[] options = { "Create account", "Login" };
            this.helper.showOption(options);
            int chossenOption = this.helper.takeOptions(2);
            if (chossenOption == 1) {
                Account account = new AccountImplementation();
                account.createAccount("ngo");
                showStartupOptions();
            } else {
                String[] data = login.systemLogin();
                loggedIn = data[1];
                if (loggedIn.equals("ngo")) {
                    ngoPart(data[0]);
                } else {
                    System.out.println("================================");
                    System.out.println("Permission denied");
                    System.out.println("================================");
                }

            }
        }
    }

    @Override
    public void adminPart() {
        String[] options = { "See sponsonr donations", "See Volunteer's request history", "Payment to Volunteer",
                "Current balance", "Total collection", "Total Payement", "Logout" };
        int chossenOption = 0;
        while (chossenOption != 7) {
            this.helper.showOption(options);
            chossenOption = this.helper.takeOptions(7);
            if (chossenOption == 1) {
                showHistory("/Data/Donations/Donation.txt", "donation_list");
            } else if (chossenOption == 2) {
                showHistory("/Data/RequestFund/Request.txt", "donation_request");
            } else if (chossenOption == 3) {
                Scanner input = new Scanner(System.in);
                System.out.println("Please enter Volunteer name");
                String name = input.nextLine();
                Boolean check = makePayment(name);
                if (check) {
                    System.out.println("================================");
                    System.out.println("Payment successfull");
                    System.out.println("================================");
                } else {
                    System.out.println("===================================");
                    System.out.println("Something went wrong during payment");
                    System.out.println("===================================");
                }
            } else if (chossenOption == 4) {
                int currentBalance = getTotal();
                System.out.println("================================");
                System.out.println("Current Balance: " + currentBalance);
                System.out.println("================================");
            } else if (chossenOption == 5) {
                int currentDonation = getCurrentDonation();
                System.out.println("================================");
                System.out.println("Total Collection: " + currentDonation);
                System.out.println("================================");
            } else if (chossenOption == 6) {
                int currentPayment = getCurrentPayment();
                System.out.println("================================");
                System.out.println("Total Payment: " + currentPayment);
                System.out.println("================================");
            }
        }
    }

    @Override
    public void sponsorPart(String username) {
        String[] options = { "See NGO's fund request", "Donation", "Logout" };
        int chossenOption = 0;
        while (chossenOption != 3) {
            this.helper.showOption(options);
            chossenOption = this.helper.takeOptions(3);

            if (chossenOption == 1) {
                showHistory("/Data/RequestFund/Request.txt", "donation_request");
            } else if (chossenOption == 2) {
                System.out.print("Enter your donation amount: ");
                Scanner amount = new Scanner(System.in);
                int fund = amount.nextInt();
                // String check = getUserType(user);
                try {
                    FileWriter mywriter;
                    mywriter = new FileWriter(helper.filePath + "/Data/Donations/Donation.txt", true);
                    Formatter formatter = new Formatter(mywriter);
                    formatter.format("%s %s \r\n\n\n", username, fund);
                    formatter.close();
                } catch (IOException e) {
                    System.out.println("An error occured");
                    e.printStackTrace();
                }
                System.out.println("*****Thank you for your Donation*****");
            }
        }
    }

    @Override
    public void ngoPart(String username) {
        String[] options = { "Request for fund", "Logout" };
        int chossenOption = 0;
        while (chossenOption != 2) {
            this.helper.showOption(options);
            chossenOption = this.helper.takeOptions(2);
            if (chossenOption == 1) {
                System.out.print("Enter your needed fund: ");
                Scanner amount = new Scanner(System.in);
                int fund = amount.nextInt();
                try {
                    FileWriter mywriter;
                    mywriter = new FileWriter(helper.filePath + "/Data/RequestFund/Request.txt", true);
                    Formatter formatter = new Formatter(mywriter);
                    formatter.format("%s %s \r\n\n\n", username, fund);
                    formatter.close();
                } catch (IOException e) {
                    System.out.println("An error occured");
                    e.printStackTrace();
                }
            }

        }

    }

    @Override
    public void showHistory(String path, String type) {
        Helper helper = new Helper();
        File obj1 = new File(helper.filePath + path);
        try {
            Scanner scanner = new Scanner(obj1);
            if (type.equals("donation_list")) {
                System.out.println("================================");
                System.out.println("Donation List");
                System.out.println("================================");
            } else if (type.equals("donation_request")) {
                System.out.println("================================");
                System.out.println("Donation Requests");
                System.out.println("================================");
            }

            while (scanner.hasNext()) {
                String user = scanner.next();
                String amount = scanner.next();
                System.out.println("User: " + user + " Amount: " + amount);

            }
            scanner.close();
            if (type.equals("donation_list")) {
                System.out.println("================================");
                System.out.println("Donation List End");
                System.out.println("================================");
            } else if (type.equals("donation_request")) {
                System.out.println("================================");
                System.out.println("Request Historyt End");
                System.out.println("================================");
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public Boolean checkVolunteer(String name) {
        try {
            File obj1 = new File(helper.filePath + "/Data/Account/Account.txt");
            Scanner scanner = new Scanner(obj1);
            while (scanner.hasNext()) {
                String user = scanner.next();
                String pass = scanner.next();
                String type = scanner.next();

                while (user.equals(name) && type.equals("ngo")) {
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
    public int getCurrentDonation() {
        int totalAmount = 0;
        try {
            File obj1 = new File(helper.filePath + "/Data/Donations/Donation.txt");
            Scanner scanner = new Scanner(obj1);
            while (scanner.hasNext()) {
                String user = scanner.next();
                String amounStr = scanner.next();
                int amount = Integer.parseInt(amounStr);
                totalAmount += amount;
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return totalAmount;
    }

    @Override
    public int getCurrentPayment() {
        int totalAmount = 0;
        try {
            File obj1 = new File(helper.filePath + "/Data/Payment/Payment.txt");
            Scanner scanner = new Scanner(obj1);
            while (scanner.hasNext()) {
                String user = scanner.next();
                String amounStr = scanner.next();
                int amount = Integer.parseInt(amounStr);
                totalAmount += amount;
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return totalAmount;
    }

    @Override
    public int getTotal() {
        int totalDonation = getCurrentDonation();
        int totalPayment = getCurrentPayment();
        int current = totalDonation - totalPayment;
        return current;
    }

    @Override
    public Boolean makePayment(String name) {
        boolean check = checkVolunteer(name);
        Scanner input = new Scanner(System.in);
        if (check) {
            System.out.println("Please enter your amount");
            int amount = input.nextInt();
            int currentBalance = getTotal();
            if (amount > currentBalance) {
                System.out.println("You dont have enough balance");
                return false;
            } else {
                try {
                    FileWriter mywriter;
                    mywriter = new FileWriter(helper.filePath + "/Data/Payment/Payment.txt", true);
                    Formatter formatter = new Formatter(mywriter);
                    formatter.format("%s %s \r\n\n\n", name, amount);
                    formatter.close();
                } catch (Exception e) {
                    // TODO: handle exception
                }
                return true;
            }
        } else {
            System.out.println("Volunteer not found");
            return false;
        }
    }

}
