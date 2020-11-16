package ceui.lisa.rrshare

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import ceui.lisa.rrshare.databinding.ActivityMainBinding
import ceui.lisa.rrshare.fragments.FragmentMine
import ceui.lisa.rrshare.fragments.FragmentMovie
import ceui.lisa.rrshare.fragments.FragmentR
import rxhttp.RxHttp

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun initLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        RxHttp.setDebug(true)
        baseBind.viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager, 0) {
            override fun getItem(position: Int): Fragment {
                return when (position) {
                    0 -> {
                        FragmentMine()
                    }
                    1 -> {
                        FragmentMine()
                    }
                    2 -> {
                        FragmentR()
                    }
                    else -> {
                        Fragment()
                    }
                }
            }

            override fun getCount(): Int {
                return 3
            }
        }
        baseBind.bottom.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_1 -> {
                    baseBind.viewPager.currentItem = 0
                }
                R.id.action_2 -> {
                    baseBind.viewPager.currentItem = 1
                }
                R.id.action_3 -> {
                    baseBind.viewPager.currentItem = 2
                }
            }
            true
        }
        baseBind.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        baseBind.bottom.selectedItemId = R.id.action_1
                    }
                    1 -> {
                        baseBind.bottom.selectedItemId = R.id.action_2
                    }
                    2 -> {
                        baseBind.bottom.selectedItemId = R.id.action_3
                    }
                }
            }
        })
    }

    override fun initData() {
    }

    override fun hideStatusBar(): Boolean {
        return true
    }
}