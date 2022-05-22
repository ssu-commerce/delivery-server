package com.ssu.commerce.delivery

import com.ssu.commerce.core.configs.EnableSsuCommerceCore
import com.ssu.commerce.vault.config.EnableSsuCommerceVault
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableSsuCommerceVault
@EnableSsuCommerceCore
@SpringBootApplication
class DeliveryApplication

fun main(args: Array<String>) {
    runApplication<DeliveryApplication>(*args)
}
