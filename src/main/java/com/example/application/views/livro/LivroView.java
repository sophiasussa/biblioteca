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
    ControllerEdicao controller = new ControllerEdicao();
    ControllerLivro controller2 = new ControllerLivro();
    ControllerEditora controller3 = new ControllerEditora();
    ControllerAutor controller4 = new ControllerAutor();
    VerticalLayout layoutColumn2 = new VerticalLayout();
    VerticalLayout layoutColumn3 = new VerticalLayout();
    FormLayout formLayout2Col = new FormLayout();
    H3 h3 = new H3();
    HorizontalLayout layoutRow = new HorizontalLayout();
    VerticalLayout layoutColumn4 = new VerticalLayout();
    Hr hr = new Hr();
    FormLayout formLayout2Col2 = new FormLayout();
    NumberField numberField = new NumberField();
    TextField textField = new TextField();
    TextField txtData = new TextField();
    TextArea textArea = new TextArea();
    ComboBox<Autor> comboBox = new ComboBox();
    ComboBox<Editora> comboBox2 = new ComboBox();
    ComboBox<Livro> comboBox3 = new ComboBox<>();
    RouterLink routerLink = new RouterLink();
    RouterLink routerLink2 = new RouterLink();
    HorizontalLayout layoutRow2 = new HorizontalLayout();
    Button buttonPrimary = new Button();
    Button buttonSecondary = new Button();
    Button buttonTertiary = new Button();
    Hr hr2 = new Hr();
    H4 h4 = new H4();
    FormLayout formLayout3Col = new FormLayout();
    NumberField numberField2 = new NumberField();
    TextField txtData2 = new TextField();
    TextArea textArea2 = new TextArea();
    HorizontalLayout layoutRow3 = new HorizontalLayout();
    Button buttonPrimary2 = new Button();
    Button buttonSecondary2 = new Button();
    Button buttonTertiary2 = new Button();
    Hr hr3 = new Hr();
    HorizontalLayout layoutRow4 = new HorizontalLayout();
    TextField textField2 = new TextField();
    Button buttonSecondary3 = new Button();
    Button buttonSecondary4 = new Button();
    Grid<Livro> grid;
    Grid<Edicao> grid1;

    public LivroView() {
        formLayout2Col.setWidth("100%");
        h3.setText("Cadastrar Livro");
        h3.setWidth("max-content");
        layoutRow.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutColumn4.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn4);
        layoutColumn4.setWidth("100%");
        layoutColumn4.getStyle().set("flex-grow", "1");
        formLayout2Col2.setWidth("100%");
        numberField.setLabel("ID");
        numberField.setWidth("min-content");
        textField.setLabel("Nome");
        textField.setWidth("min-content");
        txtData.setLabel("Ano de Publicação");
        txtData.setWidth("min-content");
        textArea.setLabel("Descrição");
        textArea.setWidth("100%");
        comboBox.setLabel("Autor");
        comboBox.setWidth("min-content");
        comboBox2.setLabel("Editora");
        comboBox2.setWidth("min-content");
        routerLink.setText("Adicionar Autor");
        routerLink.setRoute(AutorView.class);
        routerLink2.setText("Adicionar Editora");
        routerLink2.setRoute(EditoraView.class);
        layoutRow2.setWidthFull();
        layoutColumn4.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        layoutRow2.setAlignItems(Alignment.START);
        layoutRow2.setJustifyContentMode(JustifyContentMode.END);
        buttonPrimary.setText("Cadastrar");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        buttonPrimary.addClickListener(event -> {
            Livro livro = new Livro();
            livro.setNome_livro(textField.getValue());
            livro.setDescricao(textArea.getValue());
            livro.setAno_publicacao(Integer.parseInt(txtData.getValue()));
            Autor autorSelecionado = comboBox.getValue();
            Editora editoraSelecionado = comboBox2.getValue();
        
            if (autorSelecionado != null && editoraSelecionado != null) {
                livro.setAutor(autorSelecionado);
                livro.setEditora(editoraSelecionado);
                if (controller2.inserir(livro) == true) {
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
                        "Por favor, selecione um autor ou editora.", 3000);
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                notification.setPosition(Notification.Position.MIDDLE);
                notification.open();
                return;
            }
        });
        buttonSecondary.setText("Alterar");
        buttonSecondary.setWidth("min-content");

        buttonSecondary.addClickListener(event -> {
            int id = (int) Math.round(numberField.getValue());

            if (id > 0) {
                Livro livro = controller2.pesquisar(id);
        
                if (livro != null) {
                    livro.setNome_livro(textField.getValue());
                    livro.setDescricao(textArea.getValue());
                    livro.setAno_publicacao(Integer.parseInt(txtData.getValue()));
                    Autor autorSelecionado = comboBox.getValue();
                    Editora editoraSelecionado = comboBox2.getValue();
                
                    if (autorSelecionado != null) {
                        livro.setAutor(autorSelecionado);
                    } else {
                        Notification notification = new Notification(
                                "Por favor, selecione um autor.", 3000);
                        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                        notification.setPosition(Notification.Position.MIDDLE);
                        notification.open();
                        return;
                    }
        
                    if (editoraSelecionado != null) {
                        livro.setEditora(editoraSelecionado);
                    } else {
                        Notification notification = new Notification(
                                "Por favor, selecione uma editora.", 3000);
                        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                        notification.setPosition(Notification.Position.MIDDLE);
                        notification.open();
                        return;
                    }
        
                    if (controller2.alterar(livro)) {
                        Notification notification = new Notification(
                                "Livro alterado com sucesso.", 3000);
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
                            "Livro com o ID fornecido não encontrado.", 3000);
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
                Livro livro = controller2.pesquisar(id);
        
                if (livro != null) {
                    if (controller2.excluir(livro)) {
                        Notification notification = new Notification(
                                "Livro deletado com sucesso.", 3000);
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
                            "Livro com o ID fornecido não encontrado.", 3000);
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



        h4.setText("Adicionar Edição");
        h4.setWidth("max-content");
        formLayout3Col.setWidth("100%");
        formLayout3Col.setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("250px", 2),
                new ResponsiveStep("500px", 3));
        numberField2.setLabel("ID - Edição");
        numberField2.setWidth("min-content");
        txtData2.setLabel("Ano - Edição");
        txtData2.setWidth("min-content");
        textArea2.setLabel("Descrição Edição");
        textArea2.setWidth("100%");
        comboBox3.setLabel("Livro");
        comboBox3.setWidth("min-content");
  
        layoutRow3.setWidthFull();
        layoutColumn4.setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.getStyle().set("flex-grow", "1");
        layoutRow3.setAlignItems(Alignment.START);
        layoutRow3.setJustifyContentMode(JustifyContentMode.END);
        buttonPrimary2.setText("Cadastrar");
        buttonPrimary2.setWidth("min-content");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        buttonPrimary2.addClickListener(event -> {
        Edicao edicao = new Edicao();
        edicao.setAno(Integer.parseInt(txtData2.getValue()));
        edicao.setNovo_conteudo(textArea2.getValue());
        Livro livroSelecionado = comboBox3.getValue();
        
            if (livroSelecionado != null) {
                edicao.setLivro(livroSelecionado);
            } else {
                Notification notification = new Notification(
                        "Por favor, selecione um livro.", 3000);
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                notification.setPosition(Notification.Position.MIDDLE);
                notification.open();
                return;
            }

            if (controller.inserir(edicao) == true) {
                Notification notification = new Notification(
                        "Edição salvo com sucesso.", 3000);
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

        buttonSecondary2.setText("Alterar");
        buttonSecondary2.setWidth("min-content");
        
        buttonSecondary2.addClickListener(event -> {
            int id = (int) Math.round(numberField2.getValue());

            if (id > 0) {
                Edicao edicao = controller.pesquisar(id);
        
                if (edicao != null) {
                    edicao.setAno(Integer.parseInt(txtData2.getValue()));
                    edicao.setNovo_conteudo(textArea2.getValue());
        
                    if (controller.alterar(edicao)) {
                        Notification notification = new Notification(
                                "Edicao alterado com sucesso.", 3000);
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
                            "Edicao com o ID fornecido não encontrado.", 3000);
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

        buttonTertiary2.setText("Deletar");
        buttonTertiary2.setWidth("min-content");
        buttonTertiary2.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        buttonTertiary2.addClickListener(event -> {
            int id = (int) Math.round(numberField2.getValue());

            if (id > 0) {
                Edicao edicao = controller.pesquisar(id);
        
                if (edicao != null) {
                    if (controller.excluir(edicao)) {
                        Notification notification = new Notification(
                                "Edicao deletado com sucesso.", 3000);
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
                            "Edicao com o ID fornecido não encontrado.", 3000);
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
        layoutRow4.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutRow4);
        layoutRow4.addClassName(Gap.MEDIUM);
        layoutRow4.setWidth("100%");
        layoutRow4.getStyle().set("flex-grow", "1");
        layoutRow4.setAlignItems(Alignment.CENTER);
        layoutRow4.setJustifyContentMode(JustifyContentMode.END);
        textField2.setLabel("");
        textField2.setWidth("min-content");
        textField2.setPrefixComponent(new Icon("lumo", "search"));
        buttonSecondary3.setText("Pesquisar Livro");
        layoutRow4.setAlignSelf(FlexComponent.Alignment.END, buttonSecondary3);
        buttonSecondary3.setWidth("min-content");

        buttonSecondary3.addClickListener(event -> {
            if (textField2.isEmpty()) {
                List<Livro> livro = controller2.pesquisarTodos();
                addGridToConsultaTab(livro);
            }else{
                try{
                    int id = (int) Math.round(Double.parseDouble(textField2.getValue()));
                    Livro livro = controller2.pesquisar(id);
                    if (livro != null) {
                        List<Livro> livrosEncontrados = new ArrayList<>();
                        livrosEncontrados.add(livro);
                        addGridToConsultaTab(livrosEncontrados);
                    } else {
                        Notification notification = new Notification(
                                "Livro com o ID fornecido não encontrado.", 3000);
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


        buttonSecondary4.setText("Pesquisar Edição");
        layoutRow4.setAlignSelf(FlexComponent.Alignment.END, buttonSecondary4);
        buttonSecondary4.setWidth("min-content");

        buttonSecondary4.addClickListener(event -> {
            if (textField2.isEmpty()) {
                List<Edicao> edicao = controller.pesquisarTodos();
                addGridToConsultaTab2(edicao);
            }else{
                try{
                    int id = (int) Math.round(Double.parseDouble(textField2.getValue()));
                    Edicao edicao = controller.pesquisar(id);
                    if (edicao != null) {
                        List<Edicao> edicaoEncontrados = new ArrayList<>();
                        edicaoEncontrados.add(edicao);
                        addGridToConsultaTab2(edicaoEncontrados);
                    } else {
                        Notification notification = new Notification(
                                "Edição com o ID fornecido não encontrado.", 3000);
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

        getContent().add(layoutColumn2);
        layoutColumn2.add(layoutColumn3);
        layoutColumn3.add(formLayout2Col);
        formLayout2Col.add(h3);
        layoutColumn3.add(layoutRow);
        layoutRow.add(layoutColumn4);
        layoutColumn4.add(hr);
        layoutColumn4.add(formLayout2Col2);
        formLayout2Col2.add(numberField);
        formLayout2Col2.add(textField);
        formLayout2Col2.add(txtData);
        formLayout2Col2.add(textArea);
        formLayout2Col2.add(comboBox);
        formLayout2Col2.add(comboBox2);
        formLayout2Col2.add(routerLink);
        formLayout2Col2.add(routerLink2);
        layoutColumn4.add(layoutRow2);
        layoutRow2.add(buttonPrimary);
        layoutRow2.add(buttonSecondary);
        layoutRow2.add(buttonTertiary);
        layoutColumn4.add(hr2);
        layoutColumn4.add(h4);
        layoutColumn4.add(formLayout3Col);
        formLayout3Col.add(numberField2);
        formLayout3Col.add(txtData2);
        formLayout3Col.add(textArea2);
        formLayout3Col.add(comboBox3);
        layoutColumn4.add(layoutRow3);
        layoutRow3.add(buttonPrimary2);
        layoutRow3.add(buttonSecondary2);
        layoutRow3.add(buttonTertiary2);
        layoutColumn4.add(hr3);
        layoutColumn3.add(layoutRow4);
        layoutRow4.add(textField2);
        layoutRow4.add(buttonSecondary3);
        layoutRow4.add(buttonSecondary4);

        setComboBoxAutorData(comboBox);
        setComboBoxEditoraData(comboBox2);
        setComboBoxData(comboBox3);
    }
    
    private void setComboBoxData(ComboBox<Livro> comboBox3) {
        List<Livro> livros = controller2.pesquisarTodos();
        comboBox3.setItems(livros);
        comboBox3.setItemLabelGenerator(livro -> livro.getNome_livro());
    }
    
    private void setComboBoxAutorData(ComboBox<Autor> comboBox) {
        List<Autor> autores = controller4.pesquisarTodos();
        comboBox.setItems(autores);
        comboBox.setItemLabelGenerator(autor -> autor.getNome_autor());
    }
    
    private void setComboBoxEditoraData(ComboBox<Editora> comboBox2) {
        List<Editora> editoras = controller3.pesquisarTodos();
        comboBox2.setItems(editoras);
        comboBox2.setItemLabelGenerator(editora -> editora.getNome_editora());
    }   


    private void addGridToConsultaTab(List<Livro> livros) {
        if (grid == null) {
            grid = new Grid<>();
            grid.addColumn(Livro::getId).setHeader("ID");
            grid.addColumn(Livro::getNome_livro).setHeader("Nome");
            grid.setItems(livros);
    
            grid.addItemDoubleClickListener(event -> {
                Livro livro = event.getItem();
                if (livro != null) {
                    numberField.setValue(Double.parseDouble(String.valueOf(livro.getId())));
                    textField.setValue(livro.getNome_livro());
                }
            });
    
            layoutColumn3.add(grid);
        } else {
            grid.setItems(livros);
        }
    }

    private void addGridToConsultaTab2(List<Edicao> edicoes) {
        if (grid1 == null) {
            grid1 = new Grid<>();
            grid1.addColumn(Edicao::getId).setHeader("ID");
            grid1.addColumn(Edicao::getNovo_conteudo).setHeader("Nome");
            grid1.setItems(edicoes);
    
            grid1.addItemDoubleClickListener(event -> {
                Edicao edicao = event.getItem();
                if (edicao != null) {
                    numberField.setValue(Double.parseDouble(String.valueOf(edicao.getId())));
                    textField.setValue(edicao.getNovo_conteudo());
                }
            });
    
            layoutColumn3.add(grid1);
        } else {
            grid1.setItems(edicoes);
        }
    }
    
}
