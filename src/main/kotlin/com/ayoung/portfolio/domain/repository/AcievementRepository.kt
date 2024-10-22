package com.ayoung.portfolio.domain.repository

import com.ayoung.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AcievementRepository : JpaRepository<Achievement, Long>