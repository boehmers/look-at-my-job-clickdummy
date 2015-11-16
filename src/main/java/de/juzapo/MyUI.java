package de.juzapo;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

/**
 *
 */
@Theme("mytheme")
@Widgetset("de.juzapo.MyAppWidgetset")
public class MyUI extends UI {

    Navigator navi;

    public static final String VIEW_LOGIN = "login";
    public static final String VIEW_FEED = "feed";
    public static final String VIEW_SPONSORED = "sponsored";
    public static final String VIEW_VIDEOS = "videos";

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        navi = new Navigator(this, this);

        navi.addView(VIEW_LOGIN, new LoginView(navi));
        navi.addView(VIEW_FEED, new FeedView(navi));
        navi.addView(VIEW_SPONSORED, new SponsoredView(navi));
        navi.addView(VIEW_VIDEOS, new VideosView(navi));
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
