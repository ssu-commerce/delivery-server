package com.ssu.commerce.delivery.domain

import com.ssu.commerce.core.jpa.BaseEntity
import com.ssu.commerce.delivery.domain.enum.DeliveryStatus
import com.ssu.commerce.delivery.domain.enum.DeliveryType
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "delivery_info")
data class DeliveryInfoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    val id: Long? = null,
    @Column(nullable = false, updatable = false)
    val transactionId: Long,
    @Column(nullable = false, updatable = false)
    val orderBookId: Long,
    @Embedded
    val deliveryFee: DeliveryFee,
    @Column(nullable = false, updatable = false)
    val sellerAccountId: Long,
    @Column(nullable = false, updatable = false)
    val lenderAccountId: Long,
    @Embedded
    var lenderAddress: Address,
    @Column(nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    var deliveryType: DeliveryType,
    @Column(nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    var status: DeliveryStatus,
    @Column(nullable = false, updatable = false)
    val deliveryStartedAt: LocalDateTime,
    @Column(nullable = false, updatable = false)
    val deliveryArrivedAt: LocalDateTime
) : BaseEntity()
