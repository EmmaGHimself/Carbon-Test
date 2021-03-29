package com.emmagcarbontest.app.local.dao

import androidx.annotation.Keep
import androidx.room.*
import com.emmagcarbontest.restapi.models.User

@Keep
@Dao
interface UserDao {

    @Insert
    suspend fun saveUser(user: User)

    @Query("SELECT * FROM user WHERE id = :id")
    suspend fun getUserByID(id: String): User?

    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<User>?

    @Update
    suspend fun updateUser(user: User)
}