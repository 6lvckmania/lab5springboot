package com.example.ytym.lab5springboot.svc.impl

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import com.example.ytym.lab5springboot.dto.SoftwareModuleRequest
import com.example.ytym.lab5springboot.dto.SoftwareProductRequest
import com.example.ytym.lab5springboot.entity.SoftwareProduct
import com.example.ytym.lab5springboot.repository.SoftwareProductRepository
import com.example.ytym.lab5springboot.svc.SoftwareProductService
import com.example.ytym.lab5springboot.entity.SoftwareModule
import com.example.ytym.lab5springboot.repository.SoftwareModuleRepository
import com.example.ytym.lab5springboot.svc.SoftwareModuleService

@Service
class SoftwareModuleServiceImpl(
    private val moduleRepository: SoftwareModuleRepository
) : SoftwareModuleService {

    @PreAuthorize("hasRole('EDITOR')")
    override fun createModule(module: SoftwareModuleRequest): SoftwareModule {
        val softwareModule = SoftwareModule(
            description = module.description,
            author = module.author,
            language = module.language,
            lastEditDate = module.lastEditDate,
            size = module.size,
            linesOfCode = module.linesOfCode,
            isCrossPlatform = module.isCrossPlatform,
        )
        return moduleRepository.save(softwareModule)
    }

    @PreAuthorize("permitAll()")
    override fun getModuleById(id: Long): SoftwareModule? {
        return moduleRepository.findById(id).orElse(null)
    }

    @PreAuthorize("hasRole('EDITOR')")
    override fun updateModule(id: Long, module: SoftwareModuleRequest): SoftwareModule {
        val softwareModule = moduleRepository.findById(id).orElse(null)
            ?: throw RuntimeException("SoftwareModule not found with id: $id")
        softwareModule.description = module.description
        softwareModule.author = module.author
        softwareModule.language = module.language
        softwareModule.lastEditDate = module.lastEditDate
        softwareModule.size = module.size
        softwareModule.linesOfCode = module.linesOfCode
        softwareModule.isCrossPlatform = module.isCrossPlatform
        return moduleRepository.save(softwareModule)
    }

    @PreAuthorize("hasRole('EDITOR')")
    override fun deleteModule(id: Long) {
        moduleRepository.deleteById(id)
    }

    @PreAuthorize("permitAll()")
    override fun getAllModules(): List<SoftwareModule> {
        return moduleRepository.findAll()
    }
}

@Service
class SoftwareProductServiceImpl(
    private val productRepository: SoftwareProductRepository
) : SoftwareProductService {

    @PreAuthorize("hasRole('EDITOR')")
    override fun createProduct(product: SoftwareProductRequest): SoftwareProduct {
        val softwareProduct = SoftwareProduct(
            name = product.name,
            developer = product.developer,
            version = product.version,
            releaseDate = product.releaseDate,
            distributionSize = product.distributionSize,
            architecture = product.architecture,
            isCrossPlatform = product.isCrossPlatform,
        )
        return productRepository.save(softwareProduct)
    }

    @PreAuthorize("permitAll()")
    override fun getProductById(id: Long): SoftwareProduct? {
        return productRepository.findById(id).orElse(null)
    }

    @PreAuthorize("hasRole('EDITOR')")
    override fun updateProduct(id: Long, product: SoftwareProductRequest): SoftwareProduct {
        val softwareProduct = productRepository.findById(id).orElse(null)
            ?: throw RuntimeException("SoftwareProduct not found with id: $id")
        softwareProduct.name = product.name
        softwareProduct.developer = product.developer
        softwareProduct.version = product.version
        softwareProduct.releaseDate = product.releaseDate
        softwareProduct.distributionSize = product.distributionSize
        softwareProduct.architecture = product.architecture
        softwareProduct.isCrossPlatform = product.isCrossPlatform
        return productRepository.save(softwareProduct)
    }

    @PreAuthorize("hasRole('EDITOR')")
    override fun deleteProduct(id: Long) {
        productRepository.deleteById(id)
    }

    @PreAuthorize("permitAll()")
    override fun getAllProducts(): List<SoftwareProduct> {
        return productRepository.findAll()
    }
}
