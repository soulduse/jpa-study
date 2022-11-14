package com.example.jpastudy.model.ex5

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne

@Entity
class Member(
    name: String,
    city: String,
    street: String,
    zipCode: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var name: String = name
        private set

    var city: String = city
        private set

    var street: String = street
        private set

    var zipCode: String = zipCode
        private set

    @OneToMany(mappedBy = "member")
    var orders: MutableList<Order> = mutableListOf()
        private set

    @ManyToOne
    @JoinColumn(name = "team_id")
    var team: Team? = null
        private set

    @OneToOne
    @JoinColumn(name = "locker_id")
    var locker: Locker? = null
        private set

    fun setLocker(locker: Locker) {
        this.locker = locker
        locker.setMember(this)
    }

    fun setTeam(team: Team) {
        this.team = team
        if (!team.members.contains(this)) {
            team.members.add(this)
        }
    }
}
