import java.text.DecimalFormat;

public class Characters implements Character{
    private int level = 1;
    private double HP, speed, deff, atk, Mana;
    private boolean dead = false, equipR = false, equipB = false;
    private String name = null, CL = null;
    Characters (int level, double speed, String name, String CL){
        this.level = Math.min(level, 5);
        this.speed = speed;
        this.name = name;
        this.CL = CL;
        if(CL.equalsIgnoreCase("TANK")){
            deff = 150+10*level;
            HP = 200 + 20*level;
            Mana = 100 + 10*level;
            atk = (0.5*deff)+10*level;
        }
        if(CL.equalsIgnoreCase("MAGE")){
            deff = 50 + 10*level;
            HP = 100 + 20*level;
            Mana = 200+10*level;
            atk = (0.5*Mana)+10*level;
        }
    }

    @Override
    public void attack(Characters c) {
        if(!c.dead){
            if(c.deff >= this.atk){
                System.out.println("Can't attack.Your atk is too low.");
            }else{
                c.HP -= this.atk - c.deff;
                if(c.HP <= 0){
                    c.dead = true;
                    c.HP = 0;
                }
                System.out.println(this.name + " attack " + c.name);
            }
        }else{
            System.out.println("Your target is dead.");
        }
    }


    @Override
    public void equip_Ring(Ring r) {
        r.increaseMana(this);
        r.decrease_speed(this);
        r.powerup_HP(this);
        equipR = true;
        System.out.println(this.name + " equip " + r.getName());
    }

    @Override
    public void equip_Boot(Boot b) {
        b.speedInc(this);
        b.powerup_HP(this);
        equipB = true;
        System.out.println(this.name + " equip " + b.getName());
    }

    @Override
    public void showstatus() {
        System.out.println("------------------------------------------------------");
        if(!this.dead){
            String speed = new DecimalFormat("##.##").format(this.speed);
            System.out.println("NAME: "+this.name+"\nLevel: " + this.level
                    + "\nHP: " + this.HP + "\nmana: " + this.Mana + "\nAtk: " + this.atk
                    + "\nSpeed: " + speed +"\nDeff: " + this.deff + "\nClass: " + this.CL);
            if(equipR) System.out.println(this.name + " equip RING.");
            else if(equipB) System.out.println(this.name + " equip BOOT.");
        }else{
            System.out.println(this.name + " is dead.");
        }

        System.out.println("------------------------------------------------------");
    }

    @Override
    public void update() {
        HP += 10*(level*0.5);
        deff += 20*(level*0.25);
        atk += 50*(level*0.25);
        Mana += 25*(level*0.5);
        speed += 10*(level*0.8);
        if(HP > 500) HP = 500;
        if(atk >= 1000) atk = 1000;
        if(deff >= 1000) deff = 1000;
        if(Mana >= 1000) Mana = 1000;
    }

    @Override
    public double getElement(String s) {
        if(s.equalsIgnoreCase("HP")){
            return this.HP;
        }else if(s.equalsIgnoreCase("deff")){
            return this.deff;
        }else if(s.equalsIgnoreCase("ATK")){
            return this.atk;
        }else if(s.equalsIgnoreCase("MANA")){
            return this.Mana;
        }else if(s.equalsIgnoreCase("speed")){
            return this.speed;
        }else{
            return 0;
        }
    }

    @Override
    public String getName_CL(String s) {
        if(s.equalsIgnoreCase("name")){
            return this.name;
        }else if(s.equalsIgnoreCase("CL")){
            return this.CL;
        }else{
            return null;
        }
    }

    @Override
    public int getLv() {
        return this.level;
    }

    @Override
    public void assign_Element(String s, double n) {
        if(s.equalsIgnoreCase("HP")){
            this.HP = n;
        }else if(s.equalsIgnoreCase("deff")){
            this.deff = n;
        }else if(s.equalsIgnoreCase("ATK")){
            this.atk = n;
        }else if(s.equalsIgnoreCase("MANA")){
            this.Mana = n;
        }else if(s.equalsIgnoreCase("speed")){
            this.speed = n;
        }else if(s.equalsIgnoreCase(("level"))){
            this.level = (int)n;
        }
    }


}
