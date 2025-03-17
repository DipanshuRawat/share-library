// vars/cleanWorkspace.groovy

def call() {
    stage('Clean Workspace') {
        deleteDir()
    }
}
