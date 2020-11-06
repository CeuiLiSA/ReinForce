package ceui.lisa.rrshare

import ceui.lisa.rrshare.databinding.ActivityMainBinding
import ceui.lisa.rrshare.fragments.FragmentR
import rxhttp.RxHttp

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun initLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
    }

    override fun initData() {
        RxHttp.setDebug(true)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,
                    FragmentR.newInstance("CHANNEL_USK")
            )
            .commit()
    }
}