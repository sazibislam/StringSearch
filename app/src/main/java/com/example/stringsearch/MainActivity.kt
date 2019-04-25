package com.example.stringsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    initView()
  }

  private fun initView() {

    val trie = Trie()
    val contacts = arrayOf("gforgeeks", "geeksquiz", "adfghjadg", "gaggdfgdfg")
    trie.insertIntoTrie(contacts)
    val query = "ge"
    // Note that the user will enter 'g' then 'e' so
    // first display all the strings with prefix as 'g'
    // and then all the strings with prefix as 'ge'
    trie.displayContacts(query)

  }
}
