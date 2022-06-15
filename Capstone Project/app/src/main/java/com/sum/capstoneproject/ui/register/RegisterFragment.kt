package com.sum.capstoneproject.ui.register

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
import com.sum.capstoneproject.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RegisterViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      //  binding.btnAccount.setOnClickListener {
        //    findNavController().navigate(R.id.action_registerFragment_to_forgotPasswordFragment)
        //}
        binding.signUpFragmentObject = this
        initObservers()


    }
    private fun initObservers() {

        with(binding) {

            with(viewModel) {

                isInfosValid.observe(viewLifecycleOwner) {

                    if (it.not()) Snackbar.make(requireView(),
                        R.string.incomplete_information_entered,
                        1000).show()

                }

                isValidMail.observe(viewLifecycleOwner) {

                    if (it.not()) {
                        editTextRegisterEmail.error = getString(R.string.invalid_mail)
                    } else {
                        editTextRegisterEmail.error = ""
                    }

                }

                isPasswordMatch.observe(viewLifecycleOwner) {

                    if (it.not()) {
                        editTextRegisterPassword.error = getString(R.string.password_match_error)
                        editTextRegisterAgainPassword.error = getString(R.string.password_match_error)
                    } else {
                        editTextRegisterPassword.error = ""
                        editTextRegisterAgainPassword.error = ""
                    }

                }

                isSignUp.observe(viewLifecycleOwner) {

                    if (it) {
                        Snackbar.make(requireView(), R.string.sign_up_snack_text, 1000).show()
                        clearFields()
                    } else {
                        textViewEmail.error = getString(R.string.registered_mail)
                    }

                }
            }
        }
    }

    fun signUpButton(email: String, password: String, confirmPassword: String) {
        viewModel.signUp(email, password, confirmPassword)
    }
    private fun clearFields() {
        with(binding) {
            editTextRegisterEmail.setText("")
            editTextRegisterPassword.setText("")
            editTextRegisterAgainPassword.setText("")

        }
        }





    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }


}