package com.example.ytym.lab5springboot.entity

import jakarta.persistence.*

@Entity
data class SoftwareModule(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var description: String,
    var author: String,
    var language: String,
    var lastEditDate: String,
    var size: Int,
    var linesOfCode: Int,
    var isCrossPlatform: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    var product: SoftwareProduct? = null
): Comparable<SoftwareModule> {

    override fun compareTo(other: SoftwareModule): Int {
        return compareValuesBy(this, other, { it.lastEditDate }, { it.size })
    }
}

@Entity
data class SoftwareProduct(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var name: String,
    var developer: String,
    var version: String,
    var releaseDate: String,
    var distributionSize: Int,
    var architecture: String,
    var isCrossPlatform: Boolean,

    @OneToMany(mappedBy = "product", cascade = [CascadeType.ALL], orphanRemoval = true)
    val modules: MutableList<SoftwareModule> = mutableListOf()
): Comparable<SoftwareProduct> {

    override fun compareTo(other: SoftwareProduct): Int {
        return compareValuesBy(this, other, { it.releaseDate }, { it.distributionSize })
    }
}
