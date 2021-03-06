package com.carlyu.logindemo.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.carlyu.logindemo.R
import com.carlyu.logindemo.base.BaseActivity
import com.carlyu.logindemo.bean.Accounts
import com.carlyu.logindemo.databinding.ActivityRegisterBinding
import com.carlyu.logindemo.utils.toast


class RegisterActivity : BaseActivity<ActivityRegisterBinding>(), RegisterContract.View {

    private var registerPresenter: RegisterContract.Presenter? = null

    // Already configured in BaseActivity, so here is no longer needed
    // private val binding = ActivityRegisterBinding.inflate(layoutInflater)

    companion object {
        fun startActivity(ctx: Context) {
            val intent = Intent(ctx, RegisterActivity::class.java)
            ctx.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        try {
            super.onRestoreInstanceState(savedInstanceState)
        } catch (e: Exception) {
            Log.d(null, "======================")
            Log.d("ExceptionClass:", e.javaClass.toGenericString())
            Log.d(null, "======================")
            e.printStackTrace()
            Log.d(null, "======================")

        }
    }

    override fun initData() {
        RegisterPresenter(this)
    }

    override fun initViews() {
        binding.btnRegister.setOnClickListener {
            goRegister()
        }
    }

    private fun goRegister() {
        if (checkRegister()) {
            registerPresenter!!.register(getUserById(), getUserName(), getPwd())
        }
    }

    private fun checkRegister(): Boolean {
        if (TextUtils.isEmpty(getUserById())) {
            binding.inputRegisterId.requestFocus()
            binding.inputRegisterId.error = getString(R.string.userid_cant_null)
            return false
        }
        if (TextUtils.isEmpty(getUserName())) {
            binding.inputName.requestFocus()
            binding.inputName.error = getString(R.string.username_cant_null)
            return false
        }
        if (TextUtils.isEmpty(getPwd())) {
            binding.inputPwd.requestFocus()
            binding.inputPwd.error = getString(R.string.password_cant_null)
            return false
        }
        if (getPwd() != getConfirmPwd()) {
            binding.inputConfirmPwd.requestFocus()
            binding.inputConfirmPwd.error = getString(R.string.pwd_not_confirm)
            return false
        }
        return true
    }

    override fun setupToolbar() {
        val mToolbar = findViewById<Toolbar>(R.id.toolbar)
        mToolbar.title = "???????????????"
        mToolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_back_24)

        setSupportActionBar(mToolbar)

        mToolbar.setNavigationOnClickListener {
            finish()
        }
    }

    override fun getViewBinding(): ActivityRegisterBinding {
        return ActivityRegisterBinding.inflate(layoutInflater)
    }


    override fun getUserById(): String =
        binding.inputRegisterId.text.toString()


    override fun getUserName(): String =
        binding.inputName.text.toString()


    override fun getPwd(): String =
        binding.inputPwd.text.toString()

    override fun getConfirmPwd(): String =
        binding.inputConfirmPwd.text.toString()


    override fun registerSuccess(userAccount: Accounts) {
        toast("????????????!\n${userAccount.data.studentId}\n${userAccount.data.studentName}")
        finish()
    }

    override fun registerFail(msg: String) {
        toast("????????????,${msg}!")
    }

    override fun setPresenter(presenter: RegisterContract.Presenter) {
        registerPresenter = presenter
    }
}