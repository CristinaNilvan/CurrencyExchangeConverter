public class CECMain {
    public static void main(String[] args) {
        CECModel model = new CECModel();
        CECView view = new CECView(model);
        CECController controller = new CECController(model, view);
    }
}