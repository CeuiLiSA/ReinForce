package ceui.lisa.rrshare.response;

import java.util.List;

public class BaseList<T> extends Base{

    private List<T> data;

    public List<T> getData() {
        return data;
    }
}
