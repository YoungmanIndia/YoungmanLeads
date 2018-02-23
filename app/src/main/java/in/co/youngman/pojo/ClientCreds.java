package in.co.youngman.pojo;

/**
 * Created by vikasmahato on 23/02/18.
 */

public class ClientCreds {
    String grant_type;
    int client_id;
    String client_secret;
    String username;
    String password;

    public ClientCreds(String username, String password) {
        this.username = username;
        this.password = password;
        this.grant_type = "password";
        this.client_id = 4;
        this.client_secret = "HLPi4ear3rk2gXKzDQdOK4Bf5pdwgTlXdU8sXlci";
    }
}
