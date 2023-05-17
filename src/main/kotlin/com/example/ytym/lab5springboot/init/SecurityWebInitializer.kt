package com.example.ytym.lab5springboot.init

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer

class SecurityWebInitializer : AbstractSecurityWebApplicationInitializer() {

    override fun enableHttpSessionEventPublisher(): Boolean = true
}
