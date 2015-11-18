package de.juzapo.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import de.juzapo.Menu;
import de.juzapo.MyUI;
import de.juzapo.components.FeedCloud;
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
        postInput.setInputPrompt("Message");
        postSomething.addComponent(postInput);
        final Button post = new Button("Post!");
        post.setStyleName(ValoTheme.BUTTON_DANGER);
        post.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                masonry.addComponent(new FeedCloud(MyUI.testData.text1.getTitle(),
                        MyUI.testData.text1.getUser().getUsername(),
                        MyUI.testData.text1.getQ1(), MyUI.testData.text1.getQ2(),
                        MyUI.testData.text1.getQ3(), MyUI.testData.text1.getQ4(),
                        MyUI.testData.text1.getQ5(), MyUI.testData.text1.getQ6(),
                        MyUI.testData.text1.getQ7(), MyUI.testData.text1.getQ8(),
                        MyUI.testData.text1.getQ9()), MasonryLayout.DOUBLE_WIDE_STYLENAME);
                postInput.setValue("");
            }
        });
        postSomething.addComponent(post);
        addComponent(postSomething);

        masonry = new MasonryLayout();
        masonry.setSizeFull();
        addComponent(masonry);

        entries.add(new FeedCloud(MyUI.testData.text1.getTitle(),
                MyUI.testData.text1.getUser().getUsername(),
                MyUI.testData.text1.getQ1(), MyUI.testData.text1.getQ2(),
                MyUI.testData.text1.getQ3(), MyUI.testData.text1.getQ4(),
                MyUI.testData.text1.getQ5(), MyUI.testData.text1.getQ6(),
                MyUI.testData.text1.getQ7(), MyUI.testData.text1.getQ8(),
                MyUI.testData.text1.getQ9()));
        entries.add(new FeedCloud(MyUI.testData.text2.getTitle(),
                MyUI.testData.text2.getUser().getUsername(),
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
        if (MyUI.isLoggedIn) {
            menu.setActiveButton(MyUI.VIEW_FEED);
            addComponent(menu, 0);
        } else {
            menu.showLogin();
            Notification.show("Sie sind nicht eingeloggt!", Notification.Type.ERROR_MESSAGE);
        }
    }
}
