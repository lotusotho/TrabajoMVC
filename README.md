# Modelo Vista-Controlador Personajes WoW
## MVC basado en las estadísticas de los personajes de World Of Warcraft
Trabajo del tercer trimestre de 1º DAW

# Introducción:
Este proyecto de **MVC (Modelo Vista Controlador)** es un simple gestor de personajes/usuarios del famoso **MMORPG World Of Warcraft**, el cual contiene todas las funciones **CRUD (Create, Read, Update, Delete)**, divididas en diferentes clases y vistas gráficas las cuales el usuario puede usar de forma interactiva.

Se usa la librería de ventanas gráficas **Java Swing** y está basado en la versión de **Java 21**.

```mermaid
flowchart LR
    m[Main]
    c[Controlador]
    s[Servicio]
    v[Vista]
    db[(BBDD)]

m -.-> v ==> c ==> s ==> db
db ==> s ==> c ==> v
```

# Diagrama de clases:
```mermaid
classDiagram
  FunctionsHandler -- CharControllerDDBB
  ConnectionDDBB -- CharControllerDDBB
  ConnectionDDBB -- UserControllerDDBB
  CharControllerDDBB -- Encryption
  UserControllerDDBB -- Encryption
  Hero -- FunctionsHandler
  Hero -- CharControllerDDBB

  StringHandler -- FunctionsHandler
  StringHandler -- CharControllerDDBB
  StringHandler -- UserControllerDDBB
  CharacterView -- FunctionsHandler
  UsersLogin -- FunctionsHandler
  UsersLogin -- Main
  UsersPanel -- FunctionsHandler
  UsersRecover -- FunctionsHandler
  UsersRegister -- FunctionsHandler
  UsersView -- FunctionsHandler

  class Main {
    +main(String[] args) void
  }

  class FunctionsHandler {
    +ConnectDDBB() void
    +InsertCharacter(Hero hero) void
    +UsersLogin(String name, String passwd) void
    +UsersRegister(String name, String passwd, boolean adminCheck) void
    +CreateCSV() void
    +ViewCharactersTable(JTable jtable) void
    +DeleteLastCharacter(JTable jtable) void
    +ClearTable(JTable jtable) void
    +ReadCSV() void
    +isCurrentUserAdmin() void
    +GetFactions(int selector) void
    +ViewUsersTable(JTable jtable) void
    +DeleteLastUser(JTable jtable) void
    +RecoverPassUser(String oldPasswd, String newPasswd, String name) void
    +UserLoginPanel(boolean visible) void
    +UserRegisterPanel(boolean visible) void
    +UsersControlPanel(boolean visible) void
    +CharacterCreationPanel(boolean visible) void
    +CharacterManagementPanel(boolean visible) void
    +UsersManagementPanel(boolean visible) void
    +UsersRecoverPanel(boolean visible) void
  }

  class CharControllerDDBB {
    -getRecordFromLine(String line) List<String>
    +InsertCharacter(Hero heroObj) void
    +ShowAllRows(JTable jtable) void
    +DeleteLastCharacterDB() void
    +GetCharacterFRC(int selector) void
    +GenerateCSV() void
    +ReadCSV() void
  }

  class UserControllerDDBB {
    -currentUserId : int
    +usersLogin(String name, String passwd) void
    +usersRegister(String name, String passwd, boolean isAdmin) boolean
    +isCurrentUserAdmin() void
    +ShowAllRows(JTable jtable) void
    +DeleteLastUserDB() void
    +RecoverPassUser(String oldPasswd, String newPasswd, String name) void
    +getCurrentUserId() int
    +setCurrentUserId(int userId) void
  }

  class ConnectionDDBB {
    -bbdd : String
    -user : String
    -passwd : String
    -tmz : String
    -bbddURL : String
    -conx : Connection
    +connectDDBB()
  }

  class Encryption {
    +Encrypt(String passwd)
    -bytesToHex(byte[] hash)
  }

  class Hero {
    -id : int
    -name : String
    -race_id : int
    -faction_id : int
    -heroClass_id : id
    -title : String
    -life : BigDecimal
    -runicPower : int
    -strength : BigDecimal
    -stamina : BigDecimal
    +Hero(Todas las variables) void
    +getId() int
    +setId(int) void
    +getName() String
    +setName(String) void
    +getRace_id() int
    +setRace_id(int) void
    +getFaction_id() boolean
    +setFaction_id(boolean) void
    +getHeroClass_id() int
    +setHeroClass_id(int) void
    +getTitle() String
    +setTitle(String) void
    +getLife() BigDecimal
    +setLife(BigDecimal) void
    +getRunicPower() int
    +setRunicPower(int) void
    +getStrength() BigDecimal
    +setStrength(BigDecimal) void
    +toString() String
  }

  class CharacterCreation {

  }

  class CharacterView {

  }

  class UsersLogin {

  }

  class UsersPanel {

  }

  class UsersRecover {

  }

  class UsersRegister {

  }

  class UsersView {

  }

  class StringHandler {
    +ErrorHandler(String error) void
    +MessageHandler(String message) void
  }
```

# Paquetes del proyecto:
El proyecto está dividido en **3 paquetes principales:**
1. Controlador
2. Servicio (Modelo)
3. Vista

### 1.- Controlador:
El paquete de controlador contiene una clase llamada *FunctionsHandler.java*, la cual se utiliza como un puente entre el backend que conecta la base de datos (paquete Servicio) y realiza acciones sobre ella, y la vista de usuario (Paquete Vista), el cual se encarga de registrar las acciones que realiza el usuario sobre la aplicación.

### Clases dentro de Controlador:
#### FunctionsHandler.java
Este script se dedica a funcionar como un puente entre el código que conecta la base de datos dentro del paquete Servicio, y el código que renderiza la interfaz gráfica de usuario dentro de Vista.

## Métodos

La clase tiene varios métodos que pueden clasificarse en tres grupos:

1. ### Operaciones con la base de datos
	1. ConnectDDBB(): Establece una conexión con la base de datos.
	2. InsertCharacter(Hero): Inserta un nuevo personaje en la base de datos.
	3. UsersLogin(String name, String passwd): Registra un usuario con las credenciales proporcionadas.
	4. UsersRegister(String name, String passwd, boolean adminCheck): Registra un nuevo usuario con las credenciales proporcionadas y el estado admin.
2. ### Gestión de datos
	1. ViewCharactersTable(JTable jtable): Muestra la lista de personajes en una tabla.
	2. DeleteLastCharacter(JTable jtable): Borra el último personaje de la base de datos.
	3. ClearTable(JTable jtable): Borra todas las filas de la tabla.
	4. ReadCSV(): Lee un fichero CSV que contiene datos de personajes.
3. ### Gestión de Usuarios
	1. isCurrentUserAdmin(): Comprueba si el usuario actualmente conectado es un administrador.
	2. GetFactions(int selector): Obtiene una lista de las facciones basada en el selector proporcionado.
4. ### Gestión de Paneles
	1. UserLoginPanel(boolean visible): Muestra el panel de login del usuario.
	2. UserRegisterPanel(boolean visible): Muestra el panel de registro de usuarios.
	3. UsersControlPanel(boolean visible): Muestra el panel de control de usuarios.
	4. CharacterCreationPanel(boolean visible): Muestra el panel de creación de personajes.
	5. CharacterManagementPanel(boolean visible): Muestra el panel de gestión de personajes.
	6. UsersManagementPanel(boolean visible): Muestra el panel de gestión de usuarios.
	7. UsersRecoverPanel(boolean visible): Muestra el panel de recuperación de usuarios.
