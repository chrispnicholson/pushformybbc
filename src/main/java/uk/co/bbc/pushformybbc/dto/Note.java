package uk.co.bbc.pushformybbc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by Chris on 16-May-17.
 */
@JsonPropertyOrder({"note"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Note {
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
