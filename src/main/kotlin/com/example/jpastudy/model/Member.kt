package com.example.jpastudy.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Member(
    userName: String,
    age: Int
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var userName: String = userName
        private set

    var age: Int = age
        private set
}
