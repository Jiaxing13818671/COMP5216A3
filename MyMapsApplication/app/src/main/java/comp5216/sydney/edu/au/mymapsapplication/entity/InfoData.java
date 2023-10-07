package comp5216.sydney.edu.au.mymapsapplication.entity;

import java.util.List;

public class InfoData {
    /**
     * <pre>
     * html_attributions
     * </pre>
     */
    private List<String> html_attributions;

    /**
     * <pre>
     * result
     * </pre>
     */
    private Result	result;

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

    public Result getResult() {
        return this.result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



     public class Result {

         /**
          * <pre>
          * address_components
          * </pre>
          */
         private List<Address_components> address_components;

         /**
          * <pre>
          *
          * </pre>
          */
         private String adr_address;

         /**
          * <pre>
          *
          * </pre>
          */
         private String business_status;

         /**
          * <pre>
          * current_opening_hours
          * </pre>
          */
         private Current_opening_hours current_opening_hours;

         /**
          * <pre>
          *
          * </pre>
          */
         private String formatted_address;

         /**
          * <pre>
          *
          * </pre>
          */
         private String formatted_phone_number;

         /**
          * <pre>
          * geometry
          * </pre>
          */
         private Geometry geometry;

         /**
          * <pre>
          *
          * </pre>
          */
         private String icon;

         /**
          * <pre>
          *
          * </pre>
          */
         private String icon_background_color;

         /**
          * <pre>
          *
          * </pre>
          */
         private String icon_mask_base_uri;

         /**
          * <pre>
          *
          * </pre>
          */
         private String international_phone_number;

         /**
          * <pre>
          *
          * </pre>
          */
         private String name;

         /**
          * <pre>
          * opening_hours
          * </pre>
          */
         private Opening_hours opening_hours;

         /**
          * <pre>
          * photos
          * </pre>
          */
         private List<Photos> photos;

         /**
          * <pre>
          *
          * </pre>
          */
         private String place_id;

         /**
          * <pre>
          * plus_code
          * </pre>
          */
         private Plus_code plus_code;

         /**
          * <pre>
          *
          * </pre>
          */
         private Double rating;

         /**
          * <pre>
          *
          * </pre>
          */
         private String reference;

         /**
          * <pre>
          * reviews
          * </pre>
          */
         private List<Reviews> reviews;

         /**
          * <pre>
          * types
          * </pre>
          */
         private List<String> types;

         /**
          * <pre>
          *
          * </pre>
          */
         private String url;

         /**
          * <pre>
          *
          * </pre>
          */
         private Integer user_ratings_total;

         /**
          * <pre>
          *
          * </pre>
          */
         private Integer utc_offset;

         /**
          * <pre>
          *
          * </pre>
          */
         private String vicinity;

         /**
          * <pre>
          *
          * </pre>
          */
         private String website;

         /**
          * <pre>
          *
          * </pre>
          */
         private String wheelchair_accessible_entrance;


         public List<Address_components> getAddress_components() {
             return this.address_components;
         }

         public void setAddress_components(List<Address_components> address_components) {
             this.address_components = address_components;
         }

         public String getAdr_address() {
             return this.adr_address;
         }

         public void setAdr_address(String adr_address) {
             this.adr_address = adr_address;
         }

         public String getBusiness_status() {
             return this.business_status;
         }

         public void setBusiness_status(String business_status) {
             this.business_status = business_status;
         }

         public Current_opening_hours getCurrent_opening_hours() {
             return this.current_opening_hours;
         }

         public void setCurrent_opening_hours(Current_opening_hours current_opening_hours) {
             this.current_opening_hours = current_opening_hours;
         }

         public String getFormatted_address() {
             return this.formatted_address;
         }

         public void setFormatted_address(String formatted_address) {
             this.formatted_address = formatted_address;
         }

         public String getFormatted_phone_number() {
             return this.formatted_phone_number;
         }

         public void setFormatted_phone_number(String formatted_phone_number) {
             this.formatted_phone_number = formatted_phone_number;
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

         public String getInternational_phone_number() {
             return this.international_phone_number;
         }

         public void setInternational_phone_number(String international_phone_number) {
             this.international_phone_number = international_phone_number;
         }

         public String getName() {
             return this.name;
         }

         public void setName(String name) {
             this.name = name;
         }

         public Opening_hours getOpening_hours() {
             return this.opening_hours;
         }

         public void setOpening_hours(Opening_hours opening_hours) {
             this.opening_hours = opening_hours;
         }

         public List<Photos> getPhotos() {
             return this.photos;
         }

         public void setPhotos(List<Photos> photos) {
             this.photos = photos;
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

         public Double getRating() {
             return this.rating;
         }

         public void setRating(Double rating) {
             this.rating = rating;
         }

         public String getReference() {
             return this.reference;
         }

         public void setReference(String reference) {
             this.reference = reference;
         }

         public List<Reviews> getReviews() {
             return this.reviews;
         }

         public void setReviews(List<Reviews> reviews) {
             this.reviews = reviews;
         }

         public List<String> getTypes() {
             return this.types;
         }

         public void setTypes(List<String> types) {
             this.types = types;
         }

         public String getUrl() {
             return this.url;
         }

         public void setUrl(String url) {
             this.url = url;
         }

         public Integer getUser_ratings_total() {
             return this.user_ratings_total;
         }

         public void setUser_ratings_total(Integer user_ratings_total) {
             this.user_ratings_total = user_ratings_total;
         }

         public Integer getUtc_offset() {
             return this.utc_offset;
         }

         public void setUtc_offset(Integer utc_offset) {
             this.utc_offset = utc_offset;
         }

         public String getVicinity() {
             return this.vicinity;
         }

         public void setVicinity(String vicinity) {
             this.vicinity = vicinity;
         }

         public String getWebsite() {
             return this.website;
         }

         public void setWebsite(String website) {
             this.website = website;
         }

         public String getWheelchair_accessible_entrance() {
             return this.wheelchair_accessible_entrance;
         }

         public void setWheelchair_accessible_entrance(String wheelchair_accessible_entrance) {
             this.wheelchair_accessible_entrance = wheelchair_accessible_entrance;
         }
     }

     class Reviews{

        /**
         * <pre>
         *
         * </pre>
         */
        private String	author_name;

        /**
         * <pre>
         *
         * </pre>
         */
        private String	author_url;

        /**
         * <pre>
         *
         * </pre>
         */
        private String	language;

        /**
         * <pre>
         *
         * </pre>
         */
        private String	original_language;

        /**
         * <pre>
         *
         * </pre>
         */
        private String	profile_photo_url;

        /**
         * <pre>
         *
         * </pre>
         */
        private Integer	rating;

        /**
         * <pre>
         *
         * </pre>
         */
        private String	relative_time_description;

        /**
         * <pre>
         *
         * </pre>
         */
        private String	text;

        /**
         * <pre>
         *
         * </pre>
         */
        private Integer	time;

        /**
         * <pre>
         *
         * </pre>
         */
        private String	translated;


        public String getAuthor_name() {
            return this.author_name;
        }

        public void setAuthor_name(String author_name) {
            this.author_name = author_name;
        }

        public String getAuthor_url() {
            return this.author_url;
        }

        public void setAuthor_url(String author_url) {
            this.author_url = author_url;
        }

        public String getLanguage() {
            return this.language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getOriginal_language() {
            return this.original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getProfile_photo_url() {
            return this.profile_photo_url;
        }

        public void setProfile_photo_url(String profile_photo_url) {
            this.profile_photo_url = profile_photo_url;
        }

        public Integer getRating() {
            return this.rating;
        }

        public void setRating(Integer rating) {
            this.rating = rating;
        }

        public String getRelative_time_description() {
            return this.relative_time_description;
        }

        public void setRelative_time_description(String relative_time_description) {
            this.relative_time_description = relative_time_description;
        }

        public String getText() {
            return this.text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Integer getTime() {
            return this.time;
        }

        public void setTime(Integer time) {
            this.time = time;
        }

        public String getTranslated() {
            return this.translated;
        }

        public void setTranslated(String translated) {
            this.translated = translated;
        }

    }

     class Plus_code{

        /**
         * <pre>
         *
         * </pre>
         */
        private String	compound_code;

        /**
         * <pre>
         *
         * </pre>
         */
        private String	global_code;


        public String getCompound_code() {
            return this.compound_code;
        }

        public void setCompound_code(String compound_code) {
            this.compound_code = compound_code;
        }

        public String getGlobal_code() {
            return this.global_code;
        }

        public void setGlobal_code(String global_code) {
            this.global_code = global_code;
        }

    }

     class Photos{

        /**
         * <pre>
         *
         * </pre>
         */
        private Integer	height;

        /**
         * <pre>
         * html_attributions
         * </pre>
         */
        private List<String>	html_attributions;

        /**
         * <pre>
         *
         * </pre>
         */
        private String	photo_reference;

        /**
         * <pre>
         *
         * </pre>
         */
        private Integer	width;


        public Integer getHeight() {
            return this.height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public List<String> getHtml_attributions() {
            return this.html_attributions;
        }

        public void setHtml_attributions(List<String> html_attributions) {
            this.html_attributions = html_attributions;
        }

        public String getPhoto_reference() {
            return this.photo_reference;
        }

        public void setPhoto_reference(String photo_reference) {
            this.photo_reference = photo_reference;
        }

        public Integer getWidth() {
            return this.width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

    }


     class Opening_hours{

        /**
         * <pre>
         *
         * </pre>
         */
        private String	open_now;

        /**
         * <pre>
         * periods
         * </pre>
         */
        private List<Periods>	periods;

        /**
         * <pre>
         * weekday_text
         * </pre>
         */
        private List<String>	weekday_text;


        public String getOpen_now() {
            return this.open_now;
        }

        public void setOpen_now(String open_now) {
            this.open_now = open_now;
        }

        public List<Periods> getPeriods() {
            return this.periods;
        }

        public void setPeriods(List<Periods> periods) {
            this.periods = periods;
        }

        public List<String> getWeekday_text() {
            return this.weekday_text;
        }

        public void setWeekday_text(List<String> weekday_text) {
            this.weekday_text = weekday_text;
        }

    }

    public class Periods{

        /**
         * <pre>
         * close
         * </pre>
         */
        private Close	close;

        /**
         * <pre>
         * open
         * </pre>
         */
        private Open	open;


        public Close getClose() {
            return this.close;
        }

        public void setClose(Close close) {
            this.close = close;
        }

        public Open getOpen() {
            return this.open;
        }

        public void setOpen(Open open) {
            this.open = open;
        }

    }

    public class Open{

        /**
         * <pre>
         *
         * </pre>
         */
        private Integer	day;

        /**
         * <pre>
         *
         * </pre>
         */
        private String	time;


        public Integer getDay() {
            return this.day;
        }

        public void setDay(Integer day) {
            this.day = day;
        }

        public String getTime() {
            return this.time;
        }

        public void setTime(String time) {
            this.time = time;
        }

    }
    public class Close{

        /**
         * <pre>
         *
         * </pre>
         */
        private Integer	day;

        /**
         * <pre>
         *
         * </pre>
         */
        private String	time;


        public Integer getDay() {
            return this.day;
        }

        public void setDay(Integer day) {
            this.day = day;
        }

        public String getTime() {
            return this.time;
        }

        public void setTime(String time) {
            this.time = time;
        }

    }

    public class Geometry{

        /**
         * <pre>
         * location
         * </pre>
         */
        private Location	location;

        /**
         * <pre>
         * viewport
         * </pre>
         */
        private Viewport	viewport;


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

    public class Southwest{

        /**
         * <pre>
         *
         * </pre>
         */
        private Double	lat;

        /**
         * <pre>
         *
         * </pre>
         */
        private Double	lng;


        public Double getLat() {
            return this.lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLng() {
            return this.lng;
        }

        public void setLng(Double lng) {
            this.lng = lng;
        }

    }

    public class Northeast{

        /**
         * <pre>
         *
         * </pre>
         */
        private Double	lat;

        /**
         * <pre>
         *
         * </pre>
         */
        private Double	lng;


        public Double getLat() {
            return this.lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLng() {
            return this.lng;
        }

        public void setLng(Double lng) {
            this.lng = lng;
        }

    }
    public class Location{

        /**
         * <pre>
         *
         * </pre>
         */
        private Double	lat;

        /**
         * <pre>
         *
         * </pre>
         */
        private Double	lng;


        public Double getLat() {
            return this.lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLng() {
            return this.lng;
        }

        public void setLng(Double lng) {
            this.lng = lng;
        }

    }

    public class Current_opening_hours{

        /**
         * <pre>
         *
         * </pre>
         */
        private String	open_now;

        /**
         * <pre>
         * periods
         * </pre>
         */
        private List<Periods>	periods;

        /**
         * <pre>
         * weekday_text
         * </pre>
         */
        private List<String>	weekday_text;


        public String getOpen_now() {
            return this.open_now;
        }

        public void setOpen_now(String open_now) {
            this.open_now = open_now;
        }

        public List<Periods> getPeriods() {
            return this.periods;
        }

        public void setPeriods(List<Periods> periods) {
            this.periods = periods;
        }

        public List<String> getWeekday_text() {
            return this.weekday_text;
        }

        public void setWeekday_text(List<String> weekday_text) {
            this.weekday_text = weekday_text;
        }

    }



     class Address_components{

        /**
         * <pre>
         *
         * </pre>
         */
        private String	long_name;

        /**
         * <pre>
         *
         * </pre>
         */
        private String	short_name;

        /**
         * <pre>
         * types
         * </pre>
         */
        private List<String>	types;


        public String getLong_name() {
            return this.long_name;
        }

        public void setLong_name(String long_name) {
            this.long_name = long_name;
        }

        public String getShort_name() {
            return this.short_name;
        }

        public void setShort_name(String short_name) {
            this.short_name = short_name;
        }

        public List<String> getTypes() {
            return this.types;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }

    }

}
