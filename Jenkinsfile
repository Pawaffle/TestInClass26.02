pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'java21'
    }

    stages {
        stage('checkout') {
            steps {
                git branch: 'newBranch', url: 'https://github.com/Pawaffle/TestInClass26.02.git'
            }
        }

        stage('build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Test & Coverage') {
            steps {
                bat 'mvn test jacoco:report' // Runs tests & generates JaCoCo coverage report
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' // Publish JUnit test results

                    // Use Coverage Plugin properly
                    recordCoverage(
                        coverageAdapters: [jacocoAdapter(path: '**/target/site/jacoco/jacoco.xml')]
                    )
                }
            }
        }
    }
}
