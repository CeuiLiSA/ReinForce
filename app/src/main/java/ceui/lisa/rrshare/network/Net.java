package ceui.lisa.rrshare.network;

import java.util.HashMap;

public class Net {

    public static HashMap<String, String> header() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Accept-Language", "zh-Hans-CN;q=1, en-CN;q=0.9, ja-CN;q=0.8");
        map.put("Host", "api.rr.tv");
        map.put("clientVersion", "4.14.1");
        map.put("clientType", "ios_rrsp_jzsp");
        map.put("User-Agent", "PUClient/4.14.1 (iPhone; iOS 14.1; Scale/3.00)");
        map.put("p", "iOS");
        map.put("deviceMode", "iPhone 11 Pro");
        return map;
    }


    //        RxHttp.get("http://a.zmzapi.com/index.php?g=api/v3&m=index&accesskey=519f9cab85c8059d17544947k361a827&client=2&a=hot&limit=50")
//                .addHeader("Accept-Language", "zh-CN,zh;q=0.8")
//                .addHeader("User-Agent", "Mozilla/5.0 (Linux; U; Android 6.0.1; zh-cn; D6653 Build/23.5.A.1.291) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30")
//                .addHeader("Host", "a.zmzapi.com")
//                .asClass(RankResponse.class)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<RankResponse>() {
//                    @Override
//                    public void accept(RankResponse rankResponse) {
//                        final String[] titles = new String[]{"今日", "本月", "电影", "日剧", "新剧", "总榜"};
//                        baseBind.viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager(), 0) {
//                            @NonNull
//                            @Override
//                            public Fragment getItem(int position) {
//                                return FragmentRank.newInstance(rankResponse.getList(position));
//                            }
//
//                            @Override
//                            public int getCount() {
//                                return titles.length;
//                            }
//
//                            @Nullable
//                            @Override
//                            public CharSequence getPageTitle(int position) {
//                                return titles[position];
//                            }
//                        });
//                        baseBind.tabLayout.setupWithViewPager(baseBind.viewPager);
//                    }
//                });
}
