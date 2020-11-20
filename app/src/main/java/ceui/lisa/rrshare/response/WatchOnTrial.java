package ceui.lisa.rrshare.response;

public class WatchOnTrial {
    /**
     * fiveMinutePlayUrl : WfA5ZbpANaUTq1vIKFVIqQ6ovS9FUAXUaZDTHJ723E66MES8HDJPJcnKCdb7j7lYlznSjf1dAZwqa6Iz78dEZh+T7mJWp/rV4ehL4JG98FI3OA7pH5RsiAHoxT0H0qQUrviA97exozFmcA+G7uuc+0K2YsDit9bcqkqJlPsU5RZdiO/QrYnp1Q7mlsSiy1oPnL35YecRboL1F2I50jSecz8eV4gaL4/cB4w4IlnGEThUUdfS71J7Xya8i0aewjhYdZ2XjlrZ0xASRKCDBfrFFLBdoAbOu95r4NubQ0duzjTis/Uh0eqf/kbaa6myEXPW
     * duration : 3138
     * currentQuality : HD
     * commentRestricted : false
     */

    private String fiveMinutePlayUrl;
    private String duration;
    private String currentQuality;
    private Boolean commentRestricted;

    public String getFiveMinutePlayUrl() {
        return fiveMinutePlayUrl;
    }

    public void setFiveMinutePlayUrl(String fiveMinutePlayUrl) {
        this.fiveMinutePlayUrl = fiveMinutePlayUrl;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCurrentQuality() {
        return currentQuality;
    }

    public void setCurrentQuality(String currentQuality) {
        this.currentQuality = currentQuality;
    }

    public Boolean isCommentRestricted() {
        return commentRestricted;
    }

    public void setCommentRestricted(Boolean commentRestricted) {
        this.commentRestricted = commentRestricted;
    }
}
