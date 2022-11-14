package com.example.jpastudy.model.ex5

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Team(
    name: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var name: String = name
        private set

    @OneToMany(mappedBy = "team")
    var members: MutableList<Member> = mutableListOf()

    fun addMember(member: Member) {
        this.members.add(member)
        if (member.team != this) {
            member.setTeam(this)
        }
    }
}
