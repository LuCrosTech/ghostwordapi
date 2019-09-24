package org.lcrosby.ghostwordapi.model;

/**
 * This is the message structure to be returned in the endpoint.
 * It is expected to be converted to json.
 *
 * @author lcrosby
 */
public class WordResponse {
    protected boolean startsWith;
    protected boolean isWord;

    public boolean isStartsWith() {
        return startsWith;
    }

    public void setStartsWith(boolean startsWith) {
        this.startsWith = startsWith;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }
}
