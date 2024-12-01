package src;

import src.model.Notebook;
import src.presenter.NotebookPresenter;
import src.view.ConsoleNotebookView;

public class App {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        NotebookView view = new ConsoleNotebookView();
        NotebookPresenter presenter = new NotebookPresenter(notebook, view);
        presenter.run();
    }
}