<h1 align="center" style="font-weight: bold;">URL Shortener - Backend 💻</h1>

<p align="center">
 <a href="#tech">Technologies</a> • 
 <a href="#started">Getting Started</a> • 
 <a href="#routes">API Endpoints</a>
</p>

<p align="center">
    <b>A simple API to shorten and retrieve URLs easily.</b>
</p>

<h2 id="tech">💻 Technologies</h2>

* Java 21 (Temurin)
* Spring Boot 3
* Maven
* NanoID (for short URL generation)
* MongoDB
* Docker & Docker Compose
* NGINX (reverse proxy)

<h2 id="started">🚀 Getting started</h2>

How to run this project locally.

<h3>Prerequisites</h3>

- [Docker](https://www.docker.com/) + [Docker Compose](https://docs.docker.com/compose/)
- [Java 21](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [Git](https://git-scm.com/)
- [MongoDB](https://www.mongodb.com/try/download/community)
- [NGINX](https://nginx.org/en/download.html)

<h3>Cloning</h3>

Clone the repository:

```bash
git clone https://github.com/valter-junnior/url-shortener-backend.git
cd url-shortener-backend
```

<h3>Config .env variables</h3>

you can configure properties in `src/main/resources/application.properties`:

```properties
spring.application.name=url-shortener
spring.data.mongodb.uri=mongodb://root:rootpassword@localhost:27017/urlshortenerdb?authSource=admin
```

<h3>Running with Docker Compose</h3>

Build and start the full stack (MongoDB + Spring Boot + NGINX):

```bash
docker-compose up --build
```

This will:
✅ Build the Spring Boot app
✅ Start MongoDB with authentication
✅ Start NGINX as a reverse proxy (serving on `localhost:80`)

<h2 id="routes">📍 API Endpoints</h2>

List of available routes.

| Route                                   | Description              |
|-----------------------------------------|--------------------------|
| <kbd>GET /api/links</kbd>               | Get all short URL        |
| <kbd>POST /api/links</kbd>              | Create a short URL       |
| <kbd>GET /api/links/{shortUrl}</kbd>    | Redirect to original URL |
| <kbd>DELETE /api/links/{shortUrl}</kbd> | Delete a short URL       |

<h3>GET /api/links</h3>

**REQUEST**

```bash
GET /api/links
```

**RESPONSE**

````json
[
  {
    "shortUrl": "abc12",
    "originalUrl": "https://www.example.com/your-very-long-url",
    "count": 2
  },
  {
    "shortUrl": "xyz34",
    "originalUrl": "https://www.example.com/another-long-url",
    "count": 1
  }
]
````

<h3>POST /api/links</h3>

**REQUEST**

```json
{
  "url": "https://www.example.com/your-very-long-url"
}
```

**RESPONSE**

```json
{
  "shortUrl": "abc12",
  "originalUrl": "https://www.example.com/your-very-long-url"
}
```

<h3>GET /api/links/{shortUrl}</h3>

**Example Request**

```bash
GET /api/urls/abc12
```

**RESPONSE**

```
HTTP/1.1 301 Moved Permanently
Location: https://www.example.com/your-very-long-url
```

<h3>DELETE /api/links/{shortUrl}</h3>

**Example Request**

```bash
DELETE /api/urls/abc12
```

**RESPONSE**

```
HTTP/1.1 204 No Content
```

<h2 id="frontend">🔗 Frontend</h2>

The frontend for this project is built using React . You can find the frontend repository here:

[URL Shortener Frontend Repository](https://github.com/valter-junnior/url-shortener-frontend)

Make sure to set up and run the frontend as instructed in the frontend README, but after start the backend.
