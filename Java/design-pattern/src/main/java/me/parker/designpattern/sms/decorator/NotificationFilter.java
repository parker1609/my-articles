package me.parker.designpattern.sms.decorator;

public interface NotificationFilter {

    boolean canSend(NotificationRequest request);
}
