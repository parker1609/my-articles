package me.parker.designpattern.sms.templatemethod;

import me.parker.designpattern.sms.ASmsSendingService;

public class ASmsService extends SmsTemplateService {

    @Override
    public boolean requestAPI(String cellphoneNumber, String smsContents) {
        ASmsSendingService aService = new ASmsSendingService();
        return aService.send(cellphoneNumber, smsContents);
    }
}
