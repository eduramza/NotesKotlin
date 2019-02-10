package mobile.eduramza.com.notes.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Colors(@PrimaryKey(autoGenerate = true)
             val id: Long = 0,
             val colorCode: String)