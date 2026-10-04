# Бекенд LeLviv

### Запуск проєкту:

1. Склонувати репозиторій

```shell
git clone git@github.com:ZabeidaNazar/back.git
```

2. Встановити Java 25 (найновіша версія з довгостроковою підтримкою):

   - Є багато дистрибутивів Java, в цьому проєкті використано Eclipse Temurin від Adoptium
   - Встановити Temurin 25: https://adoptium.net/installation
   - З метою сумісності рекомендовано використовувати той же дистрибутив у всіх середовищах (Eclipse Temurin)
   - В IDEA змінити можна в File -> Project Structure -> Project -> SDK
   
3. Встановити Docker і Docker Compose:
   - Docker Desktop: https://docs.docker.com/desktop/
   - Виконувати команди не доведеться, Spring Boot зробить все сам

4. Скопіювати та задати змінні оточення:
   - `cp .env.example .env`
   
5. Для запуску можна використовувати:
   - CLI:
     - На Linux/macOS: `./gradlew bootRun`
     - На Windows: `gradlew.bat bootRun`
   - IDEA

6. Сторінка буде доступна за адресою: [http://127.0.0.1:8090/](http://127.0.0.1:8090/)
