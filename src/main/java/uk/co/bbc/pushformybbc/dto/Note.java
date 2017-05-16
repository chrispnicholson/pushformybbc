package uk.co.bbc.pushformybbc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by Chris on 16-May-17.
 */
@JsonPropertyOrder({"username", "note"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Note {
    private String username;
    private String note;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNote() {

        return note;
    }

    public void setNote(String note) {

        this.note = note;
    }
}
