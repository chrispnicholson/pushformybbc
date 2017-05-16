package uk.co.bbc.pushformybbc.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import uk.co.bbc.pushformybbc.dto.PushBulletNotification;
import uk.co.bbc.pushformybbc.dto.PushBulletResponse;
import uk.co.bbc.pushformybbc.dto.User;

/**
 * Created by Chris on 16-May-17.
 */
@Service
public class PushServiceImpl implements PushService {
    @Override
    public PushBulletResponse push(PushBulletNotification pushBulletNotification, User user) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Access-Token", user.getAccessToken());
        headers.add("Content-Type", "application/json");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpEntity<PushBulletNotification> request = new HttpEntity<PushBulletNotification>(pushBulletNotification, headers);
        PushBulletResponse response = restTemplate.postForObject("https://api.pushbullet.com/v2/pushes", request, PushBulletResponse.class);
        user.setNumOfNotificationsPushed(user.getNumOfNotificationsPushed() + 1);

        return response;
    }
}
