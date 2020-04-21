package dev.falcer.onboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Adapter
    private val adapter = MainAdapter()

    private val pagers = listOf(
        OnBoard(
            "OnBoard 1",
            "Lorem ipsum dolor sit amet,\nconsectetur adipiscing elit.",
            0,
            100,
            false
        ),
        OnBoard(
            "OnBoard 2",
            "In turpis enim, feugiat pharetra arcu ut,\ncongue commodo risus.",
            100,
            191
        ),
        OnBoard(
            "OnBoard 3",
            "Suspendisse lobortis\nac lectus id venenatis.",
            191,
            300
        )
    )

    private var currentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        setContentView(R.layout.activity_main)
        lav_onBoard.frame = pagers[0].endAnimateFrom!!
        setupVP()
        setupWDI()
    }

    private fun setupVP() {
        adapter.setData(pagers)
        vp_onBoard.adapter = adapter
        vp_onBoard.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when {
                    position < currentPage && position < 1 -> {
                        lav_onBoard.setMinFrame(pagers[0].startAnimateFrom!!)
                        lav_onBoard.setMaxFrame(pagers[0].endAnimateFrom!!)
                        lav_onBoard.speed = 1f
                        lav_onBoard.playAnimation()
                    }
                    position in 1 until currentPage -> {
                        lav_onBoard.setMinFrame(pagers[currentPage].startAnimateFrom!!)
                        lav_onBoard.setMaxFrame(pagers[currentPage].endAnimateFrom!!)
                        lav_onBoard.speed = -1f
                        lav_onBoard.playAnimation()
                    }
                    position > currentPage -> {
                        lav_onBoard.setMinFrame(pagers[position].startAnimateFrom!!)
                        lav_onBoard.setMaxFrame(pagers[position].endAnimateFrom!!)
                        lav_onBoard.speed = 1f
                        lav_onBoard.playAnimation()
                    }
                }
                currentPage = position
            }
        })
    }

    private fun setupWDI() {
        wdi_onBoard.setViewPager2(vp_onBoard)
    }
}
