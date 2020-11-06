package ceui.lisa.rrshare.response;

import java.io.Serializable;

public class Banner implements Serializable {
    /**
     * id : 4804
     * name : 良医
     * title :
     * imgUrl : http://img.rr.tv/cover/20201103/o_1604400211700.jpg
     * targetUrl : 33030
     * type : season
     * sequence : 0
     * redirectUrl : rrspjump://season?seasonId=33030&isMovie=false
     */

    private int id;
    private String name;
    private String title;
    private String imgUrl;
    private String targetUrl;
    private String type;
    private int sequence;
    private String redirectUrl;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
