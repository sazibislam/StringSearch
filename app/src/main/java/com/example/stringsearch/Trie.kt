package com.example.stringsearch

internal class Trie {

    var root: TrieNode = TrieNode()

    // Insert all the Contacts into the Trie
    fun insertIntoTrie(contacts: Array<String>) {
        root = TrieNode()
        val n = contacts.size
        for (i in 0 until n) {
            insert(contacts[i])
        }
    }

    // Insert a Contact into the Trie
    fun insert(s: String) {
        val len = s.length

        // 'itr' is used to iterate the Trie Nodes
        var itr: TrieNode = root
        for (i in 0 until len) {
            // Check if the s[i] is already present in
            // Trie
            var nextNode = itr.child[s[i]]
            if (nextNode == null) {
                // If not found then create a new TrieNode
                nextNode = TrieNode()

                // Insert into the HashMap
                itr.child[s[i]] = nextNode
            }

            // Move the iterator('itr') ,to point to next
            // Trie Node
            itr = nextNode

            // If its the last character of the string 's'
            // then mark 'isLast' as true
            if (i == len - 1) {
                itr.isLast = true
            }
        }
    }

    // This function simply displays all dictionary words
    // going through current node.  String 'prefix'
    // represents string corresponding to the path from
    // root to curNode.
    fun displayContactsUtil(
        curNode: TrieNode,
        prefix: String
    ) {

        // Check if the string 'prefix' ends at this Node
        // If yes then display the string found so far
        if (curNode.isLast) {
            println(prefix)
        }

        // Find all the adjacent Nodes to the current
        // Node and then call the function recursively
        // This is similar to performing DFS on a graph
        var i = 'a'
        while (i <= 'z') {
            val nextNode = curNode.child[i]
            if (nextNode != null) {
                displayContactsUtil(nextNode, prefix + i)
            }
            i++
        }
    }

    // Display suggestions after every character enter by
    // the user for a given string 'str'
    fun displayContacts(str: String) {
        var prevNode = root

        // 'flag' denotes whether the string entered
        // so far is present in the Contact List

        var prefix = ""
        val len = str.length

        // Display the contact List for string formed
        // after entering every character
        var i: Int
        i = 0
        while (i < len) {
            // 'str' stores the string entered so far
            prefix += str[i]

            // Get the last character entered
            val lastChar = prefix[i]

            // Find the Node corresponding to the last
            // character of 'str' which is pointed by
            // prevNode of the Trie
            val curNode = prevNode.child[lastChar]

            // If nothing found, then break the loop as
            // no more prefixes are going to be present.
            if (curNode == null) {
                println("nNo Results Found for $prefix")
                i++
                break
            }

            // If present in trie then display all
            // the contacts with given prefix.
            println("nSuggestions based on $prefix are")
            displayContactsUtil(curNode, prefix)

            // Change prevNode for next prefix
            prevNode = curNode
            i++
        }

        while (i < len) {
            prefix += str[i]
            println("nNo Results Found for $prefix")
            i++
        }
    }
}
