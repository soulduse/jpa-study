package com.example.jpastudy.model.ex5

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class OrderItem(
    orderPrice: Int,
    count: Int
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @ManyToOne
    @JoinColumn(name = "order_id")
    lateinit var order: Order

    @ManyToOne
    @JoinColumn(name = "item_id")
    lateinit var item: Item

    var orderPrice: Int = orderPrice
        private set

    var count: Int = count
        private set

    fun addOrder(order: Order?) {
        order?.orderItems?.remove(this)
    }
}
