package ceui.lisa.rrshare.response;

import java.util.List;

public class HotData {


    /**
     * id : 1
     * hotRecommend : 热搜
     * enabled : 1
     * orderNum : 0
     * searchRecommendDtos : [{"id":1,"title":"九尾狐传","subtitle":"九尾狐和蟒蛇世纪大对决","label":"hot","orderNum":1,"searchKeyword":"九尾狐传","hotRecommendId":1,"createTime":"2020-10-29T06:43:45.000+0000","updateTime":"2020-10-29T06:43:45.000+0000"},{"id":2,"title":"女王的棋局","subtitle":"口碑逆天年度爆款","label":"hot","orderNum":2,"searchKeyword":"女王的棋局","hotRecommendId":1,"createTime":"2020-10-29T06:43:45.000+0000","updateTime":"2020-10-29T06:43:45.000+0000"},{"id":3,"title":"处男魔法师","subtitle":"颜值在线情节沙雕","label":"hot","orderNum":3,"searchKeyword":"到了30岁还是处男 似乎会变成魔法师","hotRecommendId":1,"createTime":"2020-10-29T06:43:45.000+0000","updateTime":"2020-10-29T06:43:45.000+0000"},{"id":4,"title":"2020圣诞预热","subtitle":"纽约青春甜蜜🥰","label":"new","orderNum":4,"searchKeyword":"恋爱挑战书","hotRecommendId":1,"createTime":"2020-10-29T06:43:45.000+0000","updateTime":"2020-10-29T06:43:45.000+0000"},{"id":5,"title":"顶楼","subtitle":"更新~19🈲狗血神剧","label":"recommend","orderNum":5,"searchKeyword":"顶楼","hotRecommendId":1,"createTime":"2020-10-29T06:43:45.000+0000","updateTime":"2020-10-29T06:43:45.000+0000"},{"id":6,"title":"曼达洛人2","subtitle":"风靡全球科幻神剧回归！","label":"new","orderNum":6,"searchKeyword":"曼达洛人第二","hotRecommendId":1,"createTime":"2020-10-29T06:43:45.000+0000","updateTime":"2020-10-29T06:43:45.000+0000"},{"id":7,"title":"你的心诠释我的爱","subtitle":"超绝腐剧勾人心弦","label":"","orderNum":7,"searchKeyword":"以你的心诠释我的爱","hotRecommendId":1,"createTime":"2020-10-29T06:43:45.000+0000","updateTime":"2020-10-29T06:43:45.000+0000"},{"id":8,"title":"王子变青蛙","subtitle":"主演重聚","label":"","orderNum":8,"searchKeyword":"王子变青蛙","hotRecommendId":1,"createTime":"2020-10-29T06:43:45.000+0000","updateTime":"2020-10-29T06:43:45.000+0000"}]
     */

    private Integer id;
    private String hotRecommend;
    private String enabled;
    private Integer orderNum;
    private List<SearchRecommend> searchRecommendDtos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHotRecommend() {
        return hotRecommend;
    }

    public void setHotRecommend(String hotRecommend) {
        this.hotRecommend = hotRecommend;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public List<SearchRecommend> getSearchRecommendDtos() {
        return searchRecommendDtos;
    }

    public void setSearchRecommendDtos(List<SearchRecommend> searchRecommendDtos) {
        this.searchRecommendDtos = searchRecommendDtos;
    }

}
