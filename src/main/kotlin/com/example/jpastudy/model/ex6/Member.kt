package com.example.jpastudy.model.ex6

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

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

    fun addOrder(order: Order) {
        this.orders.add(order)
    }
}
