package mobile.eduramza.com.notes

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_notes.*
import mobile.eduramza.com.notes.dao.NoteDao
import mobile.eduramza.com.notes.model.Note

class NotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        fab_confirm.setOnClickListener { saveNote() }
    }

    companion object {
        private lateinit var noteDao: NoteDao

        fun newInstance(noteDao: NoteDao): NotesActivity{
            var activity = NotesActivity()
            this.noteDao = noteDao
            return activity
        }
    }

    private fun saveNote(){
        if (edit_title.text.isNotEmpty() && edit_desc.text.isNotEmpty()){
            val note = Note(title = edit_title.text.toString(), description = edit_desc.text.toString(), color = 444 )
            noteDao.insertNote(note)
            Toast.makeText(this, "Nota salva com sucesso!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "É necesário preencher todos os campos!", Toast.LENGTH_SHORT).show()
        }

    }
}
