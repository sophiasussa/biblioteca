package com.example.application.views.autor;

import com.example.application.controller.ControllerAutor;
import com.example.application.data.SamplePerson;
import com.example.application.model.Autor;
import com.example.application.services.SamplePersonService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("Autor")
@Route(value = "autor", layout = MainLayout.class)
@Uses(Icon.class)
public class AutorView extends Composite<VerticalLayout> {
    ControllerAutor controller = new ControllerAutor();
    NumberField numberField = new NumberField();
    TextField textField = new TextField();
    VerticalLayout layoutColumn2 = new VerticalLayout();
    H3 h3 = new H3();
    VerticalLayout layoutColumn3 = new VerticalLayout();
    Hr hr = new Hr();
    FormLayout formLayout2Col = new FormLayout();
    HorizontalLayout layoutRow = new HorizontalLayout();
    Button buttonPrimary = new Button();
    Button buttonSecondary = new Button();
    Button buttonTertiary = new Button();
    Hr hr2 = new Hr();
    Hr hr3 = new Hr();
    HorizontalLayout layoutRow2 = new HorizontalLayout();
    TextField textField2 = new TextField();
    Button buttonSecondary2 = new Button();
    Grid<Autor> grid;

    public AutorView() {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutColumn2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        h3.setText("Cadastrar Autor");
        h3.setWidth("max-content");
        layoutColumn3.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.setWidth("100%");
        layoutColumn3.getStyle().set("flex-grow", "1");
        formLayout2Col.setWidth("100%");
        numberField.setLabel("ID");
        numberField.setWidth("min-content");
        textField.setLabel("Nome");
        textField.setWidth("min-content");
        layoutRow.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("50px");
        layoutRow.setAlignItems(Alignment.START);
        layoutRow.setJustifyContentMode(JustifyContentMode.END);
        buttonPrimary.setText("Salvar");

        buttonPrimary.addClickListener(event -> {
            Autor autor = new Autor();
            autor.setNome_autor(textField.getValue());
            if (controller.inserir(autor) == true) {
                Notification notification = new Notification(
                        "Autor salvo com sucesso.", 3000);
                notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                notification.setPosition(Notification.Position.MIDDLE);
                notification.open();
            } else {
                Notification notification = new Notification(
                        "Erro ao salvar. Verifique se todos os dados foram preenchidos.", 3000);
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                notification.setPosition(Notification.Position.MIDDLE);
                notification.open();
            }
        });

        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonSecondary.setText("Alterar");

        buttonSecondary.addClickListener(event -> {
            int id = (int) Math.round(numberField.getValue());

            if (id > 0) {
                Autor autor = controller.pesquisar(id);
        
                if (autor != null) {
                    autor.setNome_autor(textField.getValue());
        
                    if (controller.alterar(autor)) {
                        Notification notification = new Notification(
                                "Autor alterado com sucesso.", 3000);
                        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                        notification.setPosition(Notification.Position.MIDDLE);
                        notification.open();
                    } else {
                        Notification notification = new Notification(
                                "Erro ao alterar. Verifique se todos os dados foram preenchidos.", 3000);
                        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                        notification.setPosition(Notification.Position.MIDDLE);
                        notification.open();
                    }
                } else {
                    Notification notification = new Notification(
                            "Autor com o ID fornecido não encontrado.", 3000);
                    notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                    notification.setPosition(Notification.Position.MIDDLE);
                    notification.open();
                }
            } else {
                Notification notification = new Notification(
                        "ID inválido. Por favor, insira um ID válido.", 3000);
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                notification.setPosition(Notification.Position.MIDDLE);
                notification.open();
            }     
        });
    

        buttonSecondary.setWidth("min-content");
        buttonTertiary.setText("Deletar");
        buttonTertiary.setWidth("min-content");
        buttonTertiary.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        buttonTertiary.addClickListener(event -> {
            int id = (int) Math.round(numberField.getValue());

            if (id > 0) {
                Autor autor = controller.pesquisar(id);
        
                if (autor != null) {
                    if (controller.excluir(autor)) {
                        Notification notification = new Notification(
                                "Autor deletado com sucesso.", 3000);
                        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                        notification.setPosition(Notification.Position.MIDDLE);
                        notification.open();
                    } else {
                        Notification notification = new Notification(
                                "Erro ao deletar. Verifique se todos os dados foram preenchidos.", 3000);
                        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                        notification.setPosition(Notification.Position.MIDDLE);
                        notification.open();
                    }
                } else {
                    Notification notification = new Notification(
                            "Autor com o ID fornecido não encontrado.", 3000);
                    notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                    notification.setPosition(Notification.Position.MIDDLE);
                    notification.open();
                }
            } else {
                Notification notification = new Notification(
                        "ID inválido. Por favor, insira um ID válido.", 3000);
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                notification.setPosition(Notification.Position.MIDDLE);
                notification.open();
            }     
        });

        layoutRow2.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.setHeight("50px");
        layoutRow2.setAlignItems(Alignment.END);
        layoutRow2.setJustifyContentMode(JustifyContentMode.END);

        textField2.setLabel("");
        textField2.setPrefixComponent(new Icon("lumo", "search"));
        textField2.setWidth("min-content");
        buttonSecondary2.setText("Pesquisar");

        buttonSecondary2.addClickListener(event -> {
            if (textField2.isEmpty()) {
                List<Autor> autores = controller.pesquisarTodos();
                addGridToConsultaTab(autores);
            }else{
                try{
                    int id = (int) Math.round(Double.parseDouble(textField2.getValue()));
                    Autor autor = controller.pesquisar(id);
                    if (autor != null) {
                        List<Autor> autoresEncontrados = new ArrayList<>();
                        autoresEncontrados.add(autor);
                        addGridToConsultaTab(autoresEncontrados);
                    } else {
                        Notification notification = new Notification(
                                "Autor com o ID fornecido não encontrado.", 3000);
                        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                        notification.setPosition(Notification.Position.MIDDLE);
                        notification.open();
                    }
                }catch (NumberFormatException e) {
                    Notification notification = new Notification(
                            "ID inválido. Por favor, insira um ID válido.", 3000);
                    notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                    notification.setPosition(Notification.Position.MIDDLE);
                    notification.open();
                }
            }
        });

        layoutRow2.setAlignSelf(FlexComponent.Alignment.END, buttonSecondary2);
        buttonSecondary2.setWidth("min-content");
        getContent().add(layoutColumn2);
        layoutColumn2.add(h3);
        layoutColumn2.add(layoutColumn3);
        layoutColumn3.add(hr);
        layoutColumn3.add(formLayout2Col);
        formLayout2Col.add(numberField);
        formLayout2Col.add(textField);
        layoutColumn3.add(layoutRow);
        layoutRow.add(buttonPrimary);
        layoutRow.add(buttonSecondary);
        layoutRow.add(buttonTertiary);
        layoutRow.add(hr2);
        layoutColumn3.add(hr3);
        layoutColumn3.add(layoutRow2);
        layoutRow2.add(textField2);
        layoutRow2.add(buttonSecondary2);
      //  addGridToConsultaTab(layoutColumn3);
    }

        private void addGridToConsultaTab(List<Autor> autores) {
            if (grid == null) {
                grid = new Grid<>();
                grid.addColumn(Autor::getId).setHeader("ID");
                grid.addColumn(Autor::getNome_autor).setHeader("Nome");

                grid.setItems(autores);

                grid.addItemDoubleClickListener(event -> {
                    Autor autor = event.getItem();
                    if (autor != null) {
                        numberField.setValue(Double.parseDouble(String.valueOf(autor.getId())));
                        textField.setValue(autor.getNome_autor());
                    }
                });
            }else{
                layoutColumn3.remove(grid);
                grid = null;

                grid = new Grid<>();
                grid.addColumn(Autor::getId).setHeader("ID");
                grid.addColumn(Autor::getNome_autor).setHeader("Nome");
                grid.setItems(autores);
        
                grid.addItemDoubleClickListener(event -> {
                    Autor autor = event.getItem();
                    if (autor != null) {
                        numberField.setValue(Double.parseDouble(String.valueOf(autor.getId())));
                        textField.setValue(autor.getNome_autor());
                    }
                });
            }    
            layoutColumn3.add(grid);
        
    }
}