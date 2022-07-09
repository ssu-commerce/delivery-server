package com.ssu.commerce.delivery.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class AddressInfo(
    @Column(length = 255, nullable = false)
    val addressBase: String,
    @Column(length = 255, nullable = false)
    val addressDetail: String,
    @Column(length = 255)
    val message: String? = null,
    @Column(length = 10, nullable = false)
    val zipcode: String,
    @Column(length = 15, nullable = false)
    val phoneNumber1: String,
    @Column(length = 15)
    val phoneNumber2: String? = null
)
