pipeline {
    agent any
    parameters {
        choice(name: 'OPENCART_TEST_SUITE', choices: ['dataDriven.xml','testng.xml'], description: 'Select suite to run')
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
                    bat "mvn test -DsuiteXmlFile=OpencartV2//${suiteFile}"
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
