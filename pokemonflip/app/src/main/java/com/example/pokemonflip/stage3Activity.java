package com.example.pokemonflip;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.plattysoft.leonids.ParticleSystem;

import java.util.ArrayList;
import java.util.Collections;

import pl.droidsonroids.gif.GifImageView;

public class stage3Activity extends AppCompatActivity {

    GifImageView imageview1,imageview2,imageView3, imageView5, imageView6, imageView7, imageView9, imageView10, imageView11, imageView13, imageView14, imageView15;
    GifImageView imageView4, imageView8, imageView12, imageView16, imageview4_1, imageview4_2, imageView8_1, imageView8_2, imageView12_1, imageView12_2, imageView16_1, imageView16_2;
    GifImageView imageView17, imageView18, imageView19, imageView20, imageView20_1, imageView20_2;
    ObjectView objectView;
    TextView txtseconds;
    ArrayList<Integer> listImage;
    Boolean flagStart = false, flagcheck = false;
    int point = 0;
    CountDownTimer countTimeProccess;
    InterstitialAd interstitialAd;
    AdView adView;
    String TAG = "stage3Activity";
    Intent nextIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage3);

        mappingItem();
        initListImage();
        AdSettings.addTestDevice("e4af0fa3-8c0f-489e-b041-1535c48d0ebc");

        adView = new AdView(this, "2564603783843196_2564603830509858", AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer = findViewById(R.id.banner_container);
        adContainer.addView(adView);
        adView.loadAd();
        interstitialAd = new InterstitialAd(this, "2564603783843196_2564603840509857");
        interstitialAd.loadAd(interstitialAd.buildLoadAdConfig().withAdListener(new InterstitialAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.d(TAG, "Interstitial ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.d(TAG, "Interstitial ad impression logged!");
            }

            @Override
            public void onInterstitialDisplayed(Ad ad) {
                Log.e(TAG, "Interstitial ad displayed.");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                Log.e(TAG, "Interstitial ad dismissed.");
                showNextScreen();
            }
        }).build());

        imageview1.setOnClickListener(new View.OnClickListener() {
            GifImageView temp;
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageview1.setImageResource(listImage.get(0));
                        imageview1.setTag(listImage.get(0));
                        objectView = new ObjectView(R.id.imageview1, (Integer)imageview1.getTag());
                    } else {
                        imageview1.setImageResource(listImage.get(0));
                        imageview1.setTag(listImage.get(0));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageview1.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageview1);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        }else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageview1);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageview2.setOnClickListener(new View.OnClickListener() {
            GifImageView temp;
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageview2.setImageResource(listImage.get(1));
                        imageview2.setTag(listImage.get(1));
                        objectView = new ObjectView(R.id.imageview2, (Integer)imageview2.getTag());
                    } else {
                        imageview2.setImageResource(listImage.get(1));
                        imageview2.setTag(listImage.get(1));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageview2.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageview2);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageview2);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            GifImageView temp;
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView3.setImageResource(listImage.get(2));
                        imageView3.setTag(listImage.get(2));
                        objectView = new ObjectView(R.id.imageview3, (Integer)imageView3.getTag());
                    } else {
                        imageView3.setImageResource(listImage.get(2));
                        imageView3.setTag(listImage.get(2));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView3.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView3);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView3);
                            objectView = null;
                        }
                    }
                }
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            GifImageView temp;
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView5.setImageResource(listImage.get(3));
                        imageView5.setTag(listImage.get(3));
                        objectView = new ObjectView(R.id.imageview5, (Integer)imageView5.getTag());
                    } else {
                        imageView5.setImageResource(listImage.get(3));
                        imageView5.setTag(listImage.get(3));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView5.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView5);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView5);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            GifImageView temp;
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView6.setImageResource(listImage.get(4));
                        imageView6.setTag(listImage.get(4));
                        objectView = new ObjectView(R.id.imageview6, (Integer)imageView6.getTag());
                    } else {
                        imageView6.setImageResource(listImage.get(4));
                        imageView6.setTag(listImage.get(4));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView6.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView6);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView6);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView7.setImageResource(listImage.get(5));
                        imageView7.setTag(listImage.get(5));
                        objectView = new ObjectView(R.id.imageview7, (Integer)imageView7.getTag());
                    } else {
                        imageView7.setImageResource(listImage.get(5));
                        imageView7.setTag(listImage.get(5));
                        GifImageView temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView7.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView7);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView7);
                            objectView = null;
                        }
                    }
                }
            }
        });

        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView9.setImageResource(listImage.get(6));
                        imageView9.setTag(listImage.get(6));
                        objectView = new ObjectView(R.id.imageview9, (Integer)imageView9.getTag());
                    } else {
                        imageView9.setImageResource(listImage.get(6));
                        imageView9.setTag(listImage.get(6));
                        GifImageView temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView9.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView9);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView9);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView10.setImageResource(listImage.get(7));
                        imageView10.setTag(listImage.get(7));
                        objectView = new ObjectView(R.id.imageview10, (Integer)imageView10.getTag());
                    } else {
                        imageView10.setImageResource(listImage.get(7));
                        imageView10.setTag(listImage.get(7));
                        GifImageView temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView10.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView10);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView10);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView11.setImageResource(listImage.get(8));
                        imageView11.setTag(listImage.get(8));
                        objectView = new ObjectView(R.id.imageview11, (Integer)imageView11.getTag());
                    } else {
                        imageView11.setImageResource(listImage.get(8));
                        imageView11.setTag(listImage.get(8));
                        GifImageView temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView11.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView11);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView11);
                            objectView = null;
                        }
                    }
                }
            }
        });

        imageView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView13.setImageResource(listImage.get(9));
                        imageView13.setTag(listImage.get(9));
                        objectView = new ObjectView(R.id.imageview13, (Integer)imageView13.getTag());
                    } else {
                        imageView13.setImageResource(listImage.get(9));
                        imageView13.setTag(listImage.get(9));
                        GifImageView temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView13.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView13);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView13);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView14.setImageResource(listImage.get(10));
                        imageView14.setTag(listImage.get(10));
                        objectView = new ObjectView(R.id.imageview14, (Integer)imageView14.getTag());
                    } else {
                        imageView14.setImageResource(listImage.get(10));
                        imageView14.setTag(listImage.get(10));
                        GifImageView temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView14.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView14);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView14);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView15.setImageResource(listImage.get(11));
                        imageView15.setTag(listImage.get(11));
                        objectView = new ObjectView(R.id.imageview15, (Integer)imageView15.getTag());
                    } else {
                        imageView15.setImageResource(listImage.get(11));
                        imageView15.setTag(listImage.get(11));
                        GifImageView temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView15.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView15);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView15);
                            objectView = null;
                        }
                    }
                }
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            GifImageView temp;
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView4.setImageResource(listImage.get(12));
                        imageView4.setTag(listImage.get(12));
                        objectView = new ObjectView(R.id.imageview4, (Integer)imageView4.getTag());
                    } else {
                        imageView4.setImageResource(listImage.get(12));
                        imageView4.setTag(listImage.get(12));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView4.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView4);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView4);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView8.setOnClickListener(new View.OnClickListener() {
            GifImageView temp;
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView8.setImageResource(listImage.get(13));
                        imageView8.setTag(listImage.get(13));
                        objectView = new ObjectView(R.id.imageview8, (Integer)imageView8.getTag());
                    } else {
                        imageView8.setImageResource(listImage.get(13));
                        imageView8.setTag(listImage.get(13));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView8.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView8);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView8);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView12.setOnClickListener(new View.OnClickListener() {
            GifImageView temp;
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView12.setImageResource(listImage.get(14));
                        imageView12.setTag(listImage.get(14));
                        objectView = new ObjectView(R.id.imageview12, (Integer)imageView12.getTag());
                    } else {
                        imageView12.setImageResource(listImage.get(14));
                        imageView12.setTag(listImage.get(14));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView12.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView12);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView12);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView16.setOnClickListener(new View.OnClickListener() {
            GifImageView temp;
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView16.setImageResource(listImage.get(15));
                        imageView16.setTag(listImage.get(15));
                        objectView = new ObjectView(R.id.imageview16, (Integer)imageView16.getTag());
                    } else {
                        imageView16.setImageResource(listImage.get(15));
                        imageView16.setTag(listImage.get(15));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView16.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView16);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView16);
                            objectView = null;
                        }
                    }
                }
            }
        });

        imageview4_1.setOnClickListener(new View.OnClickListener() {
            GifImageView temp;
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageview4_1.setImageResource(listImage.get(16));
                        imageview4_1.setTag(listImage.get(16));
                        objectView = new ObjectView(R.id.imageview4_1, (Integer)imageview4_1.getTag());
                    } else {
                        imageview4_1.setImageResource(listImage.get(16));
                        imageview4_1.setTag(listImage.get(16));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageview4_1.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageview4_1);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageview4_1);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageview4_2.setOnClickListener(new View.OnClickListener() {
            GifImageView temp;
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageview4_2.setImageResource(listImage.get(17));
                        imageview4_2.setTag(listImage.get(17));
                        objectView = new ObjectView(R.id.imageview4_2, (Integer)imageview4_2.getTag());
                    } else {
                        imageview4_2.setImageResource(listImage.get(17));
                        imageview4_2.setTag(listImage.get(17));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageview4_2.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageview4_2);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageview4_2);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView8_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GifImageView temp;
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView8_1.setImageResource(listImage.get(18));
                        imageView8_1.setTag(listImage.get(18));
                        objectView = new ObjectView(R.id.imageview8_1, (Integer)imageView8_1.getTag());
                    } else {
                        imageView8_1.setImageResource(listImage.get(18));
                        imageView8_1.setTag(listImage.get(18));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView8_1.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView8_1);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView8_1);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView8_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GifImageView temp;
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView8_2.setImageResource(listImage.get(19));
                        imageView8_2.setTag(listImage.get(19));
                        objectView = new ObjectView(R.id.imageview8_2, (Integer)imageView8_2.getTag());
                    } else {
                        imageView8_2.setImageResource(listImage.get(19));
                        imageView8_2.setTag(listImage.get(19));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView8_2.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView8_2);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView8_2);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView12_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GifImageView temp;
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView12_1.setImageResource(listImage.get(20));
                        imageView12_1.setTag(listImage.get(20));
                        objectView = new ObjectView(R.id.imageview12_1, (Integer)imageView12_1.getTag());
                    } else {
                        imageView12_1.setImageResource(listImage.get(20));
                        imageView12_1.setTag(listImage.get(20));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView12_1.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView12_1);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView12_1);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView12_2.setOnClickListener(new View.OnClickListener() {
            GifImageView temp;
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView12_2.setImageResource(listImage.get(21));
                        imageView12_2.setTag(listImage.get(21));
                        objectView = new ObjectView(R.id.imageview12_2, (Integer)imageView12_2.getTag());
                    } else {
                        imageView12_2.setImageResource(listImage.get(21));
                        imageView12_2.setTag(listImage.get(21));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView12_2.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView12_2);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView12_2);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView16_1.setOnClickListener(new View.OnClickListener() {
            GifImageView temp;
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView16_1.setImageResource(listImage.get(22));
                        imageView16_1.setTag(listImage.get(22));
                        objectView = new ObjectView(R.id.imageview16_1, (Integer)imageView16_1.getTag());
                    } else {
                        imageView16_1.setImageResource(listImage.get(22));
                        imageView16_1.setTag(listImage.get(22));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView16_1.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView16_1);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView16_1);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView16_2.setOnClickListener(new View.OnClickListener() {
            GifImageView temp;
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView16_2.setImageResource(listImage.get(23));
                        imageView16_2.setTag(listImage.get(23));
                        objectView = new ObjectView(R.id.imageview16_2, (Integer)imageView16_2.getTag());
                    } else {
                        imageView16_2.setImageResource(listImage.get(23));
                        imageView16_2.setTag(listImage.get(23));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView16_2.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView16_2);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView16_2);
                            objectView = null;
                        }
                    }
                }
            }
        });

        imageView17.setOnClickListener(new View.OnClickListener() {
            GifImageView temp;
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView17.setImageResource(listImage.get(24));
                        imageView17.setTag(listImage.get(24));
                        objectView = new ObjectView(R.id.imageview17, (Integer)imageView17.getTag());
                    } else {
                        imageView17.setImageResource(listImage.get(24));
                        imageView17.setTag(listImage.get(24));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView17.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView17);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView17);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView18.setOnClickListener(new View.OnClickListener() {
            GifImageView temp;
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView18.setImageResource(listImage.get(25));
                        imageView18.setTag(listImage.get(25));
                        objectView = new ObjectView(R.id.imageview18, (Integer)imageView18.getTag());
                    } else {
                        imageView18.setImageResource(listImage.get(25));
                        imageView18.setTag(listImage.get(25));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView18.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView18);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView18);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GifImageView temp;
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView19.setImageResource(listImage.get(26));
                        imageView19.setTag(listImage.get(26));
                        objectView = new ObjectView(R.id.imageview19, (Integer)imageView19.getTag());
                    } else {
                        imageView19.setImageResource(listImage.get(26));
                        imageView19.setTag(listImage.get(26));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView19.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView19);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView19);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView20.setOnClickListener(new View.OnClickListener() {
            GifImageView temp;
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView20.setImageResource(listImage.get(27));
                        imageView20.setTag(listImage.get(27));
                        objectView = new ObjectView(R.id.imageview20, (Integer)imageView20.getTag());
                    } else {
                        imageView20.setImageResource(listImage.get(27));
                        imageView20.setTag(listImage.get(27));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView20.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView20);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView20);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView20_1.setOnClickListener(new View.OnClickListener() {
            GifImageView temp;
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView20_1.setImageResource(listImage.get(28));
                        imageView20_1.setTag(listImage.get(28));
                        objectView = new ObjectView(R.id.imageview20_1, (Integer)imageView20_1.getTag());
                    } else {
                        imageView20_1.setImageResource(listImage.get(28));
                        imageView20_1.setTag(listImage.get(28));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView20_1.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView20_1);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView20_1);
                            objectView = null;
                        }
                    }
                }
            }
        });
        imageView20_2.setOnClickListener(new View.OnClickListener() {
            GifImageView temp;
            @Override
            public void onClick(View v) {
                if (flagcheck == false) {
                    if (objectView == null) {
                        if (flagStart == false){
                            flagStart = true;
                            startProccess(v);
                        }
                        imageView20_2.setImageResource(listImage.get(29));
                        imageView20_2.setTag(listImage.get(29));
                        objectView = new ObjectView(R.id.imageview20_2, (Integer)imageView20_2.getTag());
                    } else {
                        imageView20_2.setImageResource(listImage.get(29));
                        imageView20_2.setTag(listImage.get(29));
                        temp = (GifImageView) findViewById(objectView.getId());
                        if (objectView.getTag() == (Integer) imageView20_2.getTag()) {
                            flagcheck = true;
                            awaitTimerTrue(temp,imageView20_2);
                            objectView = null;
                            point += 1;
                            if (point == 15) {
                                countTimeProccess.cancel();
                                txtseconds.setText("0");
                                dialogGameWin(v);
                            }
                        } else {
                            flagcheck = true;
                            awaitTimerFalse(temp,imageView20_2);
                            objectView = null;
                        }
                    }
                }
            }
        });
    }

    // mapping element in layout
    private void mappingItem(){
        imageview1 = (GifImageView) findViewById(R.id.imageview1);
        imageview2 = (GifImageView) findViewById(R.id.imageview2);
        imageView3 = (GifImageView) findViewById(R.id.imageview3);
        imageView5 = (GifImageView) findViewById(R.id.imageview5);
        imageView6 = (GifImageView) findViewById(R.id.imageview6);
        imageView7 = (GifImageView) findViewById(R.id.imageview7);
        imageView9 = (GifImageView) findViewById(R.id.imageview9);
        imageView10 = (GifImageView) findViewById(R.id.imageview10);
        imageView11 = (GifImageView) findViewById(R.id.imageview11);
        imageView13 = (GifImageView) findViewById(R.id.imageview13);
        imageView14 = (GifImageView) findViewById(R.id.imageview14);
        imageView15 = (GifImageView) findViewById(R.id.imageview15);
        txtseconds = (TextView) findViewById(R.id.txtseconds);
        imageView4 = (GifImageView) findViewById(R.id.imageview4);
        imageView8 = (GifImageView) findViewById(R.id.imageview8);
        imageView12 = (GifImageView) findViewById(R.id.imageview12);
        imageView16 = (GifImageView) findViewById(R.id.imageview16);
        imageview4_1 = (GifImageView) findViewById(R.id.imageview4_1);
        imageview4_2 = (GifImageView) findViewById(R.id.imageview4_2);
        imageView8_1 = (GifImageView) findViewById(R.id.imageview8_1);
        imageView8_2 = (GifImageView) findViewById(R.id.imageview8_2);
        imageView12_1 = (GifImageView) findViewById(R.id.imageview12_1);
        imageView12_2 = (GifImageView) findViewById(R.id.imageview12_2);
        imageView16_1 = (GifImageView) findViewById(R.id.imageview16_1);
        imageView16_2 = (GifImageView) findViewById(R.id.imageview16_2);
        imageView17 = (GifImageView) findViewById(R.id.imageview17);
        imageView18 = (GifImageView) findViewById(R.id.imageview18);
        imageView19 = (GifImageView) findViewById(R.id.imageview19);
        imageView20 = (GifImageView) findViewById(R.id.imageview20);
        imageView20_1 = (GifImageView) findViewById(R.id.imageview20_1);
        imageView20_2 = (GifImageView) findViewById(R.id.imageview20_2);
    }

    // await compare tow image return true.
    protected void awaitTimerTrue(ImageView imageView1, ImageView imageView2) {
        CountDownTimer countDownTimer = new CountDownTimer(500,100) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                imageView1.setVisibility(imageView1.INVISIBLE);
                imageView2.setVisibility(imageView2.INVISIBLE);
                this.cancel();
                flagcheck = false;
            }
        }.start();
    }

    // await compare two image return false.
    protected void awaitTimerFalse(ImageView imageView1, ImageView imageView2) {
        CountDownTimer countDownTimer = new CountDownTimer(500,100) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                imageView1.setImageResource(R.drawable.sphere);
                imageView2.setImageResource(R.drawable.sphere);
                this.cancel();
                flagcheck = false;
            }
        }.start();
    }

    // proccess count down timer.
    protected void startProccess(View v) {
        countTimeProccess = new CountDownTimer(82000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                txtseconds.setText(String.valueOf(millisUntilFinished/1000 - 1));
            }

            @Override
            public void onFinish() {
                if (point < 15) {
                    dialogGameOver(v);
                }
                this.cancel();
            }
        }.start();
    }

    // effect game win
    public void effectGameWin() {
        new ParticleSystem(this, 80, R.drawable.confeti2, 10000)
                .setSpeedModuleAndAngleRange(0f, 0.3f, 180, 180)
                .setRotationSpeed(144)
                .setAcceleration(0.00005f, 90)
                .emit(findViewById(R.id.emiter_top_right), 8);
    }

    // dialog game win
    public void dialogGameWin(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(stage3Activity.this);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.activity_game_win, viewGroup, false);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        alertDialog.show();
        effectGameWin();
        dialogView.findViewById(R.id.btagain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                nextIntent = getIntent();
                if (interstitialAd != null && interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }else{
                    showNextScreen();
                }
            }
        });
        dialogView.findViewById(R.id.nextbt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextIntent = new Intent(stage3Activity.this, MainActivity.class);
                if (interstitialAd != null && interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }else{
                    showNextScreen();
                }
            }
        });
    }

    // dialog game over
    public void dialogGameOver(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(stage3Activity.this);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.activity_game_over, viewGroup, false);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        alertDialog.show();
        dialogView.findViewById(R.id.btrestart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                nextIntent = getIntent();
                if (interstitialAd != null && interstitialAd.isAdLoaded()) {
                    interstitialAd.show();
                }else{
                    showNextScreen();
                }
            }
        });
    }

    private void showNextScreen(){
        finish();
        startActivity(nextIntent);
    }

    @Override
    public void onBackPressed() {

    }

    private void initListImage(){
        listImage = new ArrayList<Integer>();
        listImage.add(R.drawable.image1);
        listImage.add(R.drawable.image2);
        listImage.add(R.drawable.image3);
        listImage.add(R.drawable.image4);
        listImage.add(R.drawable.image5);
        listImage.add(R.drawable.image6);
        listImage.add(R.drawable.image7);
        listImage.add(R.drawable.image8);
        listImage.add(R.drawable.image9);
        listImage.add(R.drawable.image10);
        listImage.add(R.drawable.image11);
        listImage.add(R.drawable.image12);
        listImage.add(R.drawable.image13);
        listImage.add(R.drawable.image14);
        listImage.add(R.drawable.image15);
        listImage.add(R.drawable.image1);
        listImage.add(R.drawable.image2);
        listImage.add(R.drawable.image3);
        listImage.add(R.drawable.image4);
        listImage.add(R.drawable.image5);
        listImage.add(R.drawable.image6);
        listImage.add(R.drawable.image7);
        listImage.add(R.drawable.image8);
        listImage.add(R.drawable.image9);
        listImage.add(R.drawable.image10);
        listImage.add(R.drawable.image11);
        listImage.add(R.drawable.image12);
        listImage.add(R.drawable.image13);
        listImage.add(R.drawable.image14);
        listImage.add(R.drawable.image15);
        Collections.shuffle(listImage);
    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        super.onDestroy();
    }
}