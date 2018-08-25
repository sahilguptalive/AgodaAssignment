package com.example.app_domain;

import com.example.app_domain.model.MultiMediumDomain;
import com.example.app_domain.model.MultiMediumEntity;
import com.example.app_domain.model.NewsEntity;
import com.example.app_domain.model.Result;
import com.example.app_domain.model.NewsResponseDomain;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class NewsFeedEntityDomainMapper {

    public List<NewsResponseDomain> mapResults(List<Result> results) {
        List<NewsResponseDomain> newsResponseDomainList = new ArrayList<>();
        if (results != null && results.size() > 0) {
            for (Result resultEntity : results) {
                NewsResponseDomain newsResponseDomain = new NewsResponseDomain();
                newsResponseDomain.setTitle(resultEntity.getTitle());
                newsResponseDomain.setUrl(resultEntity.getUrl());
                newsResponseDomain.setAbstract(resultEntity.getAbstract());
                newsResponseDomain.setPublishedDate(resultEntity.getPublishedDate());
                List<MultiMediumDomain> mediumDomain = mapMedia(resultEntity.getMultimedia());
                newsResponseDomain.setMultimedia(mediumDomain);
                newsResponseDomainList.add(newsResponseDomain);
            }
        }
        return newsResponseDomainList;
    }

    public List<MultiMediumDomain> mapMedia(List<MultiMediumEntity> media) {
        List<MultiMediumDomain> mediumDomains = new ArrayList<>();
        if (media != null && media.size() > 0) {
            for (MultiMediumEntity mediaEntity : media) {
                MultiMediumDomain mediumDomain = new MultiMediumDomain();
                mediumDomain.setUrl(mediaEntity.getUrl());
                mediumDomain.setFormat(mediaEntity.getFormat());
                mediumDomain.setHeight(mediaEntity.getHeight());
                mediumDomain.setWidth(mediaEntity.getWidth());
                mediumDomain.setCaption(mediaEntity.getCaption());
                mediumDomain.setCopyright(mediaEntity.getCopyright());
                mediumDomains.add(mediumDomain);
            }
        }
        return mediumDomains;
    }

    public NewsEntity parseResponse(String content) {
        NewsEntity newsItem = new NewsEntity();
        if (content != null) {
            NewsEntity newsEntity;
            try {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
                newsEntity = mapper.readValue(content, NewsEntity.class);
                newsItem = newsEntity;
            } catch (IOException e) {
                System.out.print("Fail to parse json string = " + e);
            }
        }
        return newsItem;
    }
}
