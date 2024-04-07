package com.example.application.views.livro;

import com.example.application.model.Autor;
import com.example.application.model.Edicao;
import com.example.application.model.Editora;
import com.example.application.model.Livro;
import com.example.application.repository.DaoLivro;
import com.example.application.controller.ControllerAutor;
import com.example.application.controller.ControllerEdicao;
import com.example.application.controller.ControllerEditora;
import com.example.application.controller.ControllerLivro;
import com.example.application.data.SamplePerson;
import com.example.application.services.SamplePersonService;
import com.example.application.views.MainLayout;
import com.example.application.views.autor.AutorView;
import com.example.application.views.editora.EditoraView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.function.ValueProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("Livro")
@Route(value = "livro", layout = MainLayout.class)
@Uses(Icon.class)
public class LivroView extends Composite<VerticalLayout> {
    H3 h3 = new H3();
    FormLayout formLayout3Col = new FormLayout();
    TextField textField = new TextField();
    TextField textField2 = new TextField();
    TextArea textArea = new TextArea();
    FormLayout formLayout2Col = new FormLayout();
    ComboBox comboBox = new ComboBox();
    ComboBox comboBox2 = new ComboBox();
    Anchor link = new Anchor();
    Anchor link2 = new Anchor();
    Button buttonPrimary = new Button();
    H3 h32 = new H3();
    HorizontalLayout layoutRow = new HorizontalLayout();
    HorizontalLayout layoutRow2 = new HorizontalLayout();
    FormLayout formLayout3Col2 = new FormLayout();
    TextField textField3 = new TextField();
    TextField textField4 = new TextField();
    ComboBox comboBox3 = new ComboBox();
    HorizontalLayout layoutRow3 = new HorizontalLayout();
    Button buttonPrimary2 = new Button();


    TextField textField5 = new TextField();
    Button buttonSecondary = new Button();
    Grid basicGrid = new Grid();
    TextField textField6 = new TextField();
    Button buttonSecondary2 = new Button();
    Grid basicGrid2 = new Grid();

    HorizontalLayout layoutRow4 = new HorizontalLayout();
    HorizontalLayout layoutRow5 = new HorizontalLayout();

    public LivroView() {
        Tab tabLivro = new Tab("Livro e Edição");
        Tab tabPesquisa = new Tab("Pesquisar, Alterar e Excluir");

        Tabs tabs = new Tabs(tabLivro, tabPesquisa);
        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();
        getContent().add(tabs, content);

        tabs.addSelectedChangeListener(event -> {
            if (event.getSelectedTab() == tabLivro) {
                showLivroTab(content);
            } else if (event.getSelectedTab() == tabPesquisa) {
                showPesquisa(content);
            }
        });

        tabs.setSelectedTab(tabLivro);
        showLivroTab(content);
    }

    private void showLivroTab(VerticalLayout content){
        content.removeAll();

        VerticalLayout layoutColumn2 = new VerticalLayout();

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutColumn2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        h3.setText("Cadastrar livro");
        h3.setWidth("max-content");
        formLayout3Col.setWidth("100%");
        formLayout3Col.setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("250px", 2),
                new ResponsiveStep("500px", 3));
        textField.setLabel("Text field");
        textField.setWidth("min-content");
        textField2.setLabel("Text field");
        textField2.setWidth("min-content");
        textArea.setLabel("Text area");
        textArea.setWidth("100%");
        formLayout2Col.setWidth("100%");
        comboBox.setLabel("Combo Box");
        comboBox.setWidth("min-content");
        comboBox2.setLabel("Combo Box");
        comboBox2.setWidth("min-content");
        link.setText("Hello Vaadin");
        link.setHref("#");
        link.setWidth("min-content");
        link2.setText("Hello Vaadin");
        link2.setHref("#");
        link2.setWidth("min-content");
        buttonPrimary.setText("Button");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        h32.setText("Cadastrar Edição");
        h32.setWidth("max-content");
        layoutRow.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutRow2.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        formLayout3Col2.setWidth("1055px");
        formLayout3Col2.setHeight("90px");
        formLayout3Col2.getStyle().set("flex-grow", "0");
        formLayout3Col2.setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("250px", 2),
                new ResponsiveStep("500px", 3));
        textField3.setLabel("Text field");
        textField3.setWidth("min-content");
        textField4.setLabel("Text field");
        textField4.setWidth("min-content");
        comboBox3.setLabel("Combo Box");
        layoutRow3.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.getStyle().set("flex-grow", "1");
        buttonPrimary2.setText("Button");
        buttonPrimary2.setWidth("min-content");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutColumn2.add(h3);
        layoutColumn2.add(formLayout3Col);
        formLayout3Col.add(textField);
        formLayout3Col.add(textField2);
        formLayout3Col.add(textArea);
        layoutColumn2.add(formLayout2Col);
        formLayout2Col.add(comboBox);
        formLayout2Col.add(comboBox2);
        formLayout2Col.add(link);
        formLayout2Col.add(link2);
        layoutColumn2.add(buttonPrimary);
        layoutColumn2.add(h32);
        layoutColumn2.add(layoutRow);
        layoutRow.add(layoutRow2);
        layoutRow2.add(formLayout3Col2);
        formLayout3Col2.add(textField3);
        formLayout3Col2.add(textField4);
        formLayout3Col2.add(comboBox3);
        layoutColumn2.add(layoutRow3);
        layoutRow3.add(buttonPrimary2);

        content.add(layoutColumn2);
    }

    private void showPesquisa(VerticalLayout content){
        content.removeAll();

        VerticalLayout layoutColumn3 = new VerticalLayout();

        layoutColumn3.setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.setWidth("100%");
        layoutColumn3.getStyle().set("flex-grow", "1");
        h3.setText("Livro");
        h3.setWidth("max-content");
        layoutRow4.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutRow4);
        layoutRow4.addClassName(Gap.MEDIUM);
        layoutRow4.setWidth("100%");
        layoutRow4.setHeight("70px");
        layoutRow4.setAlignItems(Alignment.END);
        layoutRow4.setJustifyContentMode(JustifyContentMode.END);
        textField5.setLabel("Text field");
        textField5.setWidth("min-content");
        buttonSecondary.setText("Button");
        buttonSecondary.setWidth("min-content");
        basicGrid.setWidth("100%");
        basicGrid.getStyle().set("flex-grow", "0");
        h32.setText("Edição");
        h32.setWidth("max-content");
        layoutRow5.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutRow5);
        layoutRow5.addClassName(Gap.MEDIUM);
        layoutRow5.setWidth("100%");
        layoutRow5.getStyle().set("flex-grow", "1");
        layoutRow5.setAlignItems(Alignment.END);
        layoutRow5.setJustifyContentMode(JustifyContentMode.END);
        textField6.setLabel("Text field");
        textField6.setWidth("min-content");
        buttonSecondary2.setText("Button");
        buttonSecondary2.setWidth("min-content");
        basicGrid2.setWidth("100%");
        basicGrid2.getStyle().set("flex-grow", "0");
        layoutColumn3.add(h3);
        layoutColumn3.add(layoutRow4);
        layoutRow4.add(textField5);
        layoutRow4.add(buttonSecondary);
        layoutColumn3.add(basicGrid);
        layoutColumn3.add(h32);
        layoutColumn3.add(layoutRow5);
        layoutRow5.add(textField6);
        layoutRow5.add(buttonSecondary2);
        layoutColumn3.add(basicGrid2);

        content.add(layoutColumn3);
    }
}
