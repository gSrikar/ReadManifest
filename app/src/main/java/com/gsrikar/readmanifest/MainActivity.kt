package com.gsrikar.readmanifest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gsrikar.library.SrikarLibrary
import com.gsrikar.library.SrikarLibraryKotlin

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SrikarLibrary.initLibrary(this)
        SrikarLibraryKotlin().initLibrary(this)

    }
}
