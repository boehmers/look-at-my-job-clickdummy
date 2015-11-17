package de.juzapo.components;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Video;
import com.vaadin.ui.themes.ValoTheme;
import de.juzapo.MyUI;

/**
 * Created by Manuel on 17.11.2015.
 */
public class VideoCloud extends VerticalLayout {
    public VideoCloud(String value) {
        Label label = new Label(value);
        label.setWidth("100%");
        label.setStyleName(ValoTheme.LABEL_BOLD);
        addComponent(label);
        Video video = new Video();
        addComponent(video);
        addComponent(new Label("by " + MyUI.userName));
    }
}
