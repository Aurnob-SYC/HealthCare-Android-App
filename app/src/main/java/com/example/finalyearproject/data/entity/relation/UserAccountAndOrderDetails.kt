package com.example.finalyearproject.data.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.finalyearproject.data.entity.OrderDetails
import com.example.finalyearproject.data.entity.UserAccount

data class UserAccountAndOrderDetails(
    @Embedded val userAccount: UserAccount,
    @Relation(
        parentColumn = "email",
        entityColumn = "email"
    )
    val list: List<OrderDetails>
)
