// vars/gitClone.groovy

def call(String repoUrl, String branchName = 'main', String credentialsId = '0a860cc7-b888-40a5-ac79-f7592861d769') {
    stage('Git Clone') {
        checkout([
            $class: 'GitSCM',
            branches: [[name: branchName]],
            userRemoteConfigs: [[url: repoUrl, credentialsId: credentialsId]]
        ])
    }
}
