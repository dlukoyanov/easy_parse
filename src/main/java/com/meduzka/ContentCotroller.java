package com.meduzka;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dmitri Lukoyanov
 * @created 27 Oct 2015
 */
@RestController
public class ContentCotroller {

    @RequestMapping("/parse")
    public Content parse(@RequestParam(value = "url", defaultValue = "http://ya.ru") String url){
            return new Content(url);
    }
}
