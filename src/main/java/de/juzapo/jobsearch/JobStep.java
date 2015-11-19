package de.juzapo.jobsearch;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import de.juzapo.Constants;
import de.juzapo.MyUI;
import de.juzapo.model.FilterParams;
import org.vaadin.teemu.wizards.WizardStep;

/**
 * Created by Manuel on 19.11.2015.
 */
public class JobStep implements WizardStep {

    private ComboBox jobPicks = new ComboBox("Welcher Beruf interessiert dich?");

    @Override
    public String getCaption() {
        return "Jobauswahl";
    }

    @Override
    public Component getContent() {
        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();
        content.setMargin(true);
        content.setSpacing(true);

        Label header = new Label("In der Liste hier findest du deine Jobvorschläge. Such dir einen aus und wir werden die Einträge für dich filtern.");
        header.setStyleName(ValoTheme.LABEL_H3);
        content.addComponent(header);
        content.setComponentAlignment(header, Alignment.MIDDLE_CENTER);

        jobPicks.setCaption("Such dir einen Job aus:");
        jobPicks.clear();
        jobPicks.addItems(JobSearchEngine.getJobByFilterParams((FilterParams) MyUI.getCurrent().getSession().getAttribute("filterParams")));
        content.addComponent(jobPicks);
        content.setComponentAlignment(jobPicks, Alignment.MIDDLE_CENTER);
        return content;
    }

    @Override
    public boolean onAdvance() {
        return false;
    }

    @Override
    public boolean onBack() {
        return true;
    }

    public Object getJobPick() {
        return jobPicks.getValue();
    }
}
