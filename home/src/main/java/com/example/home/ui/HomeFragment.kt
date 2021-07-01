package com.example.home.ui

import com.example.common.base.BaseFragment
import com.example.home.R
import com.example.home.databinding.FrgHomeBinding


/**
 * @author linjianwen on 2021/6/30
 */
class HomeFragment : BaseFragment<FrgHomeBinding>() {


    override fun getLayoutId(): Int {
        return R.layout.frg_home
    }

    override fun initData() {
        initTabLayout()
        initViewPager()
    }


    fun initTabLayout(){

    }

    fun initViewPager(){

    }
}