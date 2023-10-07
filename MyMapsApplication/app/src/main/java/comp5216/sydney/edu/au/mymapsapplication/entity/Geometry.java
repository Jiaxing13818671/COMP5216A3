package comp5216.sydney.edu.au.mymapsapplication.entity;


/**
 * <pre>
 *  Geometry
 * </pre>
 * @author toolscat.com
 * @verison $Id: Geometry v 0.1 2023-10-06 12:13:36
 */
public class Geometry{

    /**
     * <pre>
     * location
     * </pre>
     */
    private Location location;

    /**
     * <pre>
     * viewport
     * </pre>
     */
    private Viewport viewport;


    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Viewport getViewport() {
        return this.viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

}
