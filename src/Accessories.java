public class Accessories implements Accessory{
    private int level = 1;
    private String name = null;
    Accessories(int level, String name){
        this.level = Math.min(level, 5);
        this.name = name;
    }
    @Override
    public void decrease_speed(Characters c) {
        if(c.getElement("speed") > 125){
            c.assign_Element("speed",c.getElement("speed")-5*(0.5*this.getLV()));
        }
    }
    @Override
    public void powerup_HP(Characters c) {
        if(c.getElement("HP") < 500){
            c.assign_Element("HP", c.getElement("HP")+(this.level*0.8));
        }
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public int getLV() {
        return this.level;
    }

}
