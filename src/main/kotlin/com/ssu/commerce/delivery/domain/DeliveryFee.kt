package com.ssu.commerce.delivery.domain

import com.ssu.commerce.delivery.domain.enum.DeliveryFeeType
import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Embeddable
data class DeliveryFee(
    @Column(length = 4, nullable = false)
    @Enumerated(EnumType.STRING)
    val deliveryFeeType: DeliveryFeeType,
    @Column(nullable = false)
    val baseFee: BigDecimal
)
