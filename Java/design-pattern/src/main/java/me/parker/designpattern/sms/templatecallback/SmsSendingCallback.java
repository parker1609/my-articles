package me.parker.designpattern.sms.templatecallback;

@FunctionalInterface
public interface SmsSendingCallback {

    boolean send(String cellphoneNumber, String smsContents);
}
