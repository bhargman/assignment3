package com.csci38004.assignment3.data.model;

import java.util.ArrayList;
import java.util.List;

public class Categories {

    private List<CategoryItem> items;

    public List<CategoryItem> getItems() {
        return items == null ?
                new ArrayList<>() : new ArrayList<>(items);
    }
}
