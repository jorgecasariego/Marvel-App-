package jorgecasariego.marvelspanish.domain.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jorgecasariego on 7/3/17.
 */

public class Collection {
    @SerializedName("items")
    private Items[] items;
    @SerializedName("collectionURI")
    private String collectionURI;
    @SerializedName("available")
    private String available;
    @SerializedName("returned")
    private String returned;

    public Collection() {
    }

    public Collection(Items[] items, String collectionURI, String available, String returned) {
        this.items = items;
        this.collectionURI = collectionURI;
        this.available = available;
        this.returned = returned;
    }

    public Items[] getItems() {
        return items;
    }

    public void setItems(Items[] items) {
        this.items = items;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }
}
