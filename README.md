# MessageSource Parent
This example shows a barebones way to extend the default `MessageSource` created by Spring Boot so that it also includes messages from *.properties-files that aren't defined by the `spring.messages.basename` property.

The background for this example is covered by the following blog post: http://www.thomaskasene.com/2016/08/20/custom-spring-boot-starter-messagesource/

## How to Get

To check out the project, open Git Bash and enter the following:
```
git clone https://github.com/ThomasKasene/example-parent-message-source.git
```

## Contents

This project contains the following:

* `MessageSourceExtensionConfig`, which sets up a `BeanFactoryPostProcessor` bean that alters the `MessageSource` bean
* `MessageSourceCustomExtenderTest`, which defines a number of unit tests
* A number of *.properties-files under test resources to assist with the unit testing