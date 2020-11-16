package ceui.lisa.rrshare.response;

import java.io.Serializable;

public class SearchRecommend implements Serializable {
    /**
     * id : 1
     * title : 九尾狐传
     * subtitle : 九尾狐和蟒蛇世纪大对决
     * label : hot
     * orderNum : 1
     * searchKeyword : 九尾狐传
     * hotRecommendId : 1
     * createTime : 2020-10-29T06:43:45.000+0000
     * updateTime : 2020-10-29T06:43:45.000+0000
     */

    private Integer id;
    private String title;
    private String subtitle;
    private String label;
    private Integer orderNum;
    private String searchKeyword;
    private Integer hotRecommendId;
    private String createTime;
    private String updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public Integer getHotRecommendId() {
        return hotRecommendId;
    }

    public void setHotRecommendId(Integer hotRecommendId) {
        this.hotRecommendId = hotRecommendId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}

