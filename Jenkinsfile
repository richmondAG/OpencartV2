pipeline {
    agent any
    parameters {
        choice(name: 'TEST_SUITE', choices: ['dataDriven.xml'], description: 'Select the TestNG XML suite to run')
    }
    stages {
        stage('Checkout') {
            steps {
                echo 'Starting Checkout...'
                git 'https://github.com/richmondAG/OpencartV2.git'
                echo 'Checkout completed.'
            }
        }
        stage('Build') {
            steps {
                echo 'Starting Build...'
                bat 'mvn clean install'
                echo 'Build completed.'
            }
        }
        stage('Test') {
            steps {
                script {
                    def suiteFile = params.TEST_SUITE
                    bat "sed -i \"s#<suiteXmlFile>.*</suiteXmlFile>#<suiteXmlFile>${suiteFile}</suiteXmlFile>#\" src/test/resources/dataDriven.xml"
                }
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
