package ceui.lisa.rrshare.response;

public class Recommend {

    /**
     * id : 99
     * cover : https://img.rr.tv/season/o_157803226039291.jpg
     * title : 丑女贝蒂 第三季
     * subTitle : 更新至第24集
     * cornerMarkId : 0
     * expiredTime : 1460476800000
     * score : 8
     * sneakPeekVideoId : null
     * feeMode : free
     * isMovie : false
     */

    private Integer id;
    private String cover;
    private String title;
    private String subTitle;
    private Integer cornerMarkId;
    private Long expiredTime;
    private Integer score;
    private Object sneakPeekVideoId;
    private String feeMode;
    private Boolean isMovie;
    private Integer viewCount;
    private String duration;
    private String brief;
    private Auth author;

    public Boolean getMovie() {
        return isMovie;
    }

    public void setMovie(Boolean movie) {
        isMovie = movie;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Auth getAuthor() {
        return author;
    }

    public void setAuthor(Auth author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getCornerMarkId() {
        return cornerMarkId;
    }

    public void setCornerMarkId(Integer cornerMarkId) {
        this.cornerMarkId = cornerMarkId;
    }

    public Long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Long expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Object getSneakPeekVideoId() {
        return sneakPeekVideoId;
    }

    public void setSneakPeekVideoId(Object sneakPeekVideoId) {
        this.sneakPeekVideoId = sneakPeekVideoId;
    }

    public String getFeeMode() {
        return feeMode;
    }

    public void setFeeMode(String feeMode) {
        this.feeMode = feeMode;
    }

    public Boolean isIsMovie() {
        return isMovie;
    }

    public void setIsMovie(Boolean isMovie) {
        this.isMovie = isMovie;
    }
}
