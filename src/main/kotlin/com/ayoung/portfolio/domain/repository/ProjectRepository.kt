package com.ayoung.portfolio.domain.repository

import com.ayoung.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long>