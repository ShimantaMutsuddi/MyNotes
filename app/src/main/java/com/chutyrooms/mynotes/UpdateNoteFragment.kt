package com.chutyrooms.mynotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.chutyrooms.mynotes.databinding.FragmentNewNoteBinding
import com.chutyrooms.mynotes.databinding.FragmentUpdateNoteBinding


class UpdateNoteFragment : Fragment(R.layout.fragment_update_note)
{
    private var _binding: FragmentUpdateNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdateNoteBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabUpdate.setOnClickListener{ mView ->
            mView.findNavController().navigate(R.id.action_updateNoteFragment_to_homeFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}