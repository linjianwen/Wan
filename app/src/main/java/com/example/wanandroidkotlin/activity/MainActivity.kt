package com.example.wanandroidkotlin.activity

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.base.BaseActivity
import com.example.common.constant.Constants
import com.example.common.ktx.setupWithNavController
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.databinding.ActivityMainBinding

/**
 * @author linjianwen on 2021/6/29
 */
@Route(path = Constants.PATH_MAIN)
class MainActivity : BaseActivity<ActivityMainBinding>() {

    //声明一个控制器
    private var currentNavController: LiveData<NavController>? = null


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            setBottomBar()
        }
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setBottomBar()
    }

    private fun setBottomBar() {
        //每个tab 的nav
        val mNavIds =
            listOf(R.navigation.nav_home, R.navigation.nav_project, R.navigation.nav_mine)
        //控制器配置
        val controller = mBinding?.bottomBar?.setupWithNavController(
            navGraphIds = mNavIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.fcv,
            intent = intent
        )
        //添加观察者 使用lambar 的方式,监听器返回了一个  navController
        controller?.observe(this, { navController ->
            //为这个 controller 添加监听器,这里要传入一个监听器,监听器的回调参数由三个，其中两个没有用上则用下划线表示_
            navController.addOnDestinationChangedListener { _, destination, _ ->
                run {
                    val id = destination.id
                }
            }
        })

        currentNavController = controller
    }


    override fun onSupportNavigateUp(): Boolean {
        //返回当前navController跳转的返回结果，默认为false
        return currentNavController?.value?.navigateUp() ?: false
    }
}