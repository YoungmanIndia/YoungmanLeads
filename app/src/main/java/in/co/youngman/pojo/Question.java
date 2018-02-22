package in.co.youngman.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vikasmahato on 23/02/18.
 */

public class Question {
    public String title;
    public String body;

    @SerializedName("question_id")
    public String questionId;

    @Override
    public String toString() {
        return(title);
    }
}
