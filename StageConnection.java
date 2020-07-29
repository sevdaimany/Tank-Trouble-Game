import javafx.stage.Stage;

public class StageConnection {
    private static Stage stage;

    public StageConnection(Stage stage) {
        this.stage = stage;
    }

    public static Stage getStage() {
        return stage;
    }
}
