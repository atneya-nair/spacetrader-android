package edu.gatech.cs2340.spacetraderredux.ui.mappane
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.view.View
import android.widget.ImageButton
import edu.gatech.cs2340.spacetraderredux.R
import android.widget.RelativeLayout
import java.util.*

//411 x 650


class SolarSystemViewModel : ViewModel() {
    private var solarSystemArray = arrayOfNulls<ImageButton>(25)
    private val minX = 50
    private val minY = 100
    private val maxX = 350
    private val maxY = 500
    fun initPlanetLocations(context : Context, view : View) {
        val dpWidth = 15 * context.resources.displayMetrics.density
        val dpHeight = 15 * context.resources.displayMetrics.density
        val layoutParams = RelativeLayout.LayoutParams(dpWidth.toInt(), dpHeight.toInt())
        val solarSystemMap = view.findViewById<View>(R.id.solarSystemLayout) as RelativeLayout
        val rand = Random()
        for (i in 0 until solarSystemArray.size) {
            val posX = (rand.nextInt(maxX - minX + 1) + minX) *
                    context.resources.displayMetrics.density
            val posY = (rand.nextInt(maxY - minY + 1) + minY) *
                    context.resources.displayMetrics.density

            solarSystemArray[i] = ImageButton(context)
            solarSystemArray[i]?.x = posX
            solarSystemArray[i]?.y = posY
            solarSystemArray[i]?.setImageResource(R.drawable.red_dot)

            solarSystemArray[i]?.layoutParams = layoutParams
            solarSystemMap.addView(solarSystemArray[i])
        }
    }
}