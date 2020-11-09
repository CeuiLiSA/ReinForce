package ceui.lisa.rrshare.network;

import java.util.HashMap;

public class Net {

    public static HashMap<String, String> header() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Host", "api.rr.tv");
        map.put("aliId", "Xxmbyp+5KgADAIkYL55U4kvT");
        map.put("p", "iOS");
        map.put("st", "57d90270dcf232ee4bf4ef78c1531678");
        map.put("deviceMode", "iPhone 11 Pro");
        map.put("Accept", "*/*");
        map.put("Accept-Language", "zh-Hans-CN;q=1, en-CN;q=0.9, ja-CN;q=0.8");
        map.put("clientVersion", "4.15.1");
        map.put("token", "rrtv-b2228b19a37039db54172e9648c02a5dab579c88");
//        map.put("Accept-Encoding", "gzip, deflate, br");
        map.put("deviceId", "329b4a66-5519-496e-8d93-0b862d2834da");
        map.put("clientType", "ios_rrsp_jzsp");
        map.put("sm", "202007232216462b03e33869e590cc5f39035f025d60d50139041ac4c6cf2b");
        map.put("User-Agent", "PUClient/4.15.1 (iPhone; iOS 14.2; Scale/3.00)");
        map.put("t", String.valueOf(System.currentTimeMillis()));
        map.put("Cookie", "JSESSIONID=03E66F3E9CEBE8BAF5A7679C0B513B86; Hm_lvt_d26b601003e5eb802e089dd9c0c41e35=1604568447");
        map.put("sign", "584fa37056cbc5a2b5fa853dc57c674d");
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
