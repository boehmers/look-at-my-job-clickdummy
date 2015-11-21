package de.juzapo;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import de.juzapo.jobsearch.JobsearchWindow;
import de.juzapo.view.FeedView;
import de.juzapo.view.LoginView;
import de.juzapo.view.SponsoredView;
import de.juzapo.view.VideosView;

/**
 *
 */
@Theme("mytheme")
@Widgetset("de.juzapo.MyAppWidgetset")
public class MyUI extends UI {

    public static TestData testData = new TestData();

    public static final String VIEW_LOGIN = "login";
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

        navi.navigateTo(VIEW_VIDEOS);

        jobWindow = new JobsearchWindow();
        addWindow(jobWindow);
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
