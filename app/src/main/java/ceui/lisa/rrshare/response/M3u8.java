package ceui.lisa.rrshare.response;

public class M3u8 {

    /**
     * url : KHeejFFWwzGi/8zHF0ZE29K6yAumulKdhRCehWADm70SMIYEJEq50aoWM12/nlwvoenq1GJBf3bDW8OZ0YyMNMie4lMtKTM7lh7BOxTHNnSgMVq5rFEQrT5j6JFj/XnZTKYQEIo17llRGHISpbUhOmVDRJ/phFi2jfb6FBuGw4Y6/kXoqVcvOm4W12Lhkr7k7Dy4LXL7QWczsyp212SwKL6L2lITtvTbT9aYmfXeXTzJMPY9Ms2pOMLwmsaN8UxbM6cCNHbKY3bwkA7WW0R8nV8cVR2mHKtf8vkH6sUmxpMMnpUWj14P1ct84T3+tIsXFUaikYFY4CRufmujr4+YtD1pJca8bUY0P3SVv0WzLzY=
     * currentQuality : HD
     * size : 0
     * header : null
     * cacheSize : 5120
     * externalAds : true
     * commentRestricted : true
     * startingLength : 0
     * openingLength : 0
     * parseTime : 2020-11-09 11:31:42 +5650
     */

    private String url;
    private String currentQuality;
    private String size;
    private Object header;
    private Integer cacheSize;
    private Boolean externalAds;
    private Boolean commentRestricted;
    private Integer startingLength;
    private Integer openingLength;
    private String parseTime;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCurrentQuality() {
        return currentQuality;
    }

    public void setCurrentQuality(String currentQuality) {
        this.currentQuality = currentQuality;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Object getHeader() {
        return header;
    }

    public void setHeader(Object header) {
        this.header = header;
    }

    public Integer getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(Integer cacheSize) {
        this.cacheSize = cacheSize;
    }

    public Boolean isExternalAds() {
        return externalAds;
    }

    public void setExternalAds(Boolean externalAds) {
        this.externalAds = externalAds;
    }

    public Boolean isCommentRestricted() {
        return commentRestricted;
    }

    public void setCommentRestricted(Boolean commentRestricted) {
        this.commentRestricted = commentRestricted;
    }

    public Integer getStartingLength() {
        return startingLength;
    }

    public void setStartingLength(Integer startingLength) {
        this.startingLength = startingLength;
    }

    public Integer getOpeningLength() {
        return openingLength;
    }

    public void setOpeningLength(Integer openingLength) {
        this.openingLength = openingLength;
    }

    public String getParseTime() {
        return parseTime;
    }

    public void setParseTime(String parseTime) {
        this.parseTime = parseTime;
    }
}
