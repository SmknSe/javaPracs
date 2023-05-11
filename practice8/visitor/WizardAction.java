package practice8.visitor;

public class WizardAction implements WizardSpell{
    @Override
    public void spell(FireWizard wizard) {
        wizard.spellCraft();
    }

    @Override
    public void spell(WaterWizard wizard) {
        wizard.spellCraft();
    }
}
