package mementosample;

import java.util.Scanner;

public class EditorApp {

    private final Editor editor;
    private final EditorHistory history;
    private final Scanner scanner;

    public EditorApp() {
        this.editor = new Editor();
        this.history = new EditorHistory();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;

        while (running) {
            showMenu();
            int option = getUserOption();

            switch (option) {
                case 1 ->
                    writeText();
                case 2 ->
                    undo();
                case 3 ->
                    redo();
                case 4 ->
                    running = false;
                default ->
                    System.out.println("Opción inválida.");
            }
        }
        scanner.close();
    }

    private void showMenu() {
        System.out.println("\n--- Editor de texto ---");
        editor.print();
        System.out.println("1. Escribir texto");
        System.out.println("2. Deshacer");
        System.out.println("3. Rehacer");
        System.out.println("4. Salir");
        System.out.print("Elige una opción: ");
    }

    private int getUserOption() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void writeText() {
        System.out.print("Escriba su texto: ");
        String input = scanner.nextLine();
        history.saveState(editor.save());
        editor.write(input);
    }

    private void undo() {
        editor.restore(history.undo(editor.save()));
    }

    private void redo() {
        editor.restore(history.redo(editor.save()));
    }
}
