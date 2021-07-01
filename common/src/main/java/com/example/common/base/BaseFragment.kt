package com.example.common.base

import android.content.Context
import android.database.DatabaseUtils
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.common.R
import com.example.common.databinding.BaseFragmentLayoutBinding
import com.example.common.dialog.LoadingDialog

/**
 * @author linjianwen on 2021/6/29
 */
abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    var mBinding: T? = null
    private lateinit var mContext: Context
    private lateinit var mLoadingDialog: LoadingDialog
    private lateinit var mBaseContainBinding: BaseFragmentLayoutBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBaseContainBinding =
            DataBindingUtil.inflate(inflater, R.layout.base_fragment_layout, container, false)
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)

        //binding 相当于一个View ,在这里的意思是将 View 添加到baseBind(即Fragment容器中)
        mBaseContainBinding.baseContainer.addView(mBinding?.root)
        return mBaseContainBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mLoadingDialog = LoadingDialog(view.context, false)
        initData()
    }

    abstract fun getLayoutId(): Int
    abstract fun initData()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context;
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding?.unbind()
    }

    /**
     * show 加载中
     */
    private fun showLoading() {
        mLoadingDialog.showDialog(mContext, false)
    }

    /**
     * dismiss loading dialog
     */
    private fun dismissLoading() {
        mLoadingDialog.dismissDialog()
    }


}