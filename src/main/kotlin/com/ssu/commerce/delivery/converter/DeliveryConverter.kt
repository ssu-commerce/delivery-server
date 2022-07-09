package com.ssu.commerce.delivery.converter

import com.ssu.commerce.delivery.controller.model.DeliveryCreateModel
import com.ssu.commerce.delivery.domain.DeliveryInfoEntity
import com.ssu.commerce.delivery.vo.Delivery
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(componentModel = "spring")
interface DeliveryConverter {

    @Mappings(
        Mapping(target = "addressBase", source = "lenderAddress.addressBase"),
        Mapping(target = "addressDetail", source = "lenderAddress.addressDetail"),
        Mapping(target = "message", source = "lenderAddress.message"),
        Mapping(target = "zipcode", source = "lenderAddress.zipcode"),
        Mapping(target = "phoneNumber1", source = "lenderAddress.phoneNumber1"),
        Mapping(target = "phoneNumber2", source = "lenderAddress.phoneNumber2")
    )
    fun convert(deliveryInfoEntity: DeliveryInfoEntity): Delivery

    @Mappings
    fun convert(deliveryCreate: DeliveryCreateModel): Delivery
}
