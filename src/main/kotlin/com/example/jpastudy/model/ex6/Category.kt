package com.example.jpastudy.model.ex6

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @ManyToMany(mappedBy = "category")
    var items: MutableList<Item> = mutableListOf()
        private set
}
