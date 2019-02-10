package mobile.eduramza.com.notes.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import mobile.eduramza.com.notes.model.Note

@Dao
interface NoteDao{
    @Query("SELECT * FROM note")
    fun getAll(): List<Note>

    @Query("DELETE FROM note WHERE id = :noteId")
    fun deleteNote(vararg noteId: Long)

    @Insert
    fun insertNote(vararg note: Note)
}