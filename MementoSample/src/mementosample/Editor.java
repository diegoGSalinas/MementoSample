package mementosample;

public class Editor {

    private String text = "";

    public void write(String newText) {
        text += newText;
    }

    public void setText(String newText) {
        this.text = newText;
    }
    public String getText() {
        return text;
    }

    public Memento save() {
        return new Memento(text);
    }

    public void restore(Memento memento) {
        this.text = memento.getText();
    }

    public void print() {
        System.out.println("Texto actual: " + text);
    }
}
