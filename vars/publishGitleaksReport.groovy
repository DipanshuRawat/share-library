// vars/publishGitleaksReport.groovy

def call(String gitleaksReportName = "gitleaks-report.json") {
    stage('Publish Gitleaks Report') {
        archiveArtifacts artifacts: gitleaksReportName, fingerprint: true
    }
}
