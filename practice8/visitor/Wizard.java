package practice8.visitor;

public interface Wizard {
    public void accept(WizardSpell spell);
    public void spellCraft();
}

