# OpenSUN Server

[![License](https://img.shields.io/github/license/cwanix/opensun-server.svg)](LICENSE)
[![Issues](https://img.shields.io/github/issues/cwanix/opensun-server.svg)](ISSUES)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/486a6e567a6c4c6396e67467a38175bc)](https://www.codacy.com/app/CwaniX/OpenSUN-Server?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=CwaniX/OpenSUN-Server&amp;utm_campaign=Badge_Grade)

OpenSUN Server is an attempt to create from scratch a fully functional Soul of the Ultimate Nation game server emulator.

## Project state
Currently, the project is at the stage of modeling architecture. I strive to recognize as many behaviors as possible without any optimization. Therefore, the code may be inefficient and full of unrecognized errors.

## Requirements
 - Java Development Kit 8
 - Eclipse IDE
 - Spring Tools 4 for Eclipse
 - PostgreSQL 10

## Getting Started
To successfully run the project, please download and install everything from the top to the bottom of the list. If you already have some of this downloaded or installed, please skip the current step and move on to the next step. There is installation guides to help install some of these applications.

#### Java Development Kit 8
1) Download JDK 8 (https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
<br><b>NOTE:</b> Login required to download. Can sign up for free.

#### Eclipse IDE
1) Download Eclipse IDE (https://www.eclipse.org/downloads/)
2) Install Eclipse IDE. Please follow this installation guide in the link below for help.
<br><b>LINK:</b> https://www.eclipse.org/downloads/packages/installer

#### Spring Tools 4 for Eclipse
1) Open the Eclipse IDE.
2) Click Help in the toolbar at the top.
3) Click Eclipse Marketplace within the Help dropdown menu.
4) In the pop-up window, search Spring Tools 4 (aka Spring Tool Suite 4).
5) Click the install button.
<br><b>NOTE:</b> For more help, please follow the installation section of the guide in the link below.
<br><b>LINK:</b> https://www.eclipse.org/community/eclipse_newsletter/2018/february/springboot.php

#### PostgreSQL 10
1) Download PostgreSQL 10 (https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)
2) Install PostgreSQL 10. Please follow the general installation guide in the link below for help.
<br><b>LINK:</b> https://www.postgresqltutorial.com/install-postgresql/
  
 #### OpenSUN Server
 
 ##### Importing to Eclipse
1) Open Eclipse IDE.
2) Click File in the toolbar at the top.
3) Click Import...
4) In the pop-up, click the Git folder in the center section.
5) Click Projects from Git (with smart import).
6) Click Next at bottom of the current window.
7) Click Clone URI and click Next
8) Paste "https://github.com/CwaniX/OpenSUN-Server" into URI section and click Next.
<br><b>NOTE:</b> The window will fill out some sections automatically.
9) Click Next
10) Ensure the directory path is where you want the project to store. Click Next.
11) Click Finish

##### Configuring OpenSUN Server
1) Go to the main directory of OpenSUN Server.
<br><b>NOTE:</b> In Eclipse, right click OpenSUN-Server, scroll over Show In, and click Project Explorer.
2) Create a folder called config.
3) In the main directory, search through every server, and find the .properties_template files.
<br><b>NOTE:</b> Inside agent-server, the file is in agent-server\src\main\resources. The server's properties_template files you need is agent-server, auth-server, db-server, world-server.
4) Place those .properties_template files inside the config folder in the main directory.
5) In Eclipse click Run in the toolbar at the top.
6) Click Debug Configurations... in the Run dropdown bar.
7) In the pop-up window, right click Spring Boot App, and click New Configuration.
8) At the top of the window, rename the configuration to ServerConfig, and click the Environment tab.
9) Click Add at the right of the window.
10) In the new pop-up window, type config folder for name, and click the Variables... button.
11) 

## Files
 - [Server Suite (31.07.2019)](https://drive.google.com/open?id=18D...r9pEusguJf8rUe)
