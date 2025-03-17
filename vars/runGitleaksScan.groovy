// vars/runGitleaksScan.groovy

def call(Map config) {
    def gitleaksReportName = config.gitleaksReportName ?: "gitleaks-report.json" // Default report name

    stage('Gitleaks Scan') {
        sh "gitleaks detect -r ${gitleaksReportName}"
    }
}
