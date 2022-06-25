package com.ssu.commerce.delivery.configs

import com.ssu.commerce.core.configs.UrlPermissionFilter
import org.springframework.context.annotation.Primary
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer
import org.springframework.stereotype.Component

@Primary
@Component
class AuthUrlPermissionFilter : UrlPermissionFilter {
    override fun urlPermissions(authorizeRequests: ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry): ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry =
        authorizeRequests.anyRequest().authenticated()
}
