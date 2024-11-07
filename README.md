# Yieldstreet Security Challenge

This (fake) application manages _users_ and submitted accreditation _documents_. Some of the code is already in place (user registration and login), and some of it is still missing. You have two tasks:

- Review the existing code for security vulnerabilities, and propose changes to fix any vulnerabilities you can spot. You don't have to actually implement the proposed changes.

- Implement the one missing feature: the endpoint to list user documents. This is the implementation of the `find` method in `DocumentController`. The endpoint must return a list of documents (ids and names) uploaded by the logged-in user.

## Working With This Repository

This repository is integrated with [GitHub Codespaces][1]. You can launch a fully featured developer environment from the web, or using Visual Studio Code, or other IDE supporting the devcontainers specification.

To keep things simple: if you're reading this document on Github's web interface, just click the button below:

[![Open in GitHub Codespaces](https://github.com/codespaces/badge.svg)](https://codespaces.new/yieldstreet/security-challenge/tree/devcontainer)

This will launch a web-based editor you can use to complete this challenge. To run the web server, you can open the Terminal tab and type `mvn spring-boot:run`. This should even set up port forwards so you can make HTTP requests to the running server.

[1]: https://github.com/features/codespaces
