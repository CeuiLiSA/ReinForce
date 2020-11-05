package ceui.lisa.rrshare.response;

import java.io.Serializable;

public class RankBean implements Serializable {

    /**
     * id : 38156
     * cnname : 黑袍纠察队
     * enname : The Boys
     * play_status : 第2季完结
     * channel : resource
     * channel_cn : 美剧
     * category : 剧情/暴力/血腥
     * area : 美国
     * poster : http://tu.jstucdn.com/ftp/2020/0904/b_5ca3422a802dbf3c789eaf69a5fa4559.png
     */

    private int id;
    private String cnname;
    private String enname;
    private String play_status;
    private String channel;
    private String channel_cn;
    private String category;
    private String area;
    private String poster;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getPlay_status() {
        return play_status;
    }

    public void setPlay_status(String play_status) {
        this.play_status = play_status;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannel_cn() {
        return channel_cn;
    }

    public void setChannel_cn(String channel_cn) {
        this.channel_cn = channel_cn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "RankBean{" +
                "id=" + id +
                ", cnname='" + cnname + '\'' +
                ", enname='" + enname + '\'' +
                ", play_status='" + play_status + '\'' +
                ", channel='" + channel + '\'' +
                ", channel_cn='" + channel_cn + '\'' +
                ", category='" + category + '\'' +
                ", area='" + area + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
