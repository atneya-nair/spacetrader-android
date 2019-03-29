package edu.gatech.cs2340.spacetraderredux.ui.mappane

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.Toast
import edu.gatech.cs2340.spacetraderredux.domain.SolarSystem
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerState
import edu.gatech.cs2340.spacetraderredux.ui.common.BaseActivity
import java.util.*
import edu.gatech.cs2340.spacetraderredux.R
import edu.gatech.cs2340.spacetraderredux.di.presenters.DaggerMapComponent
import edu.gatech.cs2340.spacetraderredux.ui.common.App
import edu.gatech.cs2340.spacetraderredux.ui.systempane.SystemInfoActivity


class MapActivity : BaseActivity<MapPresenter>(), MapView {

    var solarSystemArray = arrayOfNulls<ImageButton>(25)
    val minX = 50
    val minY = 100
    val maxX = 350
    val maxY = 500
    override fun getLayout(): Int = R.layout.activity_solar_system

    override fun initInjector() {
        DaggerMapComponent.builder().appComponent((application as App).applicationComponent)
                .build().inject(this)        //TODO  (create dagger modules)
    }

    override fun displaySolarSystems(solarSystems: List<SolarSystem>, playerState: PlayerState) {
        var dpWidth = 15 * getResources().getDisplayMetrics().density
        var dpHeight = 15 * getResources().getDisplayMetrics().density
        val layoutParams = RelativeLayout.LayoutParams(dpWidth.toInt(), dpHeight.toInt())
        var view = findViewById<View>(R.id.solarSystemLayout)
        val solarSystemMap = view.findViewById<View>(R.id.solarSystemLayout) as RelativeLayout
        var rand = Random()
        for (i in 0..solarSystemArray.size - 1) {
            var posX = (solarSystems[i].location.x * (300 / 150) + 50) * getResources().getDisplayMetrics().density
            var posY = (solarSystems[i].location.y * (400 / 100) + 100) * getResources().getDisplayMetrics().density

            solarSystemArray[i] = ImageButton(this)
            solarSystemArray[i]?.x = posX
            solarSystemArray[i]?.y = posY
            solarSystemArray[i]?.setImageResource(R.drawable.red_dot);
            solarSystemArray[i]?.setOnClickListener {
                presenter.onSelectSolarSystem(solarSystems[i])
            }

            solarSystemArray[i]?.layoutParams = layoutParams

            if (playerState.currSystem.equals(solarSystems[i])) {
                solarSystemArray[i]?.setImageResource(R.drawable.green_dot);
            }

            solarSystemMap.addView(solarSystemArray[i])
        }
    }

    override fun showConfirmationDialogue(solarSystem: SolarSystem, dialogue: String) {
        val alertDialog: AlertDialog? = this.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton("Travel",
                        DialogInterface.OnClickListener { dialog, id ->
                            presenter.onTravel(solarSystem)
                        })
                setNegativeButton("Cancel",
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        })
                setTitle("Travel Confirmation")
                setMessage(dialogue)
            }
            // Set other dialog properties
            // Create the AlertDialog
            builder.create()
        }
        alertDialog?.show()
    }

    override fun onSuccessfulTravel() {
        val activityChangeIntent = Intent(this, SystemInfoActivity::class.java)
        this.startActivity(activityChangeIntent)
    }

    override fun onInvalidTravel(message: String) {
        val toast = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun initialiseView() {
        presenter.onInitialise();
    }

}
