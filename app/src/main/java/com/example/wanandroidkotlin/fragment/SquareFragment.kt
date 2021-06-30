package com.example.wanandroidkotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.common.base.BaseFragment
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.databinding.FrgSquareBinding

/**
 * @author linjianwen on 2021/6/30
 */
class SquareFragment : BaseFragment<FrgSquareBinding>() {


    override fun getLayoutId(): Int {
        return R.layout.frg_square
    }

    override fun initData() {
    }


}