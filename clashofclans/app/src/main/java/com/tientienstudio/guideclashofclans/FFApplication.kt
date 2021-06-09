package com.tientienstudio.guideclashofclans

import android.app.Application
import com.appnext.base.Appnext
import com.facebook.ads.AdSettings
import com.facebook.ads.AudienceNetworkAds
import com.startapp.sdk.adsbase.StartAppAd
import com.startapp.sdk.adsbase.StartAppSDK


class FFApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AudienceNetworkAds.initialize(this)
        AdSettings.addTestDevice("e240f30e-f494-401c-b2dc-8e6f3e3cfc46")
        Appnext.init(this)
        StartAppSDK.init(this, "211921198", false)
        StartAppAd.disableSplash()
        if(BuildConfig.DEBUG){
            StartAppSDK.setTestAdsEnabled(true)
        }
        // Required initialization logic here!
    }
}