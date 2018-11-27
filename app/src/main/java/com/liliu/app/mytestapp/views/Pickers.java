package com.liliu.app.mytestapp.views;

import java.io.Serializable;

/**
 * Created by li.liu on 2018/11/21.
 */

public class Pickers implements Serializable {

    private static final long serialVersionUID = 1L;

    private String showConetnt;
    private String showId;

    public String getShowConetnt() {
        return showConetnt;
    }

    public String getShowId() {
        return showId;
    }

    public Pickers(String showConetnt, String showId) {
        super();
        this.showConetnt = showConetnt;
        this.showId = showId;
    }

    public Pickers() {
        super();
    }

}
