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

        stage('Coverage') {
            discoverReferenceBuild()
            recordCoverage(tools: [[parser: 'JACOCO']])
        }
    }
}