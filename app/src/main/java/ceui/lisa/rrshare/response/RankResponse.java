package ceui.lisa.rrshare.response;


import java.util.ArrayList;
import java.util.List;

public class RankResponse extends BaseObject<RankData> {

    public List<RankBean> getList(int index) {
        RankData data = getData();
        if (data == null) {
            return new ArrayList<>();
        }
        if (index == 0) {
            return data.getToday_list();
        } else if (index == 1) {
            return data.getMonth_list();
        } else if (index == 2) {
            return data.getMovie_list();
        } else if (index == 3) {
            return data.getJapan_list();
        } else if (index == 4) {
            return data.getNew_list();
        } else if (index == 5) {
            return data.getTotal_list();
        } else {
            return new ArrayList<>();
        }
    }
}
