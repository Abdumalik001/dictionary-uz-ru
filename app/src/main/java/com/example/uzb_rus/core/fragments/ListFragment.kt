package com.example.uzb_rus.core.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.view.animation.OvershootInterpolator
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.uzb_rus.LIST_SIZE
import com.example.uzb_rus.R
import com.example.uzb_rus.core.WordEntity
import com.example.uzb_rus.core.adapter.WordAdapter
import com.example.uzb_rus.core.adapter.WordAdapter2
import com.example.uzb_rus.databinding.FragmentListBinding
import com.example.uzb_rus.viewmodel.WordViewModel
import com.google.android.material.navigation.NavigationView
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import jp.wasabeef.recyclerview.animators.ScaleInTopAnimator

class ListFragment : Fragment(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: FragmentListBinding
    private val adapter by lazy(LazyThreadSafetyMode.NONE) { WordAdapter(requireContext()) }
    private lateinit var navView: NavigationView
    private lateinit var wordViewModel: WordViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var menu: ImageView
    private lateinit var drawerLayout: DrawerLayout

    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_list, container, false)
        binding = FragmentListBinding.bind(v)
        wordViewModel = ViewModelProvider(this).get(WordViewModel::class.java)



        recyclerView = binding.rv
        recyclerView.itemAnimator = ScaleInTopAnimator()
        recyclerView.adapter = AlphaInAnimationAdapter(adapter).apply {
            // Change the durations.
            setDuration(500)
            // Change the interpolator.
            setInterpolator(OvershootInterpolator())
            // Disable the first scroll mode.
            setFirstOnly(false)
        }

        val bundle = arguments
        val list = bundle!!.getParcelableArrayList<WordEntity>("list")
        Log.d("BBBBB", "onCreateView:$ ${list!!.size}")
        adapter.submitList(list)


        return v
    }

    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.menu.setOnClickListener {
            binding.drawerLayout.openDrawer(Gravity.START)
        }
        binding.navView.setNavigationItemSelectedListener(this)
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.favorites -> {
                Toast.makeText(requireContext(), "WRITER", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_listFragment_to_favoriteFragment)
            }
            R.id.exit -> {
                val builder = AlertDialog.Builder(requireContext())
                builder
                    .setTitle("Exit")
                    .setMessage("Are you really exit app ? ")
                    .setNegativeButton("No") { _, _ ->

                    }
                    .setPositiveButton("Yes") { _, _ ->
                        activity?.finish()
                    }

                    .create()
                    .show()

            }
        }
        return true
    }


}