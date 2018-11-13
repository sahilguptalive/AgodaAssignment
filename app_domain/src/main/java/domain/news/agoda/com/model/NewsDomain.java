package domain.news.agoda.com.model;

import java.util.List;

public class NewsDomain {

    private String status;
    private String copyright;
    private String section;
    private String lastUpdated;
    private Integer numResults;
    private List<NewsResponseDomain> results = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public List<NewsResponseDomain> getResults() {
        return results;
    }

    public void setResults(List<NewsResponseDomain> results) {
        this.results = results;
    }

}
