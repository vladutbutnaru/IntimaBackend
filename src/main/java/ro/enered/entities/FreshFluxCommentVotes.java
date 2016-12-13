package ro.enered.entities;

/**
 * Created by macbook on 29/11/2016.
 */
public class FreshFluxCommentVotes {
    private int id;
    private Escort escort;
    private FreshFluxComment freshFluxComment;
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

    public FreshFluxComment getFreshFluxComment() {
        return freshFluxComment;
    }

    public void setFreshFluxComment(FreshFluxComment freshFluxComment) {
        this.freshFluxComment = freshFluxComment;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
