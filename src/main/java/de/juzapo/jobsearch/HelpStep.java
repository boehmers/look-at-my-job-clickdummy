package de.juzapo.jobsearch;

import de.juzapo.model.Beruf;
import de.juzapo.model.FilterParams;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.WizardStep;

/**
 * Created by Manuel on 19.11.2015.
 */
public class HelpStep implements WizardStep {

    private Wizard helpWizard;
    private Wizard mainWizard;
    private FilterParams filterParams = new FilterParams();
    private BeanItem<FilterParams> fpBean = new BeanItem<>(filterParams);

    public HelpStep(Wizard wizard) {
        mainWizard = wizard;
    }

    @Override
    public String getCaption() {
        return "Hilfe bei der Jobsuche";
    }

    @Override
    public Component getContent() {
        helpWizard = new Wizard();
        helpWizard.setWidth("100%");
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
                filterParams.setDoFilter(true);
                mainWizard.next();
            }
        });

        mainWizard.getUI().getSession().setAttribute("filterParams", filterParams);
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
            VerticalLayout content = new VerticalLayout();
            content.setMargin(true);
            content.setSpacing(true);

            Label header = new Label("Erzähle uns etwas über deine Vorstellungen. Welchen Typ von Job stellst du dir vor? (Mehrfachauswahl möglich)");
            header.setStyleName(ValoTheme.LABEL_COLORED);
            content.addComponent(header);
            content.setComponentAlignment(header, Alignment.MIDDLE_CENTER);

            TwinColSelect jobTypes = new TwinColSelect();
            jobTypes.setImmediate(true);
            jobTypes.addItems(Beruf.BerufsTyp.values());
            jobTypes.setPropertyDataSource(fpBean.getItemProperty("berufsTypen"));
            jobTypes.setSizeFull();
            content.addComponent(jobTypes);
            content.setComponentAlignment(jobTypes, Alignment.MIDDLE_CENTER);

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

    class VerdienstStep implements WizardStep {

        @Override
        public String getCaption() {
            return "Verdienst";
        }

        @Override
        public Component getContent() {
            VerticalLayout content = new VerticalLayout();
            content.setMargin(true);
            content.setSpacing(true);

            Label header = new Label("Welche Gehaltsvorstellungen hast du ungefähr?");
            header.setStyleName(ValoTheme.LABEL_COLORED);
            content.addComponent(header);
            content.setComponentAlignment(header, Alignment.MIDDLE_CENTER);

            ListSelect verdienst = new ListSelect();
            verdienst.setImmediate(true);
            verdienst.addItems(Beruf.Verdienst.values());
            verdienst.setPropertyDataSource(fpBean.getItemProperty("verdienst"));
            verdienst.setSizeFull();
            content.addComponent(verdienst);
            content.setComponentAlignment(verdienst, Alignment.MIDDLE_CENTER);

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

    class InteressenStep implements WizardStep {

        @Override
        public String getCaption() {
            return "Interessen";
        }

        @Override
        public Component getContent() {
            VerticalLayout content = new VerticalLayout();
            content.setMargin(true);
            content.setSpacing(true);

            Label header = new Label("Jetzt wollen wir noch deine Interessen ins Spiel bringen. Sage uns, was dir im Job wichtig ist! (Mehrfachauswahl möglich)");
            header.setStyleName(ValoTheme.LABEL_COLORED);
            content.addComponent(header);
            content.setComponentAlignment(header, Alignment.MIDDLE_CENTER);

            TwinColSelect interessen = new TwinColSelect();
            interessen.setImmediate(true);
            interessen.addItems(Beruf.Interessen.values());
            interessen.setPropertyDataSource(fpBean.getItemProperty("linkedInteressen"));
            interessen.setSizeFull();
            content.addComponent(interessen);
            content.setComponentAlignment(interessen, Alignment.MIDDLE_CENTER);

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

    class FähigkeitenStep implements WizardStep {

        @Override
        public String getCaption() {
            return "Fähigkeiten";
        }

        @Override
        public Component getContent() {
            VerticalLayout content = new VerticalLayout();
            content.setMargin(true);
            content.setSpacing(true);

            Label header = new Label("Jeder kann etwas Besonderes! Sage uns, worin du besonders gut bist. (Mehrfachauswahl möglich)");
            header.setStyleName(ValoTheme.LABEL_COLORED);
            content.addComponent(header);
            content.setComponentAlignment(header, Alignment.MIDDLE_CENTER);

            TwinColSelect fähigkeiten = new TwinColSelect();
            fähigkeiten.setImmediate(true);
            fähigkeiten.addItems(Beruf.Fähigkeiten.values());
            fähigkeiten.setPropertyDataSource(fpBean.getItemProperty("linkedSkills"));
            fähigkeiten.setSizeFull();
            content.addComponent(fähigkeiten);
            content.setComponentAlignment(fähigkeiten, Alignment.MIDDLE_CENTER);

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

    class QualifikationStep implements WizardStep {

        @Override
        public String getCaption() {
            return "Qualifikationen";
        }

        @Override
        public Component getContent() {
            VerticalLayout content = new VerticalLayout();
            content.setMargin(true);
            content.setSpacing(true);

            Label header = new Label("Zu guter Letzt spielt es natürlich auch eine Rolle, welchen Bildungsweg du bisher bestritten hast. " +
                    "Wähle aus, welche Abschlüsse du vorweisen kannst. (Mehrfachauswahl möglich)");
            header.setStyleName(ValoTheme.LABEL_COLORED);
            content.addComponent(header);
            content.setComponentAlignment(header, Alignment.MIDDLE_CENTER);

            TwinColSelect qualifikationen = new TwinColSelect();
            qualifikationen.setImmediate(true);
            qualifikationen.addItems(Beruf.Qualifikationen.values());
            qualifikationen.setPropertyDataSource(fpBean.getItemProperty("linkedQualis"));
            qualifikationen.setSizeFull();
            content.addComponent(qualifikationen);
            content.setComponentAlignment(qualifikationen, Alignment.MIDDLE_CENTER);

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

    @Override
    public boolean onAdvance() {
        return true;
    }

    @Override
    public boolean onBack() {
        return true;
    }
}
