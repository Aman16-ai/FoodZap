package com.example.foodzap.ui.auth

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.foodzap.R
import com.example.foodzap.data.model.api_payload.SendOtpPayload
import com.example.foodzap.ui.auth.viewModel.MobileNumberViewModel
import com.example.foodzap.utils.ApiHandler
import com.example.foodzap.utils.toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MobileNumberFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MobileNumberFragment : Fragment() {

    val mobileNumberViewModel : MobileNumberViewModel by viewModels()
    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mobile_number, container, false)
        val number_et = view.findViewById<EditText>(R.id.editTextNumber)
        val getOtpButton = view.findViewById<Button>(R.id.buttonGetOtp)
        progressBar = view.findViewById(R.id.api_progressBar)

        getOtpButton.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            getOtpButton.text = ""
            val sendOtpPayload = SendOtpPayload(number_et.text.toString())
            mobileNumberViewModel.getOtp(sendOtpPayload)
        }
        mobileNumberViewModel.getOtpStatus.observe(viewLifecycleOwner) {
            it?.let {
                when(it) {
                    is ApiHandler.Success -> {
                        progressBar.visibility = View.GONE
                        getOtpButton.text = "Get OTP"
                    }
                    is ApiHandler.Loading -> {
                        progressBar.visibility = View.VISIBLE
                    }
                    else -> {
                        requireContext().toast("Something went wrong")
                        progressBar.visibility = View.GONE
                        getOtpButton.text = "Get OTP"
                    }
                }
            }
        }
        return view
    }


}