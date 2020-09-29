package com.secure.fauji_gui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, RewardedVideoAdListener {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    Menu menu;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;

    Handler mHandler;
    private AdView mAdView;
    AdRequest mAdRequest;
    private InterstitialAd mInterstitialAd;
    private String AdId
            = "ca-app-pub-3940256099942544/1033173712";
    private String AdVideoAdId
            = "ca-app-pub-3940256099942544/5224354917";
    private String NativeAdId
            = "ca-app-pub-3940256099942544/2247696110";
    private RewardedVideoAd rewardedVideoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//----------------------------------------- Ads ----------------------------------------------------
        MobileAds.initialize(this);

        AdLoader adLoader = new AdLoader.Builder(this, NativeAdId)
                .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                        ColorDrawable cd = new ColorDrawable(0xFFFFFFFF);
                        NativeTemplateStyle styles = new
                                NativeTemplateStyle.Builder().withMainBackgroundColor(cd).build();


                        TemplateView template = findViewById(R.id.my_template);
                        TemplateView template1 = findViewById(R.id.my_template1);
                        TemplateView template2 = findViewById(R.id.my_template2);

                        template.setStyles(styles);
                        template1.setStyles(styles);
                        template2.setStyles(styles);
                        template.setNativeAd(unifiedNativeAd);
                        template1.setNativeAd(unifiedNativeAd);
                        template2.setNativeAd(unifiedNativeAd);
                    }
                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {
                        // Handle the failure by logging, altering the UI, and so on.
                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()
                        // Methods in the NativeAdOptions.Builder class can be
                        // used here to specify individual options settings.
                        .build())
                .build();
        adLoader.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adView);
        mAdRequest = new AdRequest.Builder().build();
        mAdView.loadAd(mAdRequest);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(AdId);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        rewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();

        mHandler = new Handler();
        startRepeatingTask();
        startRepeatingTask1();
//--------------------------------------------------------------------------------------------------

        init();
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(MainActivity.this);


        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.indiatvnews.com/technology/news-indian-pubg-alternative-fau-g-release-october-end-647862";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startVideoAd();
                startActivity(i);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://youtu.be/M6FjLGqB-uc";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startVideoAd();
                startActivity(i);
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://youtu.be/e2TZAAQmGho";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startVideoAd();
                startActivity(i);
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://youtu.be/lXsEw-AWLb8";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startVideoAd();
                startActivity(i);
            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://youtu.be/sPTK1dvr6lg";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startVideoAd();
                startActivity(i);
            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://youtu.be/ifpA4fQu4y8";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startVideoAd();
                startActivity(i);
            }
        });
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://youtu.be/ThSKocfe5QE";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startVideoAd();
                startActivity(i);
            }
        });
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://youtu.be/RW1LfGnD5uE";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startVideoAd();
                startActivity(i);
            }
        });
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://youtu.be/5EWqQW1Y_9c";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startVideoAd();
                startActivity(i);
            }
        });
        t10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://youtu.be/f_YjBTYHhug";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startVideoAd();
                startActivity(i);
            }
        });

    }

//----------------------------------------- Ads ----------------------------------------------------
    Runnable mStatusChecker = new Runnable() {
        @Override
        public void run() {
            try {
                startVideoAd(); //this function can change value of mInterval.
            } finally {
                // 100% guarantee that this always happens, even if
                // your update method throws an exception
                mHandler.postDelayed(mStatusChecker, 30000);
            }
        }
    };
    Runnable mStatusChecker1 = new Runnable() {
        @Override
        public void run() {
            try {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                } //this function can change value of mInterval.
            } finally {
                // 100% guarantee that this always happens, even if
                // your update method throws an exception
                mHandler.postDelayed(mStatusChecker1, 5000);
            }
        }
    };
    void startRepeatingTask() {
        mStatusChecker.run();
    }
    void startRepeatingTask1() {
        mStatusChecker1.run();
    }
    void stopRepeatingTask() {
        mHandler.removeCallbacks(mStatusChecker);
    }

    private void loadRewardedVideoAd(){
        if(!rewardedVideoAd.isLoaded()) {
            rewardedVideoAd.loadAd(AdVideoAdId, new AdRequest.Builder().build());
        }
    }
    public void startVideoAd(){
        if(rewardedVideoAd.isLoaded()){
            rewardedVideoAd.show();
        }
    }
    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
        loadRewardedVideoAd();
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {

    }

    @Override
    protected void onResume() {
        rewardedVideoAd.resume(this);
        super.onResume();
    }

    @Override
    protected void onPause() {
        rewardedVideoAd.pause(this);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        rewardedVideoAd.destroy(this);
        super.onDestroy();
    }
    //--------------------------------------------------------------------------------------------------

    private void init() {
        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        t1 = findViewById(R.id.faug_txt);
        t2 = findViewById(R.id.dauntless_txt);
        t3 = findViewById(R.id.wildRift_txt);
        t4 = findViewById(R.id.chronicles_txt);
        t5 = findViewById(R.id.pokemonUnite_txt);
        t6 = findViewById(R.id.odyssey_txt);
        t7 = findViewById(R.id.apexLegends_txt);
        t8 = findViewById(R.id.h1z1_txt);
        t9 = findViewById(R.id.immortal_txt);
        t10 = findViewById(R.id.exileMobile_txt);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.faug:
                String url1 = "https://www.indiatvnews.com/technology/news-indian-pubg-alternative-fau-g-release-october-end-647862";
                Intent i1 = new Intent(Intent.ACTION_VIEW);
                i1.setData(Uri.parse(url1));
                startActivity(i1);
                break;
            case R.id.dauntless:
                String url2 = "https://youtu.be/M6FjLGqB-uc";
                Intent i2 = new Intent(Intent.ACTION_VIEW);
                i2.setData(Uri.parse(url2));
                startActivity(i2);
                break;
            case R.id.wildRift:
                String url3 = "https://youtu.be/e2TZAAQmGho";
                Intent i3 = new Intent(Intent.ACTION_VIEW);
                i3.setData(Uri.parse(url3));
                startActivity(i3);
                break;
            case R.id.chronicles:
                String url4 = "https://youtu.be/lXsEw-AWLb8";
                Intent i4 = new Intent(Intent.ACTION_VIEW);
                i4.setData(Uri.parse(url4));
                startActivity(i4);
                break;
            case R.id.pokemonUnite:
                String url5 = "https://youtu.be/sPTK1dvr6lg";
                Intent i5 = new Intent(Intent.ACTION_VIEW);
                i5.setData(Uri.parse(url5));
                startActivity(i5);
                break;
            case R.id.odyssey:
                String url6 = "https://youtu.be/ifpA4fQu4y8";
                Intent i6 = new Intent(Intent.ACTION_VIEW);
                i6.setData(Uri.parse(url6));
                startActivity(i6);
                break;
            case R.id.apexLegends:
                String url7 = "https://youtu.be/ThSKocfe5QE";
                Intent i7 = new Intent(Intent.ACTION_VIEW);
                i7.setData(Uri.parse(url7));
                startActivity(i7);
                break;
            case R.id.h1z1:
                String url8 = "https://youtu.be/RW1LfGnD5uE";
                Intent i8 = new Intent(Intent.ACTION_VIEW);
                i8.setData(Uri.parse(url8));
                startActivity(i8);
                break;
            case R.id.immortal:
                String url9 = "https://youtu.be/5EWqQW1Y_9c";
                Intent i9 = new Intent(Intent.ACTION_VIEW);
                i9.setData(Uri.parse(url9));
                startActivity(i9);
                break;
            case R.id.exileMobile:
                String url10 = "https://youtu.be/f_YjBTYHhug";
                Intent i10 = new Intent(Intent.ACTION_VIEW);
                i10.setData(Uri.parse(url10));
                startActivity(i10);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START); return true;
    }

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {super.onBackPressed();
        }
    }

}