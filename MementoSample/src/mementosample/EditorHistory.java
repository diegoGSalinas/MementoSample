package mementosample;

import java.util.Stack;

public class EditorHistory {

    private final Stack<Memento> undoStack = new Stack<>();
    private final Stack<Memento> redoStack = new Stack<>();

    public void saveState(Memento memento) {
        undoStack.push(memento);
        redoStack.clear();
    }

    public Memento undo(Memento currentState) {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentState);
            return undoStack.pop();
        }
        return currentState;
    }

    public Memento redo(Memento currentState) {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentState);
            return redoStack.pop();
        }
        return currentState;
    }
}
