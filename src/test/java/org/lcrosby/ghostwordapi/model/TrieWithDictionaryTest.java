package org.lcrosby.ghostwordapi.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lcrosby.ghostwordapi.service.Trie;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrieWithDictionaryTest {

    private int countLines;
    private Trie trie;

    @Before
    public void init() throws Exception {
        Resource resource = new ClassPathResource("static/gosthGameDict.txt");
        String line;
        trie = new Trie();
        try {
            InputStream fileAsStream = resource.getInputStream();
            Scanner scanner = new Scanner(fileAsStream);

            while (scanner.hasNext()) {
                line = scanner.nextLine();
                if (!StringUtils.isEmpty(line)) {
                    trie.insert(line);
                    countLines++;
                } else {
                    System.out.println("empty line!: '" + line + "'");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(countLines);
    }

    @Test
    public void contextLoads() {
        System.out.println("search columbia " + trie.search("columbia"));
        System.out.println("search columbi " + trie.search("columbi"));
        System.out.println("startswith columbi " + trie.startsWith("columbi"));
        System.out.println("startswith columbia " + trie.startsWith("columbia"));
        Assert.assertTrue(trie.search("columbia"));
        System.out.println(trie.search("pi"));
        Assert.assertTrue(trie.search("pi"));
        System.out.println(trie.search("zipper"));
        Assert.assertTrue(trie.search("zipper"));
        System.out.println(trie.search("ccollumbia"));
        Assert.assertFalse(trie.search("ccollumbia"));
        System.out.println("startswith: " + trie.startsWith("cal"));
        System.out.println("startswith: " + trie.startsWith("cca"));
    }

}

