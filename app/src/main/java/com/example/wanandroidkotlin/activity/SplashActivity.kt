package com.example.wanandroidkotlin.activity

import android.content.Intent
import android.os.Bundle
import com.example.common.base.BaseActivity
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override fun initData(savedInstanceState: Bundle?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun getLayoutId(): Int = R.layout.activity_splash

}