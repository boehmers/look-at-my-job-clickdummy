package de.juzapo.view;

import de.juzapo.MyUI;
import de.juzapo.components.FeedCloud;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import de.juzapo.Menu;
import org.vaadin.alump.masonry.MasonryLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manuel on 16.11.2015.
 */
public class FeedView extends VerticalLayout implements View {

    private Menu menu;
    private MasonryLayout masonry;
    private List<FeedCloud> entries;

    public FeedView(final Menu menu) {
        this.menu = menu;
        this.entries = new ArrayList<>();
        setSpacing(true);
        setMargin(true);

        HorizontalLayout postSomething = new HorizontalLayout();
        postSomething.setSpacing(true);
        postSomething.setMargin(true);
        postSomething.setWidth("100%");
        final TextField postInput = new TextField();
        postInput.setWidth("100%");
        postInput.setDescription("Aktuell nur Beispielerzeugung von Posts.");
        postInput.setInputPrompt("Eingeloggte Ansprechpartner können später hier posten.");
        postSomething.addComponent(postInput);
        final Button post = new Button("Post!");
        post.setStyleName(ValoTheme.BUTTON_DANGER);
        post.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                FeedCloud f = new FeedCloud(MyUI.testData.bauer, MyUI.testData.text1.getTitle(),
                        MyUI.testData.text1.getUser(),
                        MyUI.testData.text1.getQ1(), MyUI.testData.text1.getQ2(),
                        MyUI.testData.text1.getQ3(), MyUI.testData.text1.getQ4(),
                        MyUI.testData.text1.getQ5(), MyUI.testData.text1.getQ6(),
                        MyUI.testData.text1.getQ7(), MyUI.testData.text1.getQ8(),
                        MyUI.testData.text1.getQ9());
                entries.add(f);
                masonry.addComponent(f, MasonryLayout.DOUBLE_WIDE_STYLENAME);
                postInput.setValue("");
            }
        });
        postSomething.addComponent(post);
        addComponent(postSomething);

        masonry = new MasonryLayout();
        masonry.setSizeFull();
        addComponent(masonry);

        entries.add(new FeedCloud(MyUI.testData.informatiker, MyUI.testData.text1.getTitle(),
                MyUI.testData.text1.getUser(),
                MyUI.testData.text1.getQ1(), MyUI.testData.text1.getQ2(),
                MyUI.testData.text1.getQ3(), MyUI.testData.text1.getQ4(),
                MyUI.testData.text1.getQ5(), MyUI.testData.text1.getQ6(),
                MyUI.testData.text1.getQ7(), MyUI.testData.text1.getQ8(),
                MyUI.testData.text1.getQ9()));
        entries.add(new FeedCloud(MyUI.testData.juzPapa, MyUI.testData.text2.getTitle(),
                MyUI.testData.text2.getUser(),
                MyUI.testData.text2.getQ1(), MyUI.testData.text2.getQ2(),
                MyUI.testData.text2.getQ3(), MyUI.testData.text2.getQ4(),
                MyUI.testData.text2.getQ5(), MyUI.testData.text2.getQ6(),
                MyUI.testData.text2.getQ7(), MyUI.testData.text2.getQ8(),
                MyUI.testData.text2.getQ9()));

        for (FeedCloud f : entries) {
            masonry.addComponent(f, MasonryLayout.DOUBLE_WIDE_STYLENAME);
        }
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        menu.setActiveButton(MyUI.VIEW_FEED);
        addComponent(menu, 0);
        filter();
    }

    public void filter() {
        if (menu.getBerufe().getValue() != null) {
            if (menu.getBerufe().getValue().equals("Keine Ahnung!") || menu.getBerufe().getValue().equals("Alle!")) {
                for (FeedCloud f : entries) {
                    f.setVisible(true);
                }
            } else {
                for (FeedCloud f : entries) {
                    if (f.getBeruf().equals(menu.getBerufe().getValue())) {
                        f.setVisible(true);
                    } else {
                        f.setVisible(false);
                    }
                }
            }
        }
    }
}
