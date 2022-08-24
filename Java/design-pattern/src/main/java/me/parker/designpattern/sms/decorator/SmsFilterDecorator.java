package me.parker.designpattern.sms.decorator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmsFilterDecorator implements NotificationFilter {

    private static final Pattern CELLPHONE_NUMBER_PATTERN = Pattern.compile("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$");

    private final NotificationFilter notificationFilter;

    public SmsFilterDecorator(NotificationFilter notificationFilter) {
        this.notificationFilter = notificationFilter;
    }

    @Override
    public boolean canSend(NotificationRequest request) {
        boolean result = notificationFilter.canSend(request);
        if (!result) {
            return false;
        }

        Matcher matcher = CELLPHONE_NUMBER_PATTERN.matcher(request.getCellphoneNumber());

        return matcher.find();
    }
}
