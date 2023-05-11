package practice8.visitor;

public class Visitor {

    public static void main(String[] args) {
        FireWizard fireWizard = new FireWizard();
        WaterWizard waterWizard = new WaterWizard();

        WizardAction action = new WizardAction();

        fireWizard.accept(action);
        waterWizard.accept(action);
    }
}
