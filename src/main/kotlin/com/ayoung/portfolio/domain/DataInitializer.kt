package com.ayoung.portfolio.domain

import com.ayoung.portfolio.domain.constant.SkillType
import com.ayoung.portfolio.domain.entity.Account
import com.ayoung.portfolio.domain.entity.Achievement
import com.ayoung.portfolio.domain.entity.Experience
import com.ayoung.portfolio.domain.entity.ExperienceDetail
import com.ayoung.portfolio.domain.entity.Introduction
import com.ayoung.portfolio.domain.entity.Link
import com.ayoung.portfolio.domain.entity.Project
import com.ayoung.portfolio.domain.entity.ProjectDetail
import com.ayoung.portfolio.domain.entity.ProjectSkill
import com.ayoung.portfolio.domain.entity.Skill
import com.ayoung.portfolio.domain.repository.AccountRepository
import com.ayoung.portfolio.domain.repository.AchievementRepository
import com.ayoung.portfolio.domain.repository.ExperienceRepository
import com.ayoung.portfolio.domain.repository.IntroductionRepository
import com.ayoung.portfolio.domain.repository.LinkRepository
import com.ayoung.portfolio.domain.repository.ProjectRepository
import com.ayoung.portfolio.domain.repository.SkillRepository
import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@Profile(value = ["default"])
class DataInitializer(
    private val achievementRepository: AchievementRepository,
    private val experienceRepository: ExperienceRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val projectRepository: ProjectRepository,
    private val skillRepository: SkillRepository,
    private val accountRepository: AccountRepository
) {

    val log = LoggerFactory.getLogger(DataInitializer::class.java)

    @PostConstruct
    fun initializeData() {

        log.info("스프링이 실행되었습니다. 테스트 데이터를 초기화합니다.")

        // achievement 초기화
        val achievements = mutableListOf<Achievement>(
            Achievement(
                title = "Salesforce Certified Administrator",
                description = "세일즈포스 어드민 자격 증명",
                host = "Salesforce",
                achievedDate = LocalDate.of(2022, 9, 1),
                isActive = true
            ),
            Achievement(
                title = "정보처리기사",
                description = "자료구조, 운영체제, 알고리즘, 데이터베이스 등",
                host = "한국산업인력공단",
                achievedDate = LocalDate.of(2016, 12, 2),
                isActive = true
            ),
            Achievement(
                title = "창업아이템 경진대회 우수상",
                description = "토익 메타정보 웹 서비스 아이템",
                host = "을지대학교",
                achievedDate = LocalDate.of(2015, 5, 25),
                isActive = true
            ),
            Achievement(
                title = "OCJP",
                description = "Oracle 개발 자격 증명",
                host = "Oracle",
                achievedDate = LocalDate.of(2014, 12, 11),
                isActive = true
            )
        )
        achievementRepository.saveAll(achievements)

        // introduction 초기화
        val introductions = mutableListOf<Introduction>(
            Introduction(content = "주도적으로 개선점을 찾고, 시스템을 개선하는 개발자입니다.", isActive = true),
            Introduction(content = "기존 소스를 리팩토링하여 더 좋은 구조로 개선하는 작업을 좋아합니다.", isActive = true)
        )
        introductionRepository.saveAll(introductions)

        // link 초기화
        val links = mutableListOf<Link>(
            Link(name = "Github", content = "https://github.com/joa0266", isActive = true),
            Link(name = "Velog", content = "https://velog.io/@joa0266/posts", isActive = true),
        )
        linkRepository.saveAll(links)

        // experience / experience_detail 초기화
        val experience1 = Experience(
            title = "을지대학교(Euiji Univ.)",
            description = "의료IT학과 전공",
            startYear = 2012,
            startMonth = 3,
            endYear = 2017,
            endMonth = 2,
            isActive = true
        )
        experience1.addDetails(
            mutableListOf(
                ExperienceDetail(content = "심박수 알림 아두이노 팔찌 및 앱", isActive = true),
                ExperienceDetail(content = "주변 병원 찾기 및 진료 예약시스템 개발", isActive = true),
                ExperienceDetail(content = "NFC를 이용한 모바일 주문시스템 개발", isActive = true)
            )
        )
        val experience2 = Experience(
            title = "비즈에크아이",
            description = "솔루션파트 개발자",
            startYear = 2021,
            startMonth = 4,
            endYear = null,
            endMonth = null,
            isActive = true
        )
        experience2.addDetails(
            mutableListOf(
                ExperienceDetail(content = "B2B수주관리 수익성/리스크 표준 개발", isActive = true),
                ExperienceDetail(content = "B2B수주관리 이노텍 온보딩 프로젝트", isActive = true),
                ExperienceDetail(content = "B2B수주관리 전자 온보딩 프로젝트", isActive = true),
                ExperienceDetail(content = "B2B수주관리 수익성/리스크 운영", isActive = true)
            )
        )
        val experience3 = Experience(
            title = "아이티노바",
            description = "SI사업팀 개발자",
            startYear = 2017,
            startMonth = 3,
            endYear = 2020,
            endMonth = 9,
            isActive = true
        )
        experience3.addDetails(
            mutableListOf(
                ExperienceDetail(content = "현대글로비스 트레이딩시스템 개선 프로젝트", isActive = true),
                ExperienceDetail(content = "유라코퍼레이션 가격관리시스템 고도화 프로젝트", isActive = true),
                ExperienceDetail(content = "현대자동차 VAATZ 노후화 장비교체 및 표준 SW 전환 프로젝트", isActive = true),
                ExperienceDetail(content = "현대모비스 포장원가시스템 유지보수", isActive = true),
                ExperienceDetail(content = "유라코퍼레이션 손익관리시스템 유지보수", isActive = true),
                ExperienceDetail(content = "현대모비스 원가산정시스템 기능 개선 프로젝트", isActive = true),
                ExperienceDetail(content = "현대자동차 와이어링 원가시스템 구축 프로젝트", isActive = true)
            )
        )
        experienceRepository.saveAll(mutableListOf(experience1, experience2, experience3))

        // skill 초기화
        val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
        val kotlin = Skill(name = "Kotlin", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
        val nexacro = Skill(name = "Nexacro", type = SkillType.FRAMEWORK.name, isActive = true)
        val flex = Skill(name = "Flex", type = SkillType.FRAMEWORK.name, isActive = true)
        val mysql = Skill(name = "MySQL", type = SkillType.DATABASE.name, isActive = true)
        val oracle = Skill(name = "Oracle", type = SkillType.DATABASE.name, isActive = true)
        val postgreSQL = Skill(name = "PostgreSQL", type = SkillType.DATABASE.name, isActive = true)
        val git = Skill(name = "Git", type = SkillType.TOOL.name, isActive = true)
        val aws = Skill(name = "AWS", type = SkillType.CLOUD.name, isActive = true)
        skillRepository.saveAll(mutableListOf(java, kotlin, spring, nexacro, flex, mysql, oracle, postgreSQL, git,aws))

        // project / project_detail / project_skill 초기화

        val project1 = Project(
            name = "B2B 수주관리 수익성/리스크 운영",
            description = "고객사 - 부서별로 원하는 수익성/리스크 결과를 시뮬레이션을 통해 제공\n" +
                    "AWS CloudWatch, Scouter 등을 활용한 운영 모니터링",
            startYear = 2022,
            startMonth = 10,
            endYear = null,
            endMonth = null,
            isActive = true
        )
        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "타 시스템과의 인터페이스 및 고객 요구 사항 반영, 내부 기능 개선, 버그 및 장애 대응", url = null, isActive = true),
                ProjectDetail(content = "보안취약점 대응하여 모의해킹에도 보안에 취약하지 않도록 수정", url = null, isActive = true)
            )
        )
        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = java),
                ProjectSkill(project = project1, skill = spring),
                ProjectSkill(project = project1, skill = mysql),
                ProjectSkill(project = project1, skill = aws)
            )
        )
        val project2 = Project(
            name = "B2B 수주관리 전자 온보딩 프로젝트",
            description = "표준 솔루션 기반으로 LG전자 특화 원가계산 시스템 및 자동화 배치 개발",
            startYear = 2022,
            startMonth = 1,
            endYear = 2022,
            endMonth = 10,
            isActive = true
        )
        project2.addDetails(
            mutableListOf(
                ProjectDetail(content = "원가마스터에 원가등록하여 자동 원가계산", url = null, isActive = true),
                ProjectDetail(content = "수익성요청 시 자동산출 후 결과 자동회신 기능", url = null, isActive = true),
//                ProjectDetail(content = "Github Repository", url = "https://github.com/infomuscle", isActive = true)
            )
        )
        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project2, skill = spring),
                ProjectSkill(project = project2, skill = git)
            )
        )
        projectRepository.saveAll(mutableListOf(project1, project2))

        val account = Account(
            loginId = "admin1",
            pw = "\$2a\$10\$BWi6SLqZRJyVvJyufjTtHeYXNNhpNY9rxaVl9fBOE.1t3QF98B.cO"
        )
        accountRepository.save(account)
    }
}
