package com.carlyu.logindemo.bean

import java.io.Serializable
import java.math.BigDecimal


/**
 * 登录返回
 */

data class Accounts(
    val code: String,
    val msg: String,
    val data: User
) : Serializable

data class User(
    val studentId: String,
    val password: String,
    val studentName: String,
    val balance: BigDecimal
) : Serializable

data class OrderMaster(
    val code: String,
    val msg: String,
    val studentId: String,
    val studentName: String,
    val balance: BigDecimal,
    val data: List<OrderOTOList>
) : Serializable

data class OrderOTOList(
    val orderId: String,
    val studentId: String,
    val orderAmount: BigDecimal,// 订单总价
    val data: List<OrderDetailList>
) : Serializable

data class OrderDetailList(
    val detailId: String,
    val orderId: String,
    val foodId: String,
    val foodName: String,
    val foodPrice: BigDecimal,
    val quantity: Int
) : Serializable