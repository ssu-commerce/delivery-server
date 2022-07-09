package com.ssu.commerce.delivery.service.policy

import com.ssu.commerce.delivery.controller.model.DeliveryCreateModel

interface DeliveryCreatePolicy {
    fun validate(deliveryCreateModel: DeliveryCreateModel)
}
