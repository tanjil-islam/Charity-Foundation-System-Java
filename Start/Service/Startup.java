package Service;

public interface Startup {
    void showStartupOptions();
    void navigateOptions(int option);
    void adminPart();
    void sponsorPart(String username);
    void ngoPart(String username);
    void showHistory(String path, String type);
    Boolean checkVolunteer(String name);
    int getCurrentDonation();
    int getCurrentPayment();
    int getTotal();
    Boolean makePayment(String name);
}
