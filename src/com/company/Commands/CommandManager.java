package com.company.Commands;

import java.util.ArrayList;

public class CommandManager {
    ArrayList<Command> history = new ArrayList<>();

    private int cursor = 0;

    public void executeCommand(Command command) throws Exception {
        command.execute();

        if (cursor < history.size()) {
            history.set(cursor, command);
        } else {
            history.add(command);
        }

        cursor++;
    }

    public void undo() throws Exception {
        if (cursor == 0) return;

        Command command = history.get(cursor - 1);
        command.undo();

        cursor--;
    }

    public void redo() throws Exception {
        if (cursor > history.size() - 1) return;

        Command command = history.get(cursor);
        command.execute();
        cursor++;
    }
}
