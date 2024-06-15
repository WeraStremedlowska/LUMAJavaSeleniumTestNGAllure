# LUMAJavaSeleniumTestNGAllure

[![Java CI with Maven](https://github.com/WeraStremedlowska/LUMAJavaSeleniumTestNGAllure/actions/workflows/build.yml/badge.svg)](https://github.com/WeraStremedlowska/LUMAJavaSeleniumTestNGAllure/actions/workflows/build.yml)
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>README - LUMA Java Selenium TestNG Allure</title>
</head>
<body>

<p>This repository contains a test automation framework for the LUMA application using Java, Selenium, TestNG, and Allure for reporting.</p>

<h2>Table of Contents</h2>
<ul>
    <li><a href="#project-overview">Project Overview</a></li>
    <li><a href="#project-structure">Project Structure</a></li>
    <li><a href="#technologies-used">Technologies Used</a></li>
    <li><a href="#installation">Installation</a></li>
    <li><a href="#running-tests">Running Tests</a></li>
    <li><a href="#generating-reports">Generating Reports</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
</ul>

<h2 id="project-overview">Project Overview</h2>
<p>The LUMA Java Selenium TestNG Allure project is designed to automate the testing process for the LUMA web application. It leverages the power of Selenium WebDriver for browser automation, TestNG for test execution and management, and Allure for creating detailed test reports.</p>

<h2 id="project-structure">Project Structure</h2>
<p>Here is an overview of the project structure:</p>
<pre>
<code>
LUMAJavaSeleniumTestNGAllure/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── luma/
│   │               ├── pages/       # Page Object Models
│   │               └── utils/       # Utility classes
│   ├── test/
│   │   └── java/
│   │       └── com/
│   │           └── luma/
│   │               ├── tests/       # Test classes
│   │               └── config/      # Test configuration classes
├── pom.xml        # Maven configuration file
├── README.md      # Project README file
└── LICENSE        # License file
</code>
</pre>

<h2 id="technologies-used">Technologies Used</h2>
<ul>
    <li>Java</li>
    <li>Selenium WebDriver</li>
    <li>TestNG</li>
    <li>Allure</li>
    <li>Maven</li>
</ul>

<h2 id="installation">Installation</h2>
<ol>
    <li>Clone the repository:
        <pre><code>git clone https://github.com/WeraStremedlowska/LUMAJavaSeleniumTestNGAllure.git</code></pre>
    </li>
    <li>Navigate to the project directory:
        <pre><code>cd LUMAJavaSeleniumTestNGAllure</code></pre>
    </li>
    <li>Install dependencies using Maven:
        <pre><code>mvn clean install</code></pre>
    </li>
</ol>

<h2 id="running-tests">Running Tests</h2>
<p>To execute the tests, run the following Maven command:</p>
<pre><code>mvn test</code></pre>

<h2 id="generating-reports">Generating Reports</h2>
<p>To generate Allure reports, follow these steps:</p>
<ol>
    <li>Run the tests to generate the Allure results:
        <pre><code>mvn test</code></pre>
    </li>
    <li>Generate the Allure report:
        <pre><code>mvn allure:report</code></pre>
    </li>
    <li>Serve the Allure report:
        <pre><code>mvn allure:serve</code></pre>
    </li>
</ol>

<h2 id="contributing">Contributing</h2>
<p>Contributions are welcome! Please follow these steps to contribute:</p>
<ol>
    <li>Fork the repository.</li>
    <li>Create a new branch for your feature or bugfix:
        <pre><code>git checkout -b feature/your-feature-name</code></pre>
    </li>
    <li>Make your changes and commit them:
        <pre><code>git commit -m "Description of your changes"</code></pre>
    </li>
    <li>Push to your forked repository:
        <pre><code>git push origin feature/your-feature-name</code></pre>
    </li>
    <li>Create a pull request describing your changes.</li>
</ol>

<h2 id="license">License</h2>
<p>This project is licensed under the MIT License. See the <a href="LICENSE">LICENSE</a> file for details.</p>

<h2 id="contact">Contact</h2>
<p>For any inquiries or feedback, please contact <a href="mailto:werastremedlowska@example.com">Wera Stremedlowska</a>.</p>

</body>
</html>


