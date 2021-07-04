package com.jaxadev.worklyclone

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jaxadev.mylibrary.PatternLockView
import com.jaxadev.mylibrary.listener.PatternLockViewListener
import com.jaxadev.mylibrary.utils.PatternLockUtils
import com.jaxadev.worklyclone.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), PatternLockViewListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.patternLockView.addPatternLockListener(this)


    }

    override fun onStarted() {

    }

    override fun onProgress(progressPattern: MutableList<PatternLockView.Dot>?) {

        Log.d("MainActivityda", "onProgress: $progressPattern")

    }

    override fun onComplete(pattern: MutableList<PatternLockView.Dot>?) {
        if (PatternLockUtils.patternToString(binding.patternLockView, pattern).equals("127234")) {
            binding.patternLockView.setViewMode(PatternLockView.PatternViewMode.CORRECT)
            Toast.makeText(applicationContext, "Clock in", Toast.LENGTH_SHORT).show()
        }

        if (PatternLockUtils.patternToString(binding.patternLockView, pattern).equals("1217222120")) {
            binding.patternLockView.setViewMode(PatternLockView.PatternViewMode.CORRECT)
            Toast.makeText(applicationContext, "Clock out", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCleared() {

    }

}