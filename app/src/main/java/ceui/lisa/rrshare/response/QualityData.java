package ceui.lisa.rrshare.response;

import java.util.List;

public class QualityData {

    private List<QualityItem> sortedItems;

    public List<QualityItem> getSortedItems() {
        return sortedItems;
    }

    public void setSortedItems(List<QualityItem> sortedItems) {
        this.sortedItems = sortedItems;
    }
}
