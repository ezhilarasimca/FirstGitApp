package com.bloby.blob.newkitfirstapplication;

import java.util.List;

/**
 * Created by SIT on 01/08/2018.
 */

public class expand_list_model {
    String parents;
    List<String> children;

    public expand_list_model(String parents, List<String> children) {
        this.parents = parents;
        this.children = children;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }
}
