package de.juzapo.view;

import de.juzapo.MyUI;
import de.juzapo.Constants;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.addon.oauthpopup.OAuthListener;
import org.vaadin.addon.oauthpopup.OAuthPopupButton;
import org.vaadin.addon.oauthpopup.buttons.FacebookButton;

/**
 * Created by Manuel on 19.12.2015.
 */
public class WelcomeView extends VerticalLayout implements View{

    private Navigator navi;

    private Label logo;
    private Label heading;
    private Label infoText;
    private Label whoAreWe;
    private OAuthPopupButton facebookLogin;
    private OAuthPopupButton twitterLogin;
    private OAuthPopupButton linkedinLogin;

    public WelcomeView(final Navigator navi) {
        this.navi = navi;
        setSizeFull();
        logo = new Label();
        logo.setIcon(new ThemeResource("logo.png"));
        heading = new Label("Willkommen bei look@myJob!");
        heading.setStyleName(ValoTheme.LABEL_H1);
        whoAreWe = new Label("Was tun wir eigentlich? Blablabl.");
        infoText = new Label("Um Zugriff auf unsere Inhalte zu bekommen, logge dich bitte ein.");
        infoText.setStyleName(ValoTheme.LABEL_H3);
        addComponent(logo);
        addComponent(heading);
        addComponent(whoAreWe);
        addComponent(infoText);

        facebookLogin = new FacebookButton(Constants.FACEBOOK_API.apiKey, Constants.FACEBOOK_API.apiSecret);
        facebookLogin.addOAuthListener(new OAuthListener() {
            @Override
            public void authSuccessful(String s, String s1, String s2) {
                navi.navigateTo(MyUI.VIEW_VIDEOS);
                Notification.show(s, Notification.Type.ERROR_MESSAGE);
                Notification.show(s1, Notification.Type.ERROR_MESSAGE);
                Notification.show(s2, Notification.Type.ERROR_MESSAGE);
            }

            @Override
            public void authDenied(String s) {
                navi.navigateTo(MyUI.VIEW_WELCOME);
                Notification.show(s, Notification.Type.ERROR_MESSAGE);
            }
        });
        addComponent(facebookLogin);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
