package com.ssu.commerce.delivery.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DeliveryInfoRepository : JpaRepository<DeliveryInfoEntity, Long>
