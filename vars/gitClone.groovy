// vars/gitClone.groovy

def call(String repoUrl, String branchName = 'main', String credentialsId = 'Cred') {
    stage('Git Clone') {
        checkout([
            $class: 'GitSCM',
            branches: [[name: branchName]],
            userRemoteConfigs: [[url: repoUrl, credentialsId: credentialsId]]
        ])
    }
}
