package client;

import org.jline.reader.Completer;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.reader.impl.history.DefaultHistory;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import java.io.IOException;

public class ConsoleReader {
    DefaultHistory history = new DefaultHistory();
    Completer completer = new StringsCompleter("help", "info", "show", "add", "update", "remove_by_id","clear", "save",
            "execute_script", "exit", "remove_first", "reorder", "history","remove_all_by_government",
            "group_counting_by_id", "filter_starts_with_name");
    private LineReader reader;
    private Terminal terminal;

    public ConsoleReader() {
        try {
            terminal = TerminalBuilder.terminal();
            reader = LineReaderBuilder.builder().terminal(terminal).history(history).completer(completer).build();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    terminal.close();
                } catch (Exception e) {}
            }));
        } catch (IOException e) {
            throw new RuntimeException("Не удалось инициализировать терминал", e);
        }
    }

    public String readLine(String prompt) {
        try {
            String line = reader.readLine(prompt);
            if (line == null) {
                return "";
            }
            return line;
        } catch (org.jline.reader.UserInterruptException e) {
            throw e;
        } catch (Exception e) {
            return "";
        }
    }
}