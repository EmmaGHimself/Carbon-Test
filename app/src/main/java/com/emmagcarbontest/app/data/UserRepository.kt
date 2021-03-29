package com.emmagcarbontest.app.data

import com.emmagcarbontest.restapi.Service
import com.emmagcarbontest.app.local.AppDatabase
import com.emmagcarbontest.restapi.models.User
import com.emmagcarbontest.restapi.models.UserResponse

open class UserRepository {

    var service: Service? = null
    var database: AppDatabase? = null


    /*** Saves a user to the local database. If the user already exists, the copy in the database
     * will be updated with the new user data. */
    open suspend fun saveUser(newUser: User){
        //Before saving a user, we first check if the user already exists:
        val oldUser = database?.userDao()?.getUserByID(newUser.id)

        if(oldUser == null){
            database?.userDao()?.saveUser(newUser)
        }else{
            database?.userDao()?.updateUser(newUser)
        }
    }


    /***  Fetches a user from remote database ***/
    open suspend fun getUserFromRemote(userID: String): User?{

        return try {
            val response = service?.fetchUser(userID) ?: return null
            if(response.code() == 200 && response.body() != null){ //response form server:
                val  userResponse = response.body() as User
                userResponse
            }else{//We assume that this is a network error:
                null
            }
        } catch (e: Exception) {
            null
        }
    }


    /***  Fetches a user locally from the database ***/
    open suspend fun getUserLocally(userID: String): User?{
        return database?.userDao()?.getUserByID(userID)
    }

    /***  Fetches users from remote database ***/
    open suspend fun getUsersFromRemote(): ArrayList<User>?{

        return try {
            val response = service?.fetchUsers() ?: return null
            if(response.code() == 200 && response.body() != null){ //response form server:
                val  userResponse = response.body() as UserResponse
                userResponse.data?.toCollection(ArrayList())

            }else{//We assume that this is a network error:
                null
            }
        } catch (e: Exception) {
            null
        }
    }


    /***  Fetches users locally from the database ***/
    open suspend fun getUsersLocally(): List<User>?{
        return database?.userDao()?.getAllUsers()
    }
}