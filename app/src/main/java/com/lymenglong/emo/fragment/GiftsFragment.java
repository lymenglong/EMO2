package com.lymenglong.emo.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdView;
import com.lymenglong.emo.PresenterAdMob;
import com.lymenglong.emo.R;


public class GiftsFragment extends Fragment {

    private PresenterAdMob presenterAdMob;

    public GiftsFragment() {
        // Required empty public constructor
    }

    public static GiftsFragment newInstance(String param1, String param2) {
        GiftsFragment fragment = new GiftsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gifts, container, false);
        AdView adView = view.findViewById(R.id.adView);
        Button buttonInt = view.findViewById(R.id.button_int_ad);
        Button buttonRew = view.findViewById(R.id.button_video_ad);
        presenterAdMob = new PresenterAdMob(getActivity());
        //Initial Mobile Ad
        presenterAdMob.InitialMobileAd(getString(R.string.admob_app_id));

        //Load Banner Ad
        presenterAdMob.LoadBannerAd(adView, getString(R.string.admob_banner_id));

        //Load Interstitial Ad
        presenterAdMob.LoadInterstitialAd(getString(R.string.admob_interstitial_id));
        buttonInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Show Interstitial Ad
                presenterAdMob.ShowInterstitialAd();
            }
        });

        //Load Rewarded Ad
        presenterAdMob.LoadRewardedAd(getString(R.string.admob_rewarded_id));
        buttonRew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Show Rewarded Ad
                presenterAdMob.ShowRewardAd();
            }
        });
        return view;
    }

}
