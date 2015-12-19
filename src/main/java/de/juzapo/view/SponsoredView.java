package de.juzapo.view;

import de.juzapo.MyUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import de.juzapo.Menu;

/**
 * Created by Manuel on 16.11.2015.
 */
public class SponsoredView extends VerticalLayout implements View {

    Menu menu;

    public SponsoredView(final Menu menu) {
        this.menu = menu;
        setSpacing(true);
        setMargin(true);

        Label headingPost = new Label("Jugendzentrum Alte Post");
        headingPost.setStyleName(ValoTheme.LABEL_H2);
        addComponent(headingPost);
        addComponent(new Label("Die Alte Post gibt es seit dem November 1977. Träger der Einrichtung ist " +
                "die Evang. Luth. Kirchengemeinde Langenzenn. Finanziert wird das Haus von der Stadt Langenzenn, " +
                "der Kirchengemeinde und aus eigenen Einnahmen und Spenden."));
        Video video2 = new Video();
        Link link2 = new Link("Website", new ExternalResource("http://http://www.altepost.org/"));
        link2.setTargetName("_blank");
        addComponent(video2);
        addComponent(link2);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        menu.setActiveButton(MyUI.VIEW_SPONSORED);
        addComponent(menu, 0);
    }
}
