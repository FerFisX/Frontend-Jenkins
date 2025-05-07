pipeline {
    agent any

    triggers {
        cron('H/10 * * * *')  // Cada 10 minutos
    }

    environment {
        NODE_ENV = 'development'
    }

    stages {
        stage('Clonar Repositorio') {
            steps {
                git 'https://github.com/FerFisX/Frontend-Jenkins.git'
            }
        }

        stage('Instalar dependencias') {
            steps {
                sh 'npm install'
            }
        }

        stage('Compilar o iniciar el proyecto') {
            steps {
                sh 'npm run build || npm run dev'
            }
        }
    }

    post {
        failure {
            echo 'El pipeline falló 😢'
        }
        success {
            echo 'Pipeline ejecutado correctamente ✅'
        }
    }
}
