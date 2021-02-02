package duke.commands;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.tasks.Task;
import duke.tasks.TaskList;
import duke.ui.Ui;

/**
 * Mark a task as done from the list based on given index, or mark everything as done from the list.
 */
public class DoneCommand extends Command {

    private final String input;

    public DoneCommand(String input) {
        this.input = input;
    }

    /**
     * Performs completion of tasks, prints a message to the user and update the storage file.
     *
     * @param taskList user's task list
     * @param ui text UI object
     * @param storage storage object
     * @throws DukeException if there were errors encountered when saving the file
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        int listSize = taskList.size();
        if (listSize <= 0) {
            throw new DukeException("Your task list is empty.");
        }

        String returnMessage;
        if (input.equals("all")) {
            if (taskList.isAllDone()) {
                throw new DukeException("You have already completed all the tasks!");
            }
            taskList.setAllDone();
            returnMessage = ui.showDoneMessage(taskList);
        } else {
            int index = Integer.parseInt(input) - 1;
            if (index < 0 || index >= listSize) {
                throw new DukeException("The index you entered is out of bound.");
            }

            Task task = taskList.get(index);
            if (task.getDone()) {
                throw new DukeException("You have already completed this task!");
            }

            task.setDone();
            returnMessage = ui.showDoneMessage(task);
        }

        storage.saveFile(taskList);
        return returnMessage;
    }
}
