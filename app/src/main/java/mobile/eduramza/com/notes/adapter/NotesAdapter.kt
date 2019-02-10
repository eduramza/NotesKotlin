package mobile.eduramza.com.notes.adapter

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import mobile.eduramza.com.notes.model.Note
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.item_list_recycler.view.*
import mobile.eduramza.com.notes.R
import mobile.eduramza.com.notes.dao.NoteDao


class NotesAdapter(val context: Context, val noteList: List<Note>, val noteDao: NoteDao) : RecyclerView.Adapter<NotesAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View, val noteDao: NoteDao) : RecyclerView.ViewHolder(view) {

        fun bindView(note: Note){
            val title = view.text_note_title
            val desc = view.text_note_desc
            val layout = view.linear_item

            title?.text = note.title
            desc?.text = note.description
            layout.setOnLongClickListener { deleteNote(note.id) }
        }

        private fun deleteNote(id: Long): Boolean {
            noteDao.deleteNote(id)
            return true
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_list_recycler, parent, false)
        return MyViewHolder(itemView, noteDao)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val notes  = noteList[position]
        holder.bindView(notes)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

}