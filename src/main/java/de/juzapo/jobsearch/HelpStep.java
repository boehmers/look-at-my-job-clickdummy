package de.juzapo.jobsearch;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;
import de.juzapo.model.FilterParams;
import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.WizardStep;

/**
 * Created by Manuel on 19.11.2015.
 */
public class HelpStep implements WizardStep {

    private Wizard helpWizard;
    private Wizard mainWizard;
    private FilterParams filterParams;

    public HelpStep(Wizard wizard) {
        mainWizard = wizard;
    }

    @Override
    public String getCaption() {
        return "Hilfe bei der Jobsuche";
    }

    @Override
    public Component getContent() {
        filterParams = new FilterParams();
        helpWizard = new Wizard();
        helpWizard.setSizeFull();
        helpWizard.getCancelButton().setVisible(false);

        Button nextButton = helpWizard.getNextButton();
        nextButton.setCaption("Weiter");
        nextButton.setStyleName(ValoTheme.BUTTON_LINK);

        Button backButton = helpWizard.getBackButton();
        backButton.setCaption("Zurück");
        backButton.setStyleName(ValoTheme.BUTTON_LINK);

        Button finishButton = helpWizard.getFinishButton();
        finishButton.setCaption("Jobs anzeigen");
        finishButton.setStyleName(ValoTheme.BUTTON_LINK);
        finishButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                mainWizard.next();
                helpWizard.getUI().getSession().setAttribute("filterParams", filterParams);
            }
        });

        helpWizard.addStep(new TypStep());
        helpWizard.addStep(new VerdienstStep());
        helpWizard.addStep(new InteressenStep());
        helpWizard.addStep(new FähigkeitenStep());
        helpWizard.addStep(new QualifikationStep());

        return helpWizard;
    }

    class TypStep implements WizardStep {

        @Override
        public String getCaption() {
            return "Typ";
        }

        @Override
        public Component getContent() {
            return new Label("Job-Typ-Abfrage");
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

    class VerdienstStep implements WizardStep {

        @Override
        public String getCaption() {
            return "Verdienst";
        }

        @Override
        public Component getContent() {
            return new Label("Verdienst-Abfrage");
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

    class InteressenStep implements WizardStep {

        @Override
        public String getCaption() {
            return "Interessen";
        }

        @Override
        public Component getContent() {
            return new Label("Interessen-Abfrage");
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

    class FähigkeitenStep implements WizardStep {

        @Override
        public String getCaption() {
            return "Fähigkeiten";
        }

        @Override
        public Component getContent() {
            return new Label("Fähigkeiten-Abfrage");
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

    class QualifikationStep implements WizardStep {

        @Override
        public String getCaption() {
            return "Qualifikationen";
        }

        @Override
        public Component getContent() {
            return new Label("Qualifikationen-Abfrage");
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

    @Override
    public boolean onAdvance() {
        return true;
    }

    @Override
    public boolean onBack() {
        return true;
    }
}
