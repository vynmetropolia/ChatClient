# Chat Client
Chat Client Android Application with Kotlin
## Features✨
* Multiple users can send and receive messages.
* User Login.
* Send messages without special prefix characters.
* Users are able to click the Quit button in order to returning the login activity
![alt quitButton](https://github.com/vynmetropolia/ChatClient/blob/master/Quit%20Button.png)
* MVC architecture: Whole project is built on MVC architecture.
* Material Design: Not a typical Material Design App, but you will find some familiar elements in the Chat Client application:
Bubble message layout, Color, Layout, Font of messages,...

## Object-Oriented design patterns are used in the client application:

### Creational Design Patterns:
 **-Singleton design pattern** : The Singleton Pattern ensures a class has only one instance, and provides a global access point for it. In this application, it is used in network service.
 
![alt ClientSocket](https://github.com/vynmetropolia/ChatClient/blob/master/singleton_ClientSocket.png)

### Structural Design Patterns:
 **-Adapter** :Adapter pattern lets two incompatible classes to work with each other without the need to modify both their source codes. This is done by converting the interface of one class into an interface expected by the clients.
In Android, it uses a lot of adapter pattern when it comes to handling ListView or RecyclerView data. In this application, a recyclerView is used for displaying the chat messages to screen.
![alt adapter](https://github.com/vynmetropolia/ChatClient/blob/master/MessageHolder.png)
![alt adapter](https://github.com/vynmetropolia/ChatClient/blob/master/RecyclerAdapter.png)





