package com.sum.capstoneproject.ui.forgotpassword

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
import com.sum.capstoneproject.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : Fragment() {
    private var _binding: FragmentForgotPasswordBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ForgotPasswordViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_forgot_password, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.forgotFragmentObject = this


        with(viewModel) {
            isInfosValid.observe(viewLifecycleOwner) {

                if (it.not()) Snackbar.make(requireView(),
                    R.string.incomplete_information_entered,
                    1000).show()

            }


            isPasswordUpdate.observe(viewLifecycleOwner) {
                if (it) {
                    Snackbar.make(view, "Sumeyraaaa", 1000).show()
                   // findNavController().navigate(R.id.action_forgotPasswordFragment_to_home_navigation)



                } else {
                    Snackbar.make(view, R.string.wrong_email, 1000).show()
                }
            }
        }
    }

    fun updatePasswordButton(eMail: String) {
        viewModel.updatePassword(eMail)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }


}