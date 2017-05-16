package uk.co.bbc.pushformybbc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by Chris on 16-May-17.
 */
@JsonPropertyOrder({"type", "title", "body", "url"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PushBulletNotification {
    private String type;
    private String title;
    private String body;
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
