package ceui.lisa.rrshare.response;


import java.util.ArrayList;
import java.util.List;

import ceui.lisa.rrshare.utils.Common;

public class Page extends BaseObject<WithBanner>{

    private static final int pageSize = 6;

    public List<Section> getPage(int page) {
        Common.showLog("获取第" + page + "组数据");
        List<Section> temp = new ArrayList<>();
        for (int i = pageSize * (page - 1); i < pageSize * page; i++) {
            if (i >= getData().getSections().size()) {
                return temp;
            }
            temp.add(getData().getSections().get(i));
        }
        return temp;
    }
}
