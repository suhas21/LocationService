package com.example.suhas.loc

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),LocationListener {
lateinit var lmanager:LocationManager
    val a=5000
    val m=10.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            // lmanager=getSystemService()
        but1.setOnClickListener(object :  View.OnClickListener {
            override fun onClick(v: View?) {
                getLocation()
            }
        })
    }
    @SuppressLint("MissingPermission")
    fun getLocation()
    {
                lmanager= getSystemService(Context.LOCATION_SERVICE) as LocationManager
                lmanager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000L,2f, this);
    }

    override fun onLocationChanged(location: Location?) {
        details.setText("Location details \n Latitude:"+location!!.latitude+"\n Longitude:"+location!!.longitude)
    }

    override fun onProviderDisabled(provider: String?) {
        Toast.makeText(this,"Please Enable GPS and Internet",Toast.LENGTH_SHORT).show()
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

    }

    override fun onProviderEnabled(provider: String?) {

    }
}
