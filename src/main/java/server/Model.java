package server;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by chiennv on 12/07/2017.
 */
public class Model implements Serializable{
    
    private UUID id;
    private long money;
    private String name;
    private int idCustom;
    private String toDo;
    private String comment;
    private String friend;
    private String status;
    private String like;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money += money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name += name;
    }

    public int getIdCustom() {
        return idCustom;
    }

    public void setIdCustom(int idCustom) {
        this.idCustom += idCustom;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo += toDo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment += comment;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend += friend;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status += status;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like += like;
    }
}
