# spring 5 end to end programming 

This example project is based on the following book page:
https://learning.oreilly.com/library/view/spring-5-end-to-end/9781789959666/af9fc773-b6f0-4249-8445-6e02ba755f45.xhtml

0, Two micro services can be found under this project structure:
- Customer Profile Service: allows users to persist Customer entities via two REST endpoints (/customers - RestRepository, /register - RestController) with the help of the HAL browser
- Customer Notification Service: notified by the Customer Profile Service via RabbitMQ, it sends an email to the given address. Email sending is faked by the FakeSMTP server.

1, In order to establish successful communication between the customerprofile, you need to install RabbitMQ from here:
https://github.com/rabbitmq/rabbitmq-server/releases/download/v3.7.16/rabbitmq-server-3.7.16.exe
Before installing RabbitMQ, you need the Erlang package to be installed.
http://erlang.org/download/otp_win64_22.0.exe

After setting RABBITMQ_HOME environement variable and extended Path variable, Run RabbitMQ in CMD:
rabbitmq-server

2, Fake SMTP server is included in the project, you can setup a jar runner in IntelliJ Idea run config for this application.
Once the Desktop UI is opened, hit Start server button in order to catch SMTP messages.
The fake SMTP server stores emails under received-emails folder in notification service project.
