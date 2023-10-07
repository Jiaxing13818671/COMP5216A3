package comp5216.sydney.edu.au.mymapsapplication.entity;

/**
 * <pre>
 *  Viewport
 * </pre>
 * @author toolscat.com
 * @verison $Id: Viewport v 0.1 2023-10-06 12:13:36
 */
public class Viewport{

    /**
     * <pre>
     * northeast
     * </pre>
     */
    private Northeast	northeast;

    /**
     * <pre>
     * southwest
     * </pre>
     */
    private Southwest	southwest;


    public Northeast getNortheast() {
        return this.northeast;
    }

    public void setNortheast(Northeast northeast) {
        this.northeast = northeast;
    }

    public Southwest getSouthwest() {
        return this.southwest;
    }

    public void setSouthwest(Southwest southwest) {
        this.southwest = southwest;
    }

}
