package pl.fraczek.przemyslaw;

import pl.fraczek.przemyslaw.model.InMemoryRepository;
import pl.fraczek.przemyslaw.model.UserRepository;
import pl.fraczek.przemyslaw.view.Reader;
import pl.fraczek.przemyslaw.view.StartPanel;

public class StartApplication {
    public static void main(String[] args) {
        UserRepository repository = new InMemoryRepository();
        Reader reader =  new Reader();
        StartPanel startPanel =  new StartPanel(reader,repository);
        startPanel.start();
    }
}
