package ceui.lisa.rrshare.fragments;

import android.view.View;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.core.App;
import ceui.lisa.rrshare.core.Params;
import ceui.lisa.rrshare.databinding.FragmentLoginBinding;
import ceui.lisa.rrshare.network.Net;
import ceui.lisa.rrshare.network.NullCtrl;
import ceui.lisa.rrshare.response.Empty;
import ceui.lisa.rrshare.response.LoginResponse;
import ceui.lisa.rrshare.utils.Common;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import rxhttp.RxHttp;

public class FragmentLogin extends BaseFragment<FragmentLoginBinding> {

    @Override
    protected void initLayout() {
        mLayoutID = R.layout.fragment_login;
    }

    @Override
    protected void initView() {
        baseBind.getCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.getMMKV().encode(Params.USER_JSON, RESPONSE);
//                RxHttp.postForm("https://api.rr.tv/auth/captcha/sms")
//                        .addAllHeader(Net.header())
//                        .add("countryCode", "+86")
//                        .add("mobile", "19934277269")
//                        .asClass(Empty.class)
//                        .subscribeOn(Schedulers.newThread())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new NullCtrl<Empty>() {
//                            @Override
//                            public void success(Empty empty) {
//
//                            }
//                        });
            }
        });
        baseBind.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Common.showLog("我是结果：" + App.getMMKV().decodeString(Params.USER_JSON));

//                RxHttp.postForm("https://api.rr.tv/auth/login/mobile")
//                        .addAllHeader(Net.header())
//                        .add("countryCode", "+86")
//                        .add("mobile", "19934277269")
//                        .add("captchaSms", baseBind.code.getText().toString())
//                        .asString()
//                        .subscribeOn(Schedulers.newThread())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new NullCtrl<String>() {
//                            @Override
//                            public void success(String s) {
//                                App.getMMKV().encode(Params.USER_JSON, s);
//                                Common.showLog("我是登录返回 " + s);
//                            }
//                        });
            }
        });
    }

    public static final String RESPONSE = "{\"requestId\":\"c9510516198b44afa4df6438b868472b\",\"recordsTotal\":0,\"code\":\"0000\",\"msg\":\"Success\",\"data\":{\"isNeedUpdatePwd\":false,\"isNewUser\":false,\"user\":{\"id\":156351746,\"createTime\":1595513853000,\"updateTime\":1604897313000,\"loginName\":\"19934277269#5311067880\",\"pwd\":null,\"nickName\":\"renren_15955138531117269\",\"mobile\":\"19934277269\",\"email\":\"\",\"sex\":0,\"birthday\":\"2000-01-01\",\"city\":\"\",\"intro\":\"\",\"sign\":\"\",\"headImgId\":null,\"headImgUrl\":null,\"bgImgId\":null,\"bgImgUrl\":null,\"level\":7,\"score\":3820,\"isConfirmed\":false,\"confirmInfo\":\"\",\"isLock\":false,\"userCode\":\"5311067880\",\"receiveLimit\":1,\"registerFrom\":\"9\",\"roleInfo\":\"normal\",\"salt\":null,\"deviceId\":\"329b4a66-5519-496e-8d93-0b862d2834da\",\"field1\":\"\",\"field2\":\"\",\"field3\":\"\",\"certLabel\":null,\"certNote\":null},\"token\":\"rrtv-3ebb4b705b585a514a8e7831b1c0c2a841362471\"}}";
}
