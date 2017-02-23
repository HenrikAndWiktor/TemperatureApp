package se.henrikeriksson.myapp2;
import com.loopj.android.http.*;

/**
 * Created by henrikeriksson on 17-01-25.
 */
public class HttpUtils {
        //private static final String BASE_URL = "http://wiktoreriksson.se/subdomain/weather/tempapp.json";

        //private static final String BASE_URL = "http://wiktoreriksson.se/example.json";
    // Test with array of historydata http://wiktoreriksson.se/example.json
    private static final String BASE_URL =  "http://wiktoreriksson.se/";
        private static AsyncHttpClient client = new AsyncHttpClient();

        public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
            client.get(getAbsoluteUrl(url), params, responseHandler);
        }

        public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
            client.post(getAbsoluteUrl(url), params, responseHandler);
        }

        public static void getByUrl(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
            client.get(url, params, responseHandler);
        }

        public static void postByUrl(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
            client.post(url, params, responseHandler);
        }

        private static String getAbsoluteUrl(String relativeUrl) {
            return BASE_URL + relativeUrl;
        }
    }