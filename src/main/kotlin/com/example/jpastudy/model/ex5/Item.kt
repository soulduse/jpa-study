package com.example.jpastudy.model.ex5

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Item(
    name: String,
    price: Int,
    stockQuantity: Int
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var name: String = name
        private set

    var price: Int = price
        private set

    var stockQuantity: Int = stockQuantity
        private set
}
