package in.co.youngman.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by vikasmahato on 22/02/18.
 */

public class LeadsResponse {

    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<Leads> results;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Leads> getResults() {
        return results;
    }

    public void setResults(List<Leads> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
