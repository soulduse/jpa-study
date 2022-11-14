package com.example.jpastudy.model.ex6

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class Delivery(
    city: String,
    street: String,
    zipCode: String,
    status: DeliveryStatus
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var city: String = city
        private set

    var street: String = street
        private set

    var zipCode: String = zipCode
        private set

    @Enumerated(EnumType.STRING)
    var status: DeliveryStatus = status
        private set

    @OneToOne(mappedBy = "delivery")
    var order: Order? = null
        private set

    fun setOrder(order: Order) {
        this.order = order
    }
}

enum class DeliveryStatus {
    READY,
    DELIVERING,
    DONE
}
