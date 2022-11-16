pipeline { 
     agent any
     stages{
        stage('Checkout GIT') 
        { 
        steps{ 
            echo 'Pulling...'   
               git branch: 'Siwar-Noueili', credentialsId: 'TOKEN', url: 'https://github.com/SyrineSassi/DevopsProject.git'
                 
          }
        }
       
       stage ('Nexus') {
            steps {
                sh 'mvn deploy -DskipTests'
      }
    }
      
  }
}
