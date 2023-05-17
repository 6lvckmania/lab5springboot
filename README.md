# Spring Boot lab

* Perform an HTTP GET request
```bash
curl http://localhost:8080/
```
* Get the HTTP response headers
```bash
curl -i http://localhost:8080/
```
* Perform an HTTP POST request passing data URL
```bash
curl -X POST http://localhost:8080/api/software-modules/modules \
  -u editor:password \
  -H 'Content-Type: application/json' \
  -d '{ \
    "description": "Module 1", \
    "author": "Yevhenii Tymofeiev", \
    "language": "Python", \
    "lastEditDate": "2023-05-03", \
    "size": 12312313, \
    "linesOfCode": 123123, \
    "isCrossPlatform": false, \
    "product": { \
      "id": 1 \
    } \
  }'
```
* Get data by different users
```bash
curl -X GET http://localhost:8080/api/software-modules/modules/1 -u editor:password
```
```bash
curl -X GET http://localhost:8080/api/software-modules/modules/1 -u viewer:password
```
