// vars/gitClone.groovy

def call(Map config) {
    def repoUrl = config.repoUrl
    def branchName = config.branchName ?: 'main' // Default to 'main' if branchName is not provided
    def credentialsId = config.credentialsId

    stage('Git Clone') {
        checkout([
            $class: 'GitSCM',
            branches: [[name: branchName]],
            userRemoteConfigs: [[url: repoUrl, credentialsId: credentialsId]]
        ])
    }
}
