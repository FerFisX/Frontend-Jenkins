pipeline {
    agent any

    triggers {
        cron('H/5 * * * *')  // Ejecuta cada 5 minutos
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
                bat '''
                    if exist node_modules rmdir /s /q node_modules
                    if exist package-lock.json del package-lock.json
                    npm install
                '''
            }
        }

        stage('Iniciar servidor en segundo plano') {
            steps {
                bat 'start /B npm run dev'
            }
        }
    }

    post {
        failure {
            echo '❌ El pipeline falló.'
        }
        success {
            echo '✅ El pipeline se ejecutó correctamente.'
        }
    }
}
