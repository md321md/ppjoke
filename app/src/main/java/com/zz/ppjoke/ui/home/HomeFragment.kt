package com.zz.ppjoke.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zz.ppjoke.R
import kotlinx.android.synthetic.main.fragment_home.text_home

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
//    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
//    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root: View = inflater.inflate(R.layout.fragment_home,container,false)
//        _binding = FragmentHomeBinding.inflate(inflater, container, false)

//        val root: View = binding.root

//        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            text_home.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        _binding = null
    }
}