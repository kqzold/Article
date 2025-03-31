# Article

## Описание проекта
Проект Article представляет собой платформу для публикации и управления статьями. Пользователи могут создавать, редактировать и удалять статьи, а также просматривать статьи других пользователей.

## Структура проекта
Проект состоит из следующих директорий:

- `src/main/java`: Основной код приложения на Java.
- `src/main/resources`: Ресурсы проекта, включая конфигурационные файлы и шаблоны.
- `src/main/resources/templates`: Шаблоны страниц на Thymeleaf.
- `src/main/resources/static`: Статические ресурсы, такие как CSS и JavaScript.
- `src/main/resources/db`: Скрипты для инициализации базы данных.
- config-Конфигурации Spring Security, инициализация данных
- controllers - Контроллеры для обработки HTTP-запросов
- entity - JPA-сущности: классы, представляющие таблицы в БД
- repository - Интерфейсы Spring Data JPA для работы с БД
- service - Интерфейсы бизнес-логики для сервисов
- serviceImpl - Реализация сервисов
- ArticlesApplication - Главный класс запуска Spring Boot

## Как запустить проект
1. Убедитесь, что у вас установлены JDK и Maven.
2. Клонируйте репозиторий:
    ```bash
    git clone https://github.com/kqzold/Article.git
    ```
3. Перейдите в директорию проекта:
    ```bash
    cd Article
    ```
4. Соберите проект и запустите его:
    ```bash
    mvn spring-boot:run
    ```
5. Приложение будет доступно по адресу:
http://localhost:8080


## База данных
## База данных
1. Подключение к базе данных
   Настройте файл `application.properties` следующим образом:
   ```properties
   spring.datasource.url=jdbc:mariadb://localhost:3306/db_articles
   spring.datasource.username=articles
   spring.datasource.password=articles

   spring.jpa.hibernate.ddl-auto=create
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true
   spring.devtools.restart.enabled=true
   logging.level.org.springframework.security=DEBUG
   ```
Выполните следующие SQL-запросы для создания базы данных и пользователя (если они ещё не существуют):

-- Создаём базу данных (если она ещё не существует)
CREATE DATABASE IF NOT EXISTS db_articles 
    CHARACTER SET utf8mb4 
    COLLATE utf8mb4_unicode_ci;

-- Создаём пользователя (если он ещё не существует)
CREATE USER IF NOT EXISTS 'articles'@'localhost' IDENTIFIED BY 'articles';

-- Даем пользователю все привилегии на созданную базу данных
GRANT ALL PRIVILEGES ON db_articles.* TO 'articles'@'localhost';

-- Применяем изменения
FLUSH PRIVILEGES;

3. Откройте вкладку "Database":

- Перейдите в правую часть окна IntelliJ IDEA и найдите вкладку "Database". Если она не отображается, вы можете открыть её через меню View -> Tool Windows -> Database.

3. Добавьте новое подключение к базе данных:

- Нажмите на значок + в верхней части вкладки "Database" и выберите Data Source -> H2.

4. Настройте параметры подключения:

- В появившемся окне введите следующие параметры:
- URL: jdbc:mariadb://localhost:3306/article?createDatabaseIfNotExist=true&serverTimezone=UTC
- User: root
- Password: 
- Нажмите Test Connection, чтобы убедиться, что подключение успешно.

ER-диаграмма базы данных:

![Снимок экрана (6)](https://github.com/user-attachments/assets/20202200-1813-44d5-9caa-2546b2e33ce8)
## Функциональность
- Регистрация и аутентификация пользователей.
- Создание, редактирование, удаление и просмотр статей.
- Управление пользователями и их ролями (для администраторов).

## Роли пользователей
- **Пользователь**: Может создавать, редактировать и удалять только свои статьи.
- **Администратор**: Может управлять всеми статьями и пользователями.
