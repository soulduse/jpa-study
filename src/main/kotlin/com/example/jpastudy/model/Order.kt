package com.example.jpastudy.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @ManyToOne
    @JoinColumn(name = "member_id")
    var member: Member? = null
        private set

    @OneToMany(mappedBy = "order")
    val orderItems: MutableList<OrderItem> = mutableListOf()

    fun setMember(member: Member) {
        if (this.member != null) {
            member.orders.remove(this)
        }
        this.member = member
        member.orders.add(this)
    }

    fun addOrderItem(orderItem: OrderItem) {
        orderItems.add(orderItem)
        orderItem.addOrder(this)
    }
}
