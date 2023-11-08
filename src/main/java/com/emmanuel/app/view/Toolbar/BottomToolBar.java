package com.emmanuel.app.view.Toolbar;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

/**
 * Created by emmanuel on 11/7/23
 *
 * @author: emmanuel
 * @date: 11/7/23
 * @project: IntelliJ IDEA
 */
public class BottomToolBar implements Menu, Serializable {
    @Override
    public String menu(int activeLinkIndex) {
        return StringUtils.EMPTY;
    }
}
