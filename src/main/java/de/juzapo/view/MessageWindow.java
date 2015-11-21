package de.juzapo.view;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import de.juzapo.model.User;

/**
 * Created by Manuel on 21.11.2015.
 */
public class MessageWindow extends Window {

    public MessageWindow(final User user) {
        setResizable(false);
        //setWidth("400px");
        //setHeight("600px");
        center();
        setCaption("Nachricht an " + user.getUsername());
        VerticalLayout content = new VerticalLayout();
        content.setMargin(true);
        content.addComponent(new Label("Schicke eine Nachricht an " + user.getUsername() + ", um dir weitere Infos über seinen/ihren Job einzuholen!"));
        TextField betreff = new TextField("Betreff");
        betreff.setWidth("100%");
        content.addComponent(betreff);
        TextArea msg = new TextArea("Nachricht");
        msg.setSizeFull();
        msg.setWordwrap(true);
        content.addComponent(msg);
        HorizontalLayout footer = new HorizontalLayout();
        footer.setWidth("100%");
        Button cancel = new Button("Abbrechen");
        cancel.setStyleName(ValoTheme.BUTTON_DANGER);
        cancel.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                MessageWindow.this.close();
            }
        });
        footer.addComponent(cancel);
        footer.setComponentAlignment(cancel, Alignment.BOTTOM_LEFT);
        Button send = new Button("Senden");
        send.setStyleName(ValoTheme.BUTTON_PRIMARY);
        send.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                MessageWindow.this.close();
                Notification.show("Nachricht verschickt!", user.getUsername() + " wird sie beim nächsten Login erhalten.", Notification.Type.TRAY_NOTIFICATION);
            }
        });
        footer.addComponent(send);
        footer.setComponentAlignment(send, Alignment.BOTTOM_RIGHT);
        content.addComponent(footer);

        setContent(content);
    }

}
