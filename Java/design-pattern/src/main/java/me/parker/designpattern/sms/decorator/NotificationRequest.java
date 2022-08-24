package me.parker.designpattern.sms.decorator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class NotificationRequest {
    private String memberStatus;
    private String cellphoneNumber;
    private String smsContents;
}
