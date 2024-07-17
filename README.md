
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

This document provides instructions on how to set up and run the Android client-side application using Android Studio Koala and the Spring server-side application using Spring Tools.

## Prerequisites

1. Android Studio Koala
2. Spring Tools
3. Docker
4. Android device with USB debugging enabled or an Android emulator

## Setup Instructions

### Step 1: Install Android Studio Koala

1. Download and install [Android Studio Koala](https://developer.android.com/studio).
2. Follow the installation instructions provided on the Android Studio website.

### Step 2: Install Spring Tools

1. Download and install [Spring Tools](https://spring.io/tools).
2. Follow the installation instructions provided on the Spring Tools website.

### Step 3: Determine Your IP Address

1. Find the IP address of the machine running the system. This IP address will be used for network configuration.
2. Open a terminal or command prompt and type `ipconfig` (Windows) or `ifconfig` (Linux/Mac) to find your IP address.

### Step 4: Update IP Address in RetrofitClient

1. Open the `RetrofitClient` file in your Android project.
2. Update the `BASE_URL` variable with your IP address:
    ```java
    private static final String BASE_URL = "http://YOUR_IP_ADDRESS:8085/";
    ```

### Step 5: Update Network Security Config

1. Open the `network-security-config.xml` file in your Android project.
2. Update the domain with your IP address:
    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <network-security-config>
        <domain-config cleartextTrafficPermitted="true">
            <domain includeSubdomains="true">YOUR_IP_ADDRESS</domain>
            <domain includeSubdomains="true">ANOTHER_IP_ADDRESS</domain>
        </domain-config>
    </network-security-config>
    ```

### Step 6: Run Docker

1. Ensure Docker is installed on your machine. If not, download and install it from [Docker's website](https://www.docker.com/).
2. Open a terminal or command prompt and run Docker:
    ```sh
    docker run -d -p 8085:8085 YOUR_DOCKER_IMAGE
    ```

### Step 7: Run Spring Server

1. Open Spring Tools.
2. Import your Spring server project.
3. Run the server by right-clicking the project and selecting `Run As > Spring Boot App`.

### Step 8: Run Android Application

1. Open your Android project in Android Studio Koala.
2. Connect your Android device via USB with USB debugging enabled or set up an Android emulator.

#### Setting Up an Android Emulator

1. Open Android Studio Koala.
2. Go to `Tools > AVD Manager`.
3. Click `Create Virtual Device`.
4. Choose a device definition and click `Next`.
5. Select a system image and click `Next`.
6. Verify the configuration and click `Finish`.

#### Running the Application on an Emulator or Device

1. In Android Studio, click the `Run` button.
2. Select your connected device or emulator.
3. The application should now build and run on the selected device.

### Additional Notes

- Ensure your Android device has USB debugging enabled. To enable it, go to `Settings > Developer options > USB debugging`.
- If you encounter any issues, refer to the official documentation for Android Studio and Spring Tools.

To run this project, you need to have Java installed on your system. Compile the Java files and run the `App.java` file as the entry point of the application.

## Contributing
Feel free to fork this project and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

## License
This project is licensed under the MIT License.
