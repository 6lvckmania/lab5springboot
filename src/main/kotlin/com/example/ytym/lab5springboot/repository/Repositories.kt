package com.example.ytym.lab5springboot.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.example.ytym.lab5springboot.entity.SoftwareModule
import com.example.ytym.lab5springboot.entity.SoftwareProduct

@Repository
interface SoftwareModuleRepository : JpaRepository<SoftwareModule, Long>

@Repository
interface SoftwareProductRepository : JpaRepository<SoftwareProduct, Long>
