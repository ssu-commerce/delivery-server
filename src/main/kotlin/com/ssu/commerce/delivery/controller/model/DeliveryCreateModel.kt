package com.ssu.commerce.delivery.controller.model

import com.ssu.commerce.delivery.domain.enums.DeliveryFeeType
import com.ssu.commerce.delivery.domain.enums.DeliveryType
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.validation.constraints.FutureOrPresent
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

data class DeliveryCreateModel(
    val transactionId: Long,
    val orderBookId: Long,
    val deliveryFeeType: DeliveryFeeType,
    val baseFee: BigDecimal,
    @NotNull
    val sellerAccountId: Long,
    @NotNull
    val lenderAccountId: Long,
    @NotBlank
    val addressBase: String,
    @NotBlank
    val addressDetail: String,
    val message: String? = null,
    @Pattern(regexp = "\\d{5}")
    @NotBlank
    val zipcode: String,
    @Pattern(regexp = "\\d{3}-\\d{4}-\\d{4}")
    @NotBlank
    val phoneNumber1: String,
    @Pattern(regexp = "\\d{3}-\\d{4}-\\d{4}")
    val phoneNumber2: String? = null,
    var deliveryType: DeliveryType,
    @FutureOrPresent
    val deliveryStartedAt: LocalDateTime,
    @FutureOrPresent
    val deliveryArrivedAt: LocalDateTime
)
