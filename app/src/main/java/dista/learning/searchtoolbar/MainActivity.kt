package dista.learning.searchtoolbar

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.widget.SearchView



class MainActivity : AppCompatActivity() {

    private  lateinit var listView :ListView
    private var  arrayAdapter:ArrayAdapter<String>? =null
    private val names = listOf<String>("John", "Hello", "Vishal", "kunal", "Arun", "rupesh", "Ramdas","Shoham")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lvNames) // Find the listView
        arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,names) // Adapt the list of name to listView
        listView.adapter = arrayAdapter // Attach listViewAdapter to arrayAdapter
    }

    // to create the search option in menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate menu
        menuInflater.inflate(R.menu.menu, menu)

        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as SearchView
        searchView.queryHint = "Search here..."

        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus() // Clear an widget appears on the screen after the submit of the text
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                arrayAdapter?.filter?.filter(newText)  // After the text change it filter out the data
                return true
            }

        })

        return super.onCreateOptionsMenu(menu)
    }


}