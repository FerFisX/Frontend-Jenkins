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
                git branch: 'main', url: 'https://github.com/FerFisX/Frontend-Jenkins.git'
            }
        }

        stage('Instalar dependencias') {
            steps {
                bat 'npm install'
            }
        }

        stage('Compilar o iniciar el proyecto') {
            steps {
                bat 'npm run build || npm run dev'
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
