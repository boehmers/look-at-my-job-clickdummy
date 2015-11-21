package de.juzapo.components;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import de.juzapo.MyUI;
import de.juzapo.model.Beruf;
import de.juzapo.model.User;
import de.juzapo.view.MessageWindow;

/**
 * Created by Manuel on 17.11.2015.
 */
public class VideoCloud extends VerticalLayout {

    private Beruf beruf;
    private User user;

    public VideoCloud(Beruf beruf, User user, String title) {
        this.beruf = beruf;
        this.user = user;
        Label label = new Label(title);
        label.setWidth("100%");
        label.setStyleName(ValoTheme.LABEL_H3);
        addComponent(label);

        Label berufLabel = new Label(beruf.getBezeichnung());
        berufLabel.setStyleName(ValoTheme.LABEL_LIGHT);
        addComponent(berufLabel);

        Video video = new Video();
        addComponent(video);

        HorizontalLayout footer = new HorizontalLayout();
        footer.setWidth("100%");
        Label userLabel = new Label("by " + MyUI.testData.a.getUsername());
        footer.addComponent(userLabel);
        footer.setComponentAlignment(userLabel, Alignment.BOTTOM_LEFT);
        Button contact = new Button("Kontakt");
        contact.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                showMessage();
            }
        });
        contact.setDescription("Wir ermöglichen dir Kontakt mit Personen aufzunehmen, die den Job ausüben, den du dir wünschst.");
        footer.addComponent(contact);
        footer.setComponentAlignment(contact, Alignment.BOTTOM_RIGHT);
        addComponent(footer);
    }

    private void showMessage() {
        MessageWindow msg = new MessageWindow(this.user);
        getUI().addWindow(msg);
    }

    public Beruf getBeruf() {
        return beruf;
    }

    public void setBeruf(Beruf beruf) {
        this.beruf = beruf;
    }
}
