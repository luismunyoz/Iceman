package com.luismunyoz.iceman.ui.model;

/**
 * Created by Luism on 02/04/2017.
 */

public class ListItem {

    private Integer id;
    private String image;
    private String title;

    public ListItem(Integer id, String image, String title) {
        this.id = id;
        this.image = image;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
