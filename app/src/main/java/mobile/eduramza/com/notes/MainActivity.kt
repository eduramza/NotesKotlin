package mobile.eduramza.com.notes

import android.arch.persistence.room.Room
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import mobile.eduramza.com.notes.adapter.NotesAdapter
import mobile.eduramza.com.notes.database.AppDatabase
import mobile.eduramza.com.notes.model.Note
import mobile.eduramza.com.notes.dao.CategoryDao
import mobile.eduramza.com.notes.dao.NoteDao
import android.util.TypedValue
import mobile.eduramza.com.notes.custom.GridSpacingItemDecoration
import android.support.v7.widget.GridLayoutManager


class MainActivity : AppCompatActivity() {

    lateinit var adapter: NotesAdapter
    lateinit var listNote: List<Note>
    lateinit var noteDao: NoteDao
    lateinit var categoryDao: CategoryDao
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDatabase()
        initComponents()

    }

    private fun initComponents(){

        listNote = ArrayList()
        recyclerView = recycler_view

        adapter =  NotesAdapter(this, listNote, noteDao)
        recyclerView.adapter = adapter

        val mLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.addItemDecoration(GridSpacingItemDecoration(2, dpToPx(5), true))
        recyclerView.itemAnimator = DefaultItemAnimator()

        fab_add.setOnClickListener { openNewNote() }
    }

    private fun initDatabase(){
        //database config
        val database = Room.databaseBuilder(this, AppDatabase::class.java, "Notes-database")
                .allowMainThreadQueries()
                .build()

        noteDao = database.noteDao()
        categoryDao = database.categoryDao()
        //end database config

        listNote = noteDao.getAll()

    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }

    private fun openNewNote(){
        var notesActivity = NotesActivity.newInstance(noteDao)
        val intent = Intent(this,notesActivity::class.java)
        startActivity(intent)
        finish()
    }

    /**
     * Converting dp to pixel
     */
    private fun dpToPx(dp: Int): Int {
        val r = resources
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics))
    }
}
