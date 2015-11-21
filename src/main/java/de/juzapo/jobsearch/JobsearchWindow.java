package de.juzapo.jobsearch;

import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;
import de.juzapo.MyUI;
import org.vaadin.teemu.wizards.Wizard;

/**
 * Created by Manuel on 19.11.2015.
 */
public class JobsearchWindow extends Window {

    private Wizard wizard;
    private WelcomeStep firstStep;
    private JobOrHelpStep secondStep;
    private HelpStep thirdStep;
    private JobStep fourthStep;

    public JobsearchWindow() {
        setResizable(false);
        wizard = new Wizard();
        wizard.setWidth("800px");
        wizard.setHeight("600px");

        Button backButton = wizard.getBackButton();
        backButton.setCaption("Zurück");

        Button nextButton = wizard.getNextButton();
        nextButton.setCaption("Weiter");
        nextButton.setStyleName(ValoTheme.BUTTON_PRIMARY);

        Button cancelButton = wizard.getCancelButton();
        cancelButton.setCaption("Abbrechen");
        cancelButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                JobsearchWindow.this.close();
            }
        });

        Button finishButton = wizard.getFinishButton();
        finishButton.setCaption("Fertig!");
        finishButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Object jobPick = fourthStep.getJobPick();
                MyUI ui = (MyUI) getUI();
                ui.getMenu().getBerufe().setValue(jobPick);
                JobsearchWindow.this.close();
            }
        });

        firstStep = new WelcomeStep();
        wizard.addStep(firstStep);
        secondStep = new JobOrHelpStep(wizard);
        wizard.addStep(secondStep);
        thirdStep = new HelpStep(wizard);
        wizard.addStep(thirdStep);
        fourthStep = new JobStep();
        wizard.addStep(fourthStep);

        setContent(wizard);
        setModal(true);
        setCaption("Jobsuch-Hilfe");
    }

}
