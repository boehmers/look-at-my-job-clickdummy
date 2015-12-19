package de.juzapo.view;

import de.juzapo.MyUI;
import de.juzapo.components.VideoCloud;
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
public class VideosView extends VerticalLayout implements View {

    private Menu menu;
    private MasonryLayout masonry;
    private List<VideoCloud> entries;

    public VideosView(final Menu menu) {
        this.menu = menu;
        this.entries = new ArrayList<>();
        setMargin(true);
        setSpacing(true);

        HorizontalLayout postSomething = new HorizontalLayout();
        postSomething.setSpacing(true);
        postSomething.setMargin(true);
        postSomething.setWidth("100%");
        VerticalLayout inputs = new VerticalLayout();
        inputs.setWidth("100%");
        final Upload upload = new Upload();
        upload.setWidth("100%");
        final TextField postInput = new TextField();
        postInput.setWidth("100%");
        postInput.setDescription("Aktuell nur Beispielerzeugung von Posts.");
        postInput.setInputPrompt("Eingeloggte Ansprechpartner können später hier posten.");
        inputs.addComponent(postInput);
        inputs.addComponent(upload);
        final Button post = new Button("Post!");
        post.setStyleName(ValoTheme.BUTTON_DANGER);
        post.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                VideoCloud v = new VideoCloud(MyUI.testData.informatiker, MyUI.testData.a, postInput.getValue());
                masonry.addComponent(v, MasonryLayout.DOUBLE_WIDE_STYLENAME);
                entries.add(v);
                postInput.setValue("");
            }
        });
        postSomething.addComponent(inputs);
        postSomething.addComponent(post);
        addComponent(postSomething);

        masonry = new MasonryLayout();
        masonry.setSizeFull();
        addComponent(masonry);

        VideoCloud v = new VideoCloud(MyUI.testData.informatiker, MyUI.testData.a, "Interview mit einem Informatiker");
        masonry.addComponent(v, MasonryLayout.DOUBLE_WIDE_STYLENAME);
        entries.add(v);

        VideoCloud v1 = new VideoCloud(MyUI.testData.juzPapa, MyUI.testData.b, "Interview mit einem Jugendzentrums-Papa");
        masonry.addComponent(v1, MasonryLayout.DOUBLE_WIDE_STYLENAME);
        entries.add(v1);

        VideoCloud v2 = new VideoCloud(MyUI.testData.bauer, MyUI.testData.b, "Interview mit einem Landwirtin");
        masonry.addComponent(v2, MasonryLayout.DOUBLE_WIDE_STYLENAME);
        entries.add(v2);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        menu.setActiveButton(MyUI.VIEW_VIDEOS);
        addComponent(menu, 0);
        filter();
        MyUI ui = (MyUI) getUI();
        ui.openJobWindow();
    }

    public void filter() {
        if (menu.getBerufe().getValue() != null) {
            if (menu.getBerufe().getValue().equals("Keine Ahnung!") || menu.getBerufe().getValue().equals("Alle!")) {
                for (VideoCloud v : entries) {
                    v.setVisible(true);
                }
            } else {
                for (VideoCloud v : entries) {
                    if (v.getBeruf().equals(menu.getBerufe().getValue())) {
                        v.setVisible(true);
                    } else {
                        v.setVisible(false);
                    }
                }
            }
        }
    }
}
