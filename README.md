
# Integrative Client Project

## Overview
This project is an integrative client application written in Java. It includes various components such as APIs, models, utilities, and views that work together to provide a comprehensive solution.

## File Descriptions

### Root Directory

- **App.java**: Contains the main class with the entry point of the application.
- **My_Signal.java**: A Singleton class for sending signals (messages).
- **ObjectCallback.java**: Interface for handling asynchronous callbacks with success and failure methods.
- **RoleEnumBoundary.java**: Enum defining possible user roles (PLAYER, MANAGER, ADMIN).

### Adapter
- **ObjectAdapter.java**: Class for processing and adapting data.

### API
- **MiniAppCommandApi.java**: Interface for the MiniApp Command API.
- **ObjectApi.java**: Interface for the Object API.
- **RetrofitClient.java**: Class handling the Retrofit client settings for API connections.
- **UserApi.java**: Interface for the User API.

### Model
- **CurrentUser.java**: Class representing the current user.

#### MiniApp Command
- **CommandId.java**: Class representing a command ID.
- **CreatedBy.java**: Class representing who created the command.
- **MiniAppCommandBoundary.java**: Class representing the boundaries of a mini-app command.
- **ObjectId.java**: Class representing an object ID.
- **TargetObject.java**: Class representing the target object of a command.

#### Object
- **CreatedBy.java**: Class representing who created the object.
- **LocationBoundary.java**: Class representing the location boundaries.
- **ObjectBoundary.java**: Class representing the boundaries of an object.
- **ObjectId.java**: Class representing an object ID.

#### User
- **NewUserBoundary.java**: Class representing the boundaries of a new user.
- **UserBoundary.java**: Class representing the boundaries of a user.
- **UserId.java**: Class representing a user ID.

### Utilities
- **ImageLoader.java**: Class for handling image loading.

### View
- **activity_benefit_of_store.java**: Activity representing store benefits.
- **activity_clubs.java**: Activity representing clubs.
- **activity_login.java**: Activity representing the login screen.
- **activity_main.java**: Activity representing the main screen.
- **activity_profile.java**: Activity representing the user profile.
- **activity_registration.java**: Activity representing the registration screen.
- **activity_stores_of_club.java**: Activity representing the stores of a club.
- **activity_welcome.java**: Activity representing the welcome screen.
- **NevigationActivity.java**: Activity handling navigation between different activities.

## How to Run
To run this project, you need to have Java installed on your system. Compile the Java files and run the `App.java` file as the entry point of the application.

## Contributing
Feel free to fork this project and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

## License
This project is licensed under the MIT License.
