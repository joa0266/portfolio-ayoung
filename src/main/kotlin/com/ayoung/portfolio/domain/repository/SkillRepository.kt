package com.ayoung.portfolio.domain.repository

import com.ayoung.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill, Long>