package me.parker.designpattern.sms.strategy;

public interface SmsSendingStrategy {

    boolean execute(String cellphoneNumber, String smsContents);
}
