package ceui.lisa.rrshare.response;

import java.util.List;

public class Search {

    private List<Content> seasonList;
    private List<Content> videoList;
    private List<User> uperList;

    public List<Content> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Content> videoList) {
        this.videoList = videoList;
    }

    public List<User> getUperList() {
        return uperList;
    }

    public void setUperList(List<User> uperList) {
        this.uperList = uperList;
    }

    public List<Content> getSeasonList() {
        return seasonList;
    }

    public void setSeasonList(List<Content> seasonList) {
        this.seasonList = seasonList;
    }
}
