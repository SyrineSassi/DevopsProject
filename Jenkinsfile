pipeline{
    agent any
    tools {
        maven 'M2_HOME'
    }


    stages {
    
    
        stage('Getting project from Git') {
            steps{
      			checkout([$class: 'GitSCM', branches: [[name: '*/main']], 
			extensions: [], 
			userRemoteConfigs: [[url: 'https://github.com/SyrineSassi/DevopsProject.git']]])
            }
	} 
	    
        stage('Cleaning the project') {
            steps{
                	sh "mvn -B -DskipTests clean  " 
            }
        }
	    stage('Artifact Construction') {
            steps{
                	sh "mvn -B -DskipTests package "
            }
        }
	    stage('Unit Tests') {
            steps{
               		 sh "mvn test "
            }
        }
	    
	     stage('Code Quality Check via SonarQube') {
            steps{
                
             		sh "  mvn sonar:sonar -Dsonar.projectKey=Achat -Dsonar.host.url=http://192.168.1.17:9000 -Dsonar.login=b6502a213b3324978fe77f9a6797afaf7b1f9fe1"
 
            }
        }
	    
	    
}
}
       
