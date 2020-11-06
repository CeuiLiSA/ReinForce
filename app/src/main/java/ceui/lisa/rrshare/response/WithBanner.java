package ceui.lisa.rrshare.response;

import java.util.List;

public class WithBanner {

    private List<Banner> bannerTop;
    private List<Section> sections;

    public List<Banner> getBannerTop() {
        return bannerTop;
    }

    public void setBannerTop(List<Banner> bannerTop) {
        this.bannerTop = bannerTop;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
