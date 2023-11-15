package com.emmanuel.app.view.Toolbar;

import com.emmanuel.app.model.view.MenuLink;
import com.emmanuel.app.model.view.MenuLinkStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by emmanuel on 11/7/23
 *
 * @author: emmanuel
 * @date: 11/7/23
 * @project: IntelliJ IDEA
 */
public class TopToolBar implements Menu, Serializable {
    private final List<MenuLink> links = new ArrayList<>();

    {
        links.add(new MenuLink("./home", "Home", MenuLinkStatus.ACTIVE));
        links.add(new MenuLink("./add-portfolio", "Add Portfolio", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./logout", "Logout", MenuLinkStatus.NOT_ACTIVE));
    }

    @Override
    public String menu(int activeLinkIndex) {
        this.activateLink(activeLinkIndex);

        StringBuilder menuBar = new StringBuilder("<div class=\"topnav\">");

        for (MenuLink link : links) {
            menuBar.append("<a ").append(link.getStatus() == MenuLinkStatus.ACTIVE ? "class=\"active\"" : "")
                    .append(" href=\"").append(link.getUrl()).append("\">").append(link.getLabel()).append("</a>");
        }

        menuBar.append("</div>");

        return menuBar.toString();
    }

    private void activateLink(int linkIndex) {
        for (int index = 0; index < links.size(); index++) {
            if (index == linkIndex)
                links.get(index).setStatus(MenuLinkStatus.ACTIVE);
            else
                links.get(index).setStatus(MenuLinkStatus.NOT_ACTIVE);
        }
    }
}
