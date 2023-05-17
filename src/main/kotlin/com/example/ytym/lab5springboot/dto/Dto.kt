package com.example.ytym.lab5springboot.dto

data class SoftwareModuleRequest(
    val description: String,
    val author: String,
    val language: String,
    val lastEditDate: String,
    val size: Int,
    val linesOfCode: Int,
    val isCrossPlatform: Boolean,
    val productId: Long?
)

data class SoftwareModuleResponse(
    val id: Long?,
    val description: String,
    val author: String,
    val language: String,
    val lastEditDate: String,
    val size: Int,
    val linesOfCode: Int,
    val isCrossPlatform: Boolean,
    val productId: Long?
)

data class SoftwareProductRequest(
    val name: String,
    val developer: String,
    val version: String,
    val releaseDate: String,
    val distributionSize: Int,
    val architecture: String,
    val isCrossPlatform: Boolean
)

data class SoftwareProductResponse(
    val id: Long?,
    val name: String,
    val developer: String,
    val version: String,
    val releaseDate: String,
    val distributionSize: Int,
    val architecture: String,
    val isCrossPlatform: Boolean,
    val modules: List<SoftwareModuleResponse>
)

