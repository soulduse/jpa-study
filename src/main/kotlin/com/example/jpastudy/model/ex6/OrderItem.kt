package com.example.jpastudy.model.ex6

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @ManyToOne
    @JoinColumn(name = "order_id")
    var order: Order? = null
        private set

    @ManyToOne
    @JoinColumn(name = "item_id")
    var item: Item? = null
        private set

    fun setOrder(order: Order) {
        this.order = order
    }
}
