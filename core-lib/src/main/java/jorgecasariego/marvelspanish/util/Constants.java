package jorgecasariego.marvelspanish.util;

/**
 * Created by jorgecasariego on 7/3/17.
 */

public class Constants {
    public static final String BASE_URL = "http://gateway.marvel.com:80/";

    public static final String PUBLIC_KEY = "de13b0f3c86f29b79cd41c4396a6d528";
    public static final String PRIVATE_KEY = "f54e25337bdf955628b65ebdf22b4d3a988c20c8";

    public static final int NETWORK_CONNECTION_TIMEOUT = 30; // 30 sec
    public static final long CACHE_SIZE = 10 * 1024 * 1024; // 10 MB
    public static final int CACHE_MAX_AGE = 2; // 2 min
    public static final int CACHE_MAX_STALE = 7; // 7 day

    public static final int CODE_OK = 200;

    public static final String PORTRAIT_XLARGE = "portrait_xlarge";
    public static final String STANDARD_XLARGE = "standard_xlarge";
}
