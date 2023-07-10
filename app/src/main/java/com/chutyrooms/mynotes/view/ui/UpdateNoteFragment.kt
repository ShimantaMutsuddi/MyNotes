package com.chutyrooms.mynotes.view.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.chutyrooms.mynotes.R
import com.chutyrooms.mynotes.databinding.FragmentUpdateNoteBinding


class UpdateNoteFragment : Fragment(R.layout.fragment_update_note)
{
    private var _binding: FragmentUpdateNoteBinding? = null
    private val binding get() = _binding!!
    private  val TAG = "UpdateNoteFragment"

    private val args: UpdateNoteFragmentArgs by navArgs()

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

        val note =args.note
        //binding.etNoteTitleUpdate.text = args.note.noteTitle
        //binding.etNoteContentUpdate.text=args.note.noteBody
        Log.d(TAG, "onClick : ${args.note.toString()}")

       // val title= note.noteTitle.toString()

        binding.etNoteTitleUpdate.setText(note.noteTitle)
        binding.etNoteContentUpdate.setText(note.noteBody)

        binding.fabUpdate.setOnClickListener{ mView ->
            mView.findNavController().navigate(R.id.action_updateNoteFragment_to_homeFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}