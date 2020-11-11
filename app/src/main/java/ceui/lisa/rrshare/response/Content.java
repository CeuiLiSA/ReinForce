package ceui.lisa.rrshare.response;

import java.io.Serializable;

public class Content implements Serializable {

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
    private double score;
    private int viewCount;
    private String duration;
    private String brief;
    private Auth author;
    private String from;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public boolean isMovie() {
        return isMovie;
    }

    public void setMovie(boolean movie) {
        isMovie = movie;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
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


    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

