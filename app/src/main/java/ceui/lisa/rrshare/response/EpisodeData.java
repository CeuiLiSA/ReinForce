package ceui.lisa.rrshare.response;

import java.util.List;

public class EpisodeData {


    /**
     * code : 0000
     * data : {"episodeList":[{"episodeNo":1,"id":142240,"sid":"142240","text":""},{"episodeNo":2,"id":142963,"sid":"142963","text":""},{"episodeNo":3,"id":143417,"sid":"143417","text":""},{"episodeNo":4,"id":144113,"sid":"144113","text":""},{"episodeNo":5,"id":144534,"sid":"144534","text":""}]}
     * msg : Success
     * traceId :
     */
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private List<EpisodeItem> episodeList;

    public List<EpisodeItem> getEpisodeList() {
        return episodeList;
    }

    public void setEpisodeList(List<EpisodeItem> episodeList) {
        this.episodeList = episodeList;
    }
}
