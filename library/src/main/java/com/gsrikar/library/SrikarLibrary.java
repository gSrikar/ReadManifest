package com.gsrikar.library;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class SrikarLibrary {

    private static final String TAG = SrikarLibraryKotlin.class.getSimpleName();
    private static final boolean DBG = BuildConfig.DEBUG;

    public static void initLibrary(@NonNull final Context context) {
        @Nullable ApplicationInfo applicationInfo = null;
        try {
            // Get the application info
            applicationInfo = context.getPackageManager()
                    .getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (applicationInfo != null) {
            // Get the meta data
            final Bundle metaData = applicationInfo.metaData;
            // Read the meta data values
            readValues(metaData);
            // Read the resources
            readResources(context, metaData);
        }
    }

    private static void readValues(Bundle metaData) {
        // Get the value from the key
        @Nullable String apiKey = metaData.getString("com.gsrikar.library.LIBRARY_ACCESS_KEY");
        if (apiKey != null) {
            if (DBG) Log.d(TAG, "Api Key: " + apiKey);
        }
    }

    private static void readResources(Context context, Bundle metaData) {
        // Get the resource id
        final int resourceId = metaData.getInt("com.gsrikar.library.LIBRARY_RESOURCE_KEY");
        // Get the list of cities
        final String[] cityArray = context.getResources().getStringArray(resourceId);
        // Print the list of cities to logcat
        for (final String city : cityArray) {
            Log.d(TAG, "City Name: " + city);
        }
    }
}
