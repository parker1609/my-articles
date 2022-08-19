package me.parker.designpattern.sms.templatemethod;

import me.parker.designpattern.sms.BSmsSendingService;

public class BSmsService extends SmsTemplateService {

    @Override
    public boolean requestAPI(String cellphoneNumber, String smsContents) {
        BSmsSendingService bService = new BSmsSendingService();
        return bService.send(cellphoneNumber, smsContents);
    }
}
