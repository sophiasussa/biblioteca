package com.example.application.views.emprestimo;

import com.example.application.data.SamplePerson;
import com.example.application.controller.ControllerLivro;
import com.example.application.controller.ControllerEmprestimo;
import com.example.application.controller.ControllerAutor;
import com.example.application.controller.ControllerEmpreLivro;
import com.example.application.model.Livro;
import com.example.application.model.Emprestimo;
import com.example.application.model.Autor;
import com.example.application.model.Edicao;
import com.example.application.model.Editora;
import com.example.application.model.EmpreLivro;
import com.example.application.services.SamplePersonService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("Emprestimo")
@Route(value = "emprestimo", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class EmprestimoView extends Composite<VerticalLayout> {
    ControllerEmprestimo controller = new ControllerEmprestimo();
    ControllerEmpreLivro controller2 = new ControllerEmpreLivro();
    VerticalLayout layoutColumn2 = new VerticalLayout();
    H3 h3 = new H3();
    Hr hr = new Hr();
    VerticalLayout layoutColumn3 = new VerticalLayout();
    FormLayout formLayout2Col = new FormLayout();
    NumberField numberField = new NumberField();
    TextField txtData = new TextField();
    HorizontalLayout layoutRow = new HorizontalLayout();
    Button buttonPrimary = new Button();
    Button buttonSecondary = new Button();
    Button buttonTertiary = new Button();
    H4 h4 = new H4();
    FormLayout formLayout3Col = new FormLayout();
    ComboBox<Livro> comboBox2 = new ComboBox();
    HorizontalLayout layoutRow2 = new HorizontalLayout();
    Button buttonPrimary2 = new Button();
    Button buttonSecondary2 = new Button();
    Button buttonTertiary2 = new Button();
    Hr hr2 = new Hr();
    HorizontalLayout layoutRow3 = new HorizontalLayout();
    TextField textField = new TextField();
    Button buttonSecondary3 = new Button();
    Grid<Emprestimo> grid;
    Grid<EmpreLivro> grid1;


    public EmprestimoView() {        
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutColumn2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        h3.setText("Cadastrar Empréstimo");
        h3.setWidth("max-content");
        layoutColumn3.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.setWidth("100%");
        layoutColumn3.getStyle().set("flex-grow", "1");
        formLayout2Col.setWidth("100%");
        numberField.setLabel("ID");
        numberField.setWidth("min-content");
        txtData.setLabel("Data do Empréstimo");
        txtData.setWidth("min-content");
        layoutRow.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("50px");
        layoutRow.setAlignItems(Alignment.CENTER);
        layoutRow.setJustifyContentMode(JustifyContentMode.END);
        buttonPrimary.setText("Cadastrar");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        buttonPrimary.addClickListener(event -> {
            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setData_emprestimo(Integer.parseInt(txtData.getValue()));
            if (controller.inserir(emprestimo) == true) {
                Notification notification = new Notification(
                        "Emprestimo salvo com sucesso.", 3000);
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
        
        buttonSecondary.setText("Alterar");
        buttonSecondary.setWidth("min-content");

        buttonSecondary.addClickListener(event -> {
            int id = (int) Math.round(numberField.getValue());

            if (id > 0) {
                Emprestimo emprestimo = controller.pesquisar(id);
        
                if (emprestimo != null) {
                    emprestimo.setData_emprestimo(Integer.parseInt(txtData.getValue()));
        
                    if (controller.alterar(emprestimo)) {
                        Notification notification = new Notification(
                                "Emprestimo alterado com sucesso.", 3000);
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
                            "Emprestimo com o ID fornecido não encontrado.", 3000);
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


        buttonTertiary.setText("Deletar");
        buttonTertiary.setWidth("min-content");
        buttonTertiary.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        buttonTertiary.addClickListener(event -> {
            int id = (int) Math.round(numberField.getValue());

            if (id > 0) {
                Emprestimo emprestimo = controller.pesquisar(id);
        
                if (emprestimo != null) {
                    if (controller.excluir(emprestimo)) {
                        Notification notification = new Notification(
                                "Emprestimo deletado com sucesso.", 3000);
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
                            "Emprestimo com o ID fornecido não encontrado.", 3000);
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


        h4.setText("Adicionar Livros ao Empréstimo");
        h4.setWidth("max-content");
        formLayout3Col.setWidth("100%");
        formLayout3Col.setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("250px", 2),
                new ResponsiveStep("500px", 3));
        comboBox2.setLabel("Livro");
        comboBox2.setWidth("min-content");
        layoutRow2.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        layoutRow2.setAlignItems(Alignment.CENTER);
        layoutRow2.setJustifyContentMode(JustifyContentMode.START);
        buttonPrimary2.setText("Cadastrar");
        buttonPrimary2.setWidth("min-content");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        buttonPrimary2.addClickListener(event -> {
            EmpreLivro empreLivro = new EmpreLivro();
            int emprestimoId = Integer.parseInt((String.valueOf(numberField.getValue())));
            Livro livroSelecionado = comboBox2.getValue();
            Emprestimo emprestimoSelecionado = controller.pesquisar(emprestimoId);
        
            if (livroSelecionado != null && emprestimoSelecionado != null) {
                empreLivro.setLivro(livroSelecionado);
                empreLivro.setEmprestimo(emprestimoSelecionado);
                if (controller2.inserir(empreLivro) == true) {
                    Notification notification = new Notification(
                            "Livro salvo com sucesso.", 3000);
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
            } else {
                Notification notification = new Notification(
                        "Por favor, selecione um livro ou um emprestimo.", 3000);
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                notification.setPosition(Notification.Position.MIDDLE);
                notification.open();
                return;
            }

        });

        buttonSecondary2.setText("Alterar");
        buttonSecondary2.setWidth("min-content");

/*         buttonSecondary.addClickListener(event -> {
            int id = (int) Math.round(numberField.getValue());

            if (id > 0) {
            //    EmpreLivro empreLivro = controller2.pesquisar(id);
        
                if (empreLivro != null) {
                    empreLivro.setLivro(textField.getValue());
        
                    if (controller2.alterar(empreLivro)) {
                        Notification notification = new Notification(
                                "EmpreLivro alterado com sucesso.", 3000);
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
                            "EmpreLivro com o ID fornecido não encontrado.", 3000);
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
*/

        buttonTertiary2.setText("Deletar");
        buttonTertiary2.setWidth("min-content");
        buttonTertiary2.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

/*         buttonTertiary2.addClickListener(event -> {
            int id = (int) Math.round(numberField2.getValue());

            if (id > 0) {
                EmpreLivro empreLivro = controller2.pesquisar(id);

                if (empreLivro != null) {
                    if (controller2.excluir(empreLivro)) {
                        Notification notification = new Notification(
                                "EmpreLivro deletado com sucesso.", 3000);
                        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                        notification.setPosition(Notification.Position.MIDDLE);
                        notification.open();
                    } else {
                        Notification notification = new Notification(
                                "EmpreLivro ao deletar. Verifique se todos os dados foram preenchidos.", 3000);
                        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                        notification.setPosition(Notification.Position.MIDDLE);
                        notification.open();
                    }
                } else {
                    Notification notification = new Notification(
                            "EmpreLivro com o ID fornecido não encontrado.", 3000);
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
*/
        layoutRow3.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.getStyle().set("flex-grow", "1");
        layoutRow3.setAlignItems(Alignment.START);
        layoutRow3.setJustifyContentMode(JustifyContentMode.END); 
        
        textField.setLabel("");
        textField.setPrefixComponent(new Icon("lumo", "search"));
        textField.setWidth("min-content");
        buttonSecondary3.setText("Pesquisar Emprestimo");
        buttonSecondary3.setWidth("min-content");

        buttonSecondary3.addClickListener(event -> {
            if (textField.isEmpty()) {
                List<Emprestimo> emprestimos = controller.pesquisarTodos();
                addGridToConsultaTab(emprestimos);
            }else{
                try{
                    int id = (int) Math.round(Double.parseDouble(textField.getValue()));
                    Emprestimo emprestimo = controller.pesquisar(id);
                    if (emprestimo != null) {
                        List<Emprestimo> emprestimoEncontrados = new ArrayList<>();
                        emprestimoEncontrados.add(emprestimo);
                        addGridToConsultaTab(emprestimoEncontrados);
                    } else {
                        Notification notification = new Notification(
                                "Emprestimo com o ID fornecido não encontrado.", 3000);
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
      

        layoutRow3.add(textField, buttonSecondary3);
        
        layoutRow3.setAlignItems(FlexComponent.Alignment.END);
        getContent().add(layoutColumn2);
        layoutColumn2.add(h3);
        layoutColumn2.add(hr);
        layoutColumn2.add(layoutColumn3);
        layoutColumn3.add(formLayout2Col);
        formLayout2Col.add(numberField);
        formLayout2Col.add(txtData);
        layoutColumn3.add(layoutRow);
        layoutRow.add(buttonPrimary);
        layoutRow.add(buttonSecondary);
        layoutRow.add(buttonTertiary);
        layoutColumn3.add(h4);
        layoutColumn3.add(formLayout3Col);
        formLayout3Col.add(comboBox2);
        layoutColumn3.add(layoutRow2);
        layoutRow2.add(buttonPrimary2);
        layoutRow2.add(buttonSecondary2);
        layoutRow2.add(buttonTertiary2);
        layoutColumn3.add(hr2);
        layoutColumn3.add(layoutRow3);
        layoutRow3.add(textField);
        layoutRow3.add(buttonSecondary3);
    }

    private void addGridToConsultaTab(List<Emprestimo> emprestimos) {
        if (grid == null) {
            grid = new Grid<>();
            grid.addColumn(Emprestimo::getId).setHeader("ID");
            grid.addColumn(Emprestimo::getData_emprestimo).setHeader("Nome");

            grid.setItems(emprestimos);

            grid.addItemDoubleClickListener(event -> {
                Emprestimo emprestimo = event.getItem();
                if (emprestimo != null) {
                    numberField.setValue(Double.parseDouble(String.valueOf(emprestimo.getId())));
                    txtData.setValue(String.valueOf(emprestimo.getData_emprestimo()));
                }
            });
        }else{
            layoutColumn3.remove(grid);
            grid = null;

            grid = new Grid<>();
            grid.addColumn(Emprestimo::getId).setHeader("ID");
            grid.addColumn(Emprestimo::getData_emprestimo).setHeader("Nome");
            grid.setItems(emprestimos);
    
            grid.addItemDoubleClickListener(event -> {
                Emprestimo emprestimo = event.getItem();
                if (emprestimo != null) {
                    numberField.setValue(Double.parseDouble(String.valueOf(emprestimo.getId())));
                    txtData.setValue(String.valueOf(emprestimo.getData_emprestimo()));
                }
            });
        }    
        layoutColumn3.add(grid);
    }
}
