package com.meduzka;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * @author Dmitri Lukoyanov
 * @created 27 Oct 2015
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<Application> applicationClass = Application.class;


}

/**
 * @author Dmitri Lukoyanov
 * @created 27 Oct 2015
 */
@RestController
class ContentCotroller {

    private final static Logger logger = LoggerFactory.getLogger(ContentCotroller.class);



    @RequestMapping("/")
    public Content parse(@RequestParam(value = "url", defaultValue = "http://ya.ru") String urlStr){

        Content response = new Content();
        response.setContent(new ArrayList<String>());
        if(!urlStr.startsWith("http://") && !urlStr.startsWith("https://")){
            urlStr = "http://"+urlStr;
        }
        try {
            URL url = new URL(urlStr);
            logger.info("Start processing URL:{}", url);
            Document doc = Jsoup.connect(urlStr)
//                        .data("query", "Java")
//                        .userAgent("Mozilla")
//                        .cookie("auth", "token")
//                        .timeout(3000)
                    .get();
            response.getContent().add(doc.outerHtml());
        } catch (MalformedURLException m){
            response.getContent().add("Bad URL");
        } catch (IOException e) {
            response.getContent().add(String.format("Error fetch data from URL:%s",urlStr));
        }
        return response;
    }
}
