package com.meduzka;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * @author Dmitri Lukoyanov
 * @created 27 Oct 2015
 */
@SpringBootApplication
public class Main {

    Logger logger = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args){
//        Main main = new Main();
//        main.process(args);

        SpringApplication.run(Main.class, args);

    }

    private void process(String[] args) {
        if (args != null && args.length > 0){
            logger.info("Start processing URL:{}", args[0]);
            try {
                Document doc = Jsoup.connect(args[0])
//                        .data("query", "Java")
//                        .userAgent("Mozilla")
//                        .cookie("auth", "token")
//                        .timeout(3000)
                        .get();
                logger.info("doc:{}", doc);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
