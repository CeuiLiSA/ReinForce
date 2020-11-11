package ceui.lisa.rrshare.response;

import android.text.TextUtils;

import java.io.Serializable;

public class Auth implements Serializable {

    /**
     * id : 597119
     * cover : https://img.rr.tv/head/20160618/o_1466264011590.jpg
     * name : 妙看影视miaojiezi
     */

    private int id;
    private String cover;
    private String name;
    private String nickName;
    private String headImgUrl;
    private String level;
    private float score;
    private String roleInfo;
    private String sign;
    private String intro;
    private int seasonCount;
    private boolean focused;
    private boolean isConfirmed;

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImgUrl() {
        if (!TextUtils.isEmpty(headImgUrl)) {
            return headImgUrl;
        } else {
            return "http://tp3.sinaimg.cn/2231318522/180/5746319964/1";
        }
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(String roleInfo) {
        this.roleInfo = roleInfo;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getSeasonCount() {
        return seasonCount;
    }

    public void setSeasonCount(int seasonCount) {
        this.seasonCount = seasonCount;
    }

    public boolean isFocused() {
        return focused;
    }

    public void setFocused(boolean focused) {
        this.focused = focused;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
