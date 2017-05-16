package uk.co.bbc.pushformybbc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;

/**
 * Created by Chris on 09-May-17.
 */
@JsonPropertyOrder({"username", "accessToken", "creationTime", "numOfNotificationsPushed"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private String username;
    private String accessToken;
    private Date creationTime;
    private Long numOfNotificationsPushed;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Long getNumOfNotificationsPushed() {
        return numOfNotificationsPushed;
    }

    public void setNumOfNotificationsPushed(Long numOfNotificationsPushed) {
        this.numOfNotificationsPushed = numOfNotificationsPushed;
    }
}
