package com.thomaskasene.example.messagesource.parent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Thomas Kåsene
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MessageSourceExtensionConfig.class)
public class MessageSourceCustomExtenderTest {

    @Autowired
    private MessageSource messageSource;

    @Test
    public void retrievesMessageFromMessagePropertiesFile() {
        String firstNameMessage = messageSource.getMessage("name.first", null, Locale.UK);

        assertThat(firstNameMessage, is(equalTo("First name")));
    }

    @Test
    public void retrievesMessageFromCustomPropertiesFile() {
        String lastNameMessage = messageSource.getMessage("name.last", null, Locale.UK);

        assertThat(lastNameMessage, is(equalTo("Last name")));
    }

    @Test
    public void overridesMessageInMessagePropertiesFile() {
        String middleNameMessage = messageSource.getMessage("name.middle", null, Locale.UK);

        assertThat(middleNameMessage, is(equalTo("Middle name")));
    }

    @Test
    public void retrievesTranslatedMessageFromCustomPropertiesFile() {
        String languageMessage = messageSource.getMessage("language", null, Locale.US);

        assertThat(languageMessage, is(equalTo("American English")));
    }

    @Test
    public void retrievesTranslatedMessageFromMessagePropertiesFile() {
        String countryMessage = messageSource.getMessage("country", null, Locale.US);

        assertThat(countryMessage, is(equalTo("United States")));
    }
}
