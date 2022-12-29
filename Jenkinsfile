pipeline{
    agent any

    stages {
        stage ('Maven Build'){
            steps{
            script {
                    properties([pipelineTriggers([pollSCM('* * * * *')])])
                    }
            git url: 'https://github.com/hareeshsreenivasan/jenkins-docker.git'
            withMaven {
                  bat "mvn clean install"
                }
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
    }