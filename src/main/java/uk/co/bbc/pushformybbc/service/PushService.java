package uk.co.bbc.pushformybbc.service;

import uk.co.bbc.pushformybbc.dto.PushBulletNotification;
import uk.co.bbc.pushformybbc.dto.PushBulletResponse;
import uk.co.bbc.pushformybbc.dto.User;

/**
 * Created by Chris on 16-May-17.
 */
public interface PushService {

    public PushBulletResponse push(PushBulletNotification pushBulletNotification, User user);
}
