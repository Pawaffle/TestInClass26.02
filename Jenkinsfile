pipeline{
    agent any
    tools{
        maven 'Maven'
        jdk 'java21'
    }

    stages{
        stage('checkout'){
            steps{
                git branch: 'newBranch', url: 'https://github.com/Pawaffle/TestInClass26.02.git'
            }
        }

        stage('build'){
            steps{
                bat 'mvn clean install'
            }
        }

        stage('test'){
            steps{
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
                    jacoco( // Correct JaCoCo publisher
                        execFiles: '**/target/jacoco.exec',
                        classDirs: '**/target/classes',
                        sourceDirs: '**/src/main/java'
                    )
                }
            }
        }
    }
}