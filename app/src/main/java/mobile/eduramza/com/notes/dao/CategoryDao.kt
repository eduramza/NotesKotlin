package mobile.eduramza.com.notes.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import mobile.eduramza.com.notes.model.Category

@Dao
interface CategoryDao{
    @Query("SELECT * FROM category WHERE noteId = :noteId")
    fun getCategory(noteId: Long): List<Category>
}