package ceui.lisa.rrshare.response;

public class Content {

    /**
     * id : 33030
     * cover : http://img.rr.tv/seasonCover/20201016/o_1602843858453.png
     * title : 良医  第四季
     * feeMode : free
     * isMovie : false
     * subTitle : 小天使抗疫
     * cornerMarkId : null
     * expiredTime : null
     * score : 8.5
     * sneakPeekVideoId : null
     */

    private int id;
    private String cover;
    private String title;
    private String feeMode;
    private boolean isMovie;
    private String subTitle;
    private Object cornerMarkId;
    private Object expiredTime;
    private double score;
    private Object sneakPeekVideoId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getFeeMode() {
        return feeMode;
    }

    public void setFeeMode(String feeMode) {
        this.feeMode = feeMode;
    }

    public boolean isIsMovie() {
        return isMovie;
    }

    public void setIsMovie(boolean isMovie) {
        this.isMovie = isMovie;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Object getCornerMarkId() {
        return cornerMarkId;
    }

    public void setCornerMarkId(Object cornerMarkId) {
        this.cornerMarkId = cornerMarkId;
    }

    public Object getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Object expiredTime) {
        this.expiredTime = expiredTime;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Object getSneakPeekVideoId() {
        return sneakPeekVideoId;
    }

    public void setSneakPeekVideoId(Object sneakPeekVideoId) {
        this.sneakPeekVideoId = sneakPeekVideoId;
    }
}

