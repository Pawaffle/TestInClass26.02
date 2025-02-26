pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: "main", url: "https://github.com/Pawaffle/TestInClass26.02.git"
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

//         stage('Code Coverage') {
//             steps {
//                 jacoco execPattern: '**/target/jacoco.exec',
//                         classPattern: '**/target/classes',
//                         sourcePattern: '**/src/main/java',
//                         exclusionPattern: '**/test/**'
//             }
//         }

        stage('Test & Coverage') {
            steps {
                bat 'mvn test jacoco:report' // Runs tests & generates JaCoCo coverage report
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' // Publish JUnit test results
                    jacoco execPattern: '**/target/jacoco.exec', // Reads JaCoCo execution file
                           classPattern: '**/target/classes',
                           sourcePattern: '**/src/main/java',
                           exclusionPattern: '**/test/**'
                }
            }
        }

    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
            jacoco execPattern: '**/target/jacoco.exec'
        }
    }
}