package com.example.wanandroidkotlin.activity

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.example.common.base.BaseActivity
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.databinding.ActivityMainBinding

/**
 * @author linjianwen on 2021/6/29
 */
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private var currentNavController: LiveData<NavController>? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData(savedInstanceState: Bundle?) {
        if (savedInstanceState!=null){
            setBottomBar()
        }
    }

    private fun setBottomBar() {
        val navGraphIds = listOf<Int>(R.navigation.navi_home)
    }asdf


}