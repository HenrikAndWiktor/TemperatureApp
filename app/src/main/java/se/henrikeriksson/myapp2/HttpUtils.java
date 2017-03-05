package se.henrikeriksson.myapp2;
import com.loopj.android.http.*;

import java.net.URL;

class HttpUtils {
        //private static final String BASE_URL = "http://wiktoreriksson.se/subdomain/weather/tempapp.json";

        //private static final String BASE_URL = "http://wiktoreriksson.se/example.json";
    // Test with array of historydata http://wiktoreriksson.se/example.json
    private static final String BASE_URL =  "http://wiktoreriksson.se/";
        private static AsyncHttpClient client = new AsyncHttpClient();

        static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
            client.get(getAbsoluteUrl(url), params, responseHandler);
        }

        static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
            client.post(getAbsoluteUrl(url), params, responseHandler);
        }

        static void getByUrl(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
            client.get(url, params, responseHandler);
        }

        static void postByUrl(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
            client.post(url, params, responseHandler);
        }
    static void getByUrl(java.net.URL url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        getByUrl(url.getPath(), params, responseHandler);
    }

    static void postByUrl(URL url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        postByUrl(url.getPath(), params, responseHandler);
    }
    public static void put(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.put(getAbsoluteUrl(url), params, responseHandler);
    }
        private static String getAbsoluteUrl(String relativeUrl) {
            return BASE_URL + relativeUrl;
        }
    }