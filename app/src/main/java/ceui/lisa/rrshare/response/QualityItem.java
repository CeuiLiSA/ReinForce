package ceui.lisa.rrshare.response;

public class QualityItem {

    /**
     * qualityDescription : 高清
     * qualityCode : SD
     * canPlay : true
     * canShowVip : false
     * initialQuality : true
     */

    private String qualityDescription;
    private String qualityCode;
    private Boolean canPlay;
    private Boolean canShowVip;
    private Boolean initialQuality;

    public String getQualityDescription() {
        return qualityDescription;
    }

    public void setQualityDescription(String qualityDescription) {
        this.qualityDescription = qualityDescription;
    }

    public String getQualityCode() {
        return qualityCode;
    }

    public void setQualityCode(String qualityCode) {
        this.qualityCode = qualityCode;
    }

    public Boolean isCanPlay() {
        return canPlay;
    }

    public void setCanPlay(Boolean canPlay) {
        this.canPlay = canPlay;
    }

    public Boolean isCanShowVip() {
        return canShowVip;
    }

    public void setCanShowVip(Boolean canShowVip) {
        this.canShowVip = canShowVip;
    }

    public Boolean isInitialQuality() {
        return initialQuality;
    }

    public void setInitialQuality(Boolean initialQuality) {
        this.initialQuality = initialQuality;
    }
}
