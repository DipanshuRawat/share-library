// vars/publishGitleaksReport.groovy

def call(Map config) {
    def gitleaksReportName = config.gitleaksReportName ?: "gitleaks-report.json" // Default report name

    stage('Publish Gitleaks Report') {
        archiveArtifacts artifacts: gitleaksReportName, fingerprint: true
    }
}
