package randomer.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Request {

    @Id
    @NotNull
    private int id;

    @NotNull
    private int start;

    @NotNull
    private int end;

    @NotNull
    private int user;

    public Request() {
    }

    public Request(@NotNull int start, @NotNull int end, @NotNull int user) {
        this.start = start;
        this.end = end;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
}
