package com.example.stringsearch

import java.util.*

internal class TrieNode {

    // Each Trie Node contains a Map 'child'
    // where each alphabet points to a Trie
    // Node.
    var child: HashMap<Char, TrieNode?> = HashMap()

    // 'isLast' is true if the node represents
    // end of a contact
    var isLast: Boolean = false

    // Default Constructor
    init {
        child = HashMap()

        // Initialize all the Trie nodes with NULL
        var i = 'a'
        while (i <= 'z') {
            child[i] = null
            i++
        }

        isLast = false
    }
}
