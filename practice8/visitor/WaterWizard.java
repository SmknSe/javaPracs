package practice8.visitor;

public class WaterWizard implements Wizard{
    @Override
    public void accept(WizardSpell spell) {
        spell.spell(this);
    }

    @Override
    public void spellCraft() {
        System.out.println("make water");
    }
}
