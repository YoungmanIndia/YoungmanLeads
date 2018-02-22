package in.co.youngman.rest;

import in.co.youngman.pojo.Answer;
import in.co.youngman.pojo.Question;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by vikasmahato on 23/02/18.
 */

public interface StackOverflowAPI {
    String BASE_URL = "https://api.stackexchange.com";

    @GET("/2.2/questions?order=desc&sort=votes&site=stackoverflow&tagged=android&filter=withbody")
    Call<ListWrapper<Question>> getQuestions();

    @GET("/2.2/questions/{id}/answers?order=desc&sort=votes&site=stackoverflow")
    Call<ListWrapper<Answer>> getAnswersForQuestion(@Path("id") String questionId);

}