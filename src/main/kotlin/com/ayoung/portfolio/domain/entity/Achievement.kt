package com.ayoung.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Achievement : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acievement_id")
    var id: Long? = null
}