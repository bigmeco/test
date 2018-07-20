package com.alphavending.partizanmaster

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        scheduleSplashScreen()
    }

    private fun scheduleSplashScreen() {
        val splashScreenDuration = getSplashScreenDuration()
        Handler().postDelayed(
                {
                    routeToAppropriatePage()
                    finish()
                },
                splashScreenDuration
        )
    }

    private fun getSplashScreenDuration() = 1000L


    private fun routeToAppropriatePage() {
        when (null) {
            null -> startActivity(Intent(this, LoginActivity::class.java))
            else ->  startActivity(Intent(this, LoginActivity::class.java))
        }
    }


}
