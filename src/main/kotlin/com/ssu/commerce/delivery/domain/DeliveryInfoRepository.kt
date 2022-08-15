package com.ssu.commerce.delivery.domain

import com.ssu.commerce.core.exception.SsuCommerceException
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository

@Repository
interface DeliveryInfoRepository : JpaRepository<DeliveryInfoEntity, Long> {
    override fun getById(id: Long): DeliveryInfoEntity = findByIdOrNull(id)
        ?: throw SsuCommerceException(HttpStatus.BAD_REQUEST, "delivery-01", "존재 하지 않는 아이디입니다.")
}
