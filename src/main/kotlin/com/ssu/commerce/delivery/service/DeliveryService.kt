package com.ssu.commerce.delivery.service

import com.ssu.commerce.delivery.controller.model.DeliveryCreateModel
import com.ssu.commerce.delivery.converter.DeliveryConverter
import com.ssu.commerce.delivery.domain.DeliveryInfoRepository
import com.ssu.commerce.delivery.vo.Delivery
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeliveryService(
    private val deliveryInfoRepository: DeliveryInfoRepository,
    private val deliveryConverter: DeliveryConverter,
    private val deliveryInfoEntityFactory: DeliveryInfoEntityFactory
) {

    @Transactional(readOnly = true)
    fun get(id: Long): Delivery {
        val deliveryEntity = deliveryInfoRepository.getById(id)
        return deliveryConverter.convert(deliveryEntity)
    }

    @Transactional(readOnly = true)
    fun getList(page: Int, size: Int): Page<Delivery> {
        val pageRequest = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "id"))
        val entities = deliveryInfoRepository.findAll(pageRequest)
        return entities.map(deliveryConverter::convert)
    }

    @Transactional
    fun create(deliveryCreateModel: DeliveryCreateModel): Delivery {
        val entity = deliveryInfoEntityFactory.buildNewEntity(deliveryCreateModel)
        val savedEntity = deliveryInfoRepository.save(entity)
        return deliveryConverter.convert(savedEntity)
    }
}
