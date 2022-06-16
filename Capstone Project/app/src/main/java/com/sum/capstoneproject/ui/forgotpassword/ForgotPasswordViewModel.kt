package com.sum.capstoneproject.ui.forgotpassword

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sum.capstoneproject.repository.FirebaseRepository

class ForgotPasswordViewModel: ViewModel()  {
    private var usersRepo = FirebaseRepository()

    private var _isPasswordUpdate = MutableLiveData<Boolean>()
    val isPasswordUpdate: LiveData<Boolean>
        get() = _isPasswordUpdate

    private var _isInfosValid = MutableLiveData<Boolean>()
    val isInfosValid: LiveData<Boolean>
        get() = _isInfosValid

    init {
        _isPasswordUpdate = usersRepo.getIsUpdatePassword()
    }

    fun updatePassword(eMail: String) {
        if (eMail.isEmpty()) {

            _isInfosValid.value = false
        }else {
            usersRepo.updatePassword(eMail)
        }
    }

}