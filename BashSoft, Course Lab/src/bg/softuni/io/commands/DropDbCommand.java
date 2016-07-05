package bg.softuni.io.commands;

import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.IOManager;
import bg.softuni.io.OutputWriter;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentRepository;

public class DropDbCommand extends Command{
    public DropDbCommand(String input,
                         String[] data,
                         StudentRepository repository,
                         Tester tester,
                         IOManager ioManager,
                         DownloadManager downloadManager) {
        super(input, data, repository, tester, ioManager, downloadManager);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 1){
            throw new InvalidInputException(this.getInput());
        }

        this.getRepository().unloadData();
        OutputWriter.writeMessageOnNewLine("Data dropped!");
    }
}
