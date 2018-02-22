package in.co.youngman.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vikasmahato on 23/02/18.
 */

public class Answer {
    @SerializedName("answer_id")
    public int answerId;

    @SerializedName("is_accepted")
    public boolean accepted;

    public int score;

    @Override
    public String toString() {
        return answerId + " - Score: " + score + " - Accepted: " + (accepted ? "Yes" : "No");
    }
}
