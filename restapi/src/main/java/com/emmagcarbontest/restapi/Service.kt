package com.emmagcarbontest.restapi


import com.emmagcarbontest.restapi.models.User
import com.emmagcarbontest.restapi.models.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface Service {

    @GET("/data/api/user?limit=100")
    suspend fun fetchUsers(): Response<UserResponse>

    @GET("/data/api/user/{userId}")
    suspend fun fetchUser(@Path("userId") userId: String): Response<User>
}