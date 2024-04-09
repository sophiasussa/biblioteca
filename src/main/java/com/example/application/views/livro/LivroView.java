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
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
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
    H3 h3 = new H3();
    FormLayout formLayout3Col = new FormLayout();
    TextField textField = new TextField();
    TextField textField2 = new TextField();
    TextArea textArea = new TextArea();
    FormLayout formLayout2Col = new FormLayout();
    ComboBox comboBox = new ComboBox();
    ComboBox comboBox2 = new ComboBox();
    RouterLink link = new RouterLink(AutorView.class);
    RouterLink link2 = new RouterLink(EditoraView.class);
    
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
    Grid<Livro> grid;
    TextField textField6 = new TextField();
    Button buttonSecondary2 = new Button();
    Grid<Edicao> grid2;

    HorizontalLayout layoutRow4 = new HorizontalLayout();
    HorizontalLayout layoutRow5 = new HorizontalLayout();

    VerticalLayout layoutColumn3 = new VerticalLayout();
    Hr hr = new Hr();

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
        h3.setText("Cadastrar Livro");
        h3.setWidth("max-content");
        formLayout3Col.setWidth("100%");
        formLayout3Col.setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("250px", 2),
                new ResponsiveStep("500px", 3));
        textField.setLabel("Nome");
        textField.setPlaceholder("Insira o nome do livro");
        textField.setWidth("min-content");
        textField2.setLabel("Ano de Publicação");
        textField2.setPlaceholder("Insira o ano de publicação do livro");
        textField2.setWidth("min-content");
        textArea.setLabel("Descrição");
        textArea.setPlaceholder("Insira a descrição do livro");
        textArea.setWidth("100%");
        formLayout2Col.setWidth("100%");
        comboBox.setLabel("Autor");
        comboBox.setPlaceholder("Selecione o autor do livro");
        comboBox.setWidth("min-content");
        comboBox2.setLabel("Editora");
        comboBox2.setPlaceholder("Selecione a editora do livro");
        comboBox2.setWidth("min-content");
        link.setText("Adicionar Autor");
        link2.setText("Adicionar Editora");
        buttonPrimary.setText("Salvar");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        buttonPrimary.addClickListener(event -> {
            Livro livro = new Livro();
            livro.setNome_livro(textField.getValue());
            livro.setDescricao(textArea.getValue());
            livro.setAno_publicacao(Integer.parseInt(textField2.getValue()));
            Autor autorSelecionado = (Autor) comboBox.getValue();
            Editora editoraSelecionado = (Editora) comboBox2.getValue();

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
        textField3.setLabel("Ano");
        textField3.setPlaceholder("Insira o ano da edição");
        textField3.setWidth("min-content");
        textField4.setLabel("Novo Conteudo");
        textField4.setPlaceholder("Insira o novo conteudo");
        textField4.setWidth("min-content");
        comboBox3.setLabel("Livro");
        comboBox3.setPlaceholder("Selecione o livro");
        layoutRow3.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.getStyle().set("flex-grow", "1");
        buttonPrimary2.setText("Salvar");

        buttonPrimary2.addClickListener(event -> {
            Edicao edicao = new Edicao();
            edicao.setAno(Integer.parseInt(textField3.getValue()));
            edicao.setNovo_conteudo(textField4.getValue());
            Livro livroSelecionado = (Livro) comboBox3.getValue();

            if (livroSelecionado != null) {
                edicao.setLivro(livroSelecionado);
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
            } else {
                Notification notification = new Notification(
                        "Por favor, selecione um livro.", 3000);
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                notification.setPosition(Notification.Position.MIDDLE);
                notification.open();
                return;
            }
        });

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
        layoutColumn2.add(hr);
        layoutColumn2.add(h32);
        layoutColumn2.add(layoutRow);
        layoutRow.add(layoutRow2);
        layoutRow2.add(formLayout3Col2);
        formLayout3Col2.add(textField3);
        formLayout3Col2.add(textField4);
        formLayout3Col2.add(comboBox3);
        layoutColumn2.add(layoutRow3);
        layoutRow3.add(buttonPrimary2);
        setComboBoxAutorData(comboBox);
        setComboBoxEditoraData(comboBox2);
        setComboBoxData(comboBox3);

        content.add(layoutColumn2);
    }
    private void showPesquisa(VerticalLayout content){
        content.removeAll();

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
        textField5.setPlaceholder("Insira ID");
        textField5.setPrefixComponent(new Icon("lumo", "search"));
        textField5.setWidth("min-content");
        buttonSecondary.setText("Pesquisar Livro");

        buttonSecondary.addClickListener(event -> {
            if (textField5.isEmpty()) {
                List<Livro> livro = controller2.pesquisarTodos();
                addGridToConsultaTab(livro);
            } else {
                try {
                    int id = (int) Math.round(Double.parseDouble(textField5.getValue()));
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
                } catch (NumberFormatException e) {
                    Notification notification = new Notification(
                            "ID inválido. Por favor, insira um ID válido.", 3000);
                    notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                    notification.setPosition(Notification.Position.MIDDLE);
                    notification.open();
                }
            }
        });        

        buttonSecondary.setWidth("min-content");
        h32.setText("Edição");
        h32.setWidth("max-content");
        layoutRow5.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutRow5);
        layoutRow5.addClassName(Gap.MEDIUM);
        layoutRow5.setWidth("100%");
        layoutRow5.getStyle().set("flex-grow", "1");
        layoutRow5.setAlignItems(Alignment.END);
        layoutRow5.setJustifyContentMode(JustifyContentMode.END);
        textField6.setPlaceholder("Insira ID");
        textField6.setPrefixComponent(new Icon("lumo", "search"));
        textField6.setWidth("min-content");
        buttonSecondary2.setText("Pesquisar Edição");
        buttonSecondary2.setWidth("min-content");

        buttonSecondary2.addClickListener(event -> {
            if (textField6.isEmpty()) {
                List<Edicao> edicao = controller.pesquisarTodos();
                addGridToConsultaTab2(edicao);
            } else {
                try {
                    int id = (int) Math.round(Double.parseDouble(textField6.getValue()));
                    Edicao edicao = controller.pesquisar(id);
                    if (edicao != null) {
                        List<Edicao> edicaoEncontrados = new ArrayList<>();
                        edicaoEncontrados.add(edicao);
                        addGridToConsultaTab2(edicaoEncontrados);
                    } else {
                        Notification notification = new Notification(
                                "Edicao com o ID fornecido não encontrado.", 3000);
                        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                        notification.setPosition(Notification.Position.MIDDLE);
                        notification.open();
                    }
                } catch (NumberFormatException e) {
                    Notification notification = new Notification(
                            "ID inválido. Por favor, insira um ID válido.", 3000);
                    notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                    notification.setPosition(Notification.Position.MIDDLE);
                    notification.open();
                }
            }
        });        

        layoutColumn3.add(h3);
        layoutColumn3.add(layoutRow4);
        layoutRow4.add(textField5);
        layoutRow4.add(buttonSecondary);
        layoutColumn3.add(h32);
        layoutColumn3.add(layoutRow5);
        layoutRow5.add(textField6);
        layoutRow5.add(buttonSecondary2);
        
        content.add(layoutColumn3);
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
            grid.addColumn(Livro::getDescricao).setHeader("Descricao");
            grid.addColumn(Livro::getAno_publicacao).setHeader("Ano de Publicação");
            grid.addColumn(livro -> livro.getAutor().getNome_autor()).setHeader("Autor");
            grid.addColumn(livro -> livro.getEditora().getNome_editora()).setHeader("Editora");
             
            
            grid.addComponentColumn(livro -> {

                MenuBar menuBar = new MenuBar();
                
                MenuItem editarItem = menuBar.addItem(new Icon(VaadinIcon.EDIT), e -> abrirPopupEdicao(livro));
                MenuItem excluirItem = menuBar.addItem(new Icon(VaadinIcon.TRASH), e -> abrirPopupExclusao(livro));
                
                editarItem.getElement().setAttribute("title", "Editar livro");
                excluirItem.getElement().setAttribute("title", "Excluir livro");
                
                return menuBar;
            }).setHeader("Opções"); 
            
            grid.setItems(livros);
            layoutColumn3.add(grid);
        } else {
            
            grid.setItems(livros);
        }
    }    

    private void abrirPopupEdicao(Livro livro) {
        Dialog dialog = new Dialog();
        FormLayout formLayout = new FormLayout();
        TextField nomeField = new TextField("Nome");
        nomeField.setValue(livro.getNome_livro());
        TextField anoField = new TextField("Ano de Publicação");
        anoField.setValue(String.valueOf(livro.getAno_publicacao()));
        TextArea descricaoField = new TextArea("Descrição");
        descricaoField.setValue(livro.getDescricao());
        ComboBox<Autor> autorComboBox = new ComboBox<>("Autor");
        autorComboBox.setItemLabelGenerator(Autor::getNome_autor); 
        autorComboBox.setItems(controller4.pesquisarTodos());
        autorComboBox.setValue(livro.getAutor());
        ComboBox<Editora> editoraComboBox = new ComboBox<>("Editora");
        editoraComboBox.setItemLabelGenerator(Editora::getNome_editora);
        editoraComboBox.setItems(controller3.pesquisarTodos());
        editoraComboBox.setValue(livro.getEditora());   

        Button confirmarButton = new Button("Confirmar", event -> {
            livro.setNome_livro(nomeField.getValue());
            livro.setAno_publicacao(Integer.parseInt(anoField.getValue()));
            livro.setDescricao(descricaoField.getValue());
            livro.setAutor(autorComboBox.getValue());
            livro.setEditora(editoraComboBox.getValue());
            if (controller2.alterar(livro)) {
                Notification.show("Livro alterado com sucesso.").addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                addGridToConsultaTab(controller2.pesquisarTodos());
            } else {
                Notification.show("Erro ao alterar. Verifique se todos os dados foram preenchidos.")
                        .addThemeVariants(NotificationVariant.LUMO_ERROR);
            }
            dialog.close();
        });
        Button cancelarButton = new Button("Cancelar", event -> dialog.close());

        formLayout.add(nomeField, anoField, descricaoField, autorComboBox, editoraComboBox, confirmarButton, cancelarButton);
        dialog.add(formLayout);
        dialog.add(formLayout);
        dialog.open();
    }

    private void adicionarIconeEdicao(Grid<Autor> grid, Livro livro) {
        Icon iconEditar = new Icon(VaadinIcon.EDIT);
        iconEditar.addClickListener(event -> abrirPopupEdicao(livro));

        grid.addComponentColumn(item -> {
            MenuBar menuBar = new MenuBar();
            MenuItem editarItem = menuBar.addItem("Editar", e -> abrirPopupEdicao(livro));
            editarItem.getElement().setAttribute("title", "Editar livro");
            return menuBar;
        }).setHeader("Opções");
    }

    private void abrirPopupExclusao(Livro livro) {
        Dialog dialog = new Dialog();
        FormLayout formLayout = new FormLayout();

        Span mensagem = new Span("Tem certeza que deseja excluir?");
        formLayout.add(mensagem);

        NumberField idField = new NumberField("ID");
        idField.setValue((double) livro.getId());
        idField.setReadOnly(true);
        formLayout.add(idField);

        int id = (int) Math.round(idField.getValue());
        final Livro livroParaExcluir = controller2.pesquisar(id);

        Button confirmarButton = new Button("Confirmar", event -> {
            if (controller2.excluir(livroParaExcluir)) {
                Notification.show("Livro excluido com sucesso.").addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                addGridToConsultaTab(controller2.pesquisarTodos());
            } else {
                Notification.show("Erro ao alterar. Verifique se todos os dados foram preenchidos.")
                        .addThemeVariants(NotificationVariant.LUMO_ERROR);
            }
            dialog.close();
        });
        Button cancelarButton = new Button("Cancelar", event -> dialog.close());

        formLayout.add(confirmarButton, cancelarButton);
        dialog.add(formLayout);
        dialog.open();
    }

    private void adicionarIconeExclusao(Grid<Livro> grid, Livro livro) {
        Icon iconEditar = new Icon(VaadinIcon.EDIT);
        iconEditar.addClickListener(event -> abrirPopupExclusao(livro));

        grid.addComponentColumn(item -> {
            MenuBar menuBar = new MenuBar();
            MenuItem editarItem = menuBar.addItem("Exclusao", e -> abrirPopupExclusao(livro));
            editarItem.getElement().setAttribute("title", "Excluir livro");
            return menuBar;
        }).setHeader("Opções");
    }

    private void addGridToConsultaTab2(List<Edicao> edicoes) {
        if (grid2 == null) {
            grid2 = new Grid<>();
            grid2.addColumn(Edicao::getId).setHeader("ID");
            grid2.addColumn(Edicao::getAno).setHeader("Ano");
            grid2.addColumn(Edicao::getNovo_conteudo).setHeader("Novo Conteudo");
            grid2.addColumn(edicao -> edicao.getLivro().getNome_livro()).setHeader("Livro");
                         
            grid2.addComponentColumn(edicao -> {

                MenuBar menuBar = new MenuBar();
                
                MenuItem editarItem = menuBar.addItem(new Icon(VaadinIcon.EDIT), e -> abrirPopupEdicao2(edicao));
                MenuItem excluirItem = menuBar.addItem(new Icon(VaadinIcon.TRASH), e -> abrirPopupExclusao2(edicao));
                
                editarItem.getElement().setAttribute("title", "Editar Edição");
                excluirItem.getElement().setAttribute("title", "Excluir Edição");
                
                return menuBar;
            }).setHeader("Opções"); 
            
            grid2.setItems(edicoes);
            layoutColumn3.add(grid2);
        } else {
            
            grid2.setItems(edicoes);
        }
    }   
    
    
    private void abrirPopupEdicao2(Edicao edicao) {
        Dialog dialog = new Dialog();
        FormLayout formLayout = new FormLayout();
        TextField anoField = new TextField("Ano");
        anoField.setValue(String.valueOf(edicao.getAno()));
        TextField nomeField = new TextField("Novo Conteudo");
        nomeField.setValue(edicao.getNovo_conteudo()); 
        ComboBox<Livro> livroComboBox = new ComboBox<>("Livro");
        livroComboBox.setItemLabelGenerator(Livro::getNome_livro); 
        livroComboBox.setItems(controller2.pesquisarTodos());
        livroComboBox.setValue(edicao.getLivro());


        Button confirmarButton = new Button("Confirmar", event -> {
            edicao.setAno(Integer.parseInt(anoField.getValue()));
            edicao.setNovo_conteudo(nomeField.getValue());
            edicao.setLivro(livroComboBox.getValue());
            if (controller.alterar(edicao)) {
                Notification.show("Edicao alterado com sucesso.").addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                addGridToConsultaTab2(controller.pesquisarTodos());
            } else {
                Notification.show("Erro ao alterar. Verifique se todos os dados foram preenchidos.")
                        .addThemeVariants(NotificationVariant.LUMO_ERROR);
            }
            dialog.close();
        });
        Button cancelarButton = new Button("Cancelar", event -> dialog.close());

        formLayout.add(anoField, nomeField, livroComboBox, confirmarButton, cancelarButton);
        dialog.add(formLayout);
        dialog.add(formLayout);
        dialog.open();
    }

    private void adicionarIconeEdicao2(Grid<Edicao> grid2, Edicao edicao) {
        Icon iconEditar = new Icon(VaadinIcon.EDIT);
        iconEditar.addClickListener(event -> abrirPopupEdicao2(edicao));

        grid.addComponentColumn(item -> {
            MenuBar menuBar = new MenuBar();
            MenuItem editarItem = menuBar.addItem("Editar", e -> abrirPopupEdicao2(edicao));
            editarItem.getElement().setAttribute("title", "Editar edicao");
            return menuBar;
        }).setHeader("Opções");
    }

    private void abrirPopupExclusao2(Edicao edicao) {
        Dialog dialog = new Dialog();
        FormLayout formLayout = new FormLayout();

        Span mensagem = new Span("Tem certeza que deseja excluir?");
        formLayout.add(mensagem);

        NumberField idField = new NumberField("ID");
        idField.setValue((double) edicao.getId());
        idField.setReadOnly(true);
        formLayout.add(idField);

        Button confirmarButton = new Button("Confirmar", event -> {
            if (controller.excluir(edicao)) {
                Notification.show("Edicao excluida com sucesso.").addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                addGridToConsultaTab2(controller.pesquisarTodos());
            } else {
                Notification.show("Erro ao alterar. Verifique se todos os dados foram preenchidos.")
                        .addThemeVariants(NotificationVariant.LUMO_ERROR);
            }
            dialog.close();
        });
        Button cancelarButton = new Button("Cancelar", event -> dialog.close());

        formLayout.add(confirmarButton, cancelarButton);
        dialog.add(formLayout);
        dialog.open();
    }

    private void adicionarIconeExclusao2(Grid<Edicao> grid2, Edicao edicao) {
        Icon iconEditar = new Icon(VaadinIcon.EDIT);
        iconEditar.addClickListener(event -> abrirPopupExclusao2(edicao));

        grid.addComponentColumn(item -> {
            MenuBar menuBar = new MenuBar();
            MenuItem editarItem = menuBar.addItem("Exclusao", e -> abrirPopupExclusao2(edicao));
            editarItem.getElement().setAttribute("title", "Excluir edicao");
            return menuBar;
        }).setHeader("Opções");
    }
}
