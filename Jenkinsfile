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
	    
	  
        
	
}
}
       
