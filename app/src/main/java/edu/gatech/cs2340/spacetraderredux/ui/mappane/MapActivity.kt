package edu.gatech.cs2340.spacetraderredux.ui.mappane

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.RelativeLayout
import edu.gatech.cs2340.spacetraderredux.R
import edu.gatech.cs2340.spacetraderredux.domain.SolarSystem
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerState
import edu.gatech.cs2340.spacetraderredux.ui.common.BaseActivity
import java.util.*

class MapActivity : BaseActivity<MapPresenter>(), MapView {

    var solarSystemArray = arrayOfNulls<ImageButton>(25)
    val minX = 50
    val minY = 100
    val maxX = 350
    val maxY = 500
    override fun getLayout(): Int = R.layout.activity_solar_system

    override fun initInjector() {
        //TODO  (create dagger modules)
    }

    fun displaySolarSystems(solarSystems: Array<SolarSystem>, playerState: PlayerState) {
        var dpWidth = 15 * getResources().getDisplayMetrics().density
        var dpHeight = 15 * getResources().getDisplayMetrics().density
        val layoutParams = RelativeLayout.LayoutParams(dpWidth.toInt(), dpHeight.toInt())
        var view = findViewById<View>(R.id.solarSystemLayout)
        val solarSystemMap = view.findViewById<View>(R.id.solarSystemLayout) as RelativeLayout
        var rand = Random()
        for (i in 0..solarSystemArray.size - 1) {
            var posX = solarSystems[i].location.x * getResources().getDisplayMetrics().density
            var posY = solarSystems[i].location.y * getResources().getDisplayMetrics().density

            solarSystemArray[i] = ImageButton(this)
            solarSystemArray[i]?.x = posX
            solarSystemArray[i]?.y = posY
            solarSystemArray[i]?.setImageResource(R.drawable.red_dot);
            solarSystemArray[i]?.setOnClickListener {
                val intent = Intent(this@MapActivity, SolarSystemSpecification::class.java)
                this@MapActivity.startActivity(intent)
            }

            solarSystemArray[i]?.layoutParams = layoutParams

            if (playerState.currSystem.equals(solarSystems[i])) {
                solarSystemArray[i]?.setImageResource(R.drawable.green_dot);
            }

            solarSystemMap.addView(solarSystemArray[i])
        }
    }

    override fun initialiseView() {
        presenter.onInitialise();
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solar_system)
        var viewModel = SolarSystemViewModel()
        for (i in 0..viewModel.solarSystemArray.size - 1) {
            viewModel.solarSystemArray[i]?.setOnClickListener(object : View.OnClickListener{
                override fun onClick(v: View?) {
                    val intent = Intent(this@MapActivity, SolarSystemSpecification::class.java)
                    this@MapActivity.startActivity(intent)
                }
            })
        }
    }

}
