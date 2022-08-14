package com.ssu.commerce.delivery.controller

import com.ssu.commerce.core.response.PageResponse
import com.ssu.commerce.delivery.controller.model.DeliveryCreateModel
import com.ssu.commerce.delivery.controller.model.DeliveryResponseModel
import com.ssu.commerce.delivery.converter.DeliveryConverter
import com.ssu.commerce.delivery.service.DeliveryService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/deliveries")
@Tag(name = "배송 관련 API")
class DeliveryController(
    private val deliveryService: DeliveryService,
    private val deliveryConverter: DeliveryConverter
) {

    @GetMapping
    @Operation(summary = "배송 리스트 조회")
    fun getList(@RequestParam page: Int, @RequestParam size: Int): PageResponse<DeliveryResponseModel> {
        val result = deliveryService.getList(page, size)
        return PageResponse(result.map(deliveryConverter::convert))
    }

    @GetMapping("/{deliveryId}")
    @Operation(summary = "배송 상세 조회")
    fun get(@PathVariable deliveryId: Long): DeliveryResponseModel {
        val result = deliveryService.get(deliveryId)
        return deliveryConverter.convert(result)
    }

    @PostMapping
    @Operation(
        summary = "배송 생성",
        requestBody = io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "배달 생성 객체",
            required = true,
            content = [Content(schema = Schema(implementation = DeliveryCreateModel::class))]
        )
    )
    fun create(
        @RequestBody @Valid
        deliveryCreate: DeliveryCreateModel
    ) {
        deliveryService.create(deliveryCreate)
    }
}
