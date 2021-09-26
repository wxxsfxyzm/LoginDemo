package com.carlyu.logindemo.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlyu.logindemo.R
import com.carlyu.logindemo.base.BaseActivity
import com.carlyu.logindemo.bean.OrderDetailList
import com.carlyu.logindemo.bean.OrderOTOList
import com.carlyu.logindemo.databinding.ActivityDetailBinding
import com.carlyu.logindemo.utils.toast

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    private val orderDetailList1 = listOf(
        OrderDetailList("1632466736830930517", "1632466736828668349", "1001", "鱼香肉丝", 15.00.toBigDecimal(), 1),
        OrderDetailList("1632466736886889401", "1632466736828668349", "1003", "宫保鸡丁", 30.00.toBigDecimal(), 1)
    )

    private val orderDetailList2 = listOf(
        OrderDetailList("1632466988346280933", "1632466988339939878", "1003", "宫保鸡丁", 30.00.toBigDecimal(), 2)
    )
    private val orderDTOList1 = OrderOTOList("1632466736828668349", "195080625", 45.00.toBigDecimal(), orderDetailList1)
    private val orderDTOList2 = OrderOTOList("1632466988339939878", "195080625", 60.00.toBigDecimal(), orderDetailList2)

    private val orderOTOList = arrayListOf<String>(
        "OrderId:" + orderDTOList1.orderId + "\nTotal Amount:" + orderDTOList1.orderAmount,
        "OrderId:" + orderDTOList2.orderId + "\nTotal Amount:" + orderDTOList2.orderAmount,
    )


    companion object {
        fun startActivity(ctx: Context) {
            val i = Intent(ctx, DetailActivity::class.java)
            ctx.startActivity(i)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toast("点击列表查看详情！")
    }

    override fun initData() {
        //TODO("Not yet implemented")
    }

    override fun initViews() {

        //使用Recycler
        val layoutManager = LinearLayoutManager(this)
        binding.detailRecyclerView.layoutManager = layoutManager
        val adapter = RecyclerAdapter(orderOTOList)
        binding.detailRecyclerView.adapter = adapter
    }

    override fun getViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater, binding.root, true)
    }

    override fun setupToolbar() {
        val mToolbar = findViewById<Toolbar>(R.id.toolbar)
        mToolbar.apply {
            title = "于泽明"
            subtitle = "195080625"
            navigationIcon = ContextCompat.getDrawable(this@DetailActivity, R.drawable.ic_baseline_arrow_back_24)
        }

        setSupportActionBar(mToolbar)

        mToolbar.setNavigationOnClickListener {
            finish()
        }
    }
}