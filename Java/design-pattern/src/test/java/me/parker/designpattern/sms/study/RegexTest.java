package me.parker.designpattern.sms.study;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class RegexTest {

    @Test
    void success_cellphone_number() {
        Pattern pattern = Pattern.compile("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$");
        String input = "010-1234-5678";

        Matcher matcher = pattern.matcher(input);

        assertThat(matcher.find()).isTrue();
    }

    @Test
    void fail_cellphone_number() {
        Pattern pattern = Pattern.compile("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$");
        String input = "02-1234-5678";

        Matcher matcher = pattern.matcher(input);

        assertThat(matcher.find()).isFalse();
    }
}
