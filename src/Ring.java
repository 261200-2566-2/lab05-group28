public class Ring extends Accessories{
    Ring(int level, String name) {
        super(level, name);
    }

    void increaseMana(Characters c){
        c.assign_Element("Mana",c.getElement("Mana")+50+(0.5*this.getLV()));
        if(c.getElement("Mana") >= 1000) c.assign_Element("Mana",1000);
    }

}
