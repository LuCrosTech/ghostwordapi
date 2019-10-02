package org.lcrosby.ghostwordapi.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


/**
 * The singleton spring bean that will load the dictionary only once
 * and to be accessible across the application runtime.
 *
 * @author lcrosby
 */
public class WordAnalyzer {

    private Trie trie;

    private int countLines;

    public boolean search(String word) {
        return trie.search(word);
    }

    public boolean startsWith(String word) {
        return trie.startsWith(word);
    }

    @PostConstruct
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
}
