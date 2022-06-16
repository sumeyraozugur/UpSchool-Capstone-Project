package com.sum.capstoneproject.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.sum.capstoneproject.R
import com.sum.capstoneproject.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInFragmentObject = this


        binding.TbtnLoginForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }
        //binding.loFragmentObject = this


        with(viewModel) {
            this.currentUser() //should call
            isCurrentUser.observe(viewLifecycleOwner){

                if(it){

                    findNavController().navigate(R.id.action_loginFragment_to_home_navigation2)

                }
            }
            isInfosValid.observe(viewLifecycleOwner) {

                if (it.not()) Snackbar.make(requireView(),
                    R.string.incomplete_information_entered,
                    1000).show()

            }

            isSignIn.observe(viewLifecycleOwner) {
                if (it) {
                    findNavController().navigate(R.id.action_loginFragment_to_home_navigation2)

                } else {
                    Snackbar.make(view, R.string.wrong_email_password, 1000).show()
                }
            }
        }


        binding.TbtnLoginRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

    }

    fun signInButton(email: String, password: String) {
        viewModel.signIn(email, password)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }


}