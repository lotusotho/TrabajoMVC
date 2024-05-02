# Modelo Vista-Controlador Personajes WoW
## MVC basado en las estadísticas de los personajes de World Of Warcraft
Trabajo del tercer trimestre de 1º DAW

# Introducción:
Este proyecto de **MVC (Modelo Vista Controlador)** es un simple gestor de personajes/usuarios del famoso **MMORPG World Of Warcraft**, el cual contiene todas las funciones **CRUD (Create, Read, Update, Delete)**, divididas en diferentes clases y vistas gráficas las cuales el usuario puede usar de forma interactiva.

Se usa la librería de ventanas gráficas **Java Swing** y está basado en la versión de **Java 21**.

## Paquetes del proyecto:
El proyecto está dividido en **3 paquetes principales:**
1. Controlador
2. Servicio (Modelo)
3. Vista

### 1.- Controlador:
El paquete de controlador contiene una clase llamada *FunctionsHandler.java*, la cual se utiliza como un puente entre el backend que conecta la base de datos (paquete Servicio) y realiza acciones sobre ella, y la vista de usuario (Paquete Vista), el cual se encarga de registrar las acciones que realiza el usuario sobre la aplicación.

### Clases dentro de Controlador:
#### FunctionsHandler.java
Este script se dedica a funcionar como un puente entre el código que conecta la base de datos dentro del paquete Servicio, y el código que renderiza la interfaz gráfica de usuario dentro de Vista.
```mermaid
classDiagram
  class FunctionsHandler {
    +ConnectDDBB()
    +InsertCharacter(Hero hero)
    +UsersLogin(String name, String passwd)
    +UsersRegister(String name, String passwd, boolean adminCheck)
    +CreateCSV()
    +ViewCharactersTable(JTable jtable)
    +DeleteLastCharacter(JTable jtable)
    +ClearTable(JTable jtable)
    +ReadCSV()
    +isCurrentUserAdmin()
    +GetFactions(int selector)
    +ViewUsersTable(JTable jtable)
    +DeleteLastUser(JTable jtable)
    +RecoverPassUser(String oldPasswd, String newPasswd, String name)
    +UserLoginPanel(boolean visible)
    +UserRegisterPanel(boolean visible)
    +UsersControlPanel(boolean visible)
    +CharacterCreationPanel(boolean visible)
    +CharacterManagementPanel(boolean visible)
    +UsersManagementPanel(boolean visible)
    +UsersRecoverPanel(boolean visible)
  }
```

### Controlador:
