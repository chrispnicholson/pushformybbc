package uk.co.bbc.pushformybbc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by Chris on 16-May-17.
 */

@JsonPropertyOrder({"active", "body", "created", "direction", "dismissed",
"iden", "modified", "receiver_email", "receiver_email_normalized",
"receiver_iden", "sender_email", "sender_email_normalized", "sender_iden",
"sender_name", "title", "type", "url"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PushBulletResponse {
    private boolean active;
    private String body;
    private double created;
    private String direction;
    private boolean dismissed;
    private String iden;
    private double modified;
    private String receiverEmail;
    private String receiverEmailNormalized;
    private String receiverIden;
    private String senderEmail;
    private String senderEmailNormalized;
    private String senderIden;
    private String senderName;
    private String title;
    private String type;
    private String url;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public double getCreated() {
        return created;
    }

    public void setCreated(double created) {
        this.created = created;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isDismissed() {
        return dismissed;
    }

    public void setDismissed(boolean dismissed) {
        this.dismissed = dismissed;
    }

    public String getIden() {
        return iden;
    }

    public void setIden(String iden) {
        this.iden = iden;
    }

    public double getModified() {
        return modified;
    }

    public void setModified(double modified) {
        this.modified = modified;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getReceiverEmailNormalized() {
        return receiverEmailNormalized;
    }

    public void setReceiverEmailNormalized(String receiverEmailNormalized) {
        this.receiverEmailNormalized = receiverEmailNormalized;
    }

    public String getReceiverIden() {
        return receiverIden;
    }

    public void setReceiverIden(String receiverIden) {
        this.receiverIden = receiverIden;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getSenderEmailNormalized() {
        return senderEmailNormalized;
    }

    public void setSenderEmailNormalized(String senderEmailNormalized) {
        this.senderEmailNormalized = senderEmailNormalized;
    }

    public String getSenderIden() {
        return senderIden;
    }

    public void setSenderIden(String senderIden) {
        this.senderIden = senderIden;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
