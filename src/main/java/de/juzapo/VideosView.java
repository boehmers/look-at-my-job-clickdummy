package de.juzapo;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Video;

/**
 * Created by Manuel on 16.11.2015.
 */
public class VideosView extends VerticalLayout implements View {

    MenuView menu;

    public VideosView(Navigator navi) {
        menu = new MenuView(navi);
        addComponent(menu);
        Video video = new Video();
        addComponent(video);
        Video video2 = new Video();
        addComponent(video2);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("VIDEOS!");
    }
}
