package ro.enered.entities;

/**
 * Created by macbook on 29/11/2016.
 */
public class EscortFlagMapping {
    private int id;
    private EscortFlag flag;
    private Escort escort;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EscortFlag getFlag() {
        return flag;
    }

    public void setFlag(EscortFlag flag) {
        this.flag = flag;
    }

    public Escort getEscort() {
        return escort;
    }

    public void setEscort(Escort escort) {
        this.escort = escort;
    }
}
