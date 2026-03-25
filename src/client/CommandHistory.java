package client;

import java.util.ArrayDeque;
import java.util.Deque;


public class CommandHistory {
    private static final int MAX_SIZE = 7;
    private final Deque<String> history = new ArrayDeque<>();


    public void addCommand(String command) {
        if (command == null || command.isEmpty()) {
            return;
        }
        if (history.size() == MAX_SIZE) {
            history.pollFirst();
        }
        history.addLast(command);
    }


    public void printHistory() {
        if (history.isEmpty()) {
            System.out.println("История команд пуста.");
            return;
        }
        System.out.println("Последние команды:");
        int index = 1;
        for (String cmd : history) {
            System.out.println(index++ + ". " + cmd);
        }
    }
}