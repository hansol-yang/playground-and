package com.engflip.www.playgroundand.ui.store_state.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.engflip.www.playgroundand.model.User

class UserViewModel : ViewModel() {
    private val _users =
        MutableLiveData<List<User>>()
    val users: LiveData<List<User>>
        get() = _users

    fun onViewCreated() {
        _users.value = getUsers()
    }

    private fun getUsers(): List<User> {
        return listOf(
            User(1, "A", 12),
            User(2, "B", 13),
            User(3, "C", 14),
            User(4, "D", 15),
            User(5, "E", 16),
            User(6, "F", 17),
            User(7, "G", 18)
        )
    }
}