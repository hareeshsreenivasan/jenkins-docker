pipeline{
    agent any
    stages {
        stage('Setting PollSCM'){
            steps{
                script{
                    properties([pipelineTriggers([pollSCM('* * * * *')])])
                }
            }
        }
        stage ('Checkout'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'gitpass', url: 'https://github.com/hareeshsreenivasan/jenkins-docker']]])
            }
        }
        stage('Build'){
            steps{
                bat 'mvn clean install -f jenkins-docker/pom.xml'
            }
        }
        stage ('Docker Build'){
            steps{
                bat 'docker build -t hareesh52/jenkins-docker:version1.0 .'
            }
        }
        stage ('Publish'){
            steps{
                withDockerRegistry([credentialsId:"docker-hub", url:""]){
                    bat 'docker push hareesh52/jenkins-docker:version1.0'
                    }
                }
            }
        }
        post {
                always {
                    cleanWs()
                }
            }
    }