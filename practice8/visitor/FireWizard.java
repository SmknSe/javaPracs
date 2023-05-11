package practice8.visitor;

public class FireWizard implements Wizard{
    @Override
    public void accept(WizardSpell spell) {
        spell.spell(this);
    }

    @Override
    public void spellCraft() {
        System.out.println("make fire");
    }
}
