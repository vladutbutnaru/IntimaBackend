package ro.enered.entities;

/**
 * Created by macbook on 29/11/2016.
 */
public class EscortPhotoVote {
    private int id;
    private EscortPhoto photo;
    private Member member;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EscortPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(EscortPhoto photo) {
        this.photo = photo;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
