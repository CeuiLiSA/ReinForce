package ceui.lisa.rrshare.response;

public class UserVod {
    /**
     * endTime : null
     * systemTime : 1605843708561
     * hasPrivilege : false
     */

    private Object endTime;
    private Long systemTime;
    private Boolean hasPrivilege;

    public Object getEndTime() {
        return endTime;
    }

    public void setEndTime(Object endTime) {
        this.endTime = endTime;
    }

    public Long getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(Long systemTime) {
        this.systemTime = systemTime;
    }

    public Boolean isHasPrivilege() {
        return hasPrivilege;
    }

    public void setHasPrivilege(Boolean hasPrivilege) {
        this.hasPrivilege = hasPrivilege;
    }
}
