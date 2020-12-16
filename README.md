## Template Selenium
![GitHub Workflow Status](https://img.shields.io/github/workflow/status/clevsampaio/template-selenium/maven?style=for-the-badge)

Framework template para testes automatizados em java

Para executar, basta utilizar o comando:
```
mvn test
```
ou pode executar manualmente através de sua IDE.

Também é possível passar alguns parâmetros, veja quais:
```
mvn test -Dproperty.browser=firefox|chrome (default:chrome)
mvn test -Dproperty.type=local|remote|headless_local|headless_remote (default:local)
mvn test -Dproperty.hub=http://localhost:4444/wd/hub
mvn test -Dproperty.env=hom|dev|stress|prod (default:hom)
```
Você pode passar um ou mais a mesma linha dependendo da situação desejada.

Estes parâmetros podem ser definidos no pom.xml