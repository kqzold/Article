# Article

## Описание проекта
Article — это платформа для публикации и управления статьями. Пользователи могут создавать, редактировать и удалять статьи, а также просматривать публикации других пользователей.

## Структура проекта
Проект состоит из следующих директорий:

![Снимок экрана (7)](https://github.com/user-attachments/assets/a48768af-3d36-4bda-8b3a-9f618ae1560b)

- `src/main/java` — основной код приложения на Java.
- `src/main/resources` — ресурсы проекта, включая конфигурационные файлы и шаблоны.
  - `templates` — шаблоны страниц на Thymeleaf.
  - `static` — статические ресурсы, такие как CSS и JavaScript.
  - `db` — скрипты для инициализации базы данных.
- `config` — конфигурации Spring Security, инициализация данных.
- `controllers` — контроллеры для обработки HTTP-запросов.
- `entity` — JPA-сущности: классы, представляющие таблицы в базе данных.
- `repository` — интерфейсы Spring Data JPA для работы с базой данных.
- `service` — интерфейсы бизнес-логики для сервисов.
- `serviceImpl` — реализации сервисов.
- `ArticlesApplication` — главный класс для запуска Spring Boot.

## Как запустить проект
1. Убедитесь, что у вас установлены JDK и Maven.
  
3. Клонируйте репозиторий:
    ```bash
    git clone https://github.com/kqzold/Article.git
    ```
4. Перейдите в директорию проекта:
    ```bash
    cd Article
    ```
5. Соберите проект и запустите его:
    ```bash
    mvn spring-boot:run
    ```
6. Приложение будет доступно по адресу:
    [http://localhost:8080](http://localhost:8080)

## Освобождение порта 8080
### Для Windows:
1. Откройте командную строку от имени администратора.
2. Выполните следующую команду, чтобы узнать PID процесса, занимающего порт 8080:
   ```cmd
   netstat -ano | findstr :8080
   ```
3. Определите PID процесса и остановите его командой:
   ```cmd
   taskkill /PID <PID> /F
   ```
   Замените `<PID>` на фактический номер процесса.

### Для Linux/Mac:
1. Откройте терминал и выполните команду:
   ```bash
   sudo lsof -i :8080
   ```
2. Найдите PID процесса и завершите его командой:
   ```bash
   kill -9 <PID>
   ```
   Замените `<PID>` на фактический номер процесса.

## База данных
1. Подключение к базе данных
   Настройте файл `application.properties` следующим образом:
   ```properties
   spring.datasource.url=jdbc:mariadb://localhost:3306/article?createDatabaseIfNotExist=true&serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=

   spring.jpa.hibernate.ddl-auto=create
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true
   spring.devtools.restart.enabled=true
   logging.level.org.springframework.security=DEBUG
   ```
2. Выполните следующие SQL-запросы для создания базы данных и пользователя (если они ещё не существуют):
   ```sql
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
   ```
3. Подключение базы данных в IntelliJ IDEA:
   - Перейдите в правую часть окна и найдите вкладку **Database** (если она не отображается, откройте через **View -> Tool Windows -> Database**).
   - Нажмите **+** и выберите **Data Source -> MariaDB**.
   - Введите параметры:
     - **URL:** `jdbc:mariadb://localhost:3306/article?createDatabaseIfNotExist=true&serverTimezone=UTC`
     - **User:** `root`
     - **Password:** *(оставьте пустым или укажите ваш пароль)*
   - Нажмите **Test Connection**, чтобы убедиться, что подключение успешно.
  
## Подключение базы данных в VS Code

### Установите расширение SQLTools в VS Code:

1. Перейдите в Extensions (расширения) и найдите SQLTools.
2. Установите это расширение.

### Откройте панель SQLTools:

1. Перейдите в меню в левом боковом окне и найдите иконку SQLTools.

### Создайте новое подключение:

1. Нажмите на + в панели SQLTools, чтобы добавить новое подключение.
2. Выберите MariaDB (или MySQL, если MariaDB нет в списке).

### Введите параметры подключения:

- Server/Host: `localhost`
- Port: `3306`
- Database: `article`
- User: `root`
- Password: (оставьте пустым или укажите ваш пароль)

3. Нажмите `Test Connection`, чтобы убедиться, что подключение успешно.

После успешного подключения вы сможете работать с базой данных через SQLTools в VS Code.

## База данных (ER-диаграмма)

![Снимок экрана (6)](https://github.com/user-attachments/assets/1890afdc-a167-4e11-b46f-1f8068163a56)

## Функциональность
- Регистрация и аутентификация пользователей.
- Создание, редактирование, удаление и просмотр статей.
- Управление пользователями и их ролями (для администраторов).

## Роли пользователей
- **Пользователь** — может создавать, редактировать и удалять только свои статьи.
- **Администратор** — может управлять всеми статьями и пользователями.

