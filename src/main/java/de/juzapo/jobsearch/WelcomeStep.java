package de.juzapo.jobsearch;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.teemu.wizards.WizardStep;

/**
 * Created by Manuel on 19.11.2015.
 */
public class WelcomeStep implements WizardStep {
    @Override
    public String getCaption() {
        return "Willkommen";
    }

    @Override
    public Component getContent() {
        VerticalLayout content = new VerticalLayout();
        content.setMargin(true);

        Label header = new Label("Willkommen!");
        header.setStyleName(ValoTheme.LABEL_H1);
        content.addComponent(header);
        content.setComponentAlignment(header, Alignment.MIDDLE_CENTER);

        Label message1 = new Label("Du suchst einen Job oder willst studieren und weißt noch nicht, wo die Reise hingehen soll?");
        message1.setStyleName(ValoTheme.LABEL_H3);
        content.addComponent(message1);
        content.setComponentAlignment(message1, Alignment.MIDDLE_CENTER);

        Label message2 = new Label("Dann bist du bei uns genau richtig. Wir helfen dir, anhand deiner Interessen und Fähigkeiten " +
                "den perfekten Job für dich zu finden. Wir zeigen dir Menschen, die deinen gewünschten Job ausüben und vermitteln " +
                "dir den Kontakt zu ihnen, falls du noch weitere Fragen hast. Wenn du dir schon einen Job ausgesucht hast, kannst du " +
                "diese Schritte auch überspringen.");
        content.addComponent(message2);
        content.setComponentAlignment(message2, Alignment.MIDDLE_CENTER);
        return content;
    }

    @Override
    public boolean onAdvance() {
        return true;
    }

    @Override
    public boolean onBack() {
        return false;
    }
}
