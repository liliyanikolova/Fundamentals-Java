package bg.softuni;

import bg.softuni.io.CommandInterpreter;
import bg.softuni.io.IOManager;
import bg.softuni.io.InputReader;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.RepositoryFilter;
import bg.softuni.repository.RepositorySorter;
import bg.softuni.repository.StudentRepository;

public class Main {

    public static void main(String[] args) {
        Tester tester = new Tester();
        DownloadManager downloadManager = new DownloadManager();
        IOManager ioManager = new IOManager();
        RepositorySorter soretr = new RepositorySorter();
        RepositoryFilter filter = new RepositoryFilter();
        StudentRepository repository = new StudentRepository(filter, soretr);
        CommandInterpreter currentInterpreter = new CommandInterpreter(tester, repository, downloadManager, ioManager);
        InputReader reader = new InputReader(currentInterpreter);

        try {
            reader.readCommands();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
