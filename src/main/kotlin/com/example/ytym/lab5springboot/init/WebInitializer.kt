package com.example.ytym.lab5springboot.init

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer
import com.example.ytym.lab5springboot.config.RootConfig
import com.example.ytym.lab5springboot.config.WebConfig

class WebInitializer : AbstractAnnotationConfigDispatcherServletInitializer() {
    override fun getServletMappings(): Array<String> = arrayOf("/")

    override fun getRootConfigClasses(): Array<Class<*>> = arrayOf(RootConfig::class.java)

    override fun getServletConfigClasses(): Array<Class<*>> = arrayOf(WebConfig::class.java)
}