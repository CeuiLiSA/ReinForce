package ceui.lisa.rrshare.response;


import java.util.ArrayList;
import java.util.List;

import ceui.lisa.rrshare.utils.Common;

public class Page extends BaseObject<WithBanner>{

    public List<Section> getPage(int page) {
        Common.showLog("获取第" + page + "组数据");
        List<Section> temp = new ArrayList<>();
        for (int i = 8 * (page - 1); i < 8 * page; i++) {
            if (i >= getData().getSections().size()) {
                return temp;
            }
            temp.add(getData().getSections().get(i));
        }
        return temp;
    }
}
