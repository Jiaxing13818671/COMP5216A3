package comp5216.sydney.edu.au.mymapsapplication.entity;

import java.util.List;

/**
 * <pre>
 *  Root
 * </pre>
 * @author toolscat.com
 * @verison $Id: Root v 0.1 2023-10-06 12:13:36
 */
public class Root{

    /**
     * <pre>
     * html_attributions
     * </pre>
     */
    private List<String> html_attributions;

    /**
     * <pre>
     * results
     * </pre>
     */
    private List<Results>	results;

    /**
     * <pre>
     *
     * </pre>
     */
    private String	status;


    public List<String> getHtml_attributions() {
        return this.html_attributions;
    }

    public void setHtml_attributions(List<String> html_attributions) {
        this.html_attributions = html_attributions;
    }

    public List<Results> getResults() {
        return this.results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
