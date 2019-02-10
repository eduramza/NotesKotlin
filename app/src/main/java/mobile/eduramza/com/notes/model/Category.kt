package mobile.eduramza.com.notes.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Category(@PrimaryKey(autoGenerate = true)
               val id: Long = 0,
               val category: String,
               val noteId: Long)