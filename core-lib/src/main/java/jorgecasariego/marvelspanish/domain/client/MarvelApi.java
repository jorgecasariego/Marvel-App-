package jorgecasariego.marvelspanish.domain.client;

import jorgecasariego.marvelspanish.domain.model.CharactersResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jorgecasariego on 7/3/17.
 */

public interface MarvelApi {
    String NAME = "name";
    String API_KEY = "apikey";
    String HASH = "hash";
    String TIMESTAMP = "ts";

    // http://gateway.marvel.com:80/v1/public/characters?name=Iron%20Man&apikey=PUBLIC_API_KEY&hash=HASH&ts=TIMESTAMP
    @GET("v1/public/characters")
    Observable<CharactersResponse> getCharacters(
            @Query(NAME) String query,
            @Query(API_KEY) String publicKey,
            @Query(HASH) String hash,
            @Query(TIMESTAMP) long timestamp);


}
