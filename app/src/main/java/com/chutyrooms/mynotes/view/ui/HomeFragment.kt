package com.chutyrooms.mynotes.view.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.chutyrooms.mynotes.R
import com.chutyrooms.mynotes.databinding.FragmentHomeBinding
import com.chutyrooms.mynotes.service.model.Note
import com.chutyrooms.mynotes.view.adapter.NoteAdapter
import com.chutyrooms.mynotes.viewmodel.NoteViewModel


class HomeFragment : Fragment(R.layout.fragment_home), NoteAdapter.OnItemClickListener
{
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
   // private lateinit var noteViewModel: NoteViewModel
    lateinit var viewModel:NoteViewModel
    private  val TAG = "HomeFragment"
    lateinit var noteAdapter:NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //noteViewModel = (activity as MainActivity).noteViewModel
        viewModel= (activity as MainActivity).noteViewModel!!

        setUpRecyclerView(view)




        binding.fbAddNote.setOnClickListener{ mView ->
            mView.findNavController().navigate(R.id.action_homeFragment_to_newNoteFragment)
        }
    }

    private fun setUpRecyclerView(view: View) {
        noteAdapter = NoteAdapter(this)

        binding.recyclerView.apply{
            layoutManager = StaggeredGridLayoutManager(
                2,
                StaggeredGridLayoutManager.VERTICAL
            )
            setHasFixedSize(true)
            adapter = noteAdapter
           /* layoutManager=LinearLayoutManager(view.context)
            setHasFixedSize(true)
            adapter=noteAdapter*/
        }

        viewModel.getAllNotes().observe(this){
            //binding.recyclerView.adapter.submitList()
            Log.d(TAG, "onViewCreated: "+it.toString())
            binding.cardView.visibility=View.INVISIBLE
            if(it.isNotEmpty())
            {
                binding.recyclerView.visibility=View.VISIBLE
                noteAdapter.submitList(it)

            }


        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemClick(task: Note, view: View) {

        view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToUpdateNoteFragment(task))
    }
}