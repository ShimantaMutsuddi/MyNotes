package com.chutyrooms.mynotes.view.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.chutyrooms.mynotes.R
import com.chutyrooms.mynotes.databinding.FragmentNewNoteBinding
import com.chutyrooms.mynotes.viewmodel.NoteViewModel


class NewNoteFragment : Fragment(R.layout.fragment_new_note)
{
    private var _binding: FragmentNewNoteBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel:NoteViewModel
    private  val TAG = "NewNoteFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewNoteBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel= (activity as MainActivity).viewModel!!

        binding.fabNew.setOnClickListener{ mView ->
            createNotes(mView)
            mView.findNavController().navigate(R.id.action_newNoteFragment_to_homeFragment)
        }
    }

    private fun createNotes(mView: View?) {
        val title=binding.etNoteTitle.text
        val subTitle=binding.etNoteTitle.text
        val notes=binding.etNoteContent.text
        Log.d(TAG, "createNotes: $title $subTitle $notes")

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}