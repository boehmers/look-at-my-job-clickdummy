package de.juzapo.components;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Video;
import com.vaadin.ui.themes.ValoTheme;
import de.juzapo.MyUI;
import de.juzapo.model.Beruf;

/**
 * Created by Manuel on 17.11.2015.
 */
public class VideoCloud extends VerticalLayout {

    private Beruf beruf;

    public VideoCloud(Beruf beruf, String title) {
        this.beruf = beruf;
        Label label = new Label(title);
        label.setWidth("100%");
        label.setStyleName(ValoTheme.LABEL_H3);
        addComponent(label);

        Label berufLabel = new Label(beruf.getBezeichnung());
        berufLabel.setStyleName(ValoTheme.LABEL_LIGHT);
        addComponent(berufLabel);

        Video video = new Video();
        addComponent(video);
        addComponent(new Label("by " + MyUI.testData.a.getUsername()));
    }
}
