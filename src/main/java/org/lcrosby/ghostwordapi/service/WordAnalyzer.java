package org.lcrosby.ghostwordapi.service;

import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
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
        File file = ResourceUtils.getFile("classpath:static/gosthGameDict.txt");
        System.out.println("File Found : " + file.exists());
        String line;
        trie = new Trie();
        try (Scanner scanner = new Scanner(file)) {

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
