package com.sum.capstoneproject.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class FirebaseRepository {
    private var _isLogin = MutableLiveData<Boolean>()
    private var _isRegister = MutableLiveData<Boolean>()
    private var _isCurrentUser = MutableLiveData<Boolean>()
    private var _isUpdatePassword = MutableLiveData<Boolean>()

    private var auth = Firebase.auth

    fun getIsSignIn(): MutableLiveData<Boolean> {
        return _isLogin
    }

    fun getIsSignUp(): MutableLiveData<Boolean> {
        return _isRegister
    }

    fun getIsUpdatePassword(): MutableLiveData<Boolean> {
        return _isUpdatePassword
    }

    fun getCurrentUser(): MutableLiveData<Boolean> {
        return _isCurrentUser
    }

    fun currentUser() {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            _isCurrentUser.value = true
        }

    }


    fun updatePassword(eMail: String) {
        FirebaseAuth.getInstance().sendPasswordResetEmail(eMail)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _isUpdatePassword.value = true
                    Log.d(SIGN_IN_TAG, SUCCESS)
                    System.out.println("Update Password")


                } else {
                    _isUpdatePassword.value = false
                    System.out.println("Update Password")


                }
            }
    }


    fun signIn(eMail: String, password: String) {

        auth.signInWithEmailAndPassword(eMail, password).addOnCompleteListener { task ->

            if (task.isSuccessful) {
                _isLogin.value = true
                Log.d(SIGN_IN_TAG, SUCCESS)
            } else {
                _isLogin.value = false
                Log.w(SIGN_IN_TAG, FAILURE, task.exception)
            }

        }
    }

    fun signUp(eMail: String, password: String) {

        auth.createUserWithEmailAndPassword(eMail, password).addOnCompleteListener { task ->

            if (task.isSuccessful) {

                _isRegister.value = true
                Log.d(SIGN_UP_TAG, SUCCESS)

            } else {
                _isRegister.value = false
                Log.w(SIGN_UP_TAG, FAILURE, task.exception)
            }

        }
    }


    companion object {
        private const val SIGN_IN_TAG = "Login"
        private const val SIGN_UP_TAG = "Register"
        private const val SUCCESS = "Success"
        private const val FAILURE = "Failure"

    }
}