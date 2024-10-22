package com.ayoung.portfolio.domain.repository

import com.ayoung.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long>