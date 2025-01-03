package Service;

import java.lang.reflect.Array;

public interface Login {
    String[] takeCredentials();
    boolean login(String userName, String password);
    void loginSucessMessage();
    int logInFailureMessage();
    String[] systemLogin();
}
