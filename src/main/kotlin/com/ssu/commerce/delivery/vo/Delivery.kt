package com.ssu.commerce.delivery.vo

import com.ssu.commerce.delivery.domain.enums.DeliveryFeeType
import com.ssu.commerce.delivery.domain.enums.DeliveryStatus
import com.ssu.commerce.delivery.domain.enums.DeliveryType
import java.math.BigDecimal
import java.time.LocalDateTime

data class Delivery(
    val id: Long? = null,
    val transactionId: Long,
    val orderBookId: Long,
    val deliveryFeeType: DeliveryFeeType,
    val baseFee: BigDecimal,
    val sellerAccountId: Long,
    val lenderAccountId: Long,
    val addressBase: String,
    val addressDetail: String,
    val message: String? = null,
    val zipcode: String,
    val phoneNumber1: String,
    val phoneNumber2: String? = null,
    var deliveryType: DeliveryType,
    var deliveryStatus: DeliveryStatus,
    val deliveryStartedAt: LocalDateTime,
    val deliveryArrivedAt: LocalDateTime,
    val createdWho: String? = null,
    val createdAt: LocalDateTime? = null,
    val updatedWho: String? = null,
    val updatedAt: LocalDateTime? = null
)
