package de.juzapo.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import de.juzapo.Menu;
import de.juzapo.MyUI;

/**
 * Created by Manuel on 16.11.2015.
 */
public class LoginView extends VerticalLayout implements View {

    Menu menu;

    public LoginView(final Menu menu) {
        this.menu = menu;
        setSpacing(true);
        setMargin(true);

        final TextField username = new TextField("Nutzername");
        addComponent(username);
        PasswordField password = new PasswordField("Passwort");
        addComponent(password);
        Button login = new Button("Login");
        login.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                menu.doLogin();
                MyUI.userName = username.getValue();
            }
        });
        addComponent(login);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        if(MyUI.isLoggedIn) {
            menu.navigateTo(MyUI.VIEW_FEED);
        } else {
            menu.setActiveButton(MyUI.VIEW_LOGIN);
            addComponent(menu, 0);
        }
    }
}
