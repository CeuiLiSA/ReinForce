package ceui.lisa.rrshare.response;

import java.util.List;

public class SearchData {



        /**
         * sort : 164.15288
         * id : 4772
         * title : 越狱  第五季
         * cover : https://img.rr.tv/season/20170321/o_1490077792522.jpg
         * view_count : 68158436
         * brief : 第五季将解释迈克尔为何没死，设定是众人前去也门营救迈克尔。《越狱 Prison Break》这部9集的迷你剧是原剧剧终后几年的故事，FOX并指他们会有合理的解释为何主角没有死，而且除了主角两兄弟外，一些要角也会回归。目前有指本季设定是Fernando﹑C-Note﹑Lincoln及Sara去也门拯救假死，进了牢狱的Michael。 
         * area : 美国
         * year : 2017
         * cat : 剧情/动作/犯罪
         * score : 8.1
         * upInfo : 9
         * status : CONCLUDED
         * classify : 电视剧
         * director : 尼尔森·麦科米克
         * actor : 温特沃斯·米勒/多米尼克·珀塞尔/莎拉·韦恩·卡丽丝/马克·费厄斯坦/罗伯特·克耐普/洛克蒙·邓巴/阿莫里·诺拉斯科/斯蒂夫·莫察基斯/奥古斯图斯·珀如/尹成植/保罗·安德斯坦/阿金·加齐/因巴尔·拉维/阿明·艾尔·贾迈勒/库努尔·夏尔马/纽曼·阿卡/玛琳娜·本尼迪克特/迈克尔·本耶尔/克里斯蒂安·迈克尔·库珀
         * highlights : {"title":"<em>越狱<\/em>  第五季"}
         */

        private Double sort;
        private String id;
        private String title;
        private String cover;
        private String view_count;
        private String brief;
        private String area;
        private String year;
        private String cat;
        private String score;
        private String upInfo;
        private String status;
        private String classify;
        private String director;
        private String actor;
        private HighlightsBean highlights;

        public Double getSort() {
            return sort;
        }

        public void setSort(Double sort) {
            this.sort = sort;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getView_count() {
            return view_count;
        }

        public void setView_count(String view_count) {
            this.view_count = view_count;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getCat() {
            return cat;
        }

        public void setCat(String cat) {
            this.cat = cat;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getUpInfo() {
            return upInfo;
        }

        public void setUpInfo(String upInfo) {
            this.upInfo = upInfo;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getClassify() {
            return classify;
        }

        public void setClassify(String classify) {
            this.classify = classify;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getActor() {
            return actor;
        }

        public void setActor(String actor) {
            this.actor = actor;
        }

        public HighlightsBean getHighlights() {
            return highlights;
        }

        public void setHighlights(HighlightsBean highlights) {
            this.highlights = highlights;
        }

        public static class HighlightsBean {
            /**
             * title : <em>越狱</em>  第五季
             */

            private String title;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
}
