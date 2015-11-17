package de.juzapo;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import de.juzapo.views.FeedView;
import de.juzapo.views.LoginView;
import de.juzapo.views.SponsoredView;
import de.juzapo.views.VideosView;

/**
 *
 */
@Theme("mytheme")
@Widgetset("de.juzapo.MyAppWidgetset")
public class MyUI extends UI {

    Navigator navi;
    public static boolean isLoggedIn = false;
    public static String userName;

    public static final String VIEW_LOGIN = "login";
    public static final String VIEW_FEED = "feed";
    public static final String VIEW_SPONSORED = "sponsored";
    public static final String VIEW_VIDEOS = "videos";

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        navi = new Navigator(this, this);

        Menu menu = new Menu(navi);
        navi.addView(VIEW_FEED, new FeedView(menu));
        navi.addView(VIEW_SPONSORED, new SponsoredView(menu));
        navi.addView(VIEW_VIDEOS, new VideosView(menu));
        navi.addView(VIEW_LOGIN, new LoginView(menu));

        navi.navigateTo(VIEW_LOGIN);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
