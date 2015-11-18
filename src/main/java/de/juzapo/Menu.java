package de.juzapo;

import com.vaadin.data.Property;
import com.vaadin.navigator.Navigator;
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

    public Menu(final Navigator navi) {
        this.navi = navi;
        setMargin(true);
        setSpacing(true);
        setWidth("100%");

        Label heading = new Label("look@myJob");
        heading.setStyleName(ValoTheme.LABEL_H1);
        addComponent(heading);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);

        feedButton = new Button("Feed");
        feedButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                navi.navigateTo(MyUI.VIEW_FEED);
            }
        });
        buttons.addComponent(feedButton);

        videosButton = new Button("Videos");
        videosButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                navi.navigateTo(MyUI.VIEW_VIDEOS);
            }
        });
        buttons.addComponent(videosButton);

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

        final ComboBox berufe = new ComboBox("Welcher Beruf interessiert dich?");
        berufe.addItem("Keine Ahnung!");
        berufe.addItem("Alle!");
        berufe.addItem("Bauer");
        berufe.addItem("Informatiker");
        berufe.addItem("Mediengestalter");
        berufe.addItem("Jugendzentrums-Papa");
        berufe.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                if (berufe.getValue().equals("Keine Ahnung!")) {
                    Window interessen = new Window("Interessenvergleich");
                    interessen.setContent(new Label("Hier können dann Interessen eingegeben werden, zu denen dann Berufe gesucht werden."));
                    interessen.center();
                    interessen.setModal(true);
                    getUI().addWindow(interessen);
                } else {
                    Notification.show("Hier soll dann zum gewählten Beruf gefiltert werden. Jedes Video und jeder Post soll mit " +
                            "einem Beruf versehen werden.", Notification.Type.ERROR_MESSAGE);
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
}
