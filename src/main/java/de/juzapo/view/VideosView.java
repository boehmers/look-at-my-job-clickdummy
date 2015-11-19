package de.juzapo.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import de.juzapo.Menu;
import de.juzapo.MyUI;
import de.juzapo.components.VideoCloud;
import org.vaadin.alump.masonry.MasonryLayout;

/**
 * Created by Manuel on 16.11.2015.
 */
public class VideosView extends VerticalLayout implements View {

    private Menu menu;
    private MasonryLayout masonry;

    public VideosView(final Menu menu) {
        this.menu = menu;
        setMargin(true);
        setSpacing(true);

        HorizontalLayout postSomething = new HorizontalLayout();
        postSomething.setSpacing(true);
        postSomething.setMargin(true);
        postSomething.setWidth("100%");
        VerticalLayout inputs = new VerticalLayout();
        final Upload upload = new Upload();
        upload.setWidth("100%");
        final TextField postInput = new TextField();
        postInput.setWidth("100%");
        postInput.setInputPrompt("Message");
        inputs.addComponent(postInput);
        inputs.addComponent(upload);
        final Button post = new Button("Uplaod!");
        post.setStyleName(ValoTheme.BUTTON_DANGER);
        post.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                masonry.addComponent(new VideoCloud(MyUI.testData.informatiker, postInput.getValue()), MasonryLayout.DOUBLE_WIDE_STYLENAME);
                postInput.setValue("");
            }
        });
        postSomething.addComponent(inputs);
        postSomething.addComponent(post);
        addComponent(postSomething);

        masonry = new MasonryLayout();
        masonry.setSizeFull();
        addComponent(masonry);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        menu.setActiveButton(MyUI.VIEW_VIDEOS);
        addComponent(menu, 0);
    }
}
