public class Mage extends Characters{
    Mage(int level, double speed, String name,String CL) {
        super(level, speed, name, CL);
    }

    void heal(Characters c){
        if(c.getElement("HP") <= 500){
//            c.HP += this.Mana/2.0;
            c.assign_Element("HP",c.getElement("HP")+this.getElement("Mana")/2.0);
            if(c.getElement("HP") >= 1000) c.assign_Element("HP",1000);
            System.out.println(this.getName_CL("name") + " heal " + c.getName_CL("name") + " "
                    + this.getElement("Mana")/2.0);
        }else{
            System.out.println("Your HP is max.");
        }
    }

    void levelup_Character(Characters c){
        if(c.getLv() < 100){
           c.assign_Element("level", c.getLv()+1);
           if(c.getLv() >= 100) c.assign_Element("level",100);
           c.update();
           System.out.println(this.getName_CL("name") + " level up " + c.getName_CL("name"));
        }else{
            System.out.println("Your level is max.");
        }
    }

    void buff_atk(Characters c){
        if(c.getElement("atk") < 1000){
//            c.atk += 0.4*this.Mana;
            c.assign_Element("atk",c.getElement("atk")+0.4*this.getElement("Mana"));
            if(c.getElement("atk") >= 1000){
                c.assign_Element("atk",1000);
            }
            System.out.println(this.getName_CL("name") + " buff atk " + c.getName_CL("name") + " " +
                    0.4*this.getElement("Mana"));
        }else{
            System.out.println("Your atk is max at 1000.");
        }
    }

}
