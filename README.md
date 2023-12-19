# spring-boot-crud-rest-api

### Prerequisites
Make sure you have the rust installed using this command:

#### Java
Make sure you have java installed using this command:
```bash script
java --version
```

#### Docker
Make sure you have docker installed using this command:
```bash script
docker --version
```

#### Curl
Make sure you have curl installed using this command:
```bash script
curl --version
```


### Build code
Build the code without running it
``` bash
./gradlew bootJar
```
or on windows
``` bash
gradlew.bat bootJar
```

#### Running the application locally

#####  Create docker image of app
Creating a docker image should be as simple as
``` bash
docker build -t springbootapp .
```

##### 🐘 Run the Postgres container
```bash script
docker-compose up -d db
```

##### 🏗️ Build the Rust app image
```bash script
docker compose build
```

##### 👟 Run the Rust Container
```bash script
docker compose up springbootapp
```

##### 🧪 Test the applications endpoints

Request to get the all the users:
```bash script
curl --location --request GET 'http://localhost:8080/users'
```
Example of a response:
`[
{
"id": 1,
"name": "aaa",
"email": "aaa@mail"
},
{
"id": 2,
"name": "bbb",
"email": "bbb@mail"
}
]`

Request to create a new user
```bash script
curl --location --request POST 'http://localhost:8080/users' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "aaa","email": "aaa@mail"}'
```

Request to get one specific user:
```bash script
curl --location --request GET 'http://localhost:8080/users/2'
```
Example of a response:
`{
"name": "new",
"email": "new@mail"
}`

Request to update a user
```bash script
curl --location --request PUT 'http://localhost:8080/users/2' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "new","email": "new@mail"}'
```

Request to delete a user
```bash script
curl --location --request DELETE 'http://localhost:8080/users/3'
```


### Upgrading the gradle wrapper
Find the newest version of gradle here: https://gradle.org/releases/ Then run this command:

``` bash
./gradlew wrapper --gradle-version $gradleVersion
```

## Contact
This project is maintained by [MikAoJk](CODEOWNERS)