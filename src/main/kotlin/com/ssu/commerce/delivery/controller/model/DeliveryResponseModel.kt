package com.ssu.commerce.delivery.controller.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.ssu.commerce.delivery.domain.enums.DeliveryFeeType
import com.ssu.commerce.delivery.domain.enums.DeliveryStatus
import com.ssu.commerce.delivery.domain.enums.DeliveryType
import com.ssu.commerce.delivery.utils.DateTimeUtils
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDateTime

@Schema(description = "배송 응답 모델")
data class DeliveryResponseModel(
    @Schema(description = "배송 등록번호", defaultValue = "1")
    val id: Long,
    @Schema(description = "거래 등록 번호", example = "1")
    val transactionId: Long,
    @Schema(description = "주문한 책 번호", example = "1")
    val orderBookId: Long,
    @Schema(description = "배송비 유형", example = "FREE")
    val deliveryFeeType: DeliveryFeeType,
    @Schema(description = "배송비", example = "1000")
    val baseFee: BigDecimal,
    @Schema(description = "판매자 등록번호", example = "1")
    val sellerAccountId: Long,
    @Schema(description = "대여자 등록번호", example = "1")
    val lenderAccountId: Long,
    @Schema(description = "대여자 기본주소", example = "서울특별시 동작구 상도로 369")
    val addressBase: String,
    @Schema(description = "대여자 상세주소", example = "정보과학관 301호")
    val addressDetail: String,
    @Schema(description = "남기고 싶은 메세지", example = "도착 시 연락주세요")
    val message: String? = null,
    @Schema(description = "우편번호", example = "06978")
    val zipcode: String,
    @Schema(description = "대여자 연락 번호1", example = "010-1234-1234")
    val phoneNumber1: String,
    @Schema(description = "대여자 연락 번호2", example = "010-1234-1234")
    val phoneNumber2: String? = null,
    @Schema(description = "배송 유형", example = "DELIVERY")
    var deliveryType: DeliveryType,
    @Schema(description = "배송 상태", example = "DS00")
    var deliveryStatus: DeliveryStatus,
    @Schema(description = "배송 시작 일시", example = "2022-07-01 17:00:00")
    val deliveryStartedAt: LocalDateTime,
    @Schema(description = "배송 도착 일시", example = "2022-07-01 17:00:00")
    val deliveryArrivedAt: LocalDateTime,
    @Schema(description = "생성자", example = "TREE")
    val createdWho: String,
    @JsonFormat(pattern = DateTimeUtils.PATTERN)
    @Schema(description = "생성일시", example = "2022-07-01 17:00:00")
    val createdAt: LocalDateTime,
    @Schema(description = "변경자", example = "TREE")
    val updatedWho: String,
    @JsonFormat(pattern = DateTimeUtils.PATTERN)
    @Schema(description = "변경일시", example = "2022-07-01 17:00:00")
    val updatedAt: LocalDateTime
)
