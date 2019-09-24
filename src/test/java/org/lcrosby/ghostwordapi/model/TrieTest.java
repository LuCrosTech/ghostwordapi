package org.lcrosby.ghostwordapi.model;

import org.junit.Before;
import org.junit.Test;
import org.lcrosby.ghostwordapi.service.Trie;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieTest {
    private Trie trie;

    @Before
    public void setUp() {
        trie = new Trie();
        trie.insert("at");
        trie.insert("Hello");
        trie.insert("Been");
        trie.insert("yes");
        trie.insert("water");
        trie.insert("be");
    }

    @Test
    public void testInsert() {
        assertTrue(trie.search("water"));
        assertTrue(trie.search("at"));
        assertFalse(trie.search("Beat"));
        assertFalse(trie.search("Test"));
    }
}
