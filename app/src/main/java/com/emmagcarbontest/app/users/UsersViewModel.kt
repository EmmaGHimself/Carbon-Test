package com.emmagcarbontest.app.users

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.emmagcarbontest.app.data.UserRepository
import com.emmagcarbontest.restapi.models.User
import com.emmagcarbontest.app.util.NetworkChecker

open class UsersViewModel @ViewModelInject constructor(var userRepository: UserRepository?)
    : ViewModel() {

    /***  Returns a list of users from either remote database or local database ***/
    suspend fun getUsers(): List<User>?{
        var users: List<User>? = null

        if(userRepository != null){
            //get users from remote database:
            users = userRepository?.getUsersFromRemote()

            if(users != null){
                //if we were able to fetch user's from  the service, then we need to save these users
                // in the local database for offline purpose:
                saveUsers(users)

            }else{//if no user was found, we fetch from local database:
                users =  userRepository?.getUsersLocally()
            }
        }
        return users
    }


    /*** Saves a list of users to the database ***/
    suspend fun saveUsers(users: List<User>){
        for(user in users){
            userRepository?.saveUser(user)
        }
    }


    /*** Starts the thread to listen for network or WIFI state ***/
    fun startNetworkChecking(networkChecker: NetworkChecker){
        Thread(networkChecker).start()
    }
}