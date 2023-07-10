package com.chutyrooms.mynotes.view.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chutyrooms.mynotes.databinding.NoteLayoutAdapterBinding
import com.chutyrooms.mynotes.service.model.Note
import java.util.*

class NoteAdapter(private val listener: OnItemClickListener): ListAdapter<Note,NoteAdapter.NoteViewHolder>(TaskDiffCallBack()) {


    class NoteViewHolder(val itemBinding: NoteLayoutAdapterBinding):
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Note) {
            itemBinding.apply {
                tvNoteTitle.text=item.noteTitle
                tvNoteBody.text=item.noteBody
            }
        }
    }

    class TaskDiffCallBack : DiffUtil.ItemCallback<Note>(){
            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem == newItem
            }
        }

   // val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            NoteLayoutAdapterBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
       // val currentNote = getItem(position)

        /*holder.itemBinding.tvNoteTitle.text = currentNote.noteTitle
        holder.itemBinding.tvNoteBody.text = currentNote.noteBody*/
        holder.bind(getItem(position))
         val random = Random()
         val color = Color.argb(
             255,
             random.nextInt(256),
             random.nextInt(256),
             random.nextInt(256)
         )

         holder.itemBinding.viewColor?.setBackgroundColor(color)

        /* holder.itemView.setOnClickListener{ mView ->
             val direction = HomeFragmentDirections
                 .actionHomeFragmentToUpdateNoteFragment()
             mView.findNavController().navigate(
                 direction
             )
         }*/

        holder.itemBinding.root.setOnClickListener{
            val position = holder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val task = getItem(position)
                listener.onItemClick(task,it)
            }
        }
    }

  interface OnItemClickListener {
        fun onItemClick(task: Note, view: View)
    }


}