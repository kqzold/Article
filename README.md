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

## База данных
ER-диаграмма базы данных:

![diagram](https://github.com/user-attachments/assets/1b12bd6b-048f-42b2-8a47-8946daf2aa93)

## Функциональность
- Регистрация и аутентификация пользователей.
- Создание, редактирование, удаление и просмотр статей.
- Управление пользователями и их ролями (для администраторов).

## Роли пользователей
- **Пользователь**: Может создавать, редактировать и удалять только свои статьи.
- **Администратор**: Может управлять всеми статьями и пользователями.
