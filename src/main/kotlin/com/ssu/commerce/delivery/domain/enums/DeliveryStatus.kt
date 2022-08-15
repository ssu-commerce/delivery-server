package com.ssu.commerce.delivery.domain.enums

enum class DeliveryStatus(val description: String) {
    DS00("배송 요청"),
    DS01("배송 준비"),
    DS02("배송 중"),
    DS03("배송 완료"),

    DS04("반송 요청"),
    DS05("반송 준비"),
    DS06("반송 중"),
    DS07("반송 완료"),

    DS10("배송 취소"),
    DS11("반송 취소")
}
