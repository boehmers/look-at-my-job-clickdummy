package de.juzapo.components;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import de.juzapo.MyUI;

/**
 * Created by Manuel on 17.11.2015.
 */
public class FeedCloud extends VerticalLayout {
    public FeedCloud(String value, String username) {
        Label msg = new Label(value);
        msg.setStyleName(ValoTheme.LABEL_BOLD);
        msg.setWidth("100%");
        addComponent(msg);
        addComponent(new Label("by " + username));
    }
}
