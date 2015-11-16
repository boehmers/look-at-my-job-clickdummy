package de.juzapo;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;

/**
 * Created by Manuel on 16.11.2015.
 */
public class MenuView extends HorizontalLayout {

    private Navigator navi;

    public MenuView(final Navigator navi) {
        this.navi = navi;
        setMargin(true);
        setSpacing(true);

        Button login = new Button("Login");
        login.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                navi.navigateTo(MyUI.VIEW_LOGIN);
            }
        });
        addComponent(login);

        Button feed = new Button("Feed");
        feed.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                doLogin();
            }
        });
        addComponent(feed);

        Button videos = new Button("Videos");
        videos.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                navi.navigateTo(MyUI.VIEW_VIDEOS);
            }
        });
        addComponent(videos);

        Button sponsored = new Button("Sponsored");
        sponsored.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                navi.navigateTo(MyUI.VIEW_SPONSORED);
            }
        });
        addComponent(sponsored);
    }

    public void doLogin() {
        navi.navigateTo(MyUI.VIEW_FEED);
    }
}
