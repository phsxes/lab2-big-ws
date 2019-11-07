package translator.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import translator.Application;
import translator.domain.TranslatedText;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TranslatorServiceTest {

  @Autowired
  TranslatorService translatorService;

  @Test
  public void translateEnToEs() {
    TranslatedText translatedText = translatorService.translate("en", "es", "This is a test of translation service");
    assertEquals("Esto es una prueba de servicio de traducción", translatedText.getTranslation());
  }

  @Test
  public void translateEnToKo() {
    TranslatedText translatedText = translatorService.translate("en", "ko", "This is a test translation from English to Korean.");
    assertEquals("이것은 시험에서 영어 번역 한국어입니다.", translatedText.getTranslation());
  }

  @Test
  public void translateEsToKo() {
    TranslatedText translatedText = translatorService.translate("en", "sv", "This is a test translation from English to Swedish.");
    assertEquals("Detta är ett test för översättning från engelska till svenska.", translatedText.getTranslation());
  }

}
