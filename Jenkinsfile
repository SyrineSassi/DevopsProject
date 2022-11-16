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
          
           stage ('Mockito/Junit') {
             steps {
            
            sh "mvn test"
                echo """Bravo! tous les tests sont pris en charge"""
                }
            }
          
          
            stage ('SonarQube tests') {
            steps {
              sh' mvn sonar:sonar -Dsonar.projectKey=DevOps -Dsonar.host.url=http://172.20.2.128:9000 -Dsonar.login=5c35462ae955048ee097bccb7ee16b5e1e71464c'
      }
    }
          
           stage ('Nexus') {
            steps {
               sh 'mvn clean package deploy:deploy-file -DgroupId=tn.esprit.rh -DartifactId=achat -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://172.20.2.128:8081/repository/maven-releases/ -Dfile=target/achat-1.0.jar'

      }
    }  
          
         stage("Building Docker Image") {
                steps{
                   // sh 'sudo chmod 666 /var/run/docker.sock'
                    sh 'docker build -t siwarnl/imagedevops .'
                }
        }
          
          stage("Login to DockerHub") {
                steps{
                   // sh 'sudo chmod 666 /var/run/docker.sock'
                    sh 'echo dckr_pat_SqHvpKd6FgmKg5tIaop7yh8o3pE | docker login -u siwarnl -p Siwar123@'
                }
        }
           stage("Push to DockerHub") {
                steps{             
                    sh 'docker push siwarnl/imagedevops'
                }
        }
           stage("Docker-compose") {
                steps{
                    //sh 'docker-compose up -d'
                    sh 'docker-compose up -d --force-recreate --build'
                }
        }
          
          stage ('Mockito/Junit') {
             steps {
            
            sh "mvn test"
                echo """Bravo! tous les tests sont pris en charge"""
                }
            }
          
          stage('JUnit/Mockito'){
                steps {
                sh '''mvn -version
                mvn -B -DskipTests clean package'''
                sh 'mvn test'}}
  
          
     }

}
