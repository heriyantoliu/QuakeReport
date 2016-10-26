package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by heriyanto.liu on 10/26/2016.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private static final String LOG_TAG = Earthquake.class.getSimpleName();
    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    public List<Earthquake> loadInBackground() {
        Log.e(LOG_TAG, "loadInBackground");
        if (mUrl == null){
            return null;
        }
        return QueryUtils.fetchEarthquakeData(mUrl);
    }

    @Override
    protected void onStartLoading() {
        Log.e(LOG_TAG, "onStartLoading");
        forceLoad();
    }
}
