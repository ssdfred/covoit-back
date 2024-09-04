pipeline {
    agent any

    tools {
        jdk 'java'
        maven 'Maven 3.9.9'
    }

    stages {
        stage('Checkout') {
            steps {
                // Using branch specifier to ensure the correct branch is checked out.
                git branch: 'main', url: 'https://github.com/ssdfred/covoit-back'
            }
        }

        stage('Build') {
            steps {
                // Running Maven build with a more descriptive output.
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Test') {
            steps {
                // Running tests with Maven.
                sh 'mvn test'
            }
            post {
                always {
                    // Collecting test results.
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Code Coverage') {
            steps {
                // Running JaCoCo for code coverage.
                sh 'mvn jacoco:report'
            }
            post {
                always {
                    // Archiving the code coverage report.
                    Jacoco execPattern: '**/target/jacoco.exec'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQubeServer') {
                    // Running SonarQube analysis with Maven.
                    sh 'mvn sonar:sonar'
                }
            }
        }
    }

    post {
        success {
            echo 'Build Successful'
        }
        failure {
            echo 'Build Failed'
        }
    }
}
