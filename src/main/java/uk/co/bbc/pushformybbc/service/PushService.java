package uk.co.bbc.pushformybbc.service;

import uk.co.bbc.pushformybbc.dto.PushBulletNotification;

/**
 * Created by Chris on 16-May-17.
 */
public interface PushService {

    public void push(PushBulletNotification pushBulletNotification);
}
