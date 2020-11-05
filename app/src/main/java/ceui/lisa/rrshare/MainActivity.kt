package ceui.lisa.rrshare

import ceui.lisa.rrshare.databinding.ActivityMainBinding
import ceui.lisa.rrshare.fragments.FragmentRankHolder

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun initLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
    }

    override fun initData() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,
                FragmentRankHolder()
            )
            .commit()
    }
}