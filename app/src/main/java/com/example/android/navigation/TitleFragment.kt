package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

class TitleFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentTitleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)

        setHasOptionsMenu(true)
        binding.playButton.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.playButton -> {
                moveToNextFragment(p0)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,view!!.findNavController()) ||super.onOptionsItemSelected(item)

    }

    private fun moveToNextFragment(view: View) {
        view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
    }

}