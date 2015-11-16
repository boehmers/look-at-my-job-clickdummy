package de.juzapo;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

/**
 * Created by Manuel on 16.11.2015.
 */
public class LoginView extends VerticalLayout implements View {

    MenuView menu;

    public LoginView(Navigator navi) {
        menu = new MenuView(navi);
        addComponent(menu);
        TextField username = new TextField("Nutzername");
        addComponent(username);
        PasswordField password = new PasswordField("Passwort");
        addComponent(password);
        Button login = new Button("Login");
        login.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                menu.doLogin();
            }
        });
        addComponent(login);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("LOGIN!");
    }
}
