package com.example.test1.service.app2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grit on 31.05.2014.
 */

public class Group {

    public String string;
    public final List<String> children = new ArrayList<String>();

    public Group(String string) {
        this.string = string;
    }

}