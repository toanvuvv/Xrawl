package com.hust.crawler.link;

public interface Link {
    final String baseFilePath = "Crawler/src/main/resources/data/";
    void writeToFile(String fileName);
    void crawl(String url);
}
