package mobile.eduramza.com.notes.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import mobile.eduramza.com.notes.dao.CategoryDao
import mobile.eduramza.com.notes.dao.NoteDao
import mobile.eduramza.com.notes.model.Category
import mobile.eduramza.com.notes.model.Colors
import mobile.eduramza.com.notes.model.Note

@Database(entities = [Note::class, Colors::class, Category::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase(){

    abstract fun noteDao(): NoteDao

    abstract fun categoryDao(): CategoryDao
}