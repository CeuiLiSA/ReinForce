package ceui.lisa.rrshare.response;

public class LoginData {

    /**
     * isNeedUpdatePwd : false
     * isNewUser : false
     * user : {"id":156351746,"createTime":1595513853000,"updateTime":1604897313000,"loginName":"19934277269#5311067880","pwd":null,"nickName":"renren_15955138531117269","mobile":"19934277269","email":"","sex":0,"birthday":"2000-01-01","city":"","intro":"","sign":"","headImgId":null,"headImgUrl":null,"bgImgId":null,"bgImgUrl":null,"level":7,"score":3820,"isConfirmed":false,"confirmInfo":"","isLock":false,"userCode":"5311067880","receiveLimit":1,"registerFrom":"9","roleInfo":"normal","salt":null,"deviceId":"329b4a66-5519-496e-8d93-0b862d2834da","field1":"","field2":"","field3":"","certLabel":null,"certNote":null}
     * token : rrtv-a89a36390bd9fc74b459c1208e9761425d8b4f33
     */

    private Boolean isNeedUpdatePwd;
    private Boolean isNewUser;
    private User user;
    private String token;

    public Boolean isIsNeedUpdatePwd() {
        return isNeedUpdatePwd;
    }

    public void setIsNeedUpdatePwd(Boolean isNeedUpdatePwd) {
        this.isNeedUpdatePwd = isNeedUpdatePwd;
    }

    public Boolean isIsNewUser() {
        return isNewUser;
    }

    public void setIsNewUser(Boolean isNewUser) {
        this.isNewUser = isNewUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
