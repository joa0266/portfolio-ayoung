package com.ayoung.portfolio.presentation.repository

import com.ayoung.portfolio.domain.entity.Achievement
import com.ayoung.portfolio.domain.entity.Experience
import com.ayoung.portfolio.domain.entity.Introduction
import com.ayoung.portfolio.domain.entity.Link
import com.ayoung.portfolio.domain.entity.Project
import com.ayoung.portfolio.domain.entity.Skill
import com.ayoung.portfolio.domain.repository.AchievementRepository
import com.ayoung.portfolio.domain.repository.ExperienceRepository
import com.ayoung.portfolio.domain.repository.IntroductionRepository
import com.ayoung.portfolio.domain.repository.LinkRepository
import com.ayoung.portfolio.domain.repository.ProjectRepository
import com.ayoung.portfolio.domain.repository.SkillRepository
import org.springframework.stereotype.Repository

@Repository
class PresentationRepository(
    private val achievementRepository: AchievementRepository,
    private val experienceRepository: ExperienceRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val projectRepository: ProjectRepository,
    private val skillRepository: SkillRepository
) {

    fun getActiveAchievements(): List<Achievement> {
        return achievementRepository.findAllByIsActive(true)
    }

    fun getActiveExperiences(): List<Experience> {
        return experienceRepository.findAllByIsActive(true)
    }

    fun getActiveIntroductions(): List<Introduction> {
        return introductionRepository.findAllByIsActive(true)
    }

    fun getActiveLinks(): List<Link> {
        return linkRepository.findAllByIsActive(true)
    }

    fun getActiveProjects(): List<Project> {
        return projectRepository.findAllByIsActive(true)
    }

    fun getActiveSkills(): List<Skill> {
        return skillRepository.findAllByIsActive(true)
    }

}