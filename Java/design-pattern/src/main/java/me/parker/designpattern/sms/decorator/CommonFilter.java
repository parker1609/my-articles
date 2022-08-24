package me.parker.designpattern.sms.decorator;

public class CommonFilter implements NotificationFilter {

    @Override
    public boolean canSend(NotificationRequest request) {
        return "NORMAL".equals(request.getMemberStatus());
    }
}
