package duke.commands;

import duke.storage.Storage;
import duke.tasks.TaskList;
import duke.ui.Ui;

/**
 * Terminates the program.
 */
public class ExitCommand extends Command {

    public ExitCommand() {
        super(true);
    }

    /**
     * Terminates the program and prints a farewell message to the user.
     *
     * @param taskList user's task list
     * @param ui text UI object
     * @param storage storage object
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        return ui.showExit();
    }
}
