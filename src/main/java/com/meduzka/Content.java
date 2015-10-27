package com.meduzka;

import java.util.List;

/**
 * @author Dmitri Lukoyanov
 * @created 27 Oct 2015
 */
public class Content {
    private long id;
    private List<String> content;

    public Content(String url) {
    }

    public long getId() {
        return id;
    }

    public List<String> getContent() {
        return content;
    }
}
