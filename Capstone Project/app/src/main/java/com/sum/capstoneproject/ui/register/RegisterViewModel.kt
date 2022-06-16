package com.sum.capstoneproject.ui.register

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sum.capstoneproject.repository.FirebaseRepository

class RegisterViewModel : ViewModel() {

    private var usersRepo = FirebaseRepository()

    private var _isInfosValid = MutableLiveData<Boolean>()
    val isInfosValid: LiveData<Boolean>
        get() = _isInfosValid

    private var _isValidMail = MutableLiveData<Boolean>()

    val isValidMail: LiveData<Boolean>
        get() = _isValidMail

    private var _isPasswordMatch = MutableLiveData<Boolean>()
    val isPasswordMatch: LiveData<Boolean>
        get() = _isPasswordMatch

    private var _isRegister = MutableLiveData<Boolean>()
    val isSignUp: LiveData<Boolean>
        get() = _isRegister






    init {
        _isRegister = usersRepo.getIsSignUp()
    }

    fun signUp(eMail: String, password: String, confirmPassword: String) {

        if (eMail.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {

            _isInfosValid.value = false

        } else {

            if (Patterns.EMAIL_ADDRESS.matcher(eMail).matches().not()) {

                _isValidMail.value = false

            }else {

                if (password != confirmPassword) {

                    _isPasswordMatch.value = false

                }else {

                    usersRepo.signUp(eMail, password)
                }

            }
        }
    }
}