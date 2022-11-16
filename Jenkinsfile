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
          
          stage('Creation livrable'){ 
             steps{ 
                 sh "mvn clean package"
             }
         }
          
         stage('Compilation'){ 
             steps{ 
                 sh "mvn compile"
             }
         } 
          
            stage ('SonarQube tests') {
            steps {
              sh' mvn sonar:sonar -Dsonar.projectKey=DevOps -Dsonar.host.url=http://172.20.2.128:9000 -Dsonar.login=5c35462ae955048ee097bccb7ee16b5e1e71464c'
      }
    }
          
  
          
     }

}
