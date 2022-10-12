package com.example.newsws.ApiClient;

import java.io.*;
import java.net.URL;

public class Article {
        Source source;
        String author, title, description, url, urlToImage, publishedAt, content;

        public Article(Source source, String author, String title, String description, String url, String urlToImage, String publishedAt, String content) {
                this.source = source;
                this.author = author;
                this.title = title;
                this.description = description;
                this.url = url;
                this.urlToImage = urlToImage;
                this.publishedAt = publishedAt;
                this.content = content;
        }

        public Source getSource() {
                return source;
        }

        public void setSource(Source source) {
                this.source = source;
        }

        public String getAuthor() {
                return author;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getUrl() {
                return url;
        }

        public void setUrl(String url) {
                this.url = url;
        }

        public String getUrlToImage() {
                return urlToImage;
        }

        public void setUrlToImage(String urlToImage) {
                this.urlToImage = urlToImage;
        }

        public String getPublishedAt() {
                return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
        }

        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
        }

        public String GenerateDiv() {
                if ( description == null || description == "null") {
                        description = "No Description Provided";
                }
                return String.format("""
                    <a href= "%s"> 
                    <div class="newsCard">
                        <img src="%s" alt="image">
                        <div class="titleDescription">
                            <h1>%s</h1>
                            <h3>%s</h3>
                        </div>
                    </div>
                    </a>
                """, url, urlToImage, title, description.replace("<", "").replace(">", "").replace("/", ""));
        }

        @Override
        public String toString() {
                return "ApiClient.Article{" +
                "source=" + source +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", content='" + content + '\'' +
                '}' + '\n';
        }

}
