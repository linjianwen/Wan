package com.example.wanandroidkotlin.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.example.common.base.BaseActivity
import com.example.common.ktx.setupWithNavController
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
        if (savedInstanceState != null) {
            setBottomBar()
        }
    }

    private fun setBottomBar() {
        val navGraphIds = listOf(R.navigation.nav_home, R.navigation.nav_project, R.navigation.nav_mine)

        val controller = mBinding?.bottomBar?.setupWithNavController(
                navGraphIds = navGraphIds,
                fragmentManager = supportFragmentManager,
                containerId = R.id.fcv,
                intent = intent
        )


    }


}