package de.juzapo;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.*;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import de.juzapo.jobsearch.JobsearchWindow;
import de.juzapo.view.*;

/**
 *
 */
@Push
@PreserveOnRefresh
@Theme("mytheme")
@Widgetset("de.juzapo.DefaultWidgetSet")
public class MyUI extends UI {

    public static TestData testData = new TestData();

    public static final String VIEW_LOGIN = "login";
    public static final String VIEW_WELCOME = "welcome";
    public static final String VIEW_FEED = "feed";
    public static final String VIEW_SPONSORED = "sponsored";
    public static final String VIEW_VIDEOS = "videos";

    public static boolean isLoggedIn = false;

    private Navigator navi;
    private JobsearchWindow jobWindow;
    private Menu menu;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Page.getCurrent().setTitle("look@myJob");

        navi = new Navigator(this, this);

        menu = new Menu(navi);
        navi.addView(VIEW_FEED, new FeedView(menu));
        navi.addView(VIEW_SPONSORED, new SponsoredView(menu));
        navi.addView(VIEW_VIDEOS, new VideosView(menu));
        navi.addView(VIEW_LOGIN, new LoginView(menu));
        navi.addView(VIEW_WELCOME, new WelcomeView(navi));

        navi.navigateTo(VIEW_WELCOME);

        jobWindow = new JobsearchWindow();
        //TODO:
        // - Enums anzeige anpassen (zweite Wörter sind klein)
    }

    public void openJobWindow() {
        addWindow(jobWindow);
    }

    public Navigator getNavi() {
        return navi;
    }

    public JobsearchWindow getJobWindow() {
        return jobWindow;
    }

    public Menu getMenu() {
        return menu;
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
