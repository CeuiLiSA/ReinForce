package ceui.lisa.rrshare.response;

import java.util.List;

public class CommentBean {

    /**
     * id : 1457743298258176
     * createTime : 1603709589981
     * updateTime : 1605075797827
     * createTimeStr : 10-26 18:53
     * type : SEASON
     * typeId : 32810
     * authorId : 58886248
     * author : {"id":58886248,"nickName":"抽风的阳阳阳","headImgUrl":"http://img.rr.tv/head/20201028/o_7ca0758307724bb9b5514f10b9d1965f.jpeg","level":10,"isConfirmed":false,"roleInfo":"normal","certLabel":null,"certNote":null,"medalList":null}
     * content : 这个女主真的爱了爱了，孤独却不孤僻，我非常喜欢她的主动，主动和别人结交，主动追求自己热爱的东西，不管是西洋棋还是好看的裙子。虽然后面沉迷药物和酒精，但是感觉她内心其实一直是清醒的，所以看着一点都不膈应。虽然这部剧还是带点套路的爽剧，但是节奏明快，故事完整。剧里她的生母表达过一个道理，不要因为别人的评价改变自己。我觉得女主做到了
     * images : []
     * reply2Id : null
     * reply2User : null
     * liked : false
     * replies : [{"id":1467508616784000,"createTime":1604305617723,"updateTime":1604884950118,"createTimeStr":"11-02 16:26","authorName":"renren_15927417497262686","reply2UserName":null,"content":"o\u2006w","liked":false},{"id":1467962815374208,"createTime":1604333339805,"updateTime":1605014584539,"createTimeStr":"11-03 00:08","authorName":"ТΚТÀ","reply2UserName":null,"content":"好看的剧总让人意犹未尽！","liked":false}]
     * floor : 255
     * likeCount : 2105
     * realLikeCount : 2105
     * replyCount : 15
     * featured : false
     * deleted : false
     * hot : true
     */

    private Long id;
    private Long createTime;
    private Long updateTime;
    private String createTimeStr;
    private String type;
    private Integer typeId;
    private Integer authorId;
    private Auth author;
    private String content;
    private Object reply2Id;
    private Object reply2User;
    private Boolean liked;
    private Integer floor;
    private Integer likeCount;
    private Integer realLikeCount;
    private Integer replyCount;
    private Boolean featured;
    private Boolean deleted;
    private Boolean hot;
    private List<RepliesBean> replies;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Auth getAuthor() {
        return author;
    }

    public void setAuthor(Auth author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Object getReply2Id() {
        return reply2Id;
    }

    public void setReply2Id(Object reply2Id) {
        this.reply2Id = reply2Id;
    }

    public Object getReply2User() {
        return reply2User;
    }

    public void setReply2User(Object reply2User) {
        this.reply2User = reply2User;
    }

    public Boolean isLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getRealLikeCount() {
        return realLikeCount;
    }

    public void setRealLikeCount(Integer realLikeCount) {
        this.realLikeCount = realLikeCount;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Boolean isFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean isHot() {
        return hot;
    }

    public void setHot(Boolean hot) {
        this.hot = hot;
    }

    public List<RepliesBean> getReplies() {
        return replies;
    }

    public void setReplies(List<RepliesBean> replies) {
        this.replies = replies;
    }
}
