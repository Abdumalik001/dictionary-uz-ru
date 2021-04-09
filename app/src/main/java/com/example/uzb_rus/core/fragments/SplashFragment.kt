package com.example.uzb_rus.core.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorDestinationBuilder
import androidx.navigation.fragment.findNavController
import com.example.uzb_rus.LIST_SIZE
import com.example.uzb_rus.R
import com.example.uzb_rus.core.WordEntity
import com.example.uzb_rus.databinding.FragmentSplashBinding
import com.example.uzb_rus.databinding.ItemWordBinding
import com.example.uzb_rus.viewmodel.WordViewModel


class SplashFragment : Fragment() {

    private lateinit var wordViewModel: WordViewModel
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v = inflater.inflate(R.layout.fragment_splash, container, false)
        binding = FragmentSplashBinding.bind(v)
        wordViewModel = ViewModelProvider(this).get(WordViewModel::class.java)

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        wordViewModel.readAllWord.observe(viewLifecycleOwner, Observer {
            if (it.size > 5000) {
                loadListFragment(it)
            }
        })

        super.onViewCreated(view, savedInstanceState)
    }

    private fun loadListFragment(it: List<WordEntity>?) {
        val bundle = bundleOf("list" to it)

        findNavController().navigate(R.id.action_splashFragment_to_listFragment, bundle)

    }


}