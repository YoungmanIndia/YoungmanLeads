package in.co.youngman;

import android.app.Application;

/**
 * Created by vikasmahato on 01/04/18.
 */

public class MyApplication extends Application {

    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}