public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        ControllerInterface controller = new Controller(new View("main", null), model);
        View view = new View("main", controller);
        model.addNotification(view);

        view.createView();
        controller.update("First notification");
        controller.update("Second notification");
    }
}