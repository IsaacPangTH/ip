package storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import task.Deadline;
import task.Event;
import task.Task;
import task.TaskList;
import task.ToDo;

public class Storage {
    private static final String FILE_PATH = "./data/tasks.txt";
    private static final String DIRECTORY_PATH = "./data";

    public void initStorage() {
        try {
            File path = new File(DIRECTORY_PATH);
            path.mkdir();
            File file = new File(FILE_PATH);
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error initializing storage");
            System.exit(0);
        }
    }

    public void saveTaskList(TaskList list) throws IOException {
        FileWriter fw = new FileWriter(FILE_PATH);
        fw.write(list.toData());
        fw.close();
    }

    public TaskList laodTaskList() throws FileNotFoundException {
        File file = new File(FILE_PATH);
        TaskList list = new TaskList();
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            list.add(Task.of(data));
        }
        return list;
    }

}
