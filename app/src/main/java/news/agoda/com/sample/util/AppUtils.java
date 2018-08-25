package news.agoda.com.sample.util;

import com.example.app_domain.model.MultiMediumDomain;
import com.example.app_domain.model.NewsResponseDomain;

import java.util.List;

import news.agoda.com.sample.view.BundleKeys;

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
