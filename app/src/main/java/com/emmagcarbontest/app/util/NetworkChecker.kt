package com.emmagcarbontest.app.util

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.MutableLiveData

/*** A class that helps check the network status of the device ***/

class NetworkChecker(var context: Context?): Runnable {

    companion object{
        // this live data will be true if the app can connect to a  network
        val canConnect =  MutableLiveData<Boolean>().apply {
            value = false
        }
    }

    override fun run() {
        while (true){
            if(haveNetworkConnection(context)){
                canConnect.postValue(true)
            }else{
               canConnect.postValue(false)
            }
            Log.d(NetworkChecker::class.simpleName,"Checking network health...")
            Thread.sleep(5000)
        }
    }


    /***  Returns true of the device has a network or wifi connection ***/
    private fun haveNetworkConnection(context: Context?): Boolean {
        var haveConnectedWifi = false
        var haveConnectedMobile = false
        if (context != null) {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.allNetworkInfo
            for (ni in netInfo) {
                if (ni.typeName.equals("WIFI", ignoreCase = true) && ni.isConnected) {
                    haveConnectedWifi = true
                }
                if (ni.typeName.equals("MOBILE", ignoreCase = true) && ni.isConnected) {
                    haveConnectedMobile = true
                }
            }
            return haveConnectedWifi || haveConnectedMobile
        }
        return false
    }
}