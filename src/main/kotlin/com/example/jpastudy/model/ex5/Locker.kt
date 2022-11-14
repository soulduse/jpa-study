package com.example.jpastudy.model.ex5

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class Locker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @OneToOne(mappedBy = "locker")
    var member: Member? = null
        private set

    fun setMember(member: Member) {
        this.member = member
    }
}
