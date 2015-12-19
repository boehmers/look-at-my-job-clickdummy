package de.juzapo;

import de.juzapo.view.FeedView;
import de.juzapo.view.VideosView;
import com.vaadin.data.Property;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by Manuel on 16.11.2015.
 */
public class Menu extends HorizontalLayout {

    private Navigator navi;
    private Button sponsoredButton;
    private Button videosButton;
    private Button feedButton;
    private Button loginButton;
    private final ComboBox berufe;

    public Menu(final Navigator navi) {
        this.navi = navi;
        setMargin(true);
        setSpacing(true);
        setWidth("100%");

        Button heading = new Button();
        heading.setIcon(new ThemeResource("logo.png"));
        heading.setStyleName(ValoTheme.BUTTON_LINK);
        heading.setHeight("120px");
        heading.setWidth("380px");
        heading.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                navi.navigateTo(MyUI.VIEW_VIDEOS);
            }
        });
        addComponent(heading);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);

        videosButton = new Button("Videos");
        videosButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                navi.navigateTo(MyUI.VIEW_VIDEOS);
            }
        });
        buttons.addComponent(videosButton);

        feedButton = new Button("Feed");
        feedButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                navi.navigateTo(MyUI.VIEW_FEED);
            }
        });
        buttons.addComponent(feedButton);

        sponsoredButton = new Button("Sponsored");
        sponsoredButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                navi.navigateTo(MyUI.VIEW_SPONSORED);
            }
        });
        buttons.addComponent(sponsoredButton);

        HorizontalLayout login = new HorizontalLayout();
        login.setSpacing(true);

        loginButton = new Button("Login");
        loginButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                navi.navigateTo(MyUI.VIEW_LOGIN);
            }
        });

        berufe = new ComboBox("Welcher Beruf interessiert dich?");
        berufe.setNullSelectionAllowed(false);
        berufe.addItem("Alle!");
        berufe.addItem("Keine Ahnung!");
        berufe.addItem(MyUI.testData.bauer);
        berufe.addItem(MyUI.testData.informatiker);
        berufe.addItem(MyUI.testData.juzPapa);
        berufe.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                if (berufe.getValue().equals("Keine Ahnung!")) {
                    MyUI ui = (MyUI) getUI();
                    ui.openJobWindow();
                } else {
                    HasComponents view = getParent();
                    if(view instanceof FeedView) {
                        FeedView feed = (FeedView) view;
                        feed.filter();
                    }
                    if(view instanceof VideosView) {
                        VideosView videos = (VideosView) view;
                        videos.filter();
                    }
                }
            }
        });
        login.addComponent(berufe);
        login.addComponent(loginButton);

        addComponent(buttons);
        addComponent(login);
        setComponentAlignment(login, Alignment.TOP_RIGHT);
        setComponentAlignment(buttons, Alignment.TOP_LEFT);
    }

    public void doLogin() {
        MyUI.isLoggedIn = true;
        navi.navigateTo(MyUI.VIEW_FEED);
        Notification.show("Login erfolgreich!", Notification.Type.TRAY_NOTIFICATION);
        loginButton.setStyleName(ValoTheme.BUTTON_LINK);
        loginButton.setCaption("Logout");
        loginButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                doLogout();
            }
        });
        getUI().getSession().setAttribute("jobUser", MyUI.testData.a);
    }

    private void doLogout() {
        loginButton.removeStyleName(ValoTheme.BUTTON_LINK);
        loginButton.setCaption("Login");
        Notification.show("Logout erfolgreich!", Notification.Type.TRAY_NOTIFICATION);
        setActiveButton(MyUI.VIEW_LOGIN);
        MyUI.isLoggedIn = false;
        navi.navigateTo(MyUI.VIEW_LOGIN);
    }

    public void showLogin() {
        navi.navigateTo(MyUI.VIEW_LOGIN);
    }

    public void setActiveButton(String view) {
        switch(view) {
            case MyUI.VIEW_LOGIN:
                loginButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
                feedButton.removeStyleName(ValoTheme.BUTTON_PRIMARY);
                videosButton.removeStyleName(ValoTheme.BUTTON_PRIMARY);
                sponsoredButton.removeStyleName(ValoTheme.BUTTON_PRIMARY);
                break;
            case MyUI.VIEW_FEED:
                feedButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
                videosButton.removeStyleName(ValoTheme.BUTTON_PRIMARY);
                loginButton.removeStyleName(ValoTheme.BUTTON_PRIMARY);
                sponsoredButton.removeStyleName(ValoTheme.BUTTON_PRIMARY);
                break;
            case MyUI.VIEW_SPONSORED:
                sponsoredButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
                loginButton.removeStyleName(ValoTheme.BUTTON_PRIMARY);
                feedButton.removeStyleName(ValoTheme.BUTTON_PRIMARY);
                videosButton.removeStyleName(ValoTheme.BUTTON_PRIMARY);
                break;
            case MyUI.VIEW_VIDEOS:
                videosButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
                loginButton.removeStyleName(ValoTheme.BUTTON_PRIMARY);
                sponsoredButton.removeStyleName(ValoTheme.BUTTON_PRIMARY);
                feedButton.removeStyleName(ValoTheme.BUTTON_PRIMARY);
                break;
            default:
                throw new IllegalArgumentException("Only View-Name-Strings allowed for active button setting!");
        }
    }

    public void navigateTo(String view) {
        navi.navigateTo(view);
    }

    public ComboBox getBerufe() {
        return berufe;
    }
}
