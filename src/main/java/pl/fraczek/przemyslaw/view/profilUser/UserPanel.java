package pl.fraczek.przemyslaw.view.profilUser;

import pl.fraczek.przemyslaw.controller.UserController;
import pl.fraczek.przemyslaw.model.User;
import pl.fraczek.przemyslaw.view.Reader;

public class UserPanel {

    private Reader reader;
    private UserController controller;

    public UserPanel(Reader reader, UserController controller) {
        this.reader = reader;
        this.controller = controller;

    }

    public void userPanel(User user) {
        int answer;
        do {
            reader.display("Hello " + user.getName());
            reader.display(user.getName() + " What you want to do");
            reader.display("Change email - 1");
            reader.display("Change number - 2");
            reader.display("Logout number - 3");
            answer = reader.readInt();

            if (answer == 1) {
                reader.display("What is to be new");
                String newEmail = reader.readInformation();
                reader.display(controller.changeEmail(user, newEmail).getMassage());
            }
            if (answer == 2) {
                reader.display("What is to be new");
                String newNumber = reader.readInformation();
                reader.display(controller.changeNumber(user, newNumber).getMassage());
            }
            if (answer != 1 && answer != 2 && answer != 3) {
                reader.display(answer + "This option is not available");
            }
        } while (answer != 3);

    }
}
