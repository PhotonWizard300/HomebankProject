package utils;

import java.io.IOException;

public class AllureReportGenerator {

    public void generateAllureReport() {
        try {
            // Генерация отчета Allure
//            executeCommand("allure generate allure-results -o allure-report");
            executeCommand("allure generate allure-results -o allure-report");
            // Загрузка отчета в виде архива
            executeCommand("allure open allure-report");
//            executeCommand("allure generate allure-results -o allure-report && allure archive allure-report -o allure-report.zip");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void executeCommand(String command) throws IOException {
        Process process = Runtime.getRuntime().exec(new String[]{"bash", "-c", command});
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
