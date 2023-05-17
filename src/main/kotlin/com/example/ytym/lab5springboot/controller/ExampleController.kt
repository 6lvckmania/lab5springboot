package com.example.ytym.lab5springboot.controller

import com.example.ytym.lab5springboot.entity.SoftwareModule
import com.example.ytym.lab5springboot.entity.SoftwareProduct
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.example.ytym.lab5springboot.dto.*
import com.example.ytym.lab5springboot.entity.*
import com.example.ytym.lab5springboot.svc.*

@RestController
@RequestMapping("/api/software-modules")
class SoftwareModuleController(private val softwareModuleService: SoftwareModuleService) {

    @PostMapping("/modules")
    fun create(@RequestBody softwareModuleRequest: SoftwareModuleRequest): ResponseEntity<SoftwareModule> {
        val createdSoftwareModule = softwareModuleService.createModule(softwareModuleRequest)
        return ResponseEntity.ok(createdSoftwareModule)
    }

    @GetMapping("/modules/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<SoftwareModule?> {
        val softwareModule = softwareModuleService.getModuleById(id)
        return ResponseEntity.ok(softwareModule)
    }

    @PutMapping("/modules/{id}")
    fun update(@PathVariable id: Long, @RequestBody softwareModuleRequest: SoftwareModuleRequest): ResponseEntity<SoftwareModule> {
        val updatedSoftwareModule = softwareModuleService.updateModule(id, softwareModuleRequest)
        return ResponseEntity.ok(updatedSoftwareModule)
    }

    @DeleteMapping("/modules/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        softwareModuleService.deleteModule(id)
        return ResponseEntity.noContent().build()
    }
}

@RestController
@RequestMapping("/api/software-products")
class SoftwareProductController(private val softwareProductService: SoftwareProductService) {

    @PostMapping("/products")
    fun create(@RequestBody softwareProductRequest: SoftwareProductRequest): ResponseEntity<SoftwareProduct> {
        val createdSoftwareProduct = softwareProductService.createProduct(softwareProductRequest)
        return ResponseEntity.ok(createdSoftwareProduct)
    }

    @GetMapping("/products/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<SoftwareProduct?> {
        val softwareProduct = softwareProductService.getProductById(id)
        return ResponseEntity.ok(softwareProduct)
    }

    @PutMapping("/products/{id}")
    fun update(@PathVariable id: Long, @RequestBody softwareProductRequest: SoftwareProductRequest): ResponseEntity<SoftwareProduct> {
        val updatedSoftwareProduct = softwareProductService.updateProduct(id, softwareProductRequest)
        return ResponseEntity.ok(updatedSoftwareProduct)
    }

    @DeleteMapping("/products/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        softwareProductService.deleteProduct(id)
        return ResponseEntity.noContent().build()
    }
}

