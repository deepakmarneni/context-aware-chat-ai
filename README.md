# context-aware-chat-ai
Building a Context-Aware Gemini Microservice with Spring AI and H2

It uses an H2 in-memory database for persistence.

## Tech Stack
- Java 25
- Spring AI 2.0.1
- Spring Boot 4.1.1
- Spring Web
- H2 Database

## Build and Run

### Prerequisites
- Java 25+
- Maven 4.0+

### Commands
```bash
mvn spring-boot:run
```

Application runs at: `http://localhost:8080`

H2 console: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:file:~/data/demochat`
- User: `sa`
- Password: password


## API Testing (curl examples)

### 1) Establishing the context
```bash
curl --location --request POST 'http://localhost:8080/api/ai/prompt' \
--header 'x-session-id: 8757788243' \
--header 'Content-Type: application/json' \
--data-raw '{
"query": "I love mangoes"
}'
```

### 2) Verifying History Recall
```bash
curl --location --request POST 'http://localhost:8080/api/ai/prompt' \
--header 'x-session-id: 8757788243' \
--header 'Content-Type: application/json' \
--data-raw '{
"query": "what do you think is my favorite fruit"
}'
```

