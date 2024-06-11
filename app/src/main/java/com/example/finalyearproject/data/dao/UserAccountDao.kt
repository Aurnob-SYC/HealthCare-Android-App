package com.example.finalyearproject.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.finalyearproject.data.entity.HealthArticles
import com.example.finalyearproject.data.entity.OrderDetails
import com.example.finalyearproject.data.entity.UserAccount
import kotlinx.coroutines.flow.Flow

@Dao
interface UserAccountDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userAccount: UserAccount)

    @Delete
    fun delete(userAccount: UserAccount)

    @Query("SELECT * FROM UserAccount WHERE email = :email AND password = :password")
    fun authenticate(email: String, password: String): Flow<UserAccount>

    @Query("DELETE FROM UserAccount")
    fun deleteAll()



    //OTHERS !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    // HEALTH ARTICLES
    @Query("SELECT * FROM HEALTHARTICLES")
    fun getAllHealthArticles(): Flow<List<HealthArticles>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllHealthArticles(healthArticles: List<HealthArticles>)

    //
    // Order Details
    @Query("SELECT * FROM OrderDetails WHERE email = :email")
    fun getOrderDetailsByEmail(email: String): Flow<OrderDetails?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrderDetails(orderDetails: OrderDetails)

}