package com.ssu.commerce.delivery.service

import com.ssu.commerce.delivery.controller.model.DeliveryCreateModel
import com.ssu.commerce.delivery.domain.AddressInfo
import com.ssu.commerce.delivery.domain.DeliveryFeeInfo
import com.ssu.commerce.delivery.domain.DeliveryInfoEntity
import com.ssu.commerce.delivery.service.policy.DeliveryCreatePolicy
import org.springframework.stereotype.Component

@Component
class DeliveryInfoEntityFactory(
    private val createPolicies: List<DeliveryCreatePolicy>
) {
    fun buildNewEntity(deliveryCreateModel: DeliveryCreateModel): DeliveryInfoEntity {
        deliveryCreateModel.apply { createPolicies.forEach { it.validate(this) } }

        return DeliveryInfoEntity(
            id = null,
            transactionId = deliveryCreateModel.transactionId,
            orderBookId = deliveryCreateModel.orderBookId,
            deliveryFee = DeliveryFeeInfo(deliveryCreateModel.deliveryFeeType, deliveryCreateModel.baseFee),
            sellerAccountId = deliveryCreateModel.sellerAccountId,
            lenderAccountId = deliveryCreateModel.lenderAccountId,
            lenderAddress = AddressInfo(
                deliveryCreateModel.addressBase,
                deliveryCreateModel.addressDetail,
                deliveryCreateModel.message,
                deliveryCreateModel.zipcode,
                deliveryCreateModel.phoneNumber1,
                deliveryCreateModel.phoneNumber2
            ),
            deliveryType = deliveryCreateModel.deliveryType,
            status = deliveryCreateModel.deliveryStatus,
            deliveryStartedAt = deliveryCreateModel.deliveryStartedAt,
            deliveryArrivedAt = deliveryCreateModel.deliveryArrivedAt
        )
    }
}
