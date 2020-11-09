package ceui.lisa.rrshare.response;

import java.util.List;

public class ContentHolder {

    private int id;
    private int commentCount;
    private String name;
    private List<Content> dataList;


    /**
     * cover : http://img.rr.tv/seasonCover/20201028/o_1603868747105.png
     * title : 灵异志
     * feeMode : free
     * isMovie : false
     * subTitle : 网飞最新恐怖6集连看！教授饱受鬼魂厄运的纠缠
     * tags : [""]
     * seasonType : USK
     * sneakPeekVideoId : null
     * year : 2020
     * cat : 剧情/惊悚/悬疑
     * area : 美国
     * score : 7.5
     * upInfo : 6
     * status : PREPARING
     */

    private Auth author;
    private String cover;
    private String createTimeStr;
    private String title;
    private String feeMode;
    private boolean isMovie;
    private String subTitle;
    private String seasonType;
    private Object sneakPeekVideoId;
    private String year;
    private String cat;
    private String area;
    private String score;
    private int upInfo;
    private String status;
    private List<String> tags;

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

    public String getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(String seasonType) {
        this.seasonType = seasonType;
    }

    public Object getSneakPeekVideoId() {
        return sneakPeekVideoId;
    }

    public void setSneakPeekVideoId(Object sneakPeekVideoId) {
        this.sneakPeekVideoId = sneakPeekVideoId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getUpInfo() {
        return upInfo;
    }

    public void setUpInfo(int upInfo) {
        this.upInfo = upInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Content> getDataList() {
        return dataList;
    }

    public void setDataList(List<Content> dataList) {
        this.dataList = dataList;
    }

    public Boolean getMovie() {
        return isMovie;
    }

    public void setMovie(Boolean movie) {
        isMovie = movie;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public Auth getAuthor() {
        return author;
    }

    public void setAuthor(Auth author) {
        this.author = author;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }
}
