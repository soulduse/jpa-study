package com.example.jpastudy.model.ex6

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne

@Entity
class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @ManyToOne
    @JoinColumn(name = "member_id")
    var member: Member? = null
        private set

    @OneToOne
    @JoinColumn(name = "delivery_id")
    var delivery: Delivery? = null
        private set

    @OneToMany(mappedBy = "order")
    var orderItems: MutableList<OrderItem> = mutableListOf()
        private set

    fun setMember(member: Member) {
        if (this.member != null) {
            this.member!!.orders.remove(this)
        }
        this.member = member
        member.orders.add(this)
    }

    fun addOrderItem(orderItem: OrderItem) {
        this.orderItems.add(orderItem)
        orderItem.setOrder(this)
    }

    fun setDelivery(delivery: Delivery) {
        this.delivery = delivery
        delivery.setOrder(this)
    }
}

enum class OrderStatus {
    READY,
    COOKING,
    DONE
}
