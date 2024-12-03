pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "albertprofehub/bookspageable"
        AWS_REGION = "us-east-1"
        ECR_REGISTRY = "<your-aws-account-id>.dkr.ecr.${AWS_REGION}.amazonaws.com"
        ECR_REPOSITORY = "bookspageable"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/AlbertProfe/BooksPageable.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}