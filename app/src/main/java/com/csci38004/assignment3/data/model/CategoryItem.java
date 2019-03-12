package com.csci38004.assignment3.data.model;

import java.util.ArrayList;
import java.util.List;

public class CategoryItem {
    private String id;
    private String name;
    private List<CategoryIcon> icons;

    public String getName() {
        return name;
    }

    public List<CategoryIcon> getIcons() {
        return icons == null ?
                new ArrayList<>() : new ArrayList<>(icons);
    }

    public String getId() {
        return id;
    }
}
