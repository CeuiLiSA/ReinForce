package ceui.lisa.rrshare.response;

public class RepliesBean {
    /**
     * id : 1467508616784000
     * createTime : 1604305617723
     * updateTime : 1604884950118
     * createTimeStr : 11-02 16:26
     * authorName : renren_15927417497262686
     * reply2UserName : null
     * content : o w
     * liked : false
     */

    private Long id;
    private Long createTime;
    private Long updateTime;
    private String createTimeStr;
    private String authorName;
    private Object reply2UserName;
    private String content;
    private Boolean liked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Object getReply2UserName() {
        return reply2UserName;
    }

    public void setReply2UserName(Object reply2UserName) {
        this.reply2UserName = reply2UserName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean isLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }
}

