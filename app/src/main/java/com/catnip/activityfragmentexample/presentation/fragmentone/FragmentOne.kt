package com.catnip.activityfragmentexample.presentation.fragmentone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.catnip.activityfragmentexample.R
import com.catnip.activityfragmentexample.databinding.FragmentOneBinding
import com.catnip.activityfragmentexample.model.Person

class FragmentOne : Fragment() {

    private lateinit var binding : FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState:Bundle?){
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
    }

    private fun setClickListener() {
        binding.btnNavigate.setOnClickListener {
            navigateToFragmentTwo()
        }
        binding.btnSendDataNavigate.setOnClickListener {
            navigateToFragmentTwo(getPerson())
        }
    }

    private fun getPerson(): Person? {
        return Person(
            name = "Tony Stark",
            job = "The Mechanic",
            profileDesc = "Genius, Billionaire, Playboy, Philantropist",
            profilePictUrl = "https://upload.wikimedia.org/wikipedia/en/f/f2/Robert_Downey_Jr._as_Tony_Stark_in_Avengers_Infinity_War.jpg"
        )
    }

    private  fun navigateToFragmentTwo(person: Person? = null) {
        //bundle
        /*findNavController().navigate(R.id.action_fragmentOne2_to_fragmentTwo2,Bundle().apply {
            putParcelable("person",person)
        })*/

        //safeargs
        val action = FragmentOneDirections.actionFragmentOne2ToFragmentTwo2(person)
        findNavController().navigate(action)
    }
}