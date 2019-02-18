package models;

import java.sql.Timestamp;

public class ToDo {
    private int id;
    private String description;
    private Timestamp created;
    private boolean done;
    public ToDo(String id, String description, String created, String done) {
        if (id != null && !id.equals("")) {
            this.id = Integer.parseInt(id);
        } else {
            this.id = 0;
        }

        this.description = description;

        if (created != null && !created.equals("")) {
            long timeMillis = Integer.parseInt(created);
        } else {
            this.created = new Timestamp(System.currentTimeMillis());
        }

        if (done != null && done.equals("true")) {
            this.done = true;
        } else {
            this.done = false;
        }
    }

    public ToDo() {
        super();
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getCreated() {
        return created;
    }

    public boolean isDone() {
        return done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
