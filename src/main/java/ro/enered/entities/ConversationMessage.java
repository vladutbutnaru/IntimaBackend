package ro.enered.entities;

import java.sql.Timestamp;

/**
 * Created by macbook on 29/11/2016.
 */
public class ConversationMessage {
    private int id;
    private String message;
    private boolean readBySender;
    private boolean readByReceiver;
    private boolean removedBySender;
    private boolean removedByReceiver;
    private boolean deletedBySender;
    private boolean deletedByReceiver;
    private Timestamp createdAt;
    private Escort escort;
    private Member member;
    private Conversation conversation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isReadBySender() {
        return readBySender;
    }

    public void setReadBySender(boolean readBySender) {
        this.readBySender = readBySender;
    }

    public boolean isReadByReceiver() {
        return readByReceiver;
    }

    public void setReadByReceiver(boolean readByReceiver) {
        this.readByReceiver = readByReceiver;
    }

    public boolean isRemovedBySender() {
        return removedBySender;
    }

    public void setRemovedBySender(boolean removedBySender) {
        this.removedBySender = removedBySender;
    }

    public boolean isRemovedByReceiver() {
        return removedByReceiver;
    }

    public void setRemovedByReceiver(boolean removedByReceiver) {
        this.removedByReceiver = removedByReceiver;
    }

    public boolean isDeletedBySender() {
        return deletedBySender;
    }

    public void setDeletedBySender(boolean deletedBySender) {
        this.deletedBySender = deletedBySender;
    }

    public boolean isDeletedByReceiver() {
        return deletedByReceiver;
    }

    public void setDeletedByReceiver(boolean deletedByReceiver) {
        this.deletedByReceiver = deletedByReceiver;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Escort getEscort() {
        return escort;
    }

    public void setEscort(Escort escort) {
        this.escort = escort;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
