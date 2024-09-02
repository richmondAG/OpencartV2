pipeline {
    agent any
    parameters {
        choice(name: 'TEST_SUITE', choices: ['testng.xml'], description: 'Select the TestNG XML suite to run')
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/richmondAG/OpencartV2.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                script {
                    def suiteFile = params.TEST_SUITE
                    sh "mvn test -DsuiteXmlFile=OpencartV2/${suiteFile}"
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
