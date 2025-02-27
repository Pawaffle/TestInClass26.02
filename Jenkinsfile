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
            recordCoverage(tools: [[parser: 'JACOCO']],
                    id: 'jacoco', name: 'JaCoCo Coverage',
                    sourceCodeRetention: 'EVERY_BUILD',
                    qualityGates: [
                            [threshold: 60.0, metric: 'LINE', baseline: 'PROJECT', unstable: true],
                            [threshold: 60.0, metric: 'BRANCH', baseline: 'PROJECT', unstable: true]])
        }
    }
}