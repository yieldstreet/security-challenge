# Yieldstreet Security Challenge

This (fake) application manages _users_ and submitted accreditation _documents_. Some of the code is already in place (user registration and login), and some of it is still missing. You have two tasks:

- Review the existing code for security vulnerabilities, and propose changes to fix any vulnerabilities you can spot. You don't have to actually implement the proposed changes.

- Implement the one missing feature: the endpoint to list user documents. This is the implementation of the `find` method in [`DocumentController`](src/main/java/com/yieldstreet/challenges/security/document/DocumentController.java). The endpoint must return a list of documents (ids and names) uploaded by the logged-in user.

## Working With This Repository

First, fork this repository to your own Github account. Any changes that you make should happen on the forked repository, not on the upstream `yieldstreet` repository.

This repository is integrated with [GitHub Codespaces][1]. After forking the repository, click the green "Code" button, select "Codespaces", then click the "+" button to create a new Codespace. After about five minutes this will launch a web-based editor you can use to complete this challenge. To run the web server, you can open the Terminal tab and type `mvn spring-boot:run`. This should even set up port forwards so you can make HTTP requests to the running server.

If you're more comfortable working on a traditional IDE, feel free to use anything you're familiar with. Whether you choose to use a Codespace or your own tools, open a Pull Request with your changes or share the URL of your fork with us.

[1]: https://github.com/features/codespaces
