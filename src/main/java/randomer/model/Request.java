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
    private String username;

    public Request() {
    }

    public Request(@NotNull int start, @NotNull int end, @NotNull String username) {
        this.start = start;
        this.end = end;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
