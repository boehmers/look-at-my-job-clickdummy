package de.juzapo;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Manuel on 16.11.2015.
 */
public class FeedView extends VerticalLayout implements View {

    MenuView menu;

    public FeedView(Navigator navi) {
        menu = new MenuView(navi);
        addComponent(menu);
        addComponent(new Label("Voll gsuffn auf der Ärbert heit, geil!"));
        addComponent(new Label("Voll gsuffn auf der Ärbert heit, geil!"));
        addComponent(new Label("Voll gsuffn auf der Ärbert heit, geil!"));
        addComponent(new Label("Voll gsuffn auf der Ärbert heit, geil!"));
        addComponent(new Label("Voll gsuffn auf der Ärbert heit, geil!"));
        addComponent(new Label("Voll gsuffn auf der Ärbert heit, geil!"));
        addComponent(new Label("Voll gsuffn auf der Ärbert heit, geil!"));
        addComponent(new Label("Voll gsuffn auf der Ärbert heit, geil!"));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("FEED!");
    }
}
