Garbage Recycling Application
This project presents a sophisticated Java application aimed at managing waste disposal through efficient garbage recycling techniques. The application serves as a comprehensive solution to tackle the environmental challenge of waste management by introducing innovative features and functionalities.

Project Overview
The Garbage Recycling Application is designed to streamline the process of waste segregation and recycling. It categorizes garbage into six distinct types: plastic, paper, glass, fabric, metal, and organic. Each type of garbage is assigned to its corresponding recycling bin to ensure proper disposal and recycling.

Features
Trash Can Management: The application initializes with a trash can, which acts as the primary container for all types of garbage. Garbage items are parsed from an external file, "garbage.txt", providing an initial inventory for the trash can.

Dynamic Recycling Bins: Recycling bins for each garbage type are dynamically sized, with capacities randomly determined from a predefined set of values (5, 10, and 15). This dynamic allocation optimizes resource utilization and ensures efficient waste storage.

Automated Segregation: The application autonomously segregates garbage from the trash can and transfers it to the appropriate recycling bins based on the type of waste. It employs sophisticated algorithms to optimize the distribution of garbage across recycling bins, maximizing efficiency.

Real-time Updates: As garbage is transferred to recycling bins, the application provides real-time updates on the contents of both the trash can and recycling bins. This transparency enables users to monitor the waste management process effectively.

Implementation Details
The project adheres to a structured codebase, implementing various interfaces, classes, and methods to facilitate seamless execution. Key components of the implementation include:

IBag Interface: Defines essential operations for bag data structures, such as adding, removing, and transferring items.

Main Class (GarbageRecyclingApp): Serves as the entry point for the application, orchestrating the execution flow and managing interactions between different modules.

FileIO Module: Handles file input and output operations, enabling the parsing of garbage data from external sources and updating the trash can as needed.

Garbage Class: Represents individual units of garbage, offering methods for string representation and comparison.

Recycling Bin Classes: Implemented for each garbage type, these classes manage the recycling bins' functionalities, including segregation and capacity management.

Contribution Guidelines
Contributions to the project are welcome and encouraged. Developers interested in contributing can explore opportunities to enhance existing features, optimize algorithms, improve user experience, or address any identified issues. Please refer to the project's documentation and guidelines for detailed instructions on contributing.

Contact Information
For inquiries, feedback, or collaboration opportunities, please reach out to the project maintainers:

Project Maintainer: Mustafa Şahin
Email: dantatsus@gmail.com or mustafasahin@std.iyte.edu.tr