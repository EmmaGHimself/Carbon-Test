package com.emmagcarbontest.app.users

import com.emmagcarbontest.app.data.UserRepository
import com.emmagcarbontest.restapi.models.User
import com.nhaarman.mockitokotlin2.mock
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`

class UsersViewModelTest {

    private lateinit  var viewModel: UsersViewModel


    private lateinit var repository: UserRepository

   @Before
    fun init(){
        repository = mock()
    }

    @Test
    fun `UsersViewModel should return data from remote source`() = runBlocking{

        //Given
        val userA = User(id = "1")
        val userB = User(id = "2")
        val usersResponse = listOf(userA, userB)

        //When
        `when`(repository.getUsersFromRemote()).thenReturn(usersResponse.toCollection(ArrayList()))
        `when`(repository.saveUser(userA)).thenReturn(Unit)

        viewModel = UsersViewModel(repository)

        val users = viewModel.getUsers()

        assertTrue(users != null && users.size == 2)
    }

    @Test
    fun `UsersViewModel should return data from local source when remote source returns null`()
        = runBlocking{

        //Given
        val userA = User(id = "1")
        val userB = User(id = "2")
        val usersResponse = listOf(userA, userB)

        //When
        `when`(repository.getUsersFromRemote()).thenReturn(null)
        `when`(repository.getUsersLocally()).thenReturn(usersResponse)
        `when`(repository.saveUser(userA)).thenReturn(Unit)

        viewModel = UsersViewModel(repository)

        val users = viewModel.getUsers()

        assertTrue(users != null && users.size == 2)
    }


}