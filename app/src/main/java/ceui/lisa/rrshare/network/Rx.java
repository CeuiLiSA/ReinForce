package ceui.lisa.rrshare.network;

import ceui.lisa.rrshare.response.Comment;
import ceui.lisa.rrshare.response.QueryContent;
import ceui.lisa.rrshare.response.SearchEpisode;
import io.reactivex.rxjava3.core.Observable;
import rxhttp.RxHttp;

public class Rx {

    public static Observable<QueryContent> getRank(String type, String range, int page) {
        return RxHttp.get("https://api.rr.tv/v3plus/season/topList")
                .addAllHeader(Net.header())
                .add("area", type)
                .add("page", page)
                .add("range", range)
                .asClass(QueryContent.class);
    }

    public static Observable<Comment> getComment(String type, int typeId, int page) {
        return RxHttp.get("https://api.rr.tv/rrtv-comment/comment/mergeList")
                .addAllHeader(Net.header())
                .add("page", page)
                .add("type", type)
                .add("typeId", typeId)
                .asClass(Comment.class);
    }

    public static Observable<SearchEpisode> searchVideo(String keywords, int id, float sort) {
        if (id == 0) {
            return RxHttp.get("https://api.rr.tv/search/video")
                    .addAllHeader(Net.header())
                    .add("keywords", keywords)
                    .add("size", 20)
                    .add("sort", sort)
                    .asClass(SearchEpisode.class);
        } else {
            return RxHttp.get("https://api.rr.tv/search/video")
                    .addAllHeader(Net.header())
                    .add("keywords", keywords)
                    .add("id", id)
                    .add("size", 20)
                    .add("sort", sort)
                    .asClass(SearchEpisode.class);
        }

    }
}
