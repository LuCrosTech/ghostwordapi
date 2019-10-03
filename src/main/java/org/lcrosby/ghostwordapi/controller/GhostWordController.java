package org.lcrosby.ghostwordapi.controller;

import org.lcrosby.ghostwordapi.model.WordResponse;
import org.lcrosby.ghostwordapi.service.WordAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * The rest api controller class.
 * No api security is implemented in this preliminary version.
 * Basic validation is applied with jsr 303.
 *
 * @author lcrosby
 */
@Controller
public class GhostWordController {

    @Autowired
    private WordAnalyzer wordAnalyzer;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/tell/{word}")
    @ResponseBody
    public WordResponse tell(@PathVariable("word")
                             @Valid
                             @NotEmpty(message = "Please provide a word")
                             @Pattern(regexp = "^[A-Za-z]+$")
                                     String word) {
        WordResponse response = new WordResponse();
        response.setStartsWith(wordAnalyzer.startsWith(word));
        response.setWord(wordAnalyzer.search(word));
        return response;
    }
}
