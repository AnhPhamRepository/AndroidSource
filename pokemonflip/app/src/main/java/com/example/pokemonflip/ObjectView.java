package com.example.pokemonflip;

public class ObjectView {

    private Integer id, tag;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public ObjectView() {

    }

    public ObjectView(int id, int tag) {
        this.id = id;
        this.tag = tag;
    }
}
