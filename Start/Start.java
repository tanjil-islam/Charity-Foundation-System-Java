import Helper.Helper;
import Service.*;
import ServiceImplementation.*;

public class Start {

	public static void main(String[] args) {
		Helper helper = new Helper();
		Login login = new LoginImplement();
		Account account = new AccountImplementation();
		Startup startup = new StartupImplementation(helper);
		startup.showStartupOptions();
	}
}