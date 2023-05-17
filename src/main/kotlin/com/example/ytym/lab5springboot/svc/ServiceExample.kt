package com.example.ytym.lab5springboot.svc

import com.example.ytym.lab5springboot.dto.SoftwareModuleRequest
import com.example.ytym.lab5springboot.dto.SoftwareProductRequest
import com.example.ytym.lab5springboot.entity.SoftwareModule
import com.example.ytym.lab5springboot.entity.SoftwareProduct

interface SoftwareModuleService {
    fun createModule(module: SoftwareModuleRequest): SoftwareModule
    fun updateModule(id: Long, module: SoftwareModuleRequest): SoftwareModule
    fun deleteModule(id: Long)
    fun getModuleById(id: Long): SoftwareModule?
    fun getAllModules(): List<SoftwareModule>
}

interface SoftwareProductService {
    fun createProduct(product: SoftwareProductRequest): SoftwareProduct
    fun updateProduct(id: Long, product: SoftwareProductRequest): SoftwareProduct
    fun deleteProduct(id: Long)
    fun getProductById(id: Long): SoftwareProduct?
    fun getAllProducts(): List<SoftwareProduct>
}