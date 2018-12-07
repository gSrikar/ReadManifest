package com.gsrikar.library

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log

class SrikarLibraryKotlin {

    companion object {
        private val TAG = SrikarLibraryKotlin::class.java.simpleName
        private val DBG = BuildConfig.DEBUG
    }

    fun initLibrary(context: Context) {
        context.packageManager
            .getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
            .apply {
                readValues(metaData)
                readResources(context, metaData)
            }
    }

    private fun readValues(metaData: Bundle) {
        // Get the Api Key
        val apiKey = metaData.getString("com.gsrikar.library.LIBRARY_ACCESS_KEY")
        if (DBG) Log.d(TAG, "Api Key $apiKey")
    }

    private fun readResources(context: Context, metaData: Bundle) {
        // Get the list of cities
        val resourceId = metaData.getInt("com.gsrikar.library.LIBRARY_RESOURCE_KEY")
        val cities = context.resources.getStringArray(resourceId)
        cities.forEach { Log.d(TAG, "City: $it") }
    }

}