package com.emmagcarbontest.app.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.emmagcarbontest.app.R

import com.emmagcarbontest.app.users.util.UIState
import com.emmagcarbontest.app.users.util.setUpUI
import com.emmagcarbontest.app.util.NetworkChecker
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.users_fragment.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class UsersFragment : Fragment() {

    //Inject dependencies:
    @Inject
    lateinit var networkChecker: NetworkChecker

    /*** ViewModel to be Injected by Hilt ***/
    private val viewModel: UsersViewModel by viewModels()

    companion object {
        fun newInstance() = UsersFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.users_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.startNetworkChecking(networkChecker)

        //When the fragment loads, we display the users:
        lifecycleScope.launch {
            displayUsers(viewModel)
        }

        // determine what happens when the user swipes on the screen:
        swipeRefreshLayout.setOnRefreshListener {
            lifecycleScope.launch {
                displayUsers(viewModel)
            }
        }

        //set a listener to listen for network changes:
        NetworkChecker.canConnect.observe(viewLifecycleOwner, Observer {
            if (it) {
                setUpUI(UIState.NETWORK_CONNECTION_AVAILABLE)
            } else {
                setUpUI(UIState.NO_NETWORK_CONNECTION)
            }
        })
    }


    /*** Fetches users and displays them in the recyclerView ***/
    private suspend fun displayUsers(viewModel: UsersViewModel) {
        setUpUI(UIState.LOADING)
        //make request to fetch users:
        val users = viewModel.getUsers()

        if (users == null) {
            //No user was found:
            setUpUI(UIState.NO_DATA)
        } else {
            setUpUI(UIState.DATA_FOUND, users)
        }
    }

}