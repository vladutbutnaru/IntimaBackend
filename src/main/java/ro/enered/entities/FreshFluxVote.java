package ro.enered.entities;

/**
 * Created by macbook on 29/11/2016.
 */
public class FreshFluxVote {
    private int id;
    private Escort escort;
    private FreshFlux freshFlux;
    private Member member;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Escort getEscort() {
        return escort;
    }

    public void setEscort(Escort escort) {
        this.escort = escort;
    }

    public FreshFlux getFreshFlux() {
        return freshFlux;
    }

    public void setFreshFlux(FreshFlux freshFlux) {
        this.freshFlux = freshFlux;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
