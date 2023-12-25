package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentMyBinding

class MyFragment : Fragment() {

    private var _binding: FragmentMyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyBinding.inflate(inflater, container, false)
        val activity = requireActivity()
        if (activity is DataProvider && activity.result != null) {
            binding.resultText.text = activity.result
        }
        binding.anotherFragmentButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, OtherFragment.newInstance("lolkek"))
                .addToBackStack("fragment")
                .commit()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): MyFragment {
            return MyFragment()
        }
    }
}