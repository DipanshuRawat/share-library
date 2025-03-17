// vars/gitLeaks.groovy

def call(String gitleaksReportName = "gitleaks-report.json") {
    stage('Download and Install Gitleaks') {
        sh '''
            wget https://github.com/gitleaks/gitleaks/releases/download/v8.24.0/gitleaks_8.24.0_linux_x64.tar.gz
            tar -xzvf gitleaks_8.24.0_linux_x64.tar.gz
            chmod +x gitleaks
            sudo mv gitleaks /usr/local/bin/
        '''
    }

    stage('Gitleaks Scan') {
        sh "gitleaks detect -r ${gitleaksReportName}"
    }

    stage('Publish Gitleaks Report') {
        archiveArtifacts artifacts: gitleaksReportName, fingerprint: true
    }
}
