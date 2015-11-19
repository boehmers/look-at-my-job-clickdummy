package de.juzapo.components;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import de.juzapo.Constants;
import de.juzapo.model.Beruf;
import org.vaadin.alump.masonry.MasonryLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manuel on 17.11.2015.
 */
public class FeedCloud extends VerticalLayout {

    private Beruf beruf;

    private Button hideButton = new Button("Anzeigen");
    private boolean isVisible = false;
    private Label title = new Label();
    private Label berufLabel = new Label();
    private Label user = new Label();
    private Label q1Head = new Label();
    private Label q1 = new Label();
    private Label q2Head = new Label();
    private Label q2 = new Label();
    private Label q3Head = new Label();
    private Label q3 = new Label();
    private Label q4Head = new Label();
    private Label q4 = new Label();
    private Label q5Head = new Label();
    private Label q5 = new Label();
    private Label q6Head = new Label();
    private Label q6 = new Label();
    private Label q7Head = new Label();
    private Label q7 = new Label();
    private Label q8Head = new Label();
    private Label q8 = new Label();
    private Label q9Head = new Label();
    private Label q9 = new Label();

    private List<Component> compToHide = new ArrayList<>();

    public FeedCloud(Beruf beruf, String title, String username, String q1, String q2, String q3, String q4, String q5
            , String q6, String q7, String q8, String q9) {
        this.beruf = beruf;
        berufLabel.setValue(beruf.getBezeichnung());
        berufLabel.setStyleName(ValoTheme.LABEL_LIGHT);
        this.title.setValue(title);
        this.title.setStyleName(ValoTheme.LABEL_H3);
        user.setValue("by " + username);
        user.setStyleName(ValoTheme.LABEL_COLORED);
        q1Head.setValue(Constants.QUESTION_1);
        q1Head.setStyleName(ValoTheme.LABEL_BOLD);
        compToHide.add(q1Head);
        q2Head.setValue(Constants.QUESTION_2);
        q2Head.setStyleName(ValoTheme.LABEL_BOLD);
        compToHide.add(q2Head);
        q3Head.setValue(Constants.QUESTION_3);
        q3Head.setStyleName(ValoTheme.LABEL_BOLD);
        compToHide.add(q3Head);
        q4Head.setValue(Constants.QUESTION_4);
        q4Head.setStyleName(ValoTheme.LABEL_BOLD);
        compToHide.add(q4Head);
        q5Head.setValue(Constants.QUESTION_5);
        q5Head.setStyleName(ValoTheme.LABEL_BOLD);
        compToHide.add(q5Head);
        q6Head.setValue(Constants.QUESTION_6);
        q6Head.setStyleName(ValoTheme.LABEL_BOLD);
        compToHide.add(q6Head);
        q7Head.setValue(Constants.QUESTION_7);
        q7Head.setStyleName(ValoTheme.LABEL_BOLD);
        compToHide.add(q7Head);
        q8Head.setValue(Constants.QUESTION_8);
        q8Head.setStyleName(ValoTheme.LABEL_BOLD);
        compToHide.add(q8Head);
        q9Head.setValue(Constants.QUESTION_9);
        q9Head.setStyleName(ValoTheme.LABEL_BOLD);
        compToHide.add(q9Head);

        this.q1.setValue(q1);
        compToHide.add(this.q1);
        this.q2.setValue(q2);
        compToHide.add(this.q2);
        this.q3.setValue(q3);
        compToHide.add(this.q3);
        this.q4.setValue(q4);
        compToHide.add(this.q4);
        this.q5.setValue(q5);
        compToHide.add(this.q5);
        this.q6.setValue(q6);
        compToHide.add(this.q6);
        this.q7.setValue(q7);
        compToHide.add(this.q7);
        this.q8.setValue(q8);
        compToHide.add(this.q8);
        this.q9.setValue(q9);
        compToHide.add(this.q9);

        addComponent(this.title);
        addComponent(this.berufLabel);
        addComponent(hideButton);
        addComponent(q1Head);
        addComponent(this.q1);
        addComponent(q2Head);
        addComponent(this.q2);
        addComponent(q3Head);
        addComponent(this.q3);
        addComponent(q4Head);
        addComponent(this.q4);
        addComponent(q5Head);
        addComponent(this.q5);
        addComponent(q6Head);
        addComponent(this.q6);
        addComponent(q7Head);
        addComponent(this.q7);
        addComponent(q8Head);
        addComponent(this.q8);
        addComponent(q9Head);
        addComponent(this.q9);
        addComponent(user);

        hideOrShow(isVisible);

        hideButton.setStyleName(ValoTheme.BUTTON_LINK);
        hideButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                if (isVisible) {
                    isVisible = false;
                } else {
                    isVisible = true;
                }
                hideOrShow(isVisible);
            }
        });
    }

    private void hideOrShow(boolean isVisible) {
        for (Component c : compToHide) {
            c.setVisible(isVisible);
        }
        if (isVisible) {
            hideButton.setCaption("Verstecken");
        } else {
            hideButton.setCaption("Anzeigen");
        }
        try {
            MasonryLayout masonry = (MasonryLayout) getParent();
            masonry.requestLayout();
        } catch (NullPointerException e) {
            // do nothing, because initialisation
            // bad practice, i know ;-)
        }
    }
}
