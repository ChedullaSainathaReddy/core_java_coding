package com.example.SpringSwagger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookService {
    private static final Logger logger = LogManager.getLogger(BookService.class);

    public void getBook() {
        logger.info("Fetching book...");
    }
}
