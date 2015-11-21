package de.juzapo.jobsearch;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import de.juzapo.model.FilterParams;
import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.WizardStep;

import java.util.List;
import java.util.logging.Filter;

/**
 * Created by Manuel on 19.11.2015.
 */
public class JobOrHelpStep implements WizardStep {

    private Wizard wizard;

    public JobOrHelpStep(Wizard wizard) {
        this.wizard = wizard;
    }

    @Override
    public String getCaption() {
        return "Brauchst du Hilfe?";
    }

    @Override
    public Component getContent() {
        VerticalLayout content = new VerticalLayout();
        content.setMargin(true);

        Label header = new Label("Wenn du schon eine Vorstellung von deinem Wunschjob hast, dann klicke auf \"Ja\". Wenn nicht, klicke auf \"Nein\" oder \"Weiter\".");
        header.setStyleName(ValoTheme.LABEL_H2);
        content.addComponent(header);
        content.setComponentAlignment(header, Alignment.MIDDLE_CENTER);

        Button skipButton = new Button("Ja, ich weiß was ich werden will!");
        skipButton.setStyleName(ValoTheme.BUTTON_LINK);
        skipButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                wizard.next();
                wizard.next();
            }
        });
        content.addComponent(skipButton);
        content.setComponentAlignment(skipButton, Alignment.MIDDLE_CENTER);

        Button notSkipButton = new Button("Nein, ich brauche Hilfe bei der Jobauswahl.");
        notSkipButton.setStyleName(ValoTheme.BUTTON_LINK);
        notSkipButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                wizard.next();
            }
        });
        content.addComponent(notSkipButton);
        content.setComponentAlignment(notSkipButton, Alignment.MIDDLE_CENTER);

        return content;
    }

    @Override
    public boolean onAdvance() {
        return true;
    }

    @Override
    public boolean onBack() {
        return true;
    }
}
