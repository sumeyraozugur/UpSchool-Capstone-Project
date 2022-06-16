package com.sum.capstoneproject.ui.login


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sum.capstoneproject.repository.FirebaseRepository

class LoginViewModel : ViewModel() {

    private var usersRepo = FirebaseRepository()

    private var _isSignIn = MutableLiveData<Boolean>()
    val isSignIn: LiveData<Boolean>
        get() = _isSignIn

    private var _isInfosValid = MutableLiveData<Boolean>()
    val isInfosValid: LiveData<Boolean>
        get() = _isInfosValid

    private var _isCurrentUser = MutableLiveData<Boolean>()
    val isCurrentUser: LiveData<Boolean>
        get() = _isCurrentUser


    init {
        _isSignIn = usersRepo.getIsSignIn()
    }

    fun signIn(eMail: String, password: String) {
        if (eMail.isEmpty() || password.isEmpty()) {

            _isInfosValid.value = false

        }else {

            usersRepo.signIn(eMail, password)
        }

    }

   fun currentUser(){
       usersRepo.currentUser()
       _isCurrentUser = usersRepo.getCurrentUser()
   }

}