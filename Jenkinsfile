pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'java21'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'newBranch', url: 'https://github.com/Pawaffle/TestInClass26.02.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Test & Coverage') {
            steps {
                bat 'mvn test jacoco:report' // Runs tests & generates JaCoCo coverage report
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml' // Publish JUnit test results

            jacocoPublisher(
                execPattern: '**/target/jacoco.exec',
                inclusionPattern: '**/target/classes/**',
                exclusionPattern: '**/test/**'
            )
        }
    }
}
