package com.tientienstudio.guideclashofclans

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.appnext.ads.interstitial.Interstitial
import com.appnext.banners.BannerAdRequest
import com.appnext.banners.BannerListener
import com.appnext.banners.BannerView
import com.appnext.core.AppnextAdCreativeType
import com.appnext.core.AppnextError
import com.appnext.core.callbacks.*
import com.facebook.ads.*
import com.tientienstudio.guideclashofclans.model.Main
import com.mopub.common.MoPub
import com.mopub.common.SdkConfiguration
import com.mopub.common.SdkInitializationListener
import com.mopub.common.logging.MoPubLog
import com.mopub.mobileads.MoPubErrorCode
import com.mopub.mobileads.MoPubInterstitial
import com.mopub.mobileads.MoPubView
import com.startapp.sdk.ads.banner.Banner
import com.startapp.sdk.adsbase.StartAppAd
import com.startapp.sdk.adsbase.adlisteners.AdEventListener
import com.unity3d.ads.IUnityAdsLoadListener
import com.unity3d.ads.UnityAds
import com.unity3d.services.banners.BannerErrorInfo
import com.unity3d.services.banners.UnityBannerSize
import kotlin.random.Random


abstract class ForNKBoActivity : AppCompatActivity() {
    protected lateinit var main: Main
    private var adView: AdView? = null
    private var adViewAN: BannerView? = null
    private var interstitialAd: InterstitialAd? = null
    private var interstitialAdAN: Interstitial? = null
    private var startAppAd: StartAppAd? = null

    private var bannerListener: UnityBannerListener = UnityBannerListener()
    private var bottomBanner: com.unity3d.services.banners.BannerView? = null
    private var bottomBannerView: RelativeLayout? = null
    private var banner: Banner? = null
    private var moPubView: MoPubView? = null
    private var mInterstitial: MoPubInterstitial? = null
    private var mopInsId: String? = null

    abstract fun getTag(): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = intent.getSerializableExtra("MAIN") as Main
    }

    private fun initSdkBannerListener(bannerId: String): SdkInitializationListener? {
        return SdkInitializationListener {
            Log.d(getTag(), "Mopub Check if you should show the consent dialog here, and make your ad requests!")
            moPubView = findViewById(R.id.mopBanner)
            moPubView!!.visibility = View.VISIBLE
            moPubView!!.setAdUnitId(bannerId)
            moPubView!!.bannerAdListener = object: MoPubView.BannerAdListener {
                override fun onBannerLoaded(banner: MoPubView) {
                    Log.d(getTag(), "Mopub Banner ad is loaded and ready to be displayed!")
                }

                override fun onBannerFailed(banner: MoPubView?, errorCode: MoPubErrorCode?) {
                    Log.e(getTag(), "Mopub Banner ad failed to load: $errorCode")
                }

                override fun onBannerClicked(banner: MoPubView?) {
                    Log.d(getTag(), "Mopub Banner ad clicked!")
                }

                override fun onBannerExpanded(banner: MoPubView?) {
                    Log.d(getTag(), "Mopub Banner ad expanded!")
                }

                override fun onBannerCollapsed(banner: MoPubView?) {
                    Log.d(getTag(), "Mopub Banner ad collapsed!")
                }

            }
            moPubView!!.loadAd()

            if(!mopInsId.isNullOrEmpty()){
                mInterstitial = MoPubInterstitial(this, mopInsId!!)
                mInterstitial!!.interstitialAdListener = object : MoPubInterstitial.InterstitialAdListener {
                    override fun onInterstitialLoaded(interstitial: MoPubInterstitial?) {
                        Log.d(
                            getTag(),
                            "Mopub Interstitial ad is loaded and ready to be displayed!"
                        )
                    }

                    override fun onInterstitialFailed(
                        interstitial: MoPubInterstitial?,
                        errorCode: MoPubErrorCode?
                    ) {
                        Log.e(getTag(), "Mopub Interstitial ad failed to load: $errorCode")
                    }

                    override fun onInterstitialShown(interstitial: MoPubInterstitial?) {
                        Log.e(getTag(), "Mopub Interstitial ad shown")
                    }

                    override fun onInterstitialClicked(interstitial: MoPubInterstitial?) {
                        Log.e(getTag(), "Mopub Interstitial ad clicked")
                    }

                    override fun onInterstitialDismissed(interstitial: MoPubInterstitial?) {
                        Log.e(getTag(), "Mopub Interstitial ad dismissed")
                        mInterstitial!!.load()
                    }
                }
                mInterstitial!!.load()
            }
        }
    }

    protected fun loadBannerMop(bannerId: String?){
        try {
            if(!bannerId.isNullOrEmpty()) {
                val configBuilder = SdkConfiguration.Builder(bannerId)
                if (BuildConfig.DEBUG) {
                    configBuilder.withLogLevel(MoPubLog.LogLevel.DEBUG)
                } else {
                    configBuilder.withLogLevel(MoPubLog.LogLevel.INFO)
                }
                MoPub.initializeSdk(this, configBuilder.build(), initSdkBannerListener(bannerId))
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    protected fun loadInsMop(insId: String?){
        try {
            if(!insId.isNullOrEmpty()){
                mopInsId = insId
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    protected fun loadBannerUnity(){
        try{
            if(!main.unt.id.isNullOrEmpty() && !main.unt.banner1.isNullOrEmpty()){
                UnityAds.initialize(this, main.unt.id, null, BuildConfig.DEBUG, true)
                bottomBanner = com.unity3d.services.banners.BannerView(
                    this, main.unt.banner1, UnityBannerSize(
                        320,
                        50
                    )
                )
                bottomBanner!!.listener = bannerListener
                bottomBannerView = findViewById(R.id.bottomBanner)
                bottomBannerView!!.visibility = View.VISIBLE
                bottomBannerView!!.addView(bottomBanner)
                bottomBanner!!.load()
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    protected fun loadBanner(bannerId: String?){
        try {
            if(!bannerId.isNullOrEmpty()){
                adView = AdView(this, bannerId, AdSize.BANNER_HEIGHT_50)
                adView!!.visibility = View.VISIBLE
                val adContainer = findViewById<View>(R.id.banner_container) as LinearLayout
                adContainer.visibility = View.GONE
                adContainer.addView(adView)

                val adListener: AdListener = object : AdListener {
                    override fun onError(ad: Ad, adError: AdError) {
                        Log.e(getTag(), "Banner ad failed to load: " + adError.errorMessage)
                    }

                    override fun onAdLoaded(ad: Ad) {
                        Log.d(getTag(), "Banner ad is loaded and ready to be displayed!")
                    }

                    override fun onAdClicked(ad: Ad) {
                        Log.d(getTag(), "Banner ad clicked!")
                    }

                    override fun onLoggingImpression(ad: Ad) {
                        Log.d(getTag(), "Banner ad impression logged!")
                    }
                }
                adView!!.loadAd(adView!!.buildLoadAdConfig().withAdListener(adListener).build())
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun loadBannerAN(bannerId: String?){
        try {
            if(!bannerId.isNullOrEmpty()){
                adViewAN = findViewById<View>(R.id.banner) as BannerView
                adViewAN!!.visibility = View.VISIBLE
                adViewAN!!.setPlacementId(bannerId)
                adViewAN!!.setBannerListener(object : BannerListener() {
                    override fun onError(error: AppnextError) {
                        super.onError(error)
                        Log.e(getTag(), "AN Banner ad failed to load: " + error.errorMessage)
                    }

                    override fun onAdLoaded(s: String, creativeType: AppnextAdCreativeType) {
                        super.onAdLoaded(s, creativeType)
                        Log.d(getTag(), "AN Banner ad is loaded and ready to be displayed!")
                    }

                    override fun adImpression() {
                        super.adImpression()
                        Log.d(getTag(), "AN Banner ad impression logged!")
                    }

                    override fun onAdClicked() {
                        super.onAdClicked()
                        Log.d(getTag(), "AN Banner ad clicked!")
                    }
                })
                adViewAN!!.loadAd(BannerAdRequest())
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun loadBannerSA(){
        try {
            banner = findViewById(R.id.startAppBanner)
            banner!!.visibility = View.VISIBLE
            banner!!.loadAd(320, 50)
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    protected fun loadInsUnity(){
        try {
            if(!main.unt.ins1.isNullOrEmpty()){
                UnityAds.load(main.unt.ins1, UnityLoadAdsListener())
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    protected fun loadInsAN(insId: String?){
        try {
            if(!insId.isNullOrEmpty()){
                interstitialAdAN = Interstitial(this, insId)
                interstitialAdAN!!.onAdLoadedCallback = OnAdLoaded { bannerId, creativeType ->
                    Log.d(getTag(), "AN Interstitial ad is loaded and ready to be displayed!")
                } // Get callback for ad opened

                interstitialAdAN!!.onAdOpenedCallback = OnAdOpened {
                    Log.d(getTag(), "AN Interstitial ad open!")
                } // Get callback for ad clicked

                interstitialAdAN!!.onAdClickedCallback = OnAdClicked {
                    Log.d(getTag(), "AN Interstitial ad clicked!")
                } // Get callback for ad closed

                interstitialAdAN!!.onAdClosedCallback = OnAdClosed {
                    Log.d(getTag(), "AN Interstitial ad close!")
                    interstitialAdAN!!.loadAd()
                } // Get callback for ad error

                interstitialAdAN!!.onAdErrorCallback = OnAdError { error ->
                    Log.e(getTag(), "AN Interstitial ad failed to load: $error")
                }
                interstitialAdAN!!.loadAd()
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    protected fun loadInsSA(){
        try {
            startAppAd = StartAppAd(this)
            startAppAd!!.loadAd(object : AdEventListener {
                override fun onReceiveAd(p0: com.startapp.sdk.adsbase.Ad?) {
                    Log.d(getTag(), "SA Interstitial ad is loaded and ready to be displayed!")
                }

                override fun onFailedToReceiveAd(p0: com.startapp.sdk.adsbase.Ad?) {
                    Log.e(getTag(), "SA Interstitial ad failed to load")
                }
            })
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    protected fun loadIns(insId: String?){
        try{
            if(!insId.isNullOrEmpty()){
                interstitialAd = InterstitialAd(this, insId)
                loadAd()
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    private fun loadAd(){
        try {
            val interstitialAdListener: InterstitialAdListener = object : InterstitialAdListener {
                override fun onInterstitialDisplayed(ad: Ad) {
                    Log.e(getTag(), "Interstitial ad displayed.")
                }

                override fun onInterstitialDismissed(ad: Ad) {
                    Log.e(getTag(), "Interstitial ad dismissed.")
                    loadAd()
                }

                override fun onError(ad: Ad, adError: AdError) {
                    Log.e(getTag(), "Interstitial ad failed to load: " + adError.errorMessage)
                    Handler().postDelayed({
                        loadAd()
                    }, 20000)
                }

                override fun onAdLoaded(ad: Ad) {
                    Log.d(getTag(), "Interstitial ad is loaded and ready to be displayed!")
                }

                override fun onAdClicked(ad: Ad) {
                    Log.d(getTag(), "Interstitial ad clicked!")
                }

                override fun onLoggingImpression(ad: Ad) {
                    Log.d(getTag(), "Interstitial ad impression logged!")
                }
            }
            interstitialAd?.loadAd(
                interstitialAd?.buildLoadAdConfig()
                    ?.withAdListener(interstitialAdListener)
                    ?.build()
            )
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    protected fun showInsAds(){
        try{
            if (Random.nextInt(
                    1,
                    100
                ) > (100 - main.percent_show_ins)
            ) {
                if(interstitialAd != null && interstitialAd!!.isAdLoaded){
                    interstitialAd!!.show()
                }else if(interstitialAdAN != null && interstitialAdAN!!.isAdLoaded){
                    interstitialAdAN!!.showAd()
                }else if (!main.unt.ins1.isNullOrEmpty() && UnityAds.isReady(main.unt.ins1)) {
                    UnityAds.show(this, main.unt.ins1)
                }else if(startAppAd != null){
                    startAppAd!!.showAd()
                }else if (mInterstitial != null && mInterstitial!!.isReady) {
                    mInterstitial!!.show()
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    open fun SetUpBanner(): com.unity3d.services.banners.BannerView {
        return com.unity3d.services.banners.BannerView(
            this, main.unt.banner1, UnityBannerSize(
                320,
                50
            )
        )
    }

    // Implement listener methods:
    class UnityBannerListener : com.unity3d.services.banners.BannerView.IListener {
        override fun onBannerLoaded(p0: com.unity3d.services.banners.BannerView?) {
        }

        override fun onBannerFailedToLoad(
            p0: com.unity3d.services.banners.BannerView?,
            errorInfo: BannerErrorInfo?
        ) {
            Log.d(
                "UnityAdsListener",
                "Unity Banner onBannerFailedToLoad: " + errorInfo?.errorMessage
            )
        }

        override fun onBannerClick(p0: com.unity3d.services.banners.BannerView?) {
            Log.d("UnityAdsListener", "Unity Banner onBannerClick")
        }

        override fun onBannerLeftApplication(p0: com.unity3d.services.banners.BannerView?) {
            Log.d("UnityAdsListener", "Unity Banner onBannerLeftApplication")
        }
    }

    class UnityLoadAdsListener : IUnityAdsLoadListener{
        override fun onUnityAdsAdLoaded(p0: String?) {
            Log.d("UnityAdsListener", "Unity Interstitial onUnityAdsAdLoaded: $p0")
        }

        override fun onUnityAdsFailedToLoad(p0: String?) {
            Log.d("UnityAdsListener", "Unity Interstitial onUnityAdsFailedToLoad: $p0")
        }

    }

    override fun onPause() {
        super.onPause()
        MoPub.onPause(this)
    }

    override fun onStop() {
        super.onStop()
        MoPub.onStop(this)
    }

    override fun onResume() {
        super.onResume()
        MoPub.onResume(this)
    }

    override fun onDestroy() {
        try{
            if (adView != null) {
                adView!!.destroy()
            }
            if (interstitialAd != null) {
                interstitialAd!!.destroy()
            }
            if (adViewAN != null) {
                adViewAN!!.destroy()
            }
            if(startAppAd != null){
                startAppAd!!.close()
            }
            if(bottomBannerView != null){
                bottomBannerView!!.removeAllViews()
                bottomBannerView = null
                bottomBanner = null
            }
            if(banner != null){
                banner!!.hideBanner()
            }
            if(moPubView != null){
                moPubView!!.destroy()
            }
            if(mInterstitial != null){
                mInterstitial!!.destroy()
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
        super.onDestroy()
    }

}