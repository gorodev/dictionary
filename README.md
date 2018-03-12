Java Dictionary
================================


# Example:

```java

String yandexDictionaryAccessToken = "your free yandex access token";

Dictionary dictionary = new YandexDictionary(yandexDictionaryAccessToken);

dictionary.translate("ES", "EN", "andar").ifPresent(translation -> {
    String options = translation.getOptions().stream()
        .map(TranslationOption::toString)
        .collect(Collectors.joining("\n"));
    System.out.println(options);
});
```

# Output example:
✅ 1. andar *[anˈdaɾ]* walk (`verb`)
synonyms: wander, move

✅ 2. andar *[anˈdaɾ]* walking (`noun`)
synonyms: going

✅ 3. andar *[anˈdaɾ]* go (`noun`)
synonyms: ride

✅ 4. andar *[anˈdaɾ]* pace (`noun`)


# License
The works in this repository are licensed under the MIT License.