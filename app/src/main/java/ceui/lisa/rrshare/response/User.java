package ceui.lisa.rrshare.response;

public class User {


    /**
     * sort : 17.216324
     * id : 13688713
     * nickName : 越狱。。
     * headImgUrl : https://img.rr.tv/head/20180611/o_1528718868954.png
     * roleInfo : normal
     * intro :
     * certLabel : NORMAL
     * focused : false
     */

    private Double sort;
    private Integer id;
    private String nickName;
    private String headImgUrl;
    private String roleInfo;
    private String intro;
    private String certLabel;
    private Boolean focused;

    public Double getSort() {
        return sort;
    }

    public void setSort(Double sort) {
        this.sort = sort;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(String roleInfo) {
        this.roleInfo = roleInfo;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getCertLabel() {
        return certLabel;
    }

    public void setCertLabel(String certLabel) {
        this.certLabel = certLabel;
    }

    public Boolean isFocused() {
        return focused;
    }

    public void setFocused(Boolean focused) {
        this.focused = focused;
    }
}
