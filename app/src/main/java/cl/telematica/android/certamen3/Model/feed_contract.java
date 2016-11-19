package cl.telematica.android.certamen3.Model;

import android.provider.BaseColumns;

/**
 * Created by Naty on 18-11-2016.
 *
 */

public class feed_contract {

        public static abstract class FeedEntry implements BaseColumns {
            public static final String TABLE_NAME ="Feed";

            public static final String TITLE = "title";
            public static final String LINK = "link";
            public static final String AUTHOR = "author";
            public static final String PUBLISHEDDATE = "publishedDate";
            public static final String CONTENT = "content";
            public static final String IMAGE = "image";
            public static final String ISFAVORITE = "isFavorite";

        }

}
