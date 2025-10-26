# 🚀 Hybrid Automation Framework by AP

A **Hybrid Automation Framework** built with **Java, TestNG, Maven, and RestAssured** to support **UI, API, and Integration testing**.  
The framework follows industry-standard best practices and supports **CI/CD integration with Jenkins**, **Allure Reports**, and **Docker execution**.

---

## 📁 Project Structure

HybridAutomationFrameworkbyAP/
│
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ ├── framework.api/ # API Testing Layer (RestAssured-based)
│ │ │ ├── framework.api.endpoints/ # API Endpoints Management
│ │ │ ├── framework.api.payload/ # Request Payload Builders
│ │ │ ├── framework.base/ # Base Classes (Driver setup, config, etc.)
│ │ │ ├── framework.pages/ # Page Object Model Classes for UI
│ │ │ └── framework.utils/ # Common Utilities (Excel, Logs, Reports)
│ │ │
│ │ └── resources/
│ │ ├── API_Functional_Testcase.csv
│ │ ├── config.properties # Global Configurations
│ │ ├── log4j2.xml # Logging Configuration
│ │ └── router.properties # Email / Environment Properties
│ │
│ └── test/
│ ├── java/
│ │ ├── tests.api/ # API Test Classes
│ │ ├── tests.integration/ # Integration Test Classes
│ │ └── tests.ui/ # UI Test Classes (Selenium / WebDriver)
│
├── reports/ # Extent & Allure Report Output
├── logs/ # Execution Logs
├── test-output/ # TestNG Output Directory
│
├── testng.xml # Master Suite
├── testng-api.xml # API Test Suite
├── testng-integration.xml # Integration Test Suite
├── testng-ui.xml # UI Test Suite
│
├── extent-config.xml # Extent Report Theme Config
├── Jenkinsfile # Jenkins CI/CD Pipeline
├── Dockerfile # Docker Container Setup
├── pom.xml # Maven Project Configuration
└── README.md # Project Documentation



---

## ⚙️ Key Features

✅ Supports **UI, API, and Integration Testing**  
✅ Built on **Hybrid Framework Architecture** (POM + DDF + Modular + Keyword)  
✅ **TestNG-based** execution control  
✅ **Extent Reports** and **Allure Reports** integration  
✅ **Email Report Automation** (via Jakarta Mail API)  
✅ **Jenkins CI/CD pipeline** integration  
✅ **Dockerized execution** for consistent environment  
✅ **Parallel Execution** supported via TestNG XML  
✅ Centralized **config.properties** for environment control  

---

## 🧩 Tech Stack

| Component         | Technology Used             |
|-------------------|-----------------------------|
| Language          | Java 16                     |
| Test Framework    | TestNG                      |
| API Testing       | RestAssured                 |
| UI Testing        | Selenium WebDriver          |
| Build Tool        | Maven                       |
| Reporting         | Extent Reports, Allure      |
| Logging           | Log4j2                      |
| CI/CD             | Jenkins                     |
| Containerization  | Docker                      |
| Email Utility     | Jakarta Mail                |

---

## ⚙️ Configuration Setup

### 1. Update Configuration Files
Modify values in:
- `src/main/resources/config.properties`
- `src/main/resources/router.properties`

Example:
```properties
browser=chrome
baseURL=https://example.com
fromEmail=your_email@gmail.com
password=your_app_password


🧪 How to Run Tests
🧱 Run All Tests
mvn clean test -DsuiteXmlFile=testng.xml

🧠 Run API Tests Only
mvn clean test -DsuiteXmlFile=testng-api.xml

💻 Run UI Tests Only
mvn clean test -DsuiteXmlFile=testng-ui.xml

🔗 Run Integration Tests
mvn clean test -DsuiteXmlFile=testng-integration.xml


🧾 Generate Reports
📊 Extent Reports

Reports are auto-generated under:

/reports/

🌐 Allure Reports

To generate Allure Report:

allure serve allure-results

🧰 Jenkins Integration

Configure Maven in Jenkins.

Create a new Freestyle Project or Pipeline Job.

Add GitHub repository URL under “Source Code Management”.

Add the following command under “Build”:

mvn clean test -DsuiteXmlFile=testng.xml


For Pipeline job, use the Jenkinsfile included in the project.

🐳 Docker Execution

To build and run inside Docker:

docker build -t hybrid-automation-framework .
docker run -it hybrid-automation-framework

📧 Email Report Integration

Configured via router.properties.

Automatically sends summary and attached report after execution.

🧠 Best Practices Followed

Modular, maintainable design

Reusable utilities and base classes

CI/CD ready for scalable automation

Error handling with proper logging

Environment-driven configuration

🧩 Future Enhancements

Add Database Testing Module

Add Retry Analyzer for flaky tests

Integrate Slack notifications

Add cloud execution (BrowserStack/SauceLabs)

👨‍💻 Author

👤 Ankush Pawar (AP)
QA Engineer | Automation Specialist | AI & Test Framework Developer

📧 Email: ankushpawarapj111@gmail.com

📘 GitHub: github.com/ankushpawar


⭐ If you like this framework, give it a star on GitHub!


Would you like me to **add GitHub badges (build, report, license, Java version, etc.)** at the top for a more professional open-source look?

------------------------------------------------------
