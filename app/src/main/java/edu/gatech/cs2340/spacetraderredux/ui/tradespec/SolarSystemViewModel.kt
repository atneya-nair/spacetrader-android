package edu.gatech.cs2340.spacetraderredux.ui.tradespec
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageButton
import edu.gatech.cs2340.spacetraderredux.R
import android.widget.RelativeLayout
import android.view.ViewGroup.MarginLayoutParams
import android.view.ViewGroup
import java.util.*
import kotlin.math.min

//411 x 650


class SolarSystemViewModel : ViewModel() {
    var solarSystemArray = arrayOfNulls<ImageButton>(25)
    val minX = 50
    val minY = 100
    val maxX = 350
    val maxY = 500
    fun initPlanetLocations(context : Context, view : View) {
        var dpWidth = 15 * context.getResources().getDisplayMetrics().density
        var dpHeight = 15 * context.getResources().getDisplayMetrics().density
        val layoutParams = RelativeLayout.LayoutParams(dpWidth.toInt(), dpHeight.toInt())
        val solarSystemMap = view.findViewById<View>(R.id.solarSystemLayout) as RelativeLayout
        var rand = Random()
        for (i in 0..solarSystemArray.size - 1) {
            var posX = (rand.nextInt(maxX - minX + 1) + minX) * context.getResources().getDisplayMetrics().density
            var posY = (rand.nextInt(maxY - minY + 1) + minY) * context.getResources().getDisplayMetrics().density

            solarSystemArray[i] = ImageButton(context)
            solarSystemArray[i]?.x = posX
            solarSystemArray[i]?.y = posY
            solarSystemArray[i]?.setImageResource(R.drawable.red_dot);

            solarSystemArray[i]?.layoutParams = layoutParams
            solarSystemMap.addView(solarSystemArray[i])
        }
    }
}