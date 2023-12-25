package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentOtherBinding

class OtherFragment: Fragment() {

    private var _binding: FragmentOtherBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtherBinding.inflate(inflater, container, false)
        binding.button.text = arguments?.getString(ARG_STRING) ?: "button"
        binding.button.setOnClickListener {
            val activity = requireActivity()
            if (activity is DataProvider) {
                activity.result = binding.infoInput.text.toString()
            }
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val ARG_STRING = "argument"

        fun newInstance(arg: String): OtherFragment {
            return OtherFragment().apply {
                arguments = bundleOf(
                    ARG_STRING to arg
                )
            }
        }
    }
}