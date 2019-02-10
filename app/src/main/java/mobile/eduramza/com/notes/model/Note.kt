package mobile.eduramza.com.notes.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Note(@PrimaryKey(autoGenerate = true)
           val id: Long = 0,
           var title: String,
           var description: String,
           var color: Int)