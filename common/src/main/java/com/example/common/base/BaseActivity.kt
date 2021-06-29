package com.example.common.base

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.common.dialog.LoadingDialog

/**
 * @author linjianwen on 2021/6/29
 */
abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity {


    constructor() : super()

    private lateinit var mLoadingDialog: LoadingDialog

    var mBinding: T? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        mLoadingDialog = LoadingDialog(this, false)
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
        initData(savedInstanceState)
    }


    abstract fun initData(savedInstanceState: Bundle?)

    abstract fun getLayoutId(): Int

    override fun onDestroy() {
        super.onDestroy()
        mBinding?.unbind()
    }

    fun showLoading() {
        mLoadingDialog.showDialog(this, false)
    }

    fun dismissLoading() {
        mLoadingDialog.dismissDialog()
    }

    protected fun setToolbarTitle(view: TextView, title: String) {
        view.text = title
    }

}