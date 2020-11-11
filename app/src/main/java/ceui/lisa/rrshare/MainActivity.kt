package ceui.lisa.rrshare

import android.content.Intent
import ceui.lisa.rrshare.databinding.ActivityMainBinding
import ceui.lisa.rrshare.fragments.FragmentR
import ceui.lisa.rrshare.fragments.FragmentRNew
import rxhttp.RxHttp

class MainActivity : BaseActivity<ActivityMainBinding>() {

    var type = "CHANNEL_USK"

    override fun initLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        baseBind.toolbar.inflateMenu(R.menu.main_menu)
        baseBind.toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.action_1) {
                type = "CHANNEL_USK"
            } else if (it.itemId == R.id.action_2) {
                type = "CHANNEL_KR"
            } else if (it.itemId == R.id.action_3) {
                type = "CHANNEL_JP"
            } else if (it.itemId == R.id.action_4) {
                type = "CHANNEL_TH"
            } else if (it.itemId == R.id.action_5) {
                type = "CHANNEL_INDEX"
            }
            freshPage()
            true
        }
        RxHttp.setDebug(true)
    }

    override fun initData() {
        freshPage()
    }

    private fun freshPage() {
        baseBind.toolbar.title = getNameByType()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,
                FragmentR.newInstance(type)
            )
            .commit()
    }

    private fun getNameByType(): String {
        when (type) {
            "CHANNEL_USK" -> {
                return "美剧"
            }
            "CHANNEL_KR" -> {
                return "韩剧"
            }
            "CHANNEL_JP" -> {
                return "日剧"
            }
            "CHANNEL_TH" -> {
                return "泰剧"
            }
            "CHANNEL_INDEX" -> {
                return "精选"
            }
        }
        return "ReinForce"
    }

}