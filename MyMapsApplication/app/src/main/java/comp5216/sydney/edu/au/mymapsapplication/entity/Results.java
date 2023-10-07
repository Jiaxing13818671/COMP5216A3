package comp5216.sydney.edu.au.mymapsapplication.entity;

import java.util.List;

/**
 * <pre>
 *  Results
 * </pre>
 * @author toolscat.com
 * @verison $Id: Results v 0.1 2023-10-06 12:13:36
 */
public class Results{

    /**
     * <pre>
     *
     * </pre>
     */
    private String	formatted_address;

    /**
     * <pre>
     * geometry
     * </pre>
     */
    private Geometry	geometry;

    /**
     * <pre>
     *
     * </pre>
     */
    private String	icon;

    /**
     * <pre>
     *
     * </pre>
     */
    private String	icon_background_color;

    /**
     * <pre>
     *
     * </pre>
     */
    private String	icon_mask_base_uri;

    /**
     * <pre>
     *
     * </pre>
     */
    private String	name;

    /**
     * <pre>
     *
     * </pre>
     */
    private String	place_id;

    /**
     * <pre>
     * plus_code
     * </pre>
     */
    private Plus_code	plus_code;

    /**
     * <pre>
     *
     * </pre>
     */
    private String	reference;

    /**
     * <pre>
     * types
     * </pre>
     */
    private List<String> types;


    public String getFormatted_address() {
        return this.formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public Geometry getGeometry() {
        return this.geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon_background_color() {
        return this.icon_background_color;
    }

    public void setIcon_background_color(String icon_background_color) {
        this.icon_background_color = icon_background_color;
    }

    public String getIcon_mask_base_uri() {
        return this.icon_mask_base_uri;
    }

    public void setIcon_mask_base_uri(String icon_mask_base_uri) {
        this.icon_mask_base_uri = icon_mask_base_uri;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace_id() {
        return this.place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public Plus_code getPlus_code() {
        return this.plus_code;
    }

    public void setPlus_code(Plus_code plus_code) {
        this.plus_code = plus_code;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<String> getTypes() {
        return this.types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

}
