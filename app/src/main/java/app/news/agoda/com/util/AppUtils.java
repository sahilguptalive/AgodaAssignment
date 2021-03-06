package app.news.agoda.com.util;

import domain.news.agoda.com.model.MultiMediumDomain;
import domain.news.agoda.com.model.NewsResponseDomain;

import java.util.List;

import app.news.agoda.com.view.BundleKeys;

public class AppUtils {

    public static String getImageUrlFromResult(NewsResponseDomain result) {
        String url = null;
        if (result != null) {
            List<MultiMediumDomain> media = result.getMultimedia();
            if (media != null && !media.isEmpty()) {
                for (MultiMediumDomain multiMediumDomain : media) {
                    if (multiMediumDomain.getFormat().equals(BundleKeys.TITLE_IMAGE_FORMAT_NORMAL)) {
                        url = multiMediumDomain.getUrl();
                    }
                }
            }
        }
        return url;
    }
}
